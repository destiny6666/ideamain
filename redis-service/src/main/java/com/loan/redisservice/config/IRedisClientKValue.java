/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: IRedisClientKValue
 * Author:   user
 * Date:     2018/7/4 17:46
 * Description: redis公共方法接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.redisservice.config;

import java.util.Date;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈redis公共方法接口〉
 *
 * @author user
 * @create 2018/7/4
 * @since 1.0.0
 */
public interface IRedisClientKValue<V>{
    public void set(String appkey, String key, V value);
    public void set(String appkey, String key, V value, long timeout);
    public void delete(String appkey, String key);
    public void multiSet(String appkey, Map<String, ? extends V> map);
    public V get(String appkey, String key, Class<? extends V> requireClass);
    public Long increment(String appkey, String key, long delta);
    public Boolean expire(String appkey, String key, final long timeout);
    public Boolean expireAt(String appkey, String key, final Date date);
}