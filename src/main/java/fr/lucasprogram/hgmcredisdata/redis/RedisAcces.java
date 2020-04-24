package fr.lucasprogram.hgmcredisdata.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

public class RedisAcces {
    private RedissonClient redissonClient;

    public static RedisAcces INSTANCE; //singleton for acces

    public RedisAcces(RedisCredentials credentials){
        this.redissonClient = initRedissonConnection(credentials);
    }

    public static void init(){
        new RedisAcces(new RedisCredentials("127.0.0.1", "pass", 6379));//todo with configfile :)
    }

    public static void close(){
        RedisAcces.INSTANCE.getRedissonClient().shutdown();
    }


    public RedissonClient initRedissonConnection(RedisCredentials credentials){
        final Config redissonConfig = new Config();
        redissonConfig.setCodec(new JsonJacksonCodec());
        redissonConfig.setUseLinuxNativeEpoll(true);
        redissonConfig.setThreads(Runtime.getRuntime().availableProcessors());
        redissonConfig.setNettyThreads(Runtime.getRuntime().availableProcessors());
        redissonConfig.useSingleServer().setAddress(credentials.toRedisURL())
                .setPassword(credentials.getPassword())
                .setDatabase(1)
                .setClientName(credentials.getClientName());

        return Redisson.create(redissonConfig);
    }

    public RedissonClient getRedissonClient(){
        return redissonClient;
    }


}
