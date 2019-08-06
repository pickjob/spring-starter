package app.type.handler;

import app.common.StatusEnum;
import org.apache.ibatis.type.JdbcType;
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
@MappedTypes({StatusEnum.class})
public class StatusTypeHandler implements TypeHandler<StatusEnum> {

    @Override
    public void setParameter(PreparedStatement ps, int i, StatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, parameter.value());
    }

    @Override
    public StatusEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return StatusEnum.valueOf(rs.getInt(columnName));
    }

    @Override
    public StatusEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return StatusEnum.valueOf(rs.getInt(columnIndex));
    }

    @Override
    public StatusEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return StatusEnum.valueOf(cs.getInt(columnIndex));
    }
}
