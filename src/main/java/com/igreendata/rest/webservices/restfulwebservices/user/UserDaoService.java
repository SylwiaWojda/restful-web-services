package com.igreendata.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static int userCount = 0;
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Jordan", LocalDate.now().minusYears(40)));
    }



    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals((id));
        return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

}
