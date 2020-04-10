package tech.wetech.example.entity;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

/**
 * @author cjbi
 */
public class Datapool extends HashMap<String, Object> {

    public Datapool() {
    }

    @Id
    public Long getId() {
        return (Long) this.get("id");
    }

    public void setId(Long id) {
        this.put("id", id);
    }

    public String getOwner() {
        return (String) this.get("owner");
    }

    public  void setOwner(String owner) {
        this.put("owner", owner);
    }

    public String getModifier() {
        return (String) this.get("modifier");
    }

    public void setModifier(String modifier) {
        this.put("modifier", modifier);
    }

    public String getLastModified() {
        return (String) this.get("last_modified");
    }

    public void setLastModified(String lastModified) {
        this.put("last_modified", lastModified);
    }

    public Date getCreatedAt() {
        return (Date) this.get("created_at");
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.put("create_at", createdAt);
    }

    public String getModifiedMethod() {
        return (String) this.get("modified_method");
    }

    public void setModifiedMethod(String modifiedMethod) {
        this.put("modified_method", modifiedMethod);
    }

    public String getAppKey() {
        return (String) this.get("app_key");
    }

    public void setAppKey(String appKey) {
        this.put("app_key", appKey);
    }

    public String getAppExtendKey() {
        return (String) this.get("app_extend_key");
    }

    public void setAppExtendKey(String appExtendKey) {
        this.put("app_extend_key", appExtendKey);
    }

    public Boolean getDisable() {
        return (Boolean) this.get("disable");
    }

    public void setDisable(Integer disable) {
        this.put("disable", disable);
    }
}
