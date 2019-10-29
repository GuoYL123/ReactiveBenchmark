package reactive.test.springcloud.tomcat.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author GuoYl123
 * @Date 2019/10/28
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }
}
