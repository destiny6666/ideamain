/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RedisService
 * Author:   user
 * Date:     2018/7/6 11:43
 * Description: RedisService接口定义
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package redis;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈RedisService接口定义〉
 *
 * @author user
 * @create 2018/7/6
 * @since 1.0.0
 */
@RequestMapping("/redis")
public interface RedisService {
@RequestMapping("getRedis")
    public String getRedis();
}