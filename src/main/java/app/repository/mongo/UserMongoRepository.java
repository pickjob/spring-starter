package app.repository.mongo;

import app.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author ws@yuan-mai.com
 * @Date 2020-09-15
 */
public interface UserMongoRepository extends MongoRepository<User, Long> {
}
