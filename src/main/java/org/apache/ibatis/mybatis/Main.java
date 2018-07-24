package org.apache.ibatis.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource=System.getProperty("user.dir")+"/source/mybatis-config.xml";
        System.out.println(resource);
        BufferedInputStream inputStream= new BufferedInputStream(new FileInputStream(resource));
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        Map<String,Object> parameter=new HashMap<String,Object>(1);
        parameter.put("id",1);
        UserInfo userInfo1=sqlSession.selectOne("org.apache.ibatis.mybatis.UserInfoMapper.selectById",parameter);
        UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo2=userInfoMapper.selectById(1);

        System.out.println(userInfo1);
        System.out.println(userInfo2);
        sqlSession.close();
    }
}
