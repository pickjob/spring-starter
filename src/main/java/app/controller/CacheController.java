package app.controller;

import app.model.MyResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pickjob@126.com
 * @time 2019-08-13
 */
@RestController
@RequestMapping("/v1/cache")
public class CacheController {
    private static final Logger logger = LogManager.getLogger(CacheController.class);

    @Cacheable(value = "cacheName", key = "#id")
    @RequestMapping("/query-and-cache")
    public MyResponse queryAndCache(Integer id) {
        logger.info("no cache: {}", id);
        return MyResponse.response(id + "", "cache", null);
    }

    @CachePut("cacheName")
    @RequestMapping("/update-cache")
    public MyResponse queryAndPutCache(Integer id) {
        logger.info("update cache: {}", id);
        return MyResponse.response(id + "", "update cache", null);
    }



}
