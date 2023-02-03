package com.java668.mybatisplus.dynamic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java668.mybatisplus.dynamic.mapper.UserMapper;
import com.java668.mybatisplus.dynamic.po.User;
import com.java668.mybatisplus.dynamic.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/02/01 16:35
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final SqlSessionTemplate sqlSessionTemplate;

    protected SqlSession getNativeSqlSession() {
        return SqlSessionUtils.getSqlSession(sqlSessionTemplate.getSqlSessionFactory(),
                sqlSessionTemplate.getExecutorType(), sqlSessionTemplate.getPersistenceExceptionTranslator());
    }

    protected void closeNativeSqlSession(SqlSession sqlSession) {
        SqlSessionUtils.closeSqlSession(sqlSession, sqlSessionTemplate.getSqlSessionFactory());

    }

    @Override
    public void test()  throws SQLException {
        int count = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = getNativeSqlSession();
            Connection conn = sqlSession.getConnection();
            PreparedStatement ps = conn.prepareStatement("select sleep(34)");
            ps.executeQuery();
        } catch (SQLException e) {
            log.error("批量写入埋点数据异常：", e);
            throw e;
        } finally {
            if (null != sqlSession) {
                closeNativeSqlSession(sqlSession);
            }
        }
    }
}