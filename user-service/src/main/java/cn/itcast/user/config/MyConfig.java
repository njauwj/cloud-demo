package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: wj
 * @create_time: 2023/4/13 21:05
 * @explain: 会自动热更新nacos配置中心数据
 */
@Component
@ConfigurationProperties(prefix = "user")
@Data
public class MyConfig {

    public String name;

}
