package spring.starter.data.rdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.starter.data.rdms.entity.ScheduleJob;

/**
 * @Author pickjob@126.com
 * @Date 2020-10-30
 */
@Repository
public interface ScheduleJobRepository extends JpaRepository<ScheduleJob, Long> {
}
