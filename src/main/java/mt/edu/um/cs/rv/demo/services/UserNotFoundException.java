package mt.edu.um.cs.rv.demo.services;

/**
 * Created by dwardu on 28/11/2015.
 */
public class UserNotFoundException extends Exception{
    private Long id;
    public UserNotFoundException(Long id){
        super("Unable to find user with the specified id: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
