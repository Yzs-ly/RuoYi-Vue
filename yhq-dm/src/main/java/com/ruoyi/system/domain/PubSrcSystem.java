package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 业务系统管理对象 pub_src_system
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
public class PubSrcSystem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String id;

    /**  */
    @Excel(name = "")
    private String departId;

    /**  */
    @Excel(name = "")
    private String departName;

    /**  */
    @Excel(name = "")
    private String name;

    /**  */
    @Excel(name = "")
    private String functionIntroduction;

    /**  */
    private String constructionCost;

    /**  */
    private String runCost;

    /**  */
    private Date startDate;

    /**  */
    private Date stopDate;

    /**  */
    @Excel(name = "")
    private String status;

    /**  */
    private String fundsProvide;

    /**  */
    private String businessOffice;

    /**  */
    private String businessPreson;

    /**  */
    private String businessPhone;

    /**  */
    private String sysPeploy;

    /**  */
    private String sysDeploySelf;

    /**  */
    private String networkEnv;

    /**  */
    private String networkEnvSelf;

    /**  */
    private String scopeapplyArea;

    /**  */
    private String scopeapplyUser;

    /**  */
    private String scopeapplyUserSelf;

    /**  */
    private String dataGeneration;

    /**  */
    private String dataGenerationSelf;

    /**  */
    private String dataUp;

    /**  */
    private String dbFormat;

    /**  */
    private String isoterDb;

    /**  */
    private String shareScope;

    /**  */
    private String leavelPro;

    /**  */
    private String sysDeveloper;

    /**  */
    @Excel(name = "")
    private String companyPerson;

    /**  */
    @Excel(name = "")
    private String companyPhone;

    /**  */
    private String createuser;

    /**  */
    private String ordernum;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    private Date createtime;

    private Date updatetime;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setDepartId(String departId)
    {
        this.departId = departId;
    }

    public String getDepartId()
    {
        return departId;
    }
    public void setDepartName(String departName)
    {
        this.departName = departName;
    }

    public String getDepartName()
    {
        return departName;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setFunctionIntroduction(String functionIntroduction)
    {
        this.functionIntroduction = functionIntroduction;
    }

    public String getFunctionIntroduction()
    {
        return functionIntroduction;
    }
    public void setConstructionCost(String constructionCost)
    {
        this.constructionCost = constructionCost;
    }

    public String getConstructionCost()
    {
        return constructionCost;
    }
    public void setRunCost(String runCost)
    {
        this.runCost = runCost;
    }

    public String getRunCost()
    {
        return runCost;
    }
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getStartDate()
    {
        return startDate;
    }
    public void setStopDate(Date stopDate)
    {
        this.stopDate = stopDate;
    }

    public Date getStopDate()
    {
        return stopDate;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setFundsProvide(String fundsProvide)
    {
        this.fundsProvide = fundsProvide;
    }

    public String getFundsProvide()
    {
        return fundsProvide;
    }
    public void setBusinessOffice(String businessOffice)
    {
        this.businessOffice = businessOffice;
    }

    public String getBusinessOffice()
    {
        return businessOffice;
    }
    public void setBusinessPreson(String businessPreson)
    {
        this.businessPreson = businessPreson;
    }

    public String getBusinessPreson()
    {
        return businessPreson;
    }
    public void setBusinessPhone(String businessPhone)
    {
        this.businessPhone = businessPhone;
    }

    public String getBusinessPhone()
    {
        return businessPhone;
    }
    public void setSysPeploy(String sysPeploy)
    {
        this.sysPeploy = sysPeploy;
    }

    public String getSysPeploy()
    {
        return sysPeploy;
    }
    public void setSysDeploySelf(String sysDeploySelf)
    {
        this.sysDeploySelf = sysDeploySelf;
    }

    public String getSysDeploySelf()
    {
        return sysDeploySelf;
    }
    public void setNetworkEnv(String networkEnv)
    {
        this.networkEnv = networkEnv;
    }

    public String getNetworkEnv()
    {
        return networkEnv;
    }
    public void setNetworkEnvSelf(String networkEnvSelf)
    {
        this.networkEnvSelf = networkEnvSelf;
    }

    public String getNetworkEnvSelf()
    {
        return networkEnvSelf;
    }
    public void setScopeapplyArea(String scopeapplyArea)
    {
        this.scopeapplyArea = scopeapplyArea;
    }

    public String getScopeapplyArea()
    {
        return scopeapplyArea;
    }
    public void setScopeapplyUser(String scopeapplyUser)
    {
        this.scopeapplyUser = scopeapplyUser;
    }

    public String getScopeapplyUser()
    {
        return scopeapplyUser;
    }
    public void setScopeapplyUserSelf(String scopeapplyUserSelf)
    {
        this.scopeapplyUserSelf = scopeapplyUserSelf;
    }

    public String getScopeapplyUserSelf()
    {
        return scopeapplyUserSelf;
    }
    public void setDataGeneration(String dataGeneration)
    {
        this.dataGeneration = dataGeneration;
    }

    public String getDataGeneration()
    {
        return dataGeneration;
    }
    public void setDataGenerationSelf(String dataGenerationSelf)
    {
        this.dataGenerationSelf = dataGenerationSelf;
    }

    public String getDataGenerationSelf()
    {
        return dataGenerationSelf;
    }
    public void setDataUp(String dataUp)
    {
        this.dataUp = dataUp;
    }

    public String getDataUp()
    {
        return dataUp;
    }
    public void setDbFormat(String dbFormat)
    {
        this.dbFormat = dbFormat;
    }

    public String getDbFormat()
    {
        return dbFormat;
    }
    public void setIsoterDb(String isoterDb)
    {
        this.isoterDb = isoterDb;
    }

    public String getIsoterDb()
    {
        return isoterDb;
    }
    public void setShareScope(String shareScope)
    {
        this.shareScope = shareScope;
    }

    public String getShareScope()
    {
        return shareScope;
    }
    public void setLeavelPro(String leavelPro)
    {
        this.leavelPro = leavelPro;
    }

    public String getLeavelPro()
    {
        return leavelPro;
    }
    public void setSysDeveloper(String sysDeveloper)
    {
        this.sysDeveloper = sysDeveloper;
    }

    public String getSysDeveloper()
    {
        return sysDeveloper;
    }
    public void setCompanyPerson(String companyPerson)
    {
        this.companyPerson = companyPerson;
    }

    public String getCompanyPerson()
    {
        return companyPerson;
    }
    public void setCompanyPhone(String companyPhone)
    {
        this.companyPhone = companyPhone;
    }

    public String getCompanyPhone()
    {
        return companyPhone;
    }
    public void setCreateuser(String createuser)
    {
        this.createuser = createuser;
    }

    public String getCreateuser()
    {
        return createuser;
    }
    public void setOrdernum(String ordernum)
    {
        this.ordernum = ordernum;
    }

    public String getOrdernum()
    {
        return ordernum;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("departId", getDepartId())
                .append("departName", getDepartName())
                .append("name", getName())
                .append("functionIntroduction", getFunctionIntroduction())
                .append("constructionCost", getConstructionCost())
                .append("runCost", getRunCost())
                .append("startDate", getStartDate())
                .append("stopDate", getStopDate())
                .append("status", getStatus())
                .append("fundsProvide", getFundsProvide())
                .append("businessOffice", getBusinessOffice())
                .append("businessPreson", getBusinessPreson())
                .append("businessPhone", getBusinessPhone())
                .append("sysPeploy", getSysPeploy())
                .append("sysDeploySelf", getSysDeploySelf())
                .append("networkEnv", getNetworkEnv())
                .append("networkEnvSelf", getNetworkEnvSelf())
                .append("scopeapplyArea", getScopeapplyArea())
                .append("scopeapplyUser", getScopeapplyUser())
                .append("scopeapplyUserSelf", getScopeapplyUserSelf())
                .append("dataGeneration", getDataGeneration())
                .append("dataGenerationSelf", getDataGenerationSelf())
                .append("dataUp", getDataUp())
                .append("dbFormat", getDbFormat())
                .append("isoterDb", getIsoterDb())
                .append("shareScope", getShareScope())
                .append("leavelPro", getLeavelPro())
                .append("sysDeveloper", getSysDeveloper())
                .append("companyPerson", getCompanyPerson())
                .append("companyPhone", getCompanyPhone())
                .append("createuser", getCreateuser())
                .append("createtime", getCreatetime())
                .append("updatetime", getUpdatetime())
                .append("ordernum", getOrdernum())
                .toString();
    }
}