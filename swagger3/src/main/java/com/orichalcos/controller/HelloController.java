package com.orichalcos.controller;

import com.orichalcos.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "hello控制器")
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation(value = "say hello~")
    public String hello() {
        return "hello";
    }

    @PostMapping("/hey")
    @ResponseBody
    @ApiOperation(value = "say hey!", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", dataTypeClass = Integer.class)
    })
    public User hey(@RequestBody User user) {
        return user;
    }
}
