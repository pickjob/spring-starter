package spring.starter.data.rdms.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.jackson.JsonComponent;
import spring.starter.data.rdms.enums.ScheduleTypeEnum;

import java.io.IOException;

/**
 * @author pickjob@126.com
 * @date 2020-05-19
 */
@JsonComponent
public class ScheduleTypeJsonFormatter {
    private static final Logger logger = LogManager.getLogger(ScheduleTypeJsonFormatter.class);

    public static class ScheduleJsonSerializer extends JsonSerializer<ScheduleTypeEnum> {
        @Override
        public void serialize(ScheduleTypeEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            logger.info("serialize {}", value);
            gen.writeNumber(value.value());
        }
    }

    public static class ScheduleJsonDeserialize extends JsonDeserializer<ScheduleTypeEnum> {
        @Override
        public ScheduleTypeEnum deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonProcessingException {
            logger.info("deserialize {}", p.getByteValue());
            Byte b = p.getByteValue();
            return ScheduleTypeEnum.valueOf(b);
        }
    }
}
