package reactive.test.springcloud.webflux.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @Author GuoYl123
 * @Date 2019/10/28
 **/
@RestController
public class ConsumerController {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/hello")
    public Mono sayHello(@RequestParam("name") String name) {
        Mono ans = webClientBuilder.build().get().uri("http://provider/hello?name=", name).retrieve().bodyToMono(String.class);
        return ans;
    }
}
