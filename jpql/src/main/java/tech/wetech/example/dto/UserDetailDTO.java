package tech.wetech.example.dto;

/**
 * @author cjbi
 */
public class UserDetailDTO {
    /**
     * 编号
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 地址
     */
    private String address;
    /**
     * 城市
     */
    private String city;
    /**
     * 详情
     */
    private String description;

    public UserDetailDTO() {
    }

    public UserDetailDTO(Long userId, String username, String address, String city, String description) {
        this.userId = userId;
        this.username = username;
        this.address = address;
        this.city = city;
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
