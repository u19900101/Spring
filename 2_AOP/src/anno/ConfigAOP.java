package anno;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lppppp
 * @create 2021-01-14 9:52
 */
@Configuration
@ComponentScan(basePackages = "anno")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAOP {
}
