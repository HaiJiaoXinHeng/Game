/**
 * This is the main player class that contains all the player information.
 *
 * @author Arturo Guerrero
 */
package com.thecolony.tractus.player;

import com.jme3.math.ColorRGBA;
import com.jme3.network.serializing.Serializable;
import java.util.ArrayList;

import com.thecolony.tractus.military.battle.BattleObject;
import java.awt.Color;

@Serializable
public class Player implements java.io.Serializable
{
    public static final ColorRGBA colors[] = {ColorRGBA.Red, ColorRGBA.Blue, ColorRGBA.Green, ColorRGBA.Yellow, ColorRGBA.Magenta};
    // viewable to other players

//    protected Technology currentTech;
//    protected ArrayList<Player> allies;
    protected boolean atWar;
    // not viewable to other players
    protected double money;
//    protected ArrayList<Technology> researched;
//    protected ArrayList<Trade> trades;
    protected int playerNumber;
    protected ColorRGBA color;
    // Fog of War (light)
    // explored terrain needs a way to be kept track of
    protected ArrayList<BattleObject> ownUnits; //units that you can control
    protected ArrayList<BattleObject> otherUnits; //other units that don't belong to you and are visible to you?

    public Player(int playerNumber)
    {
//        setCurrentTech(new Technology());
//        setAllies(new ArrayList<Player>());
        setAtWar(false);
        setMoney(0);
//        setResearched(new ArrayList<Technology>());
//        setTrades(new ArrayList<Trade>());
        setPlayerNumber(playerNumber);
        setOwnShips(new ArrayList<BattleObject>());
        setOtherShips(new ArrayList<BattleObject>());
        color = colors[playerNumber];
    }

    public void sendMessage()
    {
    }

    public void updatePlayer()
    {
    }
    
    protected boolean hasUnits()
    {
        return !ownUnits.isEmpty();
    }
    
    // setters and getters for all instance variables, nothing special, will
    // probably altered later
//    public Technology getCurrentTech()
//    {
//        return currentTech;
//    }
//
//    public void setCurrentTech(Technology currentTech)
//    {
//        this.currentTech = currentTech;
//    }
//
//    public ArrayList<Player> getAllies()
//    {
//        return allies;
//    }
//
//    public void setAllies(ArrayList<Player> allies)
//    {
//        this.allies = allies;
//    }
    
    public ColorRGBA getColor()
    {
        return color;
    }

    public boolean isAtWar()
    {
        return atWar;
    }

    public void setAtWar(boolean atWar)
    {
        this.atWar = atWar;
    }

    public double getMoney()
    {
        return money;
    }

    public void setMoney(double money)
    {
        this.money = money;
    }

//    public ArrayList<Technology> getResearched()
//    {
//        return researched;
//    }
//
//    public void setResearched(ArrayList<Technology> researched)
//    {
//        this.researched = researched;
//    }
//
//    public ArrayList<Trade> getTrades()
//    {
//        return trades;
//    }
//
//    public void setTrades(ArrayList<Trade> trades)
//    {
//        this.trades = trades;
//    }

    public int getPlayerNumber()
    {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber)
    {
        this.playerNumber = playerNumber;
    }

//    public Map getMap()
//    {
//        return map;
//    }
//
//    public void setMap(Map map)
//    {
//        Player.map = map;
//    }

    public ArrayList<BattleObject> getOwnShips()
    {
        return ownUnits;
    }

    public void setOwnShips(ArrayList<BattleObject> ships)
    {
        this.ownUnits = ships;
    }

    public ArrayList<BattleObject> getOtherShips()
    {
        return otherUnits;
    }

    public void setOtherShips(ArrayList<BattleObject> otherShips)
    {
        this.otherUnits = otherShips;
    }
}
