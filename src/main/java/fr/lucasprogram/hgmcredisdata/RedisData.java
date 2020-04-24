package fr.lucasprogram.hgmcredisdata;

import fr.lucasprogram.hgmcredisdata.commons.IRedis;
import fr.lucasprogram.hgmcredisdata.redis.RedisAcces;
import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public final class RedisData extends Plugin implements IRedis {


    private Configuration config;
    @Getter
    public static RedisData instance;


    @Override
    public void onEnable() {
        instance = this;
        RedisAcces.init();
    }

    @Override
    public void onDisable() {
        RedisAcces.close();
    }


    @Override
    public void onRedisMessageEven(String source, String channel, String message) {

    }

    @Override
    public String getBungeeName() {
        return null;
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public void info(String message)
    {
        getLogger().info(message);
    }

    @Override
    public void severe(String message)
    {
        getLogger().severe(message);
    }

    @Override
    public void debug(String message) {
            getLogger().info("[Debug] " + message);
    }


}
