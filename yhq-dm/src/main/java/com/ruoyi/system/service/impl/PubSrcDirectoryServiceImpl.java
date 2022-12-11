package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PubSrcDirectoryMapper;
import com.ruoyi.system.domain.PubSrcDirectory;
import com.ruoyi.system.service.IPubSrcDirectoryService;

/**
 * 数据目录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-24
 */
@Service
public class PubSrcDirectoryServiceImpl implements IPubSrcDirectoryService 
{
    @Autowired
    private PubSrcDirectoryMapper pubSrcDirectoryMapper;

    /**
     * 查询数据目录
     * 
     * @param code 数据目录主键
     * @return 数据目录
     */
    @Override
    public PubSrcDirectory selectPubSrcDirectoryByCode(Long code)
    {
        return pubSrcDirectoryMapper.selectPubSrcDirectoryByCode(code);
    }

    /**
     * 查询数据目录列表
     * 
     * @param pubSrcDirectory 数据目录
     * @return 数据目录
     */
    @Override
    public List<PubSrcDirectory> selectPubSrcDirectoryList(PubSrcDirectory pubSrcDirectory)
    {
        return pubSrcDirectoryMapper.selectPubSrcDirectoryList(pubSrcDirectory);
    }

    /**
     * 新增数据目录
     * 
     * @param pubSrcDirectory 数据目录
     * @return 结果
     */
    @Override
    public int insertPubSrcDirectory(PubSrcDirectory pubSrcDirectory)
    {
        return pubSrcDirectoryMapper.insertPubSrcDirectory(pubSrcDirectory);
    }

    /**
     * 修改数据目录
     * 
     * @param pubSrcDirectory 数据目录
     * @return 结果
     */
    @Override
    public int updatePubSrcDirectory(PubSrcDirectory pubSrcDirectory)
    {
        return pubSrcDirectoryMapper.updatePubSrcDirectory(pubSrcDirectory);
    }

    /**
     * 批量删除数据目录
     * 
     * @param codes 需要删除的数据目录主键
     * @return 结果
     */
    @Override
    public int deletePubSrcDirectoryByCodes(Long[] codes)
    {
        return pubSrcDirectoryMapper.deletePubSrcDirectoryByCodes(codes);
    }

    /**
     * 删除数据目录信息
     * 
     * @param code 数据目录主键
     * @return 结果
     */
    @Override
    public int deletePubSrcDirectoryByCode(Long code)
    {
        return pubSrcDirectoryMapper.deletePubSrcDirectoryByCode(code);
    }
}
