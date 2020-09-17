package app.repository.jpa;

import app.model.entity.WhoAmI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-08
 */
@Repository
public interface WhoAmIJpaRepository extends JpaRepository<WhoAmI, Byte> {
}
