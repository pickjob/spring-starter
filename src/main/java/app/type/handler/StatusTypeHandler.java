package app.type.handler;

import app.common.enums.ScheduleStatusEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author pickjob@126.com
 * @time 2019-08-01
 */
@MappedJdbcTypes({JdbcType.TINYINT})
@MappedTypes({ScheduleStatusEnum.class})
public class StatusTypeHandler implements TypeHandler<ScheduleStatusEnum> {

    @Override
    public void setParameter(PreparedStatement ps, int i, ScheduleStatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, parameter.value());
    }

    @Override
    public ScheduleStatusEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return ScheduleStatusEnum.valueOf(rs.getInt(columnName));
    }

    @Override
    public ScheduleStatusEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return ScheduleStatusEnum.valueOf(rs.getInt(columnIndex));
    }

    @Override
    public ScheduleStatusEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return ScheduleStatusEnum.valueOf(cs.getInt(columnIndex));
    }
}
