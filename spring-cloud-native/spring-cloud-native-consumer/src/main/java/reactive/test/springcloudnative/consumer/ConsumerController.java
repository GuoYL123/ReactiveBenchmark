package reactive.test.springcloudnative.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author GuoYl123
 * @Date 2019/10/28
 **/
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://demo-provider/hello?name=" + name, String.class);
    }
}
