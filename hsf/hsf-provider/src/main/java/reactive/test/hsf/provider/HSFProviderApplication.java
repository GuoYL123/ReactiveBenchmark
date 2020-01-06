package reactive.test.hsf.provider;

import com.taobao.pandora.boot.PandoraBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HSFProviderApplication {

    public static void main(String[] args) {
        PandoraBootstrap.run(args);
        SpringApplication.run(HSFProviderApplication.class, args);
        PandoraBootstrap.markStartupAndWait();
    }
}
