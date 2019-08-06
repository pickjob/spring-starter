package app.type.handler;

import app.common.ScheduleTypeEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author pickjob@126.com
 * @time 2019-08-06
 */
@MappedTypes({StatusTypeHandler.class})
public class ScheduleTypeTypeHandler implements TypeHandler<ScheduleTypeEnum> {

    @Override
    public void setParameter(PreparedStatement ps, int i, ScheduleTypeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.value());
    }

    @Override
    public ScheduleTypeEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return ScheduleTypeEnum.valueOf(rs.getInt(columnName));
    }

    @Override
    public ScheduleTypeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return ScheduleTypeEnum.valueOf(rs.getInt(columnIndex));
    }

    @Override
    public ScheduleTypeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return ScheduleTypeEnum.valueOf(cs.getInt(columnIndex));
    }
}
