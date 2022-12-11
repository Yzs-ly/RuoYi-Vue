package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PubSrcDirectory;

/**
 * 数据目录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-24
 */
public interface PubSrcDirectoryMapper 
{
    /**
     * 查询数据目录
     * 
     * @param code 数据目录主键
     * @return 数据目录
     */
    public PubSrcDirectory selectPubSrcDirectoryByCode(Long code);

    /**
     * 查询数据目录列表
     * 
     * @param pubSrcDirectory 数据目录
     * @return 数据目录集合
     */
    public List<PubSrcDirectory> selectPubSrcDirectoryList(PubSrcDirectory pubSrcDirectory);

    /**
     * 新增数据目录
     * 
     * @param pubSrcDirectory 数据目录
     * @return 结果
     */
    public int insertPubSrcDirectory(PubSrcDirectory pubSrcDirectory);

    /**
     * 修改数据目录
     * 
     * @param pubSrcDirectory 数据目录
     * @return 结果
     */
    public int updatePubSrcDirectory(PubSrcDirectory pubSrcDirectory);

    /**
     * 删除数据目录
     * 
     * @param code 数据目录主键
     * @return 结果
     */
    public int deletePubSrcDirectoryByCode(Long code);

    /**
     * 批量删除数据目录
     * 
     * @param codes 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePubSrcDirectoryByCodes(Long[] codes);
}
