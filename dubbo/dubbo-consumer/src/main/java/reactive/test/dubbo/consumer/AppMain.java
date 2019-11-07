package reactive.test.dubbo.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author GuoYl123
 * @Date 2019/11/6
 **/
@EnableAutoConfiguration
public class AppMain {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Reference(version = "${demo.service.version}")
  private DemoService demoService;

  public static void main(String[] args) {
    SpringApplication.run(AppMain.class).close();
  }

  @Bean
  public ApplicationRunner runner() {
    return args -> logger.info(demoService.sayHello("mercyblitz"));
  }
}
