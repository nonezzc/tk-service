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
import com.ruoyi.system.domain.TkPermission;
import com.ruoyi.system.service.ITkPermissionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * tk权限Controller
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
@RestController
@RequestMapping("/tk-permission/permission")
public class TkPermissionController extends BaseController
{
    @Autowired
    private ITkPermissionService tkPermissionService;

    /**
     * 查询tk权限列表
     */
    @PreAuthorize("@ss.hasPermi('tk-permission:permission:list')")
    @GetMapping("/list")
    public TableDataInfo list(TkPermission tkPermission)
    {
        startPage();
        List<TkPermission> list = tkPermissionService.selectTkPermissionList(tkPermission);
        return getDataTable(list);
    }

    /**
     * 导出tk权限列表
     */
    @PreAuthorize("@ss.hasPermi('tk-permission:permission:export')")
    @Log(title = "tk权限", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TkPermission tkPermission)
    {
        List<TkPermission> list = tkPermissionService.selectTkPermissionList(tkPermission);
        ExcelUtil<TkPermission> util = new ExcelUtil<TkPermission>(TkPermission.class);
        util.exportExcel(response, list, "tk权限数据");
    }

    /**
     * 获取tk权限详细信息
     */
    @PreAuthorize("@ss.hasPermi('tk-permission:permission:query')")
    @GetMapping(value = "/{shopId}")
    public AjaxResult getInfo(@PathVariable("shopId") String shopId)
    {
        return success(tkPermissionService.selectTkPermissionByShopId(shopId));
    }

    /**
     * 新增tk权限
     */
    @PreAuthorize("@ss.hasPermi('tk-permission:permission:add')")
    @Log(title = "tk权限", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TkPermission tkPermission)
    {
        return toAjax(tkPermissionService.insertTkPermission(tkPermission));
    }

    /**
     * 修改tk权限
     */
    @PreAuthorize("@ss.hasPermi('tk-permission:permission:edit')")
    @Log(title = "tk权限", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TkPermission tkPermission)
    {
        return toAjax(tkPermissionService.updateTkPermission(tkPermission));
    }

    /**
     * 删除tk权限
     */
    @PreAuthorize("@ss.hasPermi('tk-permission:permission:remove')")
    @Log(title = "tk权限", businessType = BusinessType.DELETE)
	@DeleteMapping("/{shopIds}")
    public AjaxResult remove(@PathVariable String[] shopIds)
    {
        return toAjax(tkPermissionService.deleteTkPermissionByShopIds(shopIds));
    }
}
