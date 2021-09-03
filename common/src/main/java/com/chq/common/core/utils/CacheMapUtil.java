package com.chq.common.core.utils;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存初始化map信息
 */
public class CacheMapUtil {

    private static CacheMapUtil cacheUtil;
    private static Map<String,Object> cacheMap;
    private CacheMapUtil(){
        cacheMap = new HashMap<String, Object>();
    }

    public static CacheMapUtil getInstance(){
        if (cacheUtil == null){
            cacheUtil = new CacheMapUtil();
        }
        return cacheUtil;
    }

    /**
     * 添加缓存
     * @param key
     * @param obj
     */
    public void addCacheData(String key,Object obj){
        cacheMap.put(key,obj);
    }

    /**
     * 取出缓存
     * @param key
     * @return
     */
    public Object getCacheData(String key){
        return cacheMap.get(key);
    }

    /**
     * 清楚缓存
     * @param key
     */
    public void removeCacheData(String key){
        cacheMap.remove(key);
    }
}
