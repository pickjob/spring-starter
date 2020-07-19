package app.type.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author pickjob@126.com
 * @date 2020-05-13
 */
public class DateFormatter implements Formatter<Date> {
    private static Logger logger = LogManager.getLogger(DateFormatter.class);
    private ThreadLocal<DateFormat> formatter = new ThreadLocal<>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    @Override
    public Date parse(String origin, Locale locale) throws ParseException {
        logger.info("parse : {}", origin);
        try {
            return formatter.get().parse(origin);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String print(Date date, Locale locale) {
        logger.info("print: {}", date);
        return formatter.get().format(date);
    }
}
