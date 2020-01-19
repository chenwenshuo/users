package com.cws.users.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author wenshuo.chen@hand-china.com 2020/1/16 15:39
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @param key
     * @param time
     * @return 设置缓存过期时间
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 根据key获取过期时间
     *
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);

    }

    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 根据key删除value
     *
     * @param key
     */
    public void del(String... key) {
        if (null != key && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 插入
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object object) {
        try {
            redisTemplate.opsForValue().set(key, object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 插入 并设置过期时间
     *
     * @param key
     * @param object
     * @param time   时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return
     */
    public boolean set(String key, Object object, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, object, time, TimeUnit.SECONDS);
            } else {
                set(key, object);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     *
     * @param key
     * @param delta 增加大小
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("小于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key
     * @param delta
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("小于0");
        }
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    /**
     * Hashset 根据key和item获取值
     *
     * @param key
     * @param item
     * @return
     */
    public Object hGet(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 根据key获取键值对map
     *
     * @param key
     * @return
     */
    public Map<Object, Object> hmGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 根据key插入map
     *
     * @param key
     * @param map
     * @return
     */
    public boolean hmSet(String key, Map<Object, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param map
     * @param time
     * @return
     */
    public boolean hmSet(String key, Map<Object, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //==========hash==========

    /**
     * 向一个hash表中插入键值项
     *
     * @param key   键
     * @param item  值
     * @param value 项
     * @return
     */
    public boolean hSet(String key, String item, String value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一个hash表中插入键值项 并设置过期时间
     *
     * @param key
     * @param item
     * @param value
     * @param time
     * @return
     */
    public boolean hSet(String key, String item, String value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key
     * @param item
     */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有值
     *
     * @param key
     * @param item
     * @return
     */
    public boolean hHaskey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key
     * @param item
     * @param d
     * @return
     */
    public double hincr(String key, String item, double d) {
        return redisTemplate.opsForHash().increment(key, item, d);
    }

    /**
     * hash递减
     *
     * @param key
     * @param item
     * @param d
     * @return
     */
    public double hdecr(String key, String item, double d) {
        return redisTemplate.opsForHash().increment(key, item, -d);
    }

    //=====================set========

    /**
     * 根据key获取set集合
     *
     * @param key
     * @return
     */
    public Set<Object> sGet(String key) {
        try {

            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据value判断set中是否有该值
     *
     * @param key
     * @param item
     * @return
     */
    public boolean sHaskey(String key, Object item) {
        try {
            return redisTemplate.opsForSet().isMember(key, item);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key
     * @param values
     * @return 插入成功个数
     */
    public long sSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 设置过期时间并插入key
     *
     * @param key
     * @param time
     * @param values
     * @return
     */
    public long sSet(String key, long time, Object... values) {
        try {
            Long add = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time);
            }
            return add;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set长度
     *
     * @param key
     * @return
     */
    public long sGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除set中的value
     *
     * @param key
     * @param values
     * @return
     */
    public long setRemove(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //===========list=========

    /**
     * 获取List中值
     *
     * @param key
     * @param start 初始
     * @param end   结束 start 0,end -1 代表所有值
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取所有
     *
     * @param key
     * @return
     */
    public List<Object> lGetAll(String key) {
        try {
            return redisTemplate.opsForList().range(key, 0, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list长度
     *
     * @param key
     * @return
     */
    public long lGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 根据索引获取
     * 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @param key
     * @param index
     * @return
     */
    public Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 插入list
     * @param key
     * @param value
     * @return
     */
    public boolean lSet(String key,Object value){
        try {
            redisTemplate.opsForList().rightPush(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 插入list并设置过期时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean lSet(String key,Object value,long time){
        try {
            redisTemplate.opsForList().rightPush(key,value);
            if (time>0){
                expire(key,time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 批量插入list
     * @param key
     * @param values
     * @return
     */
    public boolean lSet(String key,List<Object> values){
        try {
            redisTemplate.opsForList().rightPushAll(key,values);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改List 中数据
     * @param key
     * @param index
     * @param value
     * @return
     */
    public boolean lupdateIndex(String key,long index,Object value){
        try {
            redisTemplate.opsForList().set(key,index,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除n个值为value的值
     * @param key
     * @param count
     * @param value
     * @return
     */
    public long lRemove(String key,long count,String value){
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}
