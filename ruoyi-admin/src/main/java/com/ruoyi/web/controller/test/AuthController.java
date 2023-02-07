package com.ruoyi.web.controller.test;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TkPermission;
import com.ruoyi.system.domain.TkUser;
import com.ruoyi.system.service.ITkPermissionService;
import com.ruoyi.system.service.ITkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 角色信息
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/tk")
public class AuthController extends BaseController {

    @Autowired
    private ITkPermissionService permissionService;
    @Autowired
    private ITkUserService userService;

    @PostMapping("auth")
    public AjaxResult auth(@RequestBody JSONObject jsonObject){
//         查账号密码
        TkUser tkUser = new TkUser();
        tkUser.setUsername((String) jsonObject.get("username"));
        tkUser.setPassword((String) jsonObject.get("password"));

        List<TkUser> tkUserList = userService.selectTkUserList(tkUser);

        //不为空则密码正确
        if (!CollectionUtils.isEmpty(tkUserList)){

            //判断这个店铺这个权限表已经有了
            TkPermission p = new TkPermission();
            p.setShopId((String) jsonObject.get("shopId"));
            p.setUsername((String) jsonObject.get("username"));
            List<TkPermission> alreadyExistOrNot = permissionService.selectTkPermissionList(p);

            //底下是尝试要插入的逻辑  这个用户这个店铺如果不存在权限表中才要尝试去插入  否则已经有了就不要插入权限表
            if (CollectionUtils.isEmpty(alreadyExistOrNot)) {
                //查询该用户是否有权限记录
                TkPermission tkPermission = new TkPermission();
                tkPermission.setUsername((String) jsonObject.get("username"));
                List<TkPermission> permissionList = permissionService.selectTkPermissionList(tkPermission);

                if(!CollectionUtils.isEmpty(permissionList)){
                    //同样的账号密码只能找到一条
                    TkUser user = tkUserList.get(0);

                    Long quota = user.getQuota();
                    //有权限判断是否有额度插入          //用户额度>用户已有的权限数  可以插入权限表
                    if(quota > permissionList.size()){
                        //有额度插入就直接插入  在前面判断是否已经存在
                        TkPermission permission = new TkPermission();
                        permission.setShopId((String) jsonObject.get("shopId"));
                        permission.setUsername((String) jsonObject.get("username"));
                        permissionService.insertTkPermission(permission);

                    }else {
                        //没有额度插入，就报错没有额度
                        return AjaxResult.error("当前用户只授权了"+user.getQuota()+"个店铺，额度已满，请联系管理员！");
                    }
                }else{
                    //这个用户一条权限都没有要插入权限表
                    TkPermission permission = new TkPermission();
                    permission.setShopId((String) jsonObject.get("shopId"));
                    permission.setUsername((String) jsonObject.get("username"));
                    permissionService.insertTkPermission(permission);
                }
            }

        }else{
            //为空则密码错误
            return AjaxResult.error("账号或密码错误！");
        }

        //返回登录成功
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
