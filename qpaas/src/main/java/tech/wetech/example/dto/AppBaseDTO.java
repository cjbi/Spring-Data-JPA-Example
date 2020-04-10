package tech.wetech.example.dto;

public class AppBaseDTO {
    private String link;
    private String appShow;
    private String description;

    public AppBaseDTO(String link, String appShow, String description) {
        this.link = link;
        this.appShow = appShow;
        this.description = description;
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

    @Override
    public String toString() {
        return "AppBaseDTO{" +
                "link='" + link + '\'' +
                ", appShow='" + appShow + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
