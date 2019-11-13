package com.czw.ms.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAdminServer
@SpringBootApplication
public class MsMonitorAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMonitorAdminApplication.class, args);
	}

}
