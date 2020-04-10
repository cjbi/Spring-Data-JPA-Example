package tech.wetech.example.dto;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
public class UserSimpleDTO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;

    private List<Long> roleIds;

    public UserSimpleDTO() {
    }

    public UserSimpleDTO(Long id, String username, String roleIds) {
        this.id = id;
        this.username = username;
        this.roleIds = Arrays.stream(roleIds.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
