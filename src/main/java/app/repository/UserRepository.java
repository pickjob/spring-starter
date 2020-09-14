package app.repository;

import app.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-03
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
