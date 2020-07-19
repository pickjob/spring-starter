package app.type.converter;

import app.enums.ScheduleTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author pickjob@126.com
 * @date 2020-05-13
 */
public class ScheduleTypeFormatter implements Formatter<ScheduleTypeEnum> {
    private static final Logger logger = LogManager.getLogger(ScheduleTypeFormatter.class);

    @Override
    public ScheduleTypeEnum parse(String origin, Locale locale) throws ParseException {
        logger.info("parse {}", origin);
        ScheduleTypeEnum typeEnum = ScheduleTypeEnum.valueOf(Byte.valueOf(origin));
        return typeEnum;
    }

    @Override
    public String print(ScheduleTypeEnum scheduleTypeEnum, Locale locale) {
        logger.info("print: {}", scheduleTypeEnum);
        return scheduleTypeEnum.value() + "";
    }
}
