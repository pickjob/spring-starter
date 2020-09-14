package app.repository;

import app.model.entity.WhoAmI;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-08
 */
public interface WhoAmIRepository extends JpaRepository<WhoAmI, Byte> {
}
