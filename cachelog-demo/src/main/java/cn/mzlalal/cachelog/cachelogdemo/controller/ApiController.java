package cn.mzlalal.cachelog.cachelogdemo.controller;

import cn.mzlalal.cachelog.cachelogcore.annotaion.Cachelog;
import cn.mzlalal.cachelog.cachelogdemo.entity.Results;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 该类中所有方法都会被aop切入
 * @author: Mzlalal
 * @date: 2019/11/19 22:15
 * @version: 1.0
 */
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
}
