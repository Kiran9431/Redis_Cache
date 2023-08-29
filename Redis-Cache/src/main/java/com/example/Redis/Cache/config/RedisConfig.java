package com.example.Redis.Cache.config;

import com.example.Redis.Cache.Binding.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory jediscon(){
        JedisConnectionFactory jedis = new JedisConnectionFactory();
        //server properties
        return jedis;
    }
    @Bean
    public RedisTemplate<String, Employee> redisTemplate(){
        RedisTemplate<String , Employee> reditem = new RedisTemplate<>();
        reditem.setConnectionFactory(jediscon());

        return reditem;
    }

}
