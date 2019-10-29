package reactive.test.springcloud.webflux.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

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

    @LoadBalanced
    @Bean
    public WebClient.Builder restTemplate() {
        return WebClient.builder();
    }
}
