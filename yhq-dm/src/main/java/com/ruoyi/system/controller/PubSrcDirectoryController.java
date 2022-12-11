package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.PubSrcDirectory;
import com.ruoyi.system.service.IPubSrcDirectoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数据目录Controller
 * 
 * @author ruoyi
 * @date 2022-11-24
 */
@RestController
@RequestMapping("/yhq-dm/directory")
public class PubSrcDirectoryController extends BaseController
{
    @Autowired
    private IPubSrcDirectoryService pubSrcDirectoryService;

    /**
     * 查询数据目录列表
     */
    @PreAuthorize("@ss.hasPermi('system:directory:list')")
    @GetMapping("/list")
    public TableDataInfo list(PubSrcDirectory pubSrcDirectory)
    {
        startPage();
        List<PubSrcDirectory> list = pubSrcDirectoryService.selectPubSrcDirectoryList(pubSrcDirectory);
        return getDataTable(list);
    }

    /**
     * 导出数据目录列表
     */
    @PreAuthorize("@ss.hasPermi('system:directory:export')")
    @Log(title = "数据目录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PubSrcDirectory pubSrcDirectory)
    {
        List<PubSrcDirectory> list = pubSrcDirectoryService.selectPubSrcDirectoryList(pubSrcDirectory);
        ExcelUtil<PubSrcDirectory> util = new ExcelUtil<PubSrcDirectory>(PubSrcDirectory.class);
        util.exportExcel(response, list, "数据目录数据");
    }

    /**
     * 获取数据目录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:directory:query')")
    @GetMapping(value = "/{code}")
    public AjaxResult getInfo(@PathVariable("code") Long code)
    {
        return AjaxResult.success(pubSrcDirectoryService.selectPubSrcDirectoryByCode(code));
    }

    /**
     * 新增数据目录
     */
    @PreAuthorize("@ss.hasPermi('system:directory:add')")
    @Log(title = "数据目录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PubSrcDirectory pubSrcDirectory)
    {
        return toAjax(pubSrcDirectoryService.insertPubSrcDirectory(pubSrcDirectory));
    }

    /**
     * 修改数据目录
     */
    @PreAuthorize("@ss.hasPermi('system:directory:edit')")
    @Log(title = "数据目录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PubSrcDirectory pubSrcDirectory)
    {
        return toAjax(pubSrcDirectoryService.updatePubSrcDirectory(pubSrcDirectory));
    }

    /**
     * 删除数据目录
     */
    @PreAuthorize("@ss.hasPermi('system:directory:remove')")
    @Log(title = "数据目录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{codes}")
    public AjaxResult remove(@PathVariable Long[] codes)
    {
        return toAjax(pubSrcDirectoryService.deletePubSrcDirectoryByCodes(codes));
    }
}
