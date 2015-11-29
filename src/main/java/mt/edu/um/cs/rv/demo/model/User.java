package mt.edu.um.cs.rv.demo.model;

/**
 * Created by dwardu on 28/11/2015.
 */
public class User {


    private Long id;
    private String username;
    private UserState state;

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

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }
}
