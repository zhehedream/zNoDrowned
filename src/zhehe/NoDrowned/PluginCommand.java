/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhehe.NoDrowned;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Zhehe
 */
public class PluginCommand {
    private PluginCommand() {
        ;
    }
    
    private static final PluginCommand instance = new PluginCommand();
    
    public static PluginCommand getInstance() {
        return instance;
    }
    
    public Drowned_Spawn drowned_spawn = new Drowned_Spawn();
    
    public class Drowned_Spawn implements CommandExecutor {
        
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(args.length != 1) return false;
            if(args[0].equals("on")) {
                CreatureSpawnListener.getInstance().enable = true;
            } else if(args[0].equals("off")) {
                CreatureSpawnListener.getInstance().enable = false;
            } else {
                return false;   
            }
            
            return true;
        }
    }
}
