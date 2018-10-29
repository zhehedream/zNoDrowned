/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhehe.NoDrowned;

//import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

/**
 *
 * @author Zhehe
 */
public class CreatureSpawnListener implements Listener {
    public boolean enable = false;
    private CreatureSpawnListener() {
        ;
    }
    
    private static final CreatureSpawnListener instance = new CreatureSpawnListener();
    
    public static CreatureSpawnListener getInstance() {
        return instance;
    }
    
    @EventHandler
     public void onCreatureSpawn(CreatureSpawnEvent event)
     {
         if(!enable) return;
         //Bukkit.broadcastMessage(event.getSpawnReason().toString());
         if(event.getEntityType() == EntityType.DROWNED) {
             SpawnReason reason = event.getSpawnReason();
             if(reason == SpawnReason.DROWNED || reason == SpawnReason.SPAWNER_EGG) return;
             event.setCancelled(true);
         }
     }
}
