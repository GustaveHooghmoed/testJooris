package coinsapi.api;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class methodsAPI {
    UUID u;
    String name;
    File pData;
    FileConfiguration pDataConfig;

    public methodsAPI(UUID u, Player p) {
        this.u = u;
        this.name = p.getName();
        pData = new File("plugins/PardoesCraft/spelers/" + u + ".yml");
        pDataConfig = YamlConfiguration.loadConfiguration(pData);
    }
    
    public void createPlayerConfig() {
        if (!pData.exists()) {  // Make sure the file doesn't exist before making the file.
            try {
                pData.createNewFile();
                if (pData.length() <= 0) { // Checking if there isn't any data in the file.
                    pDataConfig.set("Money", 0);
                    pDataConfig.set("User", name);
                    pDataConfig.save(pData);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   
    
    public FileConfiguration getPlayerConfig() {
        return pDataConfig;
    }
    
    public void savePlayerConfig() {
        try {
            getPlayerConfig().save(pData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int getMoney() {
        return pDataConfig.getInt("Money");
        
    }
    
    public void setMoney(int amount) throws IOException {
        pDataConfig.set("Money", amount);
        pDataConfig.save(pData);
    }
    
    public void takeMoney(int amount) throws IOException {
        pDataConfig.set("Money", getMoney() - amount);
        pDataConfig.save(pData);
    }
    
    public void giveMoney(int amount) throws IOException {
        pDataConfig.set("Money", getMoney() + amount);
        pDataConfig.save(pData);
    }
    
}
