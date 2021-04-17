package com.example.droolsrule.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import com.example.droolsrule.data.entity.User;
import com.example.droolsrule.mapper.UserMapper;
import com.example.droolsrule.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rui.zhou
 * @since 2021-04-17
 */
@Api(tags = "用户服务接口实现类")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    @ApiOperation("获取所有规则接口实现")
    @ApiImplicitParam(name = "name", value = "获取所有规则接口入参", defaultValue = "张三", required = true)
    public String getRules(String name) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName,name);
        return this.getOne(wrapper).toString();
    }
}
