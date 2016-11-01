package mt.edu.um.cs.rv.demo.controllers;


import mt.edu.um.cs.rv.demo.model.User;
import mt.edu.um.cs.rv.demo.services.UserNotFoundException;
import mt.edu.um.cs.rv.demo.services.UserService;
import valour.demo.monitor_triggers.MonitorTrigger1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dwardu on 28/11/15.
 */

@RestController
public class DemoController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Collection<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestParam(value = "username") String username) {
        User newUser = userService.createNewUser(username);
        
        MonitorTrigger1 monitorTrigger1 = new MonitorTrigger1();
	    monitorTrigger1.accept(newUser.getId(), newUser.getUsername());
	    
	    return newUser;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/{id}/active", method = RequestMethod.PUT)
    @ResponseBody
    public User activateUser(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        return userService.makeUserActive(id);
    }

    @RequestMapping(value = "/user/{id}/inactive", method = RequestMethod.PUT)
    @ResponseBody
    public User makeUserInactive(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        return userService.makeUserInactive(id);
    }

    @RequestMapping(value = "/user/{id}/deactive", method = RequestMethod.PUT)
    @ResponseBody
    public User deactivateUser(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        return userService.makeUserDeactive(id);
    }
}
