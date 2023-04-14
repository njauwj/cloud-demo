package com.atwj.feign.client;

import com.atwj.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: wj
 * @create_time: 2023/4/14 10:51
 * @explain:
 */
@FeignClient("userservice")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id);

}
