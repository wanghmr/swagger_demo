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
 * Description:角色DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "角色实体", description = "查询角色")
public class RoleDTO implements Serializable {
    @ApiModelProperty(value = "角色id")
    private Integer roleId;
    @ApiModelProperty(value = "角色名")
    private String roleName;
}
