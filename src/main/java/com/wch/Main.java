package com.wch;

import com.wch.test.Test;
import com.wch.test.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * created at 2018/7/27
 * created by weichunhe
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Test> tests = sqlSession.selectList("selectTest");
        System.out.println(tests);

        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        System.out.println("--------------");
        System.out.println(mapper.selectTest());

        sqlSession.close();

    }
}
