package org.yqj.source.demo.mybatis;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.mybatis.mapper.User;
import org.yqj.source.demo.mybatis.mapper.UserMapper;
import org.yqj.source.demo.mybatis.service.UserService;

import java.util.List;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@Component
@Slf4j
public class RunCommandLine implements CommandLineRunner {

//    @Resource
//    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        log.info("run command line starting ... ");

//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        userList.forEach(System.out::println);

        userService.list().forEach(System.out::println);
    }
}
