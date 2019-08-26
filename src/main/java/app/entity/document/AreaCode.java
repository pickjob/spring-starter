package app.entity.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author pickjob@126.com
 * @time 2019-08-14
 */
@Document("area-code")
@Data
public class AreaCode {
    @Id private String id;
    private Integer code;
    private String city;
    private String level;
}
