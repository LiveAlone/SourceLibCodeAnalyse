package org.yqj.source.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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

    @Resource
    private AopUserService aopUserService;

    @Resource
    private AopStudentService aopStudentService;

    @Override
    public void run(String... args) throws Exception {
//        aopUserService.saveUser(new AopUser("yao", 18, 1000));
//        aopUserService.queryUser("yao", 19, 1000);

//        aopStudentService.saveStudent(new AopStudent("qi", 28, 666));
//        aopStudentService.queryStudent("qi", 28, 667);

//        aopUserService.validateUser(new AopUser("yqj", 12, 100));
//        aopUserService.validateUser(new AopUser(null, 12, 100));

//        System.out.println(aopUserService.getClass().getName());
//        aopUserService.saveUser(new AopUser("yao", 18, 1000));
//        if (aopUserService instanceof PeopleEnabled) {
//            ((PeopleEnabled) aopUserService).enabled();
//        }
    }
}
