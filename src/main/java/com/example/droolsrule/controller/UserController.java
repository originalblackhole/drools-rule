package com.example.droolsrule.controller;


import com.example.droolsrule.common.CommonMessageCode;
import com.example.droolsrule.common.MessageCode;
import com.example.droolsrule.common.ResponseData;
import com.example.droolsrule.data.TestRequest;
import com.example.droolsrule.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rui.zhou
 * @since 2021-04-17
 */

@Api(tags = "用户管理相关接口")
@RestController
@RequestMapping("/droolsrule/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @ApiOperation("测试的接口")
    @ApiImplicitParam(name = "name", value = "测试请求对象", defaultValue = "张三", required = true)
    @PostMapping("test")
    public ResponseData test(@RequestBody @Validated TestRequest testRequest){
        return new ResponseData(CommonMessageCode.SUCCESS,userService.getRules(testRequest.getName()));
    }
}
