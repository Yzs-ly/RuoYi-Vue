package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PubSrcSystem;

/**
 * 业务系统管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
public interface PubSrcSystemMapper 
{
    /**
     * 查询业务系统管理
     * 
     * @param id 业务系统管理主键
     * @return 业务系统管理
     */
    public PubSrcSystem selectPubSrcSystemById(String id);

    /**
     * 查询业务系统管理列表
     * 
     * @param pubSrcSystem 业务系统管理
     * @return 业务系统管理集合
     */
    public List<PubSrcSystem> selectPubSrcSystemList(PubSrcSystem pubSrcSystem);

    /**
     * 查询业务系统管理列表
     *
     * @param departId 部门id
     * @return 业务系统管理集合
     */
    public List<PubSrcSystem> selectPubSrcSystemByDepartId(String departId);

    /**
     * 新增业务系统管理
     * 
     * @param pubSrcSystem 业务系统管理
     * @return 结果
     */
    public int insertPubSrcSystem(PubSrcSystem pubSrcSystem);

    /**
     * 修改业务系统管理
     * 
     * @param pubSrcSystem 业务系统管理
     * @return 结果
     */
    public int updatePubSrcSystem(PubSrcSystem pubSrcSystem);

    /**
     * 删除业务系统管理
     * 
     * @param id 业务系统管理主键
     * @return 结果
     */
    public int deletePubSrcSystemById(String id);

    /**
     * 批量删除业务系统管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePubSrcSystemByIds(String[] ids);
}
