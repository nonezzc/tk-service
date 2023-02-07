package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * tk权限对象 tk_permission
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
public class TkPermission extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 店铺id */
    private String shopId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    public void setShopId(String shopId) 
    {
        this.shopId = shopId;
    }

    public String getShopId() 
    {
        return shopId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shopId", getShopId())
            .append("username", getUsername())
            .toString();
    }
}
