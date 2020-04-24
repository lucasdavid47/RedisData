package fr.lucasprogram.hgmcredisdata.commons;

public interface IRedis {

    /**
     * Handle redis message on server.
     * @param source Server that sent the message.
     * @param channel Channel name where the message was published.
     * @param message message.
     */
    void onRedisMessageEven(String source, String channel, String message);


    /**
     * @return Name of the Bungee instance. (cf. configfile).
     */
    String getBungeeName();

    /**
     * @return the name of the server (cf configfile).
     */
    String getServerName();


    void info(String msg);

    void severe(String msg);

    void debug(String msg);
}
