package fr.lucasprogram.hgmcredisdata.redis;

import lombok.NonNull;
import org.redisson.Redisson;

public interface IRedisProvider extends IRedis{

    /**
     * Gets the global redis instance.
     *
     * @return the global redis instance.
     */
    @NonNull
    Redisson getRedis();

    /**
     * Constructs a new redis instance using the given credentials.
     *
     * <p>These instances are not cached, and a new redis instance is created each
     * time this method is called.</p>
     *
     * @param credentials the credentials for the redis instance
     * @return a new redis instance
     */
    @NonNull
    Redisson getRedis(@NonNull RedisCredentials credentials);

    /**
     * Gets the global redis credentials being used for the global redis instance.
     *
     * @return the global credentials
     */
    @NonNull
    RedisCredentials getGlobalCredentials();
}
