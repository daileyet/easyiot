package com.openthinks.easyiot;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.openthinks.easyiot.core.AppConfig;
import com.openthinks.easyiot.links.job.ProcessMessageJob;
import com.openthinks.easyiot.links.servers.tcp.TCPServerTester;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTester {

	@Autowired
	AppConfig appConfig;

	@Autowired
	ProcessMessageJob messageJob;

	@Autowired
	TCPServerTester tcpServerTester;

	MockPersistMessageService mockPersistMessageService = new MockPersistMessageService();

	@Before
	public void setUp() {
		messageJob.setPersistMessageService(mockPersistMessageService);
		TCPServerTester.sendMap.clear();
		MockPersistMessageService.receivedMap.clear();
	}

	@SuppressWarnings("static-access")
	@Test
	public void testTCPServer() throws InterruptedException {
		final Runnable task = () -> {
			try {
				Thread.currentThread().sleep(10000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			tcpServerTester.setIp("127.0.0.1");
			tcpServerTester.setPort(appConfig.getTcpServerPort());
			try {
				tcpServerTester.test();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		List<Thread> threadList = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			Thread thread = new Thread(task, "TCP_CLIENT_" + i);
			threadList.add(thread);
			thread.start();
		}
		for (Thread t : threadList) {
//			t.join();
		}
		Thread.currentThread().sleep(10000);
		TCPServerTester.sendMap.forEach((k, v) -> {
			if (!MockPersistMessageService.receivedMap.containsKey(k)) {
				Assert.fail("Not contain device id:" + k);
				return;
			}
		});

	}
}
