package com.openthinks.easyiot.links.servers.tcp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.openthinks.easyiot.core.model.BizRecord;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import net.sf.ehcache.util.concurrent.ConcurrentHashMap;

@Component
public class TCPServerTester {
	public final static Map<String, BizRecord> sendMap = new ConcurrentHashMap<>();
	private String ip = "localhost";
	private int port;

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void test() throws InterruptedException {
		Bootstrap bootstrap = new Bootstrap();
		EventLoopGroup group = new NioEventLoopGroup();
		bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, false)
				.handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new ClientHander());
					}
				});
		try {
			ChannelFuture future = bootstrap.connect(ip, port).sync();

			send(future);

			future.channel().close();
		} finally {
			group.shutdownGracefully().sync();
		}
	}

	List<BizRecord> generateData() {
		final List<BizRecord> datas = new ArrayList<>();
		Random random = new Random();
		do {
			BizRecord data = new BizRecord();
			data.setDevId("TEST_" + UUID.randomUUID().toString());
			StringBuffer sb = new StringBuffer();
			sb.append("{");
			sb.append("\"deviceid\":\"").append(data.getDevId()).append("\"");
			for (int i = 0, len = 100; i < len; i++) {
				sb.append(",").append("\"name_").append(i).append("\":").append(random.nextFloat());
			}
			sb.append("}");
			data.setData(sb.toString());
			datas.add(data);
		} while (datas.size() < 100);
		return datas;
	}

	private void send(ChannelFuture future) throws InterruptedException {
		List<BizRecord> datas = generateData();
		for (BizRecord data : datas) {
			int piece = (int) Math.floor(Math.random() * 10);
			sendData(future, data, piece);
			sendMap.put(data.getDevId(), data);
			Thread.sleep((long) (Math.random() * 1000));
		}
	}

	private void sendData(ChannelFuture future, BizRecord data, int piece) throws InterruptedException {
		String JSON = data.getData();
		if (piece == 0 || piece == 1) {
			future.channel().writeAndFlush(Unpooled.copiedBuffer(JSON, CharsetUtil.UTF_8)).sync();
			return;
		}
		int LEN = JSON.length();
		int pieceLen = LEN / piece;
		String subStr = "";
		int index = 0;
		for (; index < piece - 1; index++) {
			subStr = JSON.substring(index * pieceLen, (index + 1) * pieceLen);
			future.channel().writeAndFlush(Unpooled.copiedBuffer(subStr, CharsetUtil.UTF_8)).sync();
		}
		subStr = JSON.substring(index * pieceLen);
		future.channel().writeAndFlush(Unpooled.copiedBuffer(subStr, CharsetUtil.UTF_8)).sync();
	}

	static class ClientHander extends SimpleChannelInboundHandler<ByteBuf> {
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
			System.out.println("Client received: " + msg.toString(CharsetUtil.UTF_8));
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
			cause.printStackTrace();
			ctx.close();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TCPServerTester tester = new TCPServerTester();
		tester.setPort(10240);
		tester.test();
		TCPServerTester.sendMap.forEach((k, v) -> {
			System.out.println(k + "=" + v.getData());
		});
	}
}
