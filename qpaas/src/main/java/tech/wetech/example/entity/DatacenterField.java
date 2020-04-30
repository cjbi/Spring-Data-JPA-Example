package tech.wetech.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author cjbi
 */
@Entity
@Table(name = "ent_${entId}_datacenter_field")
public class DatacenterField {
    /**
     * 字段id
     */
    @Id
    private String id;
    /**
     * 字段名称
     */
    private String title;
    /**
     * 字段类型
     */
    private String type;
    /**
     * 属于哪一张表
     */
    private String belongs;
    /**
     * 字段配置面板字段属性为index倒序 created_time越新，index越大
     */
    private Integer index;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 修改者
     */
    private String modifier;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 最后修改时间
     */
    private Date lastModified;
    /**
     * 是否必填
     */
    private Integer required;
    /**
     * 基本信息(废弃)
     */
    private Integer basic;
    /**
     * 报表(废弃)
     */
    private Integer report;
    /**
     * 是否废弃
     */
    private Integer disable;

    public DatacenterField() {
    }

    public DatacenterField(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBelongs() {
        return belongs;
    }

    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    public Integer getBasic() {
        return basic;
    }

    public void setBasic(Integer basic) {
        this.basic = basic;
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }
}
