package app.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    private static Logger logger = LogManager.getLogger(DateConverter.class);
    private ThreadLocal<DateFormat> formatter = new ThreadLocal<>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    @Override
    public Date convert(String source) {
        logger.info("parse source: {}", source);
        try {
            return formatter.get().parse(source);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
