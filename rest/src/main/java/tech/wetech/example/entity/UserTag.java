package tech.wetech.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user_tag")
public class UserTag implements Serializable {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetail userDetail;
    private String name;

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

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
