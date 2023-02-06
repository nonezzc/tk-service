package com.ruoyi.web.controller.test;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * 角色信息
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/tk")
public class AuthController extends BaseController {

    @PostMapping("auth")
    public AjaxResult auth(@RequestBody JSONObject jsonObject){
//         查账号密码
        //用户额度>用户权限数  可以插入权限表
        return success(UUID.randomUUID());
    }


//    tk_user 表
//    id  username  password  quota
//      1   zhangsan  123456     5

//    查询条件  username

//    shop_id 主键id      username 账号            操作
//      shopId1             zhangsan               删除
//      shopId2             zhangsan               删除
//      shopId3             zhangsan              删除
//      shopId4             zhangsan              删除
//      shopId5             zhangsan              删除

//    用户段 注销  加入
}
