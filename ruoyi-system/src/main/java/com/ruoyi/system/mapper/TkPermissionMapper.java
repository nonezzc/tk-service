package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TkPermission;

/**
 * tk权限Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
public interface TkPermissionMapper 
{
    /**
     * 查询tk权限
     * 
     * @param shopId tk权限主键
     * @return tk权限
     */
    public TkPermission selectTkPermissionByShopId(String shopId);

    /**
     * 查询tk权限列表
     * 
     * @param tkPermission tk权限
     * @return tk权限集合
     */
    public List<TkPermission> selectTkPermissionList(TkPermission tkPermission);

    /**
     * 新增tk权限
     * 
     * @param tkPermission tk权限
     * @return 结果
     */
    public int insertTkPermission(TkPermission tkPermission);

    /**
     * 修改tk权限
     * 
     * @param tkPermission tk权限
     * @return 结果
     */
    public int updateTkPermission(TkPermission tkPermission);

    /**
     * 删除tk权限
     * 
     * @param shopId tk权限主键
     * @return 结果
     */
    public int deleteTkPermissionByShopId(String shopId);

    /**
     * 批量删除tk权限
     * 
     * @param shopIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTkPermissionByShopIds(String[] shopIds);
}
