package coinsapi.api;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class MySQL
{
  private Connection connection;
  
  public synchronized void openConnection()
  {
    try
    {
      this.connection = DriverManager.getConnection("jdbc:mysql://" + SimpleCoins.host + ":" + SimpleCoins.port + "/" + SimpleCoins.database + "?user=" + SimpleCoins.user + "&password=" + SimpleCoins.password + "&autoReconnect=true");
      System.out.println("[SC-API] Successfully connected to MySQL Database!");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public void addPlayer(Player player)
  {
    try
    {
      String query = "INSERT IGNORE INTO coins (uuid,coins) VALUES(?, 0);";
      PreparedStatement p = this.connection.prepareStatement(query);
      p.setString(1, player.getUniqueId().toString());
      p.execute();
      p.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public boolean containsPlayer(String uuid)
  {
    String query = "SELECT * FROM coins WHERE uuid=?";
    try
    {
      PreparedStatement st = this.connection.prepareStatement(query);
      st = this.connection.prepareStatement("SELECT * FROM coins WHERE uuid=?");
      st.setString(1, uuid);
      ResultSet rs = st.executeQuery();
      return rs.first();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }
  
  public Integer getColumn(OfflinePlayer p)
  {
    Integer temp = Integer.valueOf(0);
    String query = "SELECT * FROM coins WHERE `uuid` = '" + p.getUniqueId() + "'";
    try
    {
      ResultSet res = this.connection.prepareStatement(query).executeQuery();
      while (res.next()) {
        temp = Integer.valueOf(res.getInt("coins"));
      }
      res.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return temp;
  }
  
  public void createTables()
  {
    try
    {
      String query = "CREATE TABLE IF NOT EXISTS `coins` (`uuid` varchar(36) UNIQUE, `coins` int(1));";
      PreparedStatement p = this.connection.prepareStatement(query);
      p.execute();
      p.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public void setPlayerCoins(OfflinePlayer p2, Integer value)
  {
    try
    {
      String query = "INSERT INTO coins (uuid,coins) VALUES(?, ?) ON DUPLICATE KEY UPDATE uuid=?, coins=?;";
      PreparedStatement p = this.connection.prepareStatement(query);
      p.setString(1, p2.getUniqueId().toString());
      p.setInt(2, value.intValue());
      p.setString(3, p2.getUniqueId().toString());
      p.setInt(4, value.intValue());
      p.execute();
      p.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}

