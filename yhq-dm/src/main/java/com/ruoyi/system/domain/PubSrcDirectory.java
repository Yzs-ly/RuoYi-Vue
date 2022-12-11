package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数据目录对象 pub_src_directory
 * 
 * @author ruoyi
 * @date 2022-11-24
 */
public class PubSrcDirectory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据资源目录名称 */
    @Excel(name = "数据资源目录名称")
    private String dirName;

    /** 目录范围 */
    private String scope;

    /** 更新周期 */
    @Excel(name = "更新周期")
    private String cycle;

    /** 数据资源目录提供方 */
    private String provide;

    /** 资源分类 */
    private String classification;

    /** 资源类型 */
    private String type;

    /** 资源标签 */
    private String tag;

    /** 基础信息分类 */
    @Excel(name = "基础信息分类")
    private String basicClassification;

    /** 主题分类 */
    private String topicClassification;

    /** 数据资源目录描述 */
    @Excel(name = "数据资源目录描述")
    private String dirDescribe;

    /** 共享属性 */
    private String sharedProperties;

    /** 共享条件 */
    private String sharedConditions;

    /** 共享方式 */
    private String sharingMode;

    /** 开放属性 */
    private String openAttribute;

    /** 开放条件 */
    private String openCondition;

    /** 使用人数 */
    private Long userNumber;

    /** 关联系统 */
    private String associatedSystem;

    /** 来源使用场景 */
    private String sourceBusiness;

    /** 关联业务场景 */
    private String associatedService;

    /** 关联表 */
    private String associatedTable;

    /** 关联字段 */
    private String associatedField;

    /** 数据资源目录编码 */
    private Long code;

    /** 版本号 */
    private String version;

    /** 是否最新版本 */
    private String isLatest;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 创建时间 */
    private String createDate;

    /** 更新时间 */
    private String updateDate;

    /** 是否物理删除 */
    private String isPhysicalDelete;

    /** 同步机制 */
    private String synMechanism;

    /** 同步频率 */
    @Excel(name = "同步频率")
    private String synFrequency;

    /** 是否同步到超市 */
    private String isSynTosupermarket;

    public void setDirName(String dirName) 
    {
        this.dirName = dirName;
    }

    public String getDirName() 
    {
        return dirName;
    }
    public void setScope(String scope) 
    {
        this.scope = scope;
    }

    public String getScope() 
    {
        return scope;
    }
    public void setCycle(String cycle) 
    {
        this.cycle = cycle;
    }

    public String getCycle() 
    {
        return cycle;
    }
    public void setProvide(String provide) 
    {
        this.provide = provide;
    }

    public String getProvide() 
    {
        return provide;
    }
    public void setClassification(String classification) 
    {
        this.classification = classification;
    }

    public String getClassification() 
    {
        return classification;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setBasicClassification(String basicClassification) 
    {
        this.basicClassification = basicClassification;
    }

    public String getBasicClassification() 
    {
        return basicClassification;
    }
    public void setTopicClassification(String topicClassification) 
    {
        this.topicClassification = topicClassification;
    }

    public String getTopicClassification() 
    {
        return topicClassification;
    }
    public void setDirDescribe(String dirDescribe) 
    {
        this.dirDescribe = dirDescribe;
    }

    public String getDirDescribe() 
    {
        return dirDescribe;
    }
    public void setSharedProperties(String sharedProperties) 
    {
        this.sharedProperties = sharedProperties;
    }

    public String getSharedProperties() 
    {
        return sharedProperties;
    }
    public void setSharedConditions(String sharedConditions) 
    {
        this.sharedConditions = sharedConditions;
    }

    public String getSharedConditions() 
    {
        return sharedConditions;
    }
    public void setSharingMode(String sharingMode) 
    {
        this.sharingMode = sharingMode;
    }

    public String getSharingMode() 
    {
        return sharingMode;
    }
    public void setOpenAttribute(String openAttribute) 
    {
        this.openAttribute = openAttribute;
    }

    public String getOpenAttribute() 
    {
        return openAttribute;
    }
    public void setOpenCondition(String openCondition) 
    {
        this.openCondition = openCondition;
    }

    public String getOpenCondition() 
    {
        return openCondition;
    }
    public void setUserNumber(Long userNumber) 
    {
        this.userNumber = userNumber;
    }

    public Long getUserNumber() 
    {
        return userNumber;
    }
    public void setAssociatedSystem(String associatedSystem) 
    {
        this.associatedSystem = associatedSystem;
    }

    public String getAssociatedSystem() 
    {
        return associatedSystem;
    }
    public void setSourceBusiness(String sourceBusiness) 
    {
        this.sourceBusiness = sourceBusiness;
    }

    public String getSourceBusiness() 
    {
        return sourceBusiness;
    }
    public void setAssociatedService(String associatedService) 
    {
        this.associatedService = associatedService;
    }

    public String getAssociatedService() 
    {
        return associatedService;
    }
    public void setAssociatedTable(String associatedTable) 
    {
        this.associatedTable = associatedTable;
    }

    public String getAssociatedTable() 
    {
        return associatedTable;
    }
    public void setAssociatedField(String associatedField) 
    {
        this.associatedField = associatedField;
    }

    public String getAssociatedField() 
    {
        return associatedField;
    }
    public void setCode(Long code) 
    {
        this.code = code;
    }

    public Long getCode() 
    {
        return code;
    }
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setIsLatest(String isLatest) 
    {
        this.isLatest = isLatest;
    }

    public String getIsLatest() 
    {
        return isLatest;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreateDate(String createDate) 
    {
        this.createDate = createDate;
    }

    public String getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(String updateDate) 
    {
        this.updateDate = updateDate;
    }

    public String getUpdateDate() 
    {
        return updateDate;
    }
    public void setIsPhysicalDelete(String isPhysicalDelete) 
    {
        this.isPhysicalDelete = isPhysicalDelete;
    }

    public String getIsPhysicalDelete() 
    {
        return isPhysicalDelete;
    }
    public void setSynMechanism(String synMechanism) 
    {
        this.synMechanism = synMechanism;
    }

    public String getSynMechanism() 
    {
        return synMechanism;
    }
    public void setSynFrequency(String synFrequency) 
    {
        this.synFrequency = synFrequency;
    }

    public String getSynFrequency() 
    {
        return synFrequency;
    }
    public void setIsSynTosupermarket(String isSynTosupermarket) 
    {
        this.isSynTosupermarket = isSynTosupermarket;
    }

    public String getIsSynTosupermarket() 
    {
        return isSynTosupermarket;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dirName", getDirName())
            .append("scope", getScope())
            .append("cycle", getCycle())
            .append("provide", getProvide())
            .append("classification", getClassification())
            .append("type", getType())
            .append("tag", getTag())
            .append("basicClassification", getBasicClassification())
            .append("topicClassification", getTopicClassification())
            .append("dirDescribe", getDirDescribe())
            .append("sharedProperties", getSharedProperties())
            .append("sharedConditions", getSharedConditions())
            .append("sharingMode", getSharingMode())
            .append("openAttribute", getOpenAttribute())
            .append("openCondition", getOpenCondition())
            .append("userNumber", getUserNumber())
            .append("associatedSystem", getAssociatedSystem())
            .append("sourceBusiness", getSourceBusiness())
            .append("associatedService", getAssociatedService())
            .append("associatedTable", getAssociatedTable())
            .append("associatedField", getAssociatedField())
            .append("code", getCode())
            .append("version", getVersion())
            .append("isLatest", getIsLatest())
            .append("status", getStatus())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("isPhysicalDelete", getIsPhysicalDelete())
            .append("synMechanism", getSynMechanism())
            .append("synFrequency", getSynFrequency())
            .append("isSynTosupermarket", getIsSynTosupermarket())
            .toString();
    }
}
