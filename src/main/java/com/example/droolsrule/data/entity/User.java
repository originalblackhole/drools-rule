package com.example.droolsrule.data.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author rui.zhou
 * @since 2021-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;


//    @Size(max = 10)
//    @NotEmpty(message = "密码不能为空")
//    @Length(min=6,max=8,message = "密码长度为6-8")
//    @Pattern(regexp = "[a-zA-z]*",message = "密码不合法")
//    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;


}
