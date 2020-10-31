package spring.starter.data.rdms.aspect;

/**
 * @author pickjob@126.com
 * @date 2019-02-22
 */
public class DataSourceHolder {
    private static ThreadLocal<DataSourceKey.DataSourceKeyEnum> holder = new ThreadLocal<>() {
        @Override
        protected DataSourceKey.DataSourceKeyEnum initialValue() {
            return DataSourceKey.DataSourceKeyEnum.PRIMARY;
        }
    };

    public static void setDataSourceKey (DataSourceKey.DataSourceKeyEnum key) {
        holder.set(key);
    }

    public static DataSourceKey.DataSourceKeyEnum getDataSourceKey() {
        return holder.get();
    }
}
