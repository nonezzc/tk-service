package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TkUser;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
public interface ITkUserService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TkUser selectTkUserById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tkUser 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TkUser> selectTkUserList(TkUser tkUser);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tkUser 【请填写功能名称】
     * @return 结果
     */
    public int insertTkUser(TkUser tkUser);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tkUser 【请填写功能名称】
     * @return 结果
     */
    public int updateTkUser(TkUser tkUser);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTkUserByIds(String[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTkUserById(String id);

    int updateTkUserByUserName(TkUser tkUser);
}
