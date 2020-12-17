package com.text.swaggerdemo.controller;

import com.text.swaggerdemo.model.RoleDTO;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wh
 * @date 2020/12/16
 * Description:用户controller
 */
@Controller
@RequestMapping("/role")
@Api(tags = "角色controller")
public class RoleController {
    private List<RoleDTO> list = new ArrayList<>();

    @PostConstruct
    private void post() {
        list.add(new RoleDTO(1, "JourWon"));
        list.add(new RoleDTO(2, "Jobs"));
        list.add(new RoleDTO(3, "JackMa"));
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询用户列表")
    public List<RoleDTO> list() {
        return list;
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询用户列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "当前页数"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数")
    })
    public List<RoleDTO> page(@RequestParam(defaultValue = "1", required = false) Integer pageNum,
                              @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        return list;
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "根据用户id查询用户")
    public RoleDTO get(@PathVariable("userId") Integer userId) {
        for (RoleDTO userDTO : list) {
            if (userDTO.getRoleId().equals(userId)) {
                return userDTO;
            }
        }
        return new RoleDTO();
    }

    @PostMapping
    @ApiOperation(value = "新增用户")
    public Boolean insert(@RequestBody @ApiParam(name = "UserDTO", value = "新增用户参数") RoleDTO userDTO) {
        list.add(userDTO);
        return true;
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "根据用户id删除用户")
    public Boolean delete(@PathVariable("userId") Integer userId) {
        Iterator<RoleDTO> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getRoleId().equals(userId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @PutMapping
    @ApiOperation(value = "更新用户信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    public Boolean update(@RequestBody @ApiParam(name = "UserDTO", value = "更新用户参数") RoleDTO userDTO) {
        for (RoleDTO next : list) {
            if (next.getRoleId().equals(userDTO.getRoleId())) {
                next.setRoleName(userDTO.getRoleName());
                return true;
            }
        }
        return false;
    }
}
