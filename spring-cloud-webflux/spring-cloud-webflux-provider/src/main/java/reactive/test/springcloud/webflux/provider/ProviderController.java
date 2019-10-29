package reactive.test.springcloud.webflux.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author GuoYl123
 * @Date 2019/10/29
 **/
@RestController
public class ProviderController {
    @RequestMapping("/hello")
    public Mono sayHello(@RequestParam("name") String name) {
        return Mono.justOrEmpty("p1 hello world,"+name);
    }
}
