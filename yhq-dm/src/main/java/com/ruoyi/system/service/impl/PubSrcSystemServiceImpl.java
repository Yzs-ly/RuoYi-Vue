package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PubSrcSystemMapper;
import com.ruoyi.system.domain.PubSrcSystem;
import com.ruoyi.system.service.IPubSrcSystemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 业务系统管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
@Service("system")
public class PubSrcSystemServiceImpl implements IPubSrcSystemService 
{
    @Autowired
    private PubSrcSystemMapper pubSrcSystemMapper;

    /**
     * 查询业务系统管理
     * 
     * @param id 业务系统管理主键
     * @return 业务系统管理
     */
    @Override
    public PubSrcSystem selectPubSrcSystemById(String id)
    {
        return pubSrcSystemMapper.selectPubSrcSystemById(id);
    }

    /**
     * 查询业务系统管理列表
     *
     * @param departId 部门id
     * @return 业务系统管理集合
     */
    public List<PubSrcSystem> selectPubSrcSystemByDepartId(String departId){
        return pubSrcSystemMapper.selectPubSrcSystemByDepartId(departId);
    }

    /**
     * 查询业务系统管理列表
     * 
     * @param pubSrcSystem 业务系统管理
     * @return 业务系统管理
     */
    @Override
    public List<PubSrcSystem> selectPubSrcSystemList(PubSrcSystem pubSrcSystem)
    {
        return pubSrcSystemMapper.selectPubSrcSystemList(pubSrcSystem);
    }

    /**
     * 新增业务系统管理
     * 
     * @param pubSrcSystem 业务系统管理
     * @return 结果
     */
    @Override
    public int insertPubSrcSystem(PubSrcSystem pubSrcSystem)
    {
        return pubSrcSystemMapper.insertPubSrcSystem(pubSrcSystem);
    }

    /**
     * 修改业务系统管理
     * 
     * @param pubSrcSystem 业务系统管理
     * @return 结果
     */
    @Override
    public int updatePubSrcSystem(PubSrcSystem pubSrcSystem)
    {
        return pubSrcSystemMapper.updatePubSrcSystem(pubSrcSystem);
    }

    /**
     * 批量删除业务系统管理
     * 
     * @param ids 需要删除的业务系统管理主键
     * @return 结果
     */
    @Override
    public int deletePubSrcSystemByIds(String ids)
    {
        return pubSrcSystemMapper.deletePubSrcSystemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除业务系统管理信息
     * 
     * @param id 业务系统管理主键
     * @return 结果
     */
    @Override
    public int deletePubSrcSystemById(String id)
    {
        return pubSrcSystemMapper.deletePubSrcSystemById(id);
    }
}
