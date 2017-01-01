package me.joris.plugin;

import java.util.List;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import coinsapi.api.SimpleCoinsAPI;

public class Economy_SimpleCoins
  implements Economy
{
  public EconomyResponse bankBalance(String arg0)
  {
    return null;
  }
  
  public EconomyResponse bankDeposit(String arg0, double arg1)
  {
    return null;
  }
  
  public EconomyResponse bankHas(String arg0, double arg1)
  {
    return null;
  }
  
  public EconomyResponse bankWithdraw(String arg0, double arg1)
  {
    return null;
  }
  
  public EconomyResponse createBank(String arg0, String arg1)
  {
    return null;
  }
  
  public EconomyResponse createBank(String arg0, OfflinePlayer arg1)
  {
    return null;
  }
  
  public boolean createPlayerAccount(String arg0)
  {
    return true;
  }
  
  public boolean createPlayerAccount(OfflinePlayer arg0)
  {
    return true;
  }
  
  public boolean createPlayerAccount(String arg0, String arg1)
  {
    return true;
  }
  
  public boolean createPlayerAccount(OfflinePlayer arg0, String arg1)
  {
    return true;
  }
  
  public String currencyNamePlural()
  {
    return "Coins";
  }
  
  public String currencyNameSingular()
  {
    return "Coin";
  }
  
  public EconomyResponse deleteBank(String arg0)
  {
    return null;
  }
  
  public EconomyResponse depositPlayer(String arg0, double arg1)
  {
    SimpleCoinsAPI.addCoins(Bukkit.getPlayerExact(arg0), Integer.valueOf((int)arg1));
    return new EconomyResponse(arg1, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "It worked!");
  }
  
  public EconomyResponse depositPlayer(OfflinePlayer arg0, double arg1)
  {
    SimpleCoinsAPI.addCoins(arg0, Integer.valueOf((int)arg1));
    return new EconomyResponse(arg1, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "It worked!");
  }
  
  public EconomyResponse depositPlayer(String arg0, String arg1, double arg2)
  {
    SimpleCoinsAPI.addCoins(Bukkit.getPlayerExact(arg0), Integer.valueOf((int)arg2));
    return new EconomyResponse(arg2, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "It worked!");
  }
  
  public EconomyResponse depositPlayer(OfflinePlayer arg0, String arg1, double arg2)
  {
    SimpleCoinsAPI.addCoins(arg0, Integer.valueOf((int)arg2));
    return new EconomyResponse(arg2, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "It worked!");
  }
  
  public String format(double arg0)
  {
    return String.valueOf(arg0);
  }
  
  public int fractionalDigits()
  {
    return 0;
  }
  
  public double getBalance(String arg0)
  {
    return SimpleCoinsAPI.getCoins(Bukkit.getPlayerExact(arg0)).intValue();
  }
  
  public double getBalance(OfflinePlayer arg0)
  {
    return SimpleCoinsAPI.getCoins(arg0).intValue();
  }
  
  public double getBalance(String arg0, String arg1)
  {
    return SimpleCoinsAPI.getCoins(Bukkit.getPlayerExact(arg0)).intValue();
  }
  
  public double getBalance(OfflinePlayer arg0, String arg1)
  {
    return SimpleCoinsAPI.getCoins(arg0).intValue();
  }
  
  public List<String> getBanks()
  {
    return null;
  }
  
  public String getName()
  {
    return "SimpleCoinsAPI";
  }
  
  public boolean has(String arg0, double arg1)
  {
    if (SimpleCoinsAPI.getCoins(Bukkit.getPlayerExact(arg0)).intValue() >= (int)arg1) {
      return true;
    }
    return false;
  }
  
  public boolean has(OfflinePlayer arg0, double arg1)
  {
    if (SimpleCoinsAPI.getCoins(arg0).intValue() >= (int)arg1) {
      return true;
    }
    return false;
  }
  
  public boolean has(String arg0, String arg1, double arg2)
  {
    if (SimpleCoinsAPI.getCoins(Bukkit.getPlayerExact(arg0)).intValue() >= (int)arg2) {
      return true;
    }
    return false;
  }
  
  public boolean has(OfflinePlayer arg0, String arg1, double arg2)
  {
    if (SimpleCoinsAPI.getCoins(arg0).intValue() >= (int)arg2) {
      return true;
    }
    return false;
  }
  
  public boolean hasAccount(String arg0)
  {
    if (Bukkit.getPlayerExact(arg0).hasPlayedBefore()) {
      return true;
    }
    return false;
  }
  
  public boolean hasAccount(OfflinePlayer arg0)
  {
    if (arg0.hasPlayedBefore()) {
      return true;
    }
    return false;
  }
  
  public boolean hasAccount(String arg0, String arg1)
  {
    if (Bukkit.getPlayerExact(arg0).hasPlayedBefore()) {
      return true;
    }
    return false;
  }
  
  public boolean hasAccount(OfflinePlayer arg0, String arg1)
  {
    if (arg0.hasPlayedBefore()) {
      return true;
    }
    return false;
  }
  
  public boolean hasBankSupport()
  {
    return false;
  }
  
  public EconomyResponse isBankMember(String arg0, String arg1)
  {
    return null;
  }
  
  public EconomyResponse isBankMember(String arg0, OfflinePlayer arg1)
  {
    return null;
  }
  
  public EconomyResponse isBankOwner(String arg0, String arg1)
  {
    return null;
  }
  
  public EconomyResponse isBankOwner(String arg0, OfflinePlayer arg1)
  {
    return null;
  }
  
  public boolean isEnabled()
  {
    return true;
  }
  
  public EconomyResponse withdrawPlayer(String arg0, double arg1)
  {
    SimpleCoinsAPI.substractCoins(Bukkit.getPlayerExact(arg0), Integer.valueOf((int)arg1));
    return new EconomyResponse(arg1, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "It worked!");
  }
  
  public EconomyResponse withdrawPlayer(OfflinePlayer arg0, double arg1)
  {
    SimpleCoinsAPI.substractCoins(arg0, Integer.valueOf((int)arg1));
    return new EconomyResponse(arg1, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "It worked!");
  }
  
  public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2)
  {
    SimpleCoinsAPI.substractCoins(Bukkit.getPlayerExact(arg0), Integer.valueOf((int)arg2));
    return new EconomyResponse(arg2, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "It worked!");
  }
  
  public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2)
  {
    SimpleCoinsAPI.substractCoins(arg0, Integer.valueOf((int)arg2));
    return new EconomyResponse(arg2, getBalance(arg0), EconomyResponse.ResponseType.SUCCESS, "It worked!");
  }
}
