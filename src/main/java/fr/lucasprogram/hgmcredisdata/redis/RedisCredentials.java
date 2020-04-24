package fr.lucasprogram.hgmcredisdata.redis;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class RedisCredentials {

    private String ip;
    private String password;
    private int port;
    private String clientName;

    public RedisCredentials(String ip, String password, int port){
        this(ip, password, port, "Bungee_Acces_Hgmc");
    }

    public RedisCredentials(String ip, String password, int port, String clientName) {
        this.ip = ip;
        this.password = password;
        this.port = port;
        this.clientName = clientName;
    }

    public String toRedisURL(){
        return "redis://" +ip+":"+port;
    }
}
