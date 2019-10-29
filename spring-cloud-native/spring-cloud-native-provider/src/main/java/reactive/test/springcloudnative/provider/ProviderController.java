package reactive.test.springcloudnative.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GuoYl123
 * @Date 2019/10/29
 **/
@RestController
public class ProviderController {
    @RequestMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        return "p1 hello world,"+name;
    }
}
