package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

/**
 * Created by archerlj on 2017/6/26.
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


    /**

     对于使用 @Cacheable 注解的方法，每个缓存的 key 生成策略默认使用的是参数名+参数值，比如以下方法：

     @Cacheable("users")
     public User findByUsername(String username)

     这个方法的缓存将保存于 key 为 users~keys 的缓存下，对于 username 取值为 "赵德芳" 的缓存，
     key 为 "username-赵德芳"。一般情况下没啥问题，二般情况如方法 key 取值相等然后参数名也一样的时候就出问题了，如：

     @Cacheable("users")
     public Integer getLoginCountByUsername(String username)

     这个方法的缓存也将保存于 key 为 users~keys 的缓存下。对于 username 取值为 "赵德芳" 的缓存，key 也为 "username-赵德芳"，将另外一个方法的缓存覆盖掉。
     解决办法是使用自定义缓存策略，对于同一业务(同一业务逻辑处理的方法，哪怕是集群/分布式系统)，生成的 key 始终一致，对于不同业务则不一致：
     于是上述两个方法，对于 username 取值为 "赵德芳" 的缓存，虽然都还是存放在 key 为 users~keys 的缓存下，但由于 key 分别为 "类名-findByUsername-username-赵德芳" 和 "类名-getLoginCountByUsername-username-赵德芳"，所以也不会有问题。
     这对于集群系统、分布式系统之间共享缓存很重要，真正实现了分布式缓存。
     笔者建议：缓存方法的 @Cacheable 最好使用方法名，避免不同的方法的 @Cacheable 值一致，然后再配以以上缓存策略。

     */

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object object:objects) {
                    sb.append(object.toString());
                }
                return sb.toString();
            }
        };
    }

    // 要启用缓存支持，我们需要创建一个新的 CacheManager bean
    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager manager = new RedisCacheManager(redisTemplate);
        return manager;
    }


    /**

     Redis 可以存储键与5种不同数据结构类型之间的映射，这5种数据结构类型分别为String（字符串）、List（列表）、Set（集合）、Hash（散列）和 Zset（有序集合）。

     spring 封装了 RedisTemplate 对象来进行对redis的各种操作，它支持所有的 redis 原生的 api。

     模板中的Redis key的类型（通常为String）如：RedisTemplate<String, Object>
     注意：如果没特殊情况，切勿定义成RedisTemplate<Object, Object>，否则根据里氏替换原则，使用的时候会造成类型错误 。

     RedisTemplate中定义了对5种数据结构操作

     redisTemplate.opsForValue();//操作字符串
     redisTemplate.opsForHash();//操作hash
     redisTemplate.opsForList();//操作list
     redisTemplate.opsForSet();//操作set
     redisTemplate.opsForZSet();//操作有序set


     StringRedisTemplate与RedisTemplate

     两者的关系是StringRedisTemplate继承RedisTemplate。

     两者的数据是不共通的；也就是说StringRedisTemplate只能管理StringRedisTemplate里面的数据，RedisTemplate只能管理RedisTemplate中的数据。

     SDR默认采用的序列化策略有两种，一种是String的序列化策略，一种是JDK的序列化策略。

     StringRedisTemplate默认采用的是String的序列化策略，保存的key和value都是采用此策略序列化保存的。

     RedisTemplate默认采用的是JDK的序列化策略，保存的key和value都是采用此策略序列化保存的。
     因此被缓存对象需要实现java.io.Serializable接口，否则缓存出错。

     */

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
