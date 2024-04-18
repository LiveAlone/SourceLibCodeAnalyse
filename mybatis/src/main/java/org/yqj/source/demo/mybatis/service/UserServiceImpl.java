package org.yqj.source.demo.mybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import org.yqj.source.demo.mybatis.mapper.User;
import org.yqj.source.demo.mybatis.mapper.UserMapper;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2024/4/18
 * Email: yaoqijunmail@foxmail.com
 */
@Component
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
