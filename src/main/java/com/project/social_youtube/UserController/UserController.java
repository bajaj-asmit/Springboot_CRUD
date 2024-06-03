package com.project.social_youtube.UserController;

import com.project.social_youtube.module.User;
import com.project.social_youtube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @DeleteMapping("/userDelete/{userid}")
    public String deleteUser(@PathVariable("userid") Integer userid) throws Exception {
        Optional<User> user=userRepository.findById(userid);

        if(user.isEmpty())
        {
            throw new Exception("user doesn't exist "+userid+" ");
        }

        userRepository.delete(user.get());
        return "User deleted successfully "+userid;
    }


    @PostMapping("/users")
    public User SetUser(@RequestBody User user)
    {
        User newUser=new User();
        newUser.setId(user.getId());
        newUser.setFirstname(user.getFirstname());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setLastname(user.getLastname());
        return userRepository.save(newUser);
    }

    @PutMapping("/userUpdate/{userid}")
    public User updateUser(@PathVariable("userid") Integer id, @RequestBody User updatedUser) throws Exception {
        Optional<User> user1 = userRepository.findById(id);


      User oldUser=user1.get();

      if(updatedUser.getFirstname()!=null)
      {
          oldUser.setFirstname(updatedUser.getFirstname());
      }
            if(updatedUser.getLastname()!=null)
            {
                oldUser.setLastname(updatedUser.getLastname());
            }
            if(updatedUser.getEmail()!=null)
            {
                oldUser.setEmail(updatedUser.getEmail());
            }


        if (user1.isEmpty()) {
            throw new Exception("user doesn't exist " + id + " ");
        }
        User updated=userRepository.save(oldUser);
        return updated;
    }


    @GetMapping("/user/{userid}")
    public Optional<User> getUserById(@PathVariable("userid") Integer id) throws Exception {
        Optional<User> u1 = userRepository.findById(id);

        if (u1.isPresent()) {
            return Optional.of(u1.get());
        }
        throw new Exception("user not exist");

    }
    @GetMapping("/user")
    public ArrayList<User> getUsers() {
        List<User> users= userRepository.findAll();
        return (ArrayList<User>) users;
    }

    private LinkedList<User> users;

    // Initialize users in the constructor
    public UserController() {
        users = new LinkedList<>();
        User u1 = new User("Asmit", "bajaj", "asmit@gmail.com", "123456", 1);
        User u2 = new User("Aashish", "boy", "a@gmail.com", "123456", 2);
        User u3 = new User("samson", "cricket", "s@gmail.com", "123456", 3);
        users.add(u1);
        users.add(u2);
        users.add(u3);
    }



}
