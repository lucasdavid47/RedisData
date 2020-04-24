package fr.lucasprogram.hgmcredisdata.redis;

import lombok.NonNull;
import org.redisson.Redisson;

public interface IRedis {

    @NonNull Redisson getRedis();
}
