package com.kiseok.springmonitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMonitorApplication.class, args);
    }

}
