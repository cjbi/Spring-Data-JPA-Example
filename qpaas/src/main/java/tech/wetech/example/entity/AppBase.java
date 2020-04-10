package tech.wetech.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ent_${entId}_app_base")
public class AppBase {
    /**
     * 主键ID
     */
    @Id
    private Long id;
    /**
     * 应用名称
     */
    private String name;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 应用类型 information:df,workflow:wf,link:链接型应用,sys:一级系统,subsys:二级分类
     */
    private String appType;
    /**
     * 应用链接
     */
    private String link;
    /**
     * 应用显示渠道 1:APP端,2:web端
     */
    private String appShow;
    /**
     * 应用描述
     */
    private String description;
    /**
     * 排序值
     */
    private Integer order;
    /**
     * 一级系统ID
     */
    private Integer sysId;
    /**
     * 父及应用ID
     */
    private Integer parent;
    /**
     * 应用层级
     */
    private Integer level;
    /**
     * 图标名称
     */
    private String iconName;
    /**
     * 图标颜色
     */
    private String iconColor;
    /**
     * 个性化定制开启 1:开启；0:未开启
     */
    private Integer personalize;
    /**
     * 定制应用打开方式 1全屏模式  2嵌入模式
     */
    private Integer openType;
    /**
     * 定制应用URL
     */
    private String jumpAddr;
    /**
     * 应用包ID
     */
    private String fromStore;
    /**
     * 应用包版本号
     */
    private String packageVersionCode;
    /**
     * 应用锁定 0:未锁定;1:已锁定
     */
    private Integer lockStatus;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 创建者
     */
    private String createdUser;
    /**
     * 最后更新时间
     */
    private Date updatedAt;
    /**
     * 应用使用次数
     */
    private Integer useCount;
    /**
     * 最后更新人
     */
    private String updatedUser;
    /**
     * 删除标记 1:已删除
     */
    private Integer isDel;

    public AppBase() {
    }

    public AppBase(String appId, String name) {
        this.appId = appId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAppShow() {
        return appShow;
    }

    public void setAppShow(String appShow) {
        this.appShow = appShow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public Integer getPersonalize() {
        return personalize;
    }

    public void setPersonalize(Integer personalize) {
        this.personalize = personalize;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public String getJumpAddr() {
        return jumpAddr;
    }

    public void setJumpAddr(String jumpAddr) {
        this.jumpAddr = jumpAddr;
    }

    public String getFromStore() {
        return fromStore;
    }

    public void setFromStore(String fromStore) {
        this.fromStore = fromStore;
    }

    public String getPackageVersionCode() {
        return packageVersionCode;
    }

    public void setPackageVersionCode(String packageVersionCode) {
        this.packageVersionCode = packageVersionCode;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "AppBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appId='" + appId + '\'' +
                ", appType='" + appType + '\'' +
                ", link='" + link + '\'' +
                ", appShow='" + appShow + '\'' +
                ", description='" + description + '\'' +
                ", order=" + order +
                ", sysId=" + sysId +
                ", parent=" + parent +
                ", level=" + level +
                ", iconName='" + iconName + '\'' +
                ", iconColor='" + iconColor + '\'' +
                ", personalize=" + personalize +
                ", openType=" + openType +
                ", jumpAddr='" + jumpAddr + '\'' +
                ", fromStore='" + fromStore + '\'' +
                ", packageVersionCode='" + packageVersionCode + '\'' +
                ", lockStatus=" + lockStatus +
                ", createdAt=" + createdAt +
                ", createdUser='" + createdUser + '\'' +
                ", updatedAt=" + updatedAt +
                ", useCount=" + useCount +
                ", updatedUser='" + updatedUser + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}
