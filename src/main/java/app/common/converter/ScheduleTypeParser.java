package app.common.converter;

import app.common.enums.ScheduleTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.Parser;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author pickjob@126.com
 * @time 2020-05-13
 */
public class ScheduleTypeParser implements Parser<ScheduleTypeEnum> {
    private static final Logger logger = LogManager.getLogger(ScheduleTypeParser.class);

    @Override
    public ScheduleTypeEnum parse(String text, Locale locale) throws ParseException {
        logger.info("parse {}", text);
        ScheduleTypeEnum typeEnum = ScheduleTypeEnum.valueOf(Byte.valueOf(text));
        return typeEnum;
    }
}
