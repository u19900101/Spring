package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lppppp
 * @create 2021-01-14 10:57
 *
 *
 */
// 因为要配置数据库连接池  所以 只能加载xml 文件  不可使用纯注解开发
@Configuration
@ComponentScan(basePackages = {"dao","service"})
public class Config {
}
