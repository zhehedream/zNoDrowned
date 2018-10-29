/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhehe.NoDrowned;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author Zhehe
 */
public class PluginConfig {
    public static File configFile;
    public static FileConfiguration fileConfiguration;
    
    private PluginConfig() {
        configFile = new File("plugins/ZNoDrowned", "config.yml");
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
        //reload();
    }
    
    private static final PluginConfig instance = new PluginConfig();
    
    public static PluginConfig getInstance() {
        return instance;
    }
    
    public final void reload() {
        if(configFile.exists()) {
            loadConfig();
        } else if(!configFile.exists()) {
            fileConfiguration.set("DisableDrownedOnStart", true);
            
            loadConfig();
            
            try {
                fileConfiguration.save(configFile);
            } catch (IOException ex) {
                //ex.printStackTrace();
            }
        }
    }
    
    private void loadConfig() {
        CreatureSpawnListener.getInstance().enable = fileConfiguration.getBoolean("DisableDrownedOnStart");
    }
}
