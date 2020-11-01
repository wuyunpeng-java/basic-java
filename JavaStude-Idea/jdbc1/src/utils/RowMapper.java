package utils;

import java.sql.ResultSet;

/**
 *@ author:吴云鹏
 * Date:2020/6/6
 * Time:16:21
 * 封装对象的能力
 */
public interface RowMapper<T> {
    T getRow(ResultSet rs);
}
