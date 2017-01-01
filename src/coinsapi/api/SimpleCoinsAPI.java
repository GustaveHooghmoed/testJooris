package coinsapi.api;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SimpleCoinsAPI
{
  public static void setCoins(Player p, Integer value)
  {
    SimpleCoins.cache.put(p.getUniqueId().toString(), value);
  }
  
  public static void setCoins(OfflinePlayer p, Integer value)
  {
    SimpleCoins.cache.put(p.getUniqueId().toString(), value);
  }
  
  public static Integer getCoins(Player p)
  {
    return (Integer)SimpleCoins.cache.get(p.getUniqueId().toString());
  }
  
  public static Integer getCoins(OfflinePlayer p)
  {
    if (SimpleCoins.cache.containsKey(p.getUniqueId().toString())) {
      return (Integer)SimpleCoins.cache.get(p.getUniqueId().toString());
    }
    new BukkitRunnable()
    {
      public void run()
      {
        if (SimpleCoins.sql.containsPlayer(SimpleCoinsAPI.getUniqueId().toString()))
        {
          SimpleCoins.cache.put(SimpleCoinsAPI.this.getUniqueId().toString(), SimpleCoins.sql.getColumn((p)));
        }
        else
        {
          SimpleCoins.sql.setPlayerCoins((p), Integer.valueOf(0));
          SimpleCoins.cache.put(SimpleCoinsAPI.this.getUniqueId().toString(), Integer.valueOf(0));
        }
      }
    }.runTaskAsynchronously(SimpleCoins.plugin);
    
    return (Integer)SimpleCoins.cache.get(p.getUniqueId().toString());
  }
  
  protected static Object getUniqueId() {
	// TODO Auto-generated method stub
	return null;
}

public static void addCoins(Player p, Integer amount)
  {
    SimpleCoins.cache.put(p.getUniqueId().toString(), Integer.valueOf(((Integer)SimpleCoins.cache.get(p.getUniqueId().toString())).intValue() + amount.intValue()));
  }
  
  public static void addCoins(OfflinePlayer p, final Integer amount)
  {
    if (SimpleCoins.cache.containsKey(p.getUniqueId().toString())) {
      SimpleCoins.cache.put(p.getUniqueId().toString(), Integer.valueOf(((Integer)SimpleCoins.cache.get(p.getUniqueId().toString())).intValue() + amount.intValue()));
    } else {
      new BukkitRunnable()
      {
        public void run()
        {
          SimpleCoins.cache.put(SimpleCoinsAPI.getUniqueId().toString(), Integer.valueOf(SimpleCoins.sql.getColumn((p)).intValue() + amount.intValue()));
        }
      }.runTaskAsynchronously(SimpleCoins.plugin);
    }
  }
  
  public static boolean substractCoins(Player p, Integer amount)
  {
    if (((Integer)SimpleCoins.cache.get(p.getUniqueId().toString())).intValue() >= amount.intValue())
    {
      SimpleCoins.cache.put(p.getUniqueId().toString(), Integer.valueOf(((Integer)SimpleCoins.cache.get(p.getUniqueId().toString())).intValue() - amount.intValue()));
      return true;
    }
    return false;
  }
  
  public static boolean substractCoins(OfflinePlayer p, Integer amount)
  {
    if (SimpleCoins.cache.containsKey(p.getUniqueId().toString()))
    {
      if (((Integer)SimpleCoins.cache.get(p.getUniqueId().toString())).intValue() >= amount.intValue())
      {
        SimpleCoins.cache.put(p.getUniqueId().toString(), Integer.valueOf(((Integer)SimpleCoins.cache.get(p.getUniqueId().toString())).intValue() - amount.intValue()));
        return true;
      }
      return false;
    }
    new BukkitRunnable()
    {
      public void run()
      {
        SimpleCoins.cache.put(SimpleCoinsAPI.getUniqueId().toString(), SimpleCoins.sql.getColumn((p)));
      }
    };
    if (((Integer)SimpleCoins.cache.get(p.getUniqueId().toString())).intValue() >= amount.intValue())
    {
      SimpleCoins.cache.put(p.getUniqueId().toString(), Integer.valueOf(((Integer)SimpleCoins.cache.get(p.getUniqueId().toString())).intValue() - amount.intValue()));
      return true;
    }
    return false;
  }
}
