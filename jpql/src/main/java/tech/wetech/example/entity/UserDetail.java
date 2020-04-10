package tech.wetech.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user_detail")
public class UserDetail {
    @Id
    private Long id;
    private String address;
    private String city;
    private String description;
    /**
     * 一对一关联，(开启懒加载模式后，需要的时候才从数据库去查)
     */
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    /**
     * 一对多关联
     */
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserTag> userTags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserTag> getUserTags() {
        return userTags;
    }

    public void setUserTags(List<UserTag> userTags) {
        this.userTags = userTags;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", userTags=" + userTags +
                '}';
    }
}
