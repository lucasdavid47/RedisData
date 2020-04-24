package fr.lucasprogram.hgmcredisdata.config;

import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.*;

public interface ConfigUtils {


    static File saveRessource(Plugin plugin, String ressourceName, String destinationName){
        return saveResource(plugin, ressourceName, destinationName, false);
    }

    static File saveResource(Plugin plugin, String resourceName, String destinationName,boolean replace)
    {
        File folder = plugin.getDataFolder();

        if(!folder.exists() && !folder.mkdir())
        {
            return null;
        }

        File destinationFile = new File(folder, destinationName);

        try
        {
            if(!destinationFile.exists() || replace)
            {
                if(destinationFile.createNewFile())
                {
                    try(InputStream in = plugin.getResourceAsStream(resourceName);
                        OutputStream out = new FileOutputStream(destinationFile))
                    {
                        ByteStreams.copy(in, out);
                    }
                }
                else { return null; }
            }

            return destinationFile;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
