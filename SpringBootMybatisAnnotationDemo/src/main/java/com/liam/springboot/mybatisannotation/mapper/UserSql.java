package com.liam.springboot.mybatisannotation.mapper;

import com.liam.springboot.mybatisannotation.param.UserParam;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @Author: Liam
 * @Date: 2019/2/28 21:14
 */
public class UserSql {
    public String getList(UserParam userParam) {
        StringBuffer sql = new StringBuffer("select id, userName, passWord, user_sex as userSex, nick_name as nickName");
        sql.append(" from users  where 1=1 ");
        if (userParam != null) {
            if (!StringUtils.isEmpty(userParam.getUserName())) {
                sql.append(" and userName = #{userName}");
            }
            if (!StringUtils.isEmpty(userParam.getUserSex())) {
                sql.append(" and user_sex = #{userSex}");
            }
        }
        sql.append(" order by id desc");
        sql.append(" limit " + userParam.getBeginLine() + "," + userParam.getPageSize());
        System.out.println("getList sql is: " + sql.toString());
        return sql.toString();
    }

    public String getCount(UserParam userParam) {
        String sql = new SQL() {{
            SELECT("count(1)");
            FROM("users");
            if (!StringUtils.isEmpty(userParam.getUserName())) {
                WHERE("userName = #{userName}");
            }
            if (!StringUtils.isEmpty(userParam.getUserSex())) {
                WHERE("user_sex = #{userSex}");
            }
        }}.toString();
        System.out.println("getCount sql is: " + sql);
        return sql;
    }
}
