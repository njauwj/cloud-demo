package cn.itcast.user.web;

import cn.itcast.user.config.MyConfig;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//配置热更新
//@RefreshScope
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private MyConfig myConfig;

//    @Value(value = "${pattern.dateformat}")
//    private String pattern;

//    @GetMapping("/now")
//    public String now() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
//    }

    @GetMapping("/name")
    public String getName() {
        return myConfig.getName();
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, HttpServletRequest request) {
        System.out.println(request.getHeader("order_header"));
        System.out.println(request.getHeader("default_header"));
        System.out.println(request.getHeader("user_header"));
        return userService.queryById(id);
    }
}
