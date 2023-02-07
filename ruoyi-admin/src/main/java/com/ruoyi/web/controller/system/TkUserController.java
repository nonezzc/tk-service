package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TkUser;
import com.ruoyi.system.service.ITkUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * tk用户Controller
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
@RestController
@RequestMapping("/tk-user/user")
public class TkUserController extends BaseController
{
    @Autowired
    private ITkUserService tkUserService;

    /**
     * 查询tk用户列表
     */
    @PreAuthorize("@ss.hasPermi('tk-user:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(TkUser tkUser)
    {
        startPage();
        List<TkUser> list = tkUserService.selectTkUserList(tkUser);
        return getDataTable(list);
    }

    /**
     * 导出tk用户列表
     */
    @PreAuthorize("@ss.hasPermi('tk-user:user:export')")
    @Log(title = "tk用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TkUser tkUser)
    {
        List<TkUser> list = tkUserService.selectTkUserList(tkUser);
        ExcelUtil<TkUser> util = new ExcelUtil<TkUser>(TkUser.class);
        util.exportExcel(response, list, "tk用户数据");
    }

    /**
     * 获取tk用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('tk-user:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(tkUserService.selectTkUserById(id));
    }

    /**
     * 新增tk用户
     */
    @PreAuthorize("@ss.hasPermi('tk-user:user:add')")
    @Log(title = "tk用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TkUser tkUser)
    {
        return toAjax(tkUserService.insertTkUser(tkUser));
    }

    /**
     * 修改tk用户
     */
    @PreAuthorize("@ss.hasPermi('tk-user:user:edit')")
    @Log(title = "tk用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TkUser tkUser)
    {
        return toAjax(tkUserService.updateTkUser(tkUser));
    }

    @PostMapping("editPassword")
    public AjaxResult editPassword(@RequestBody TkUser tkUser)
    {
        return toAjax(tkUserService.updateTkUserByUserName(tkUser));
    }

    /**
     * 删除tk用户
     */
    @PreAuthorize("@ss.hasPermi('tk-user:user:remove')")
    @Log(title = "tk用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tkUserService.deleteTkUserByIds(ids));
    }
}
