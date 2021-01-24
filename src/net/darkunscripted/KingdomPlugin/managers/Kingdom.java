package net.darkunscripted.KingdomPlugin.managers;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Kingdom {

    private String name;
    private int maxPlayers;
    private int playerSize;
    private String tag;
    private String color;
    private ArrayList<Player> players = new ArrayList<Player>();
    private static ArrayList<Kingdom> kingdoms = new ArrayList<Kingdom>();

    public Kingdom(){
        Kingdom.kingdoms.add(this);
    }

    public Kingdom(String name, String tag, String color){
        this.name = name;
        this.tag = tag;
        this.color = color;
        Kingdom.kingdoms.add(this);
    }

    public static ArrayList<Kingdom> getKingdoms() {
        return kingdoms;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getPlayerSize() {
        return playerSize;
    }

    public String getColor() {
        return color;
    }

    public String getTag() {
        return tag;
    }
}
