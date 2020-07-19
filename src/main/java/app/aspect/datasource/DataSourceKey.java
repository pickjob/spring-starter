package app.aspect.datasource;

import java.lang.annotation.*;

/**
 * @author pickjob@126.com
 * @date 2019-02-22
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceKey {
    DataSourceKeyEnum value() default DataSourceKeyEnum.PRIMARY;

    enum DataSourceKeyEnum {
        PRIMARY,
        SECONDARY;
    }
}
