package app.repository.elasticsearch;

import app.model.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author ws@yuan-mai.com
 * @Date 2020-09-15
 */
@Repository
public interface UserESRepository extends ElasticsearchRepository<User, Long> {
}
