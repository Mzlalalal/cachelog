package cn.mzlalal.cachelog.cachelogdemo.controller;

import cn.mzlalal.cachelog.cachelogcore.annotaion.Cachelog;
import cn.mzlalal.cachelog.cachelogdemo.entity.Results;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Mzlalal
 * @date: 2019/11/19 22:15
 * @version: 1.0
 */
@RestController
@RequestMapping("test")
public class ApiController {

    @Cachelog(isRedis = true)
    @RequestMapping("testAnnotation")
    public Results test () {
        return Results.OK("测试");
    }

}
