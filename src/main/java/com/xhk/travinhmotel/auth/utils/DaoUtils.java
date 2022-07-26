package com.xhk.travinhmotel.auth.utils;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


public class DaoUtils {

    private DaoUtils() {
    }

    public static Boolean getIntValueToBoolean(Integer dbValue) {
        return dbValue != null && "1".equals(dbValue.toString());
    }

    public static void setString(PreparedStatement ps, int parameterIndex, String value) throws SQLException {
        if (value != null) {
            ps.setString(parameterIndex, value);
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static void setLong(PreparedStatement ps, int parameterIndex, Long value) throws SQLException {
        if (value != null) {
            ps.setLong(parameterIndex, value);
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static void setInt(PreparedStatement ps, int parameterIndex, Integer value) throws SQLException {
        if (value != null) {
            ps.setInt(parameterIndex, value);
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static void setDouble(PreparedStatement ps, int parameterIndex, Double value) throws SQLException {
        if (value != null) {
            ps.setDouble(parameterIndex, value);
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static void setBigDecimal(PreparedStatement ps, int parameterIndex, BigDecimal value) throws SQLException {
        if (value != null) {
            ps.setBigDecimal(parameterIndex, value);
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static void setNullValue(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setString(parameterIndex, null);
    }

    public static void setDate(PreparedStatement ps, int parameterIndex, java.sql.Date value) throws SQLException {
        if (value != null) {
            ps.setDate(parameterIndex, value);
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static void setDate(PreparedStatement ps, int parameterIndex, Date value) throws SQLException {
        if (value != null) {
            ps.setDate(parameterIndex, new java.sql.Date(value.getTime()));
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static void setTimestamp(PreparedStatement ps, int parameterIndex, Timestamp value) throws SQLException {
        if (value != null) {
            ps.setTimestamp(parameterIndex, value);
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static void setTimestamp(PreparedStatement ps, int parameterIndex, Date value) throws SQLException {
        if (value != null) {
            ps.setTimestamp(parameterIndex, new Timestamp(value.getTime()));
        } else {
            setNullValue(ps, parameterIndex);
        }
    }

    public static String getString(ResultSet rs, String key) {
        try {
            return rs.getString(key);
        } catch (SQLException e) {
            return null;
        }
    }

    public static Integer getInt(ResultSet rs, String key) throws SQLException {
        Integer value = null;
        try {
            value = rs.getInt(key);
            if (rs.wasNull()) {
                value = null;
            }
        } catch (NullPointerException e) {
            if (rs.getObject(key) == null) {
                value = null;
            } else {
                throw e;
            }
        }
        return value;
    }

    public static Long getLong(ResultSet rs, String key) throws SQLException {
        Long value = rs.getLong(key);
        if (rs.wasNull()) {
            value = null;
        }
        return value;
    }

    public static Double getDouble(ResultSet rs, String key) throws SQLException {
        Double value = rs.getDouble(key);
        if (rs.wasNull()) {
            value = null;
        }
        return value;
    }

    public static BigDecimal getBigDecimal(ResultSet rs, String key) {
        try {
            if (rs.getBigDecimal(key) != null) {
                return rs.getBigDecimal(key);
            } else {
                return new BigDecimal("0.00");
            }
        } catch (SQLException e) {
            return new BigDecimal("0.00");
        }
    }

    public static Date getDate(ResultSet rs, String key) throws SQLException {
        Date value = null;
        java.sql.Date sqlDate = rs.getDate(key);
        if (sqlDate != null) {
            value = new Date(sqlDate.getTime());
        }
        return value;
    }

    public static Date getTimestamp(ResultSet rs, String key) {
        try {
            Date value = null;
            Timestamp sqlTimestamp = rs.getTimestamp(key);
            if (sqlTimestamp != null) {
                value = new Date(sqlTimestamp.getTime());
            }
            return value;
        } catch (SQLException e) {
            return null;
        }

    }

    public static Boolean getBoolean(ResultSet rs, String key) {
        try {
            Boolean value = rs.getBoolean(key);
            if (rs.wasNull()) {
                value = null;
            }
            return value;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Boolean getBoolean(ResultSet rs, String key, boolean defaultWhenNull) {
        try {
            Boolean value = rs.getBoolean(key);
            if (rs.wasNull()) {
                value = defaultWhenNull;
            }
            return value;
        } catch (SQLException e) {
            return defaultWhenNull;
        }
    }

}
