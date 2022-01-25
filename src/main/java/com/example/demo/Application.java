package com.example.demo;

import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.system_management.service.SystemManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Map;

@SpringBootApplication
@EnableFeignClients("com.example.demo")
public class Application implements CommandLineRunner {

	@Autowired
	private ModuleConfig moduleConfig;

	@Autowired
	private Map<String, SystemManagementService> sysManagementServiceMap;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.sysManagementServiceMap.get(this.moduleConfig.getSysManagementTeam()).loadModules();
	}
}
