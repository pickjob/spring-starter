package app.aop.datasource.annotation;

import app.aop.datasource.keys.DataSourceKeyEnum;

import java.lang.annotation.*;

/**
 * @author pickjob@126.com
 * @time 2019-02-22
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceKey {
    DataSourceKeyEnum value() default DataSourceKeyEnum.SCHEMA_A;
}
