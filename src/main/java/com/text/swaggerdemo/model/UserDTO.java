package com.text.swagger_demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wh
 * @date 2020/12/16
 * Description:用户DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体",description = "查询用户")
public class UserDTO implements Serializable {
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "用户名")
    private String username;
}
