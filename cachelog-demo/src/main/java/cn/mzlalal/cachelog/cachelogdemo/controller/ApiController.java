package cn.mzlalal.cachelog.cachelogdemo.controller;

import cn.mzlalal.cachelog.cachelogcore.annotaion.Cachelog;
import cn.mzlalal.cachelog.cachelogdemo.entity.Results;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @description: 该类中所有方法都会被aop切入
 * @author: Mzlalal
 * @date: 2019/11/19 22:15
 * @version: 1.0
 */
@Slf4j
@Cachelog(isRedis = true)
@RestController
@RequestMapping("test")
public class ApiController {

    /**
     * 不会记录日志
     * @return
     */
    @RequestMapping("testAnnotation")
    @Cachelog(isLog = false)
    public Results find () {
        return Results.OK("测试");
    }


    /**
     * 这个不会保存到redis
     * @return
     */
    @RequestMapping("testAnnotation2")
    @Cachelog
    public Results save () {
        return Results.OK("新增");
    }

    /**
     * 这个不会保存到redis
     * @return
     */
    @RequestMapping("testAnnotation3")
    public Results list (String arg1, String args2) {
        try {
            throw new IOException(JSON.toJSONString(Results.FAIL("查询失败")));
        } catch (IOException e) {
            log.error("查询失败!", e);
            return Results.FAIL("查询失败");
//            throw new RuntimeException(JSON.toJSONString(Results.FAIL("查询失败")), e);
        }
    }
}
