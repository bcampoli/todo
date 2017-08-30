package demo.repository;

import demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by William Campoli on 2017-08-25.
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
}