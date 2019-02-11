package com.garrybest.web;

import com.garrybest.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    @PostMapping
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable long id) {
        return users.get(id);
    }

    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        return "success";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable long id) {
        users.remove(id);
        return "success";
    }
}
