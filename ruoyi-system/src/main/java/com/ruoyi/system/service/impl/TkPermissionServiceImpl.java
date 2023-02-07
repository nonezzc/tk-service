package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TkPermissionMapper;
import com.ruoyi.system.domain.TkPermission;
import com.ruoyi.system.service.ITkPermissionService;

/**
 * tk权限Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
@Service
public class TkPermissionServiceImpl implements ITkPermissionService 
{
    @Autowired
    private TkPermissionMapper tkPermissionMapper;

    /**
     * 查询tk权限
     * 
     * @param shopId tk权限主键
     * @return tk权限
     */
    @Override
    public TkPermission selectTkPermissionByShopId(String shopId)
    {
        return tkPermissionMapper.selectTkPermissionByShopId(shopId);
    }

    /**
     * 查询tk权限列表
     * 
     * @param tkPermission tk权限
     * @return tk权限
     */
    @Override
    public List<TkPermission> selectTkPermissionList(TkPermission tkPermission)
    {
        return tkPermissionMapper.selectTkPermissionList(tkPermission);
    }

    /**
     * 新增tk权限
     * 
     * @param tkPermission tk权限
     * @return 结果
     */
    @Override
    public int insertTkPermission(TkPermission tkPermission)
    {
        return tkPermissionMapper.insertTkPermission(tkPermission);
    }

    /**
     * 修改tk权限
     * 
     * @param tkPermission tk权限
     * @return 结果
     */
    @Override
    public int updateTkPermission(TkPermission tkPermission)
    {
        return tkPermissionMapper.updateTkPermission(tkPermission);
    }

    /**
     * 批量删除tk权限
     * 
     * @param shopIds 需要删除的tk权限主键
     * @return 结果
     */
    @Override
    public int deleteTkPermissionByShopIds(String[] shopIds)
    {
        return tkPermissionMapper.deleteTkPermissionByShopIds(shopIds);
    }

    /**
     * 删除tk权限信息
     * 
     * @param shopId tk权限主键
     * @return 结果
     */
    @Override
    public int deleteTkPermissionByShopId(String shopId)
    {
        return tkPermissionMapper.deleteTkPermissionByShopId(shopId);
    }
}
