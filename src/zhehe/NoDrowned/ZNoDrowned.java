/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhehe.NoDrowned;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Zhehe
 */
public class ZNoDrowned extends JavaPlugin {
    @Override
    public void onEnable() {
        DisableDrowned();
        RegisterCommand();
        PluginConfig.getInstance().reload();
    }

    @Override
    public void onDisable() {
        
    }
    
    public void DisableDrowned() {
        getServer().getPluginManager().registerEvents(CreatureSpawnListener.getInstance(), this);
    }
    
    public void RegisterCommand() {
        this.getCommand("drowned_spawn").setExecutor(PluginCommand.getInstance().drowned_spawn);
    }
}
