package com.yeahbutstill.dao;

import com.yeahbutstill.bean.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDao {

    private static final List<User> users = new ArrayList<>();

    private static Long userCount = 1L;

    static {
        users.add(new User(userCount++, "Maya", LocalDate.now().minusYears(29)));
        users.add(new User(userCount++, "Winda", LocalDate.now().minusYears(25)));
        users.add(new User(userCount++, "Yasmin", LocalDate.now().minusYears(1)));
        users.add(new User(userCount++, "Nay", LocalDate.now().minusYears(7)));
        users.add(new User(userCount++, "Piki", LocalDate.now().minusYears(5)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(userCount++);
        users.add(user);
        return user;
    }

    public User findOne(Long id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

}
