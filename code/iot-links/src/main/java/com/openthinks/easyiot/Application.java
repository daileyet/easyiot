package com.openthinks.easyiot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.openthinks.easyiot.core.AppConfig;
import com.openthinks.easyiot.core.Static;
import com.openthinks.easyiot.core.util.SpringContextUtil;
import com.openthinks.easyiot.links.servers.ServerStarter;

@MapperScan(Static.MYBATIS_CORE_MAPPER_PACKAGE)
@SpringBootApplication
@EnableScheduling
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		AppConfig appConfig = SpringContextUtil.getContext().getBean(AppConfig.class);
		LOGGER.info("APP Configurations:{}", appConfig);
		SpringContextUtil.getContext().getBeansOfType(ServerStarter.class).forEach((clz, starter) -> {
			if (!starter.isActive())
				return;
			// start worker when active
			new ServerStarterWorker(starter).start();
		});
	}

	private static final class ServerStarterWorker extends Thread {
		private final ServerStarter server;

		ServerStarterWorker(ServerStarter server) {
			this.server = server;
			this.setName("Thread_" + server.getClass().getSimpleName());
		}

		@Override
		public void run() {
			try {
				server.start();
			} catch (Exception e) {
				LOGGER.error("Failed to start server:{} by reason:{}", server.getClass().getName(), e);
			}
		}
	}
}
