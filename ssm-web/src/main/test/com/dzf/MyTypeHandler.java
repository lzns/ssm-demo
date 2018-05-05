package com.dzf;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * <p>
 *     将时间类型转为时间戳
 *
 * </p>
 *
 * <p>
 *     使用步骤1.在配置文件里面注册
 *            2.在每个标签里面引用 typeHandler = "全限定名"
 * </p>
 * @author dingzf
 * @date 2018/3/19
 * @time 15:02
 */
public class MyTypeHandler extends BaseTypeHandler<Date> {

    /**
     * 将java type convert  jdbc type
     * @param preparedStatement
     * @param i
     * @param date
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,date.getTime()+"");
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
       Date d = new Date();
       d.setTime(Long.parseLong(resultSet.getString(s)));
       return d;
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Date d = new Date();
        d.setTime(Long.parseLong(resultSet.getString(i)));
        return d;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Date d = new Date();
        d.setTime(Long.parseLong(callableStatement.getString(i)));
        return d;
    }
}
