package entities;

/**
 * Created by radu on 05.05.2017.
 */
public class UserEntity {

    private int id;
    private String role;
    private String name;

    public UserEntity(int id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
