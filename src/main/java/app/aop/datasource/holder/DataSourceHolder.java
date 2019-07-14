package app.aop.datasource.holder;

import app.aop.datasource.keys.DataSourceKeyEnum;

/**
 * @author pickjob@126.com
 * @time 2019-02-22
 */
public class DataSourceHolder {
    private static ThreadLocal<DataSourceKeyEnum> holder = new ThreadLocal<>();

    public static void setDataSourceKey (DataSourceKeyEnum key) {
        holder.set(key);
    }

    public static DataSourceKeyEnum getDataSourceKey() {
        return holder.get();
    }
}
