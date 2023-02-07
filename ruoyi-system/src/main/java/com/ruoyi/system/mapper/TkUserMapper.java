package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TkUser;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
public interface TkUserMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTkUserById(String id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTkUserByIds(String[] ids);

    int updateTkUserByUserName(TkUser tkUser);
}
