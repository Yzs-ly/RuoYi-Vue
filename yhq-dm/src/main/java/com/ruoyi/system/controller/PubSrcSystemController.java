package com.ruoyi.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PubSrcSystem;
import com.ruoyi.system.service.IPubSrcSystemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 业务系统管理Controller
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
@RestController
@RequestMapping("/yhq-dm/system")
public class PubSrcSystemController extends BaseController
{

    @Autowired
    private IPubSrcSystemService pubSrcSystemService;


    /**
     * 查询业务系统管理列表
     */
    @PreAuthorize("@ss.hasPermi('yhq-dm:system:list')")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PubSrcSystem pubSrcSystem)
    {
        startPage();
        List<PubSrcSystem> list = pubSrcSystemService.selectPubSrcSystemList(pubSrcSystem);
        return getDataTable(list);
    }

    /**
     * 导出业务系统管理列表
     */
    @PreAuthorize("@ss.hasPermi('yhq-dm:system:list')")
    @Log(title = "业务系统管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public AjaxResult export(PubSrcSystem pubSrcSystem)
    {
        List<PubSrcSystem> list = pubSrcSystemService.selectPubSrcSystemList(pubSrcSystem);
        ExcelUtil<PubSrcSystem> util = new ExcelUtil<PubSrcSystem>(PubSrcSystem.class);
        return util.exportExcel(list, "业务系统管理数据");
    }


    /**
     * 新增保存业务系统管理
     */
    @PreAuthorize("@ss.hasPermi('yhq-dm:system:add')")
    @Log(title = "业务系统管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult addSave(PubSrcSystem pubSrcSystem)
    {
        Date date = new Date();
        SimpleDateFormat spf = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = spf.format(date);
        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        for(int i=0;i<8;i++){
            str.append(random.nextInt(10));
        }
        pubSrcSystem.setId(strDate + str);
        return toAjax(pubSrcSystemService.insertPubSrcSystem(pubSrcSystem));
    }


    /**
     * 修改保存业务系统管理
     */
    @PreAuthorize("@ss.hasPermi('yhq-dm:system:edit')")
    @Log(title = "业务系统管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult editSave(PubSrcSystem pubSrcSystem)
    {
        return toAjax(pubSrcSystemService.updatePubSrcSystem(pubSrcSystem));
    }

    /**
     * 删除业务系统管理
     */
    @PreAuthorize("@ss.hasPermi('yhq-dm:system:remove')")
    @Log(title = "业务系统管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pubSrcSystemService.deletePubSrcSystemByIds(ids));
    }
}
