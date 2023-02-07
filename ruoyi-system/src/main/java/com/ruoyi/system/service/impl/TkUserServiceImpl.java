package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson2.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TkUserMapper;
import com.ruoyi.system.domain.TkUser;
import com.ruoyi.system.service.ITkUserService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
@Service
public class TkUserServiceImpl implements ITkUserService 
{
    @Autowired
    private TkUserMapper tkUserMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TkUser selectTkUserById(String id)
    {
        return tkUserMapper.selectTkUserById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tkUser 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TkUser> selectTkUserList(TkUser tkUser)
    {
        return tkUserMapper.selectTkUserList(tkUser);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tkUser 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTkUser(TkUser tkUser)
    {
        tkUser.setId(String.valueOf(UUID.randomUUID()));
        return tkUserMapper.insertTkUser(tkUser);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tkUser 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTkUser(TkUser tkUser)
    {
        return tkUserMapper.updateTkUser(tkUser);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTkUserByIds(String[] ids)
    {
        return tkUserMapper.deleteTkUserByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTkUserById(String id)
    {
        return tkUserMapper.deleteTkUserById(id);
    }

    @Override
    public int updateTkUserByUserName(TkUser tkUser) {
        return tkUserMapper.updateTkUserByUserName(tkUser);
    }
}
