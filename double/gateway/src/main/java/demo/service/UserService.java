package demo.service;

import demo.domain.User;

/**
 * Created by William Campoli on 2017-08-28.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
