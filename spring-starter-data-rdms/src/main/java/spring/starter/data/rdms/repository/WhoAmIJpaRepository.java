package spring.starter.data.rdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.starter.data.rdms.entity.WhoAmI;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-08
 */
@Repository
public interface WhoAmIJpaRepository extends JpaRepository<WhoAmI, Long> {
}
