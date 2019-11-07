package reactive.test.dubbo.provider;

import org.springframework.core.env.Environment;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author GuoYl123
 * @Date 2019/11/6
 **/
@EnableAutoConfiguration
public class AppMain {

  public static void main(String[] args) {
    new SpringApplicationBuilder(AppMain.class)
        .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
          Environment environment = event.getEnvironment();
          int port = environment.getProperty("embedded.zookeeper.port", int.class);
          new EmbeddedZooKeeper(port, false).start();
        })
        .run(args);
  }
}
