package reactive.test.javachassis.vertx.provider;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;

/**
 * @Author GuoYl123
 * @Date 2019/10/28
 **/
public class AppMain {
    public static void main(String[] args) throws Exception {
        Log4jUtils.init(); // 初始化默认的日志组件
        BeanUtils.init();  // 加载Spring bean定义文件，正式开始启动流程
    }
}
