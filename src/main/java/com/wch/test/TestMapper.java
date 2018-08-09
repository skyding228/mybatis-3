package com.wch.test;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * created at 2018/8/9
 * created by weichunhe
 */
public interface TestMapper {
    /**
     *
     * @return
     */
    @Select("select * from test")
    List<Test> selectTest();
}
