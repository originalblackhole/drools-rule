package com.example.droolsrule.service;

import com.example.droolsrule.data.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rui.zhou
 * @since 2021-04-17
 */
@Api(tags = "用户服务接口")
public interface IUserService extends IService<User> {

    @ApiOperation("获取所有规则接口")
    @ApiImplicitParam(name = "name", value = "获取所有规则接口入参", defaultValue = "张三", required = true)
    String getRules(String name);

}
