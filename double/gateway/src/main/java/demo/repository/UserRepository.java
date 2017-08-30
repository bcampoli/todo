package demo.repository;

import demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by William Campoli on 2017-08-25.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


}
