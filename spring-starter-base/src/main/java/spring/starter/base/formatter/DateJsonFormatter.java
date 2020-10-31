package spring.starter.base.formatter;

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

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author pickjob@126.com
 * @date 2020-05-13
 */
@JsonComponent
public class DateJsonFormatter {
    private static Logger logger = LogManager.getLogger(DateJsonFormatter.class);
    private static ThreadLocal<DateFormat> formatter = new ThreadLocal<>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static class DateJsonSerializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            logger.info("serialize {}", value);
            gen.writeString(formatter.get().format(value));
        }
    }

    public static class DateJsonDeserialize extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            logger.info("deserialize {}", p.getText());
            try {
                return formatter.get().parse(p.getText());
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return null;
            }
        }
    }

}
