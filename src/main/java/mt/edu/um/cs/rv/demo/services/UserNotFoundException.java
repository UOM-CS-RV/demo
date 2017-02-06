package mt.edu.um.cs.rv.demo.services;

/**
 * Created by dwardu on 28/11/2015.
 */
public class UserNotFoundException extends Exception{
    private Long id = null;
    private String username = null;
    
    public UserNotFoundException(Long id){
        super("Unable to find user with the specified id: " + id);
        this.id = id;
    }
    
    public UserNotFoundException(String username){
        super("Unable to find user with the specified username: " + username);
        this.username = username;
    }

    public Long getId() {
        return id;
    }

	public String getUsername() {
		return username;
	}
   
}
