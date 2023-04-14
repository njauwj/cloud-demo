package cn.itcast.order;

import com.atwj.feign.client.UserFeignClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
//OrderApplication 是在cn.itcast.order包下 而 UserFeignClient 是在com.atwj.feign包下所以SpringBoot无法将其注入容器，需要手动指定下
@EnableFeignClients(clients = UserFeignClient.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 用于不同模块之间的http通信
     *
     * @return
     */
    @Bean
    @LoadBalanced//开启负载均衡(Ribbon)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 针对所有服务 全局的
     * randomRule 名字不能乱写
     * @return
     */
//    @Bean
//    public IRule randomRule() {
//        return new RandomRule();
//    }
}