package com.project.social_youtube.UserController;

import com.project.social_youtube.module.User;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
public class UserController {

    private LinkedList<User> users;

    // Initialize users in the constructor
    public UserController() {
        users = new LinkedList<>();
        User u1 = new User("Asmit Bajaj", "asmit@gmail.com", "9876543210", "123456", 1);
        User u2 = new User("Aashish", "aashish@gmail.com", "4204204204", "123456", 2);
        User u3 = new User("samson", "samson@gmail.com", "4569872350", "123456", 3);
        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

    @GetMapping("/user")
    public LinkedList<User> getUsers() {
        return users;
    }

    @GetMapping("/user/{userid}")
    public User getUserById(@PathVariable("userid") Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @PostMapping("/users")
    public User SetUser(@RequestBody User user)
    {
        User newUser=new User();
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhonenumber(user.getPhonenumber());

  return newUser;
    }
    @PutMapping("/userUpdate/{userid}")
    public User updateUser(@PathVariable("userid") Integer id, @RequestBody User updatedUser) {
        for (User user : users) {
            if (user.getId().equals(id)) {

                if (updatedUser.getName() != null) {
                    user.setName(updatedUser.getName());
                }
                if (updatedUser.getEmail() != null) {
                    user.setEmail(updatedUser.getEmail());
                }
                if (updatedUser.getPhonenumber() != null) {
                    user.setPhonenumber(updatedUser.getPhonenumber());
                }
                return user;
            }
        }
        return null;
    }
    @DeleteMapping("/userDelete/{userid}")
    public String deleteUser(@PathVariable("userid") Integer userid)
    {
        return "User deleted successfully "+userid;
    }


}
