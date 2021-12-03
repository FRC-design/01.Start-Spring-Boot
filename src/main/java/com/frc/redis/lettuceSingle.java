package com.frc.redis;
import java.time.*;
import java.util.Timer;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.reactive.RedisReactiveCommands;
import io.lettuce.core.api.sync.RedisCommands;

public class lettuceSingle {

    public static void main(String[] args) {

        RedisURI redisURI = null;
        RedisClient redisClient = null;
        StatefulRedisConnection<String, String> connection = null;
        RedisCommands<String, String> redisCommands = null;
        RedisAsyncCommands<String, String> redisAsyncCommands = null;
        RedisReactiveCommands<String, String> redisReactiveCommands = null;

        try {
            // redis连接信息---单机
            redisURI = RedisURI.builder()
                    .withHost("192.168.78.169")
                    .withPort(6379)
                    //.withPassword("123456")
                    .withDatabase(0)
                   /// .withTimeout(Uni)
                    .build();
            // redis客户端
            redisClient = RedisClient.create(redisURI);
            // redis连接
            connection = redisClient.connect();

            // redis命令API接口
            // sync：同步阻塞等待服务器返回结果	*******************************************************************************
			/*
			redisCommands = connection.sync();

			// 测试服务是否正常
			String pong = redisCommands.ping();
			if("PONG".equals(pong)) {
				System.out.println("redis服务正常......");
			}

			// 基本操作
			redisCommands.del("key", "key1");
			redisCommands.expire("key", 60);
			redisCommands.expireat("key", new Date());
			redisCommands.pexpire("key", 60000);
			redisCommands.persist("key");
			redisCommands.exists("key", "key1");
			redisCommands.dbsize();
			redisCommands.flushdb();
			redisCommands.flushdbAsync();
			redisCommands.flushall();
			redisCommands.flushallAsync();
			redisCommands.select(0);
			redisCommands.keys("pattern");
			redisCommands.scan();

			// 字符串操作
			redisCommands.set("key", "value");
			redisCommands.mset(new HashMap<String, String>());
			redisCommands.setnx("key", "value");
			redisCommands.setex("key", 60, "value");

			SetArgs setArgs = SetArgs.Builder.nx().ex(60);
			redisCommands.set("key", "value", setArgs);

			redisCommands.get("key");
			redisCommands.mget("key", "key1");
			redisCommands.incr("key");
			redisCommands.incrby("key", 10);
			redisCommands.decr("key");
			redisCommands.decrby("key", 10);

			// 哈希操作
			redisCommands.hset("key", "field", "value");
			redisCommands.hsetnx("key", "field", "value");
			redisCommands.hmset("key", new HashMap<String, String>());
			redisCommands.hget("key", "field");
			redisCommands.hmget("key", "field", "field1");
			redisCommands.hgetall("key");
			redisCommands.hexists("key", "field");
			redisCommands.hdel("key", "field", "field1");
			redisCommands.hlen("key");
			redisCommands.hincrby("key", "field", 1);
			redisCommands.hincrbyfloat("key", "field", 1.1);

			// 列表操作
			redisCommands.lpush("key", "value", "value1");
			redisCommands.rpush("key", "value", "value1");
			redisCommands.lpop("key");
			redisCommands.rpop("key");
			redisCommands.blpop(60, "key", "key1");
			redisCommands.brpop(60, "key", "key1");
			redisCommands.lrange("key", 0, 10);
			redisCommands.llen("key");

			// 集合操作
			redisCommands.sadd("key", "member", "member1");
			redisCommands.srem("key", "member", "member1");
			redisCommands.smembers("key");
			redisCommands.scard("key");
			redisCommands.sismember("key", "member");
			redisCommands.srandmember("key");
			redisCommands.srandmember("key", 10);
			redisCommands.spop("key");
			redisCommands.spop("key", 10);
			redisCommands.sinter("key", "key1");
			redisCommands.sinterstore("destination", "key", "key1");
			redisCommands.sunion("key", "key1");
			redisCommands.sunionstore("destination", "key", "key1");
			redisCommands.sdiff("key", "key1");
			redisCommands.sdiffstore("destination", "key", "key1");

			// 有序集合操作
			redisCommands.zadd("key", 80, "member");
			redisCommands.zadd("key", 80, "member", 70, "member1");
			redisCommands.zcard("key");

			Range<Integer> range = Range.create(0, 100);
			redisCommands.zcount("key", range);

			redisCommands.zrank("key", "member");
			redisCommands.zrevrank("key", "member");
			redisCommands.zrange("key", 0, 10);
			redisCommands.zrevrange("key", 0, 10);
			redisCommands.zscore("key", "member");
			redisCommands.zinterstore("destination", "key", "key1");
			redisCommands.zunionstore("destination", "key", "key1");
			// ...等等
			*/


            // async：异步非阻塞		********************************************************************************************
            // 操作类似sync，只不过返回结果都是RedisFuture
			/*
			redisAsyncCommands = connection.async();

			RedisFuture<String> redisFuture = redisAsyncCommands.ping();	// 此处不会阻塞
			System.out.println("Ping result: " + redisFuture.get());		// get方法获取结果时，此处会阻塞

			// redisFuture.get(60, TimeUnit.SECONDS);
			// redisFuture.getError();
			*/


            // reactive：反应式		********************************************************************************
            // 操作类似sync，只不过返回结果如果只包含0或1个元素，那么返回值类型是Mono，如果返回的结果包含0到N（N大于0）个元素，那么返回值是Flux
            // Reactor编程可以自己了解下，这里省略了，本人也不太了解
			/*
			redisReactiveCommands = connection.reactive();

			redisReactiveCommands.set("key", "value").block();
			redisReactiveCommands.get("key").subscribe(value -> System.out.println("结果：" + value));
			*/
        } catch(Exception e) {

            e.printStackTrace();
        } finally {

            if(connection != null) {
                connection.close();
            }

            if(redisClient != null) {
                redisClient.shutdown();
            }
        }
    }
}
