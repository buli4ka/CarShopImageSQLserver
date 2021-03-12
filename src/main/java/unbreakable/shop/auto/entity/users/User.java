package unbreakable.shop.auto.entity.users;

import javax.persistence.*;

@Entity(name = "User")
@Table(schema = "carshop", name = "user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name", nullable = false, length = 72)
    private String userName;
    @Column(name = "user_password", nullable = false, length = 72)
    private String userPassword;
    @Column(name = "role", nullable = false)
    private String role;

    public User() {
    }

    public User(String userName, String userPassword, String role) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user_name) {
        this.userName = user_name;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String user_password) {
        this.userPassword = user_password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
