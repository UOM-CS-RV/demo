package mt.edu.um.cs.rv.demo.services;

import mt.edu.um.cs.rv.demo.model.User;
import mt.edu.um.cs.rv.demo.model.UserState;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dwardu on 28/11/2015.
 */
@Component
public class UserService {

    private AtomicLong idGenerator = new AtomicLong();

    private Map<Long, User> users = new ConcurrentHashMap<>();

    public User createNewUser(String username) {
        User user = new User();
        user.setId(idGenerator.incrementAndGet());
        user.setState(UserState.INITIALISED);
        user.setUsername(username);

        users.put(user.getId(), user);
        return user;
    }

    public User makeUserActive(Long id) throws UserNotFoundException {
        return updateState(id, UserState.ACTIVE);
    }

    public User makeUserInactive(Long id) throws UserNotFoundException {
        return updateState(id, UserState.INACTIVE);
    }

    public User makeUserDeactive(Long id) throws UserNotFoundException {
        return updateState(id, UserState.DEACTIVATED);
    }
    
    public Collection<User> getUsers() {
    		return users.values();
    }
    
    public User getUser(Long id) throws UserNotFoundException {
        User user = users.get(id);

        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return users.get(id);
    }

    private User updateState(Long id, UserState newState) throws UserNotFoundException {
        User user = getUser(id);
        user.setState(newState);
        return user;

    }
}
