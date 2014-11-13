/**
 * @author Arturo Guerrero
 */

package com.thecolony.tractus.player;

import java.util.ArrayList;

import com.thecolony.tractus.Map;
import com.thecolony.tractus.Trade;
import com.thecolony.tractus.Unit;
import com.thecolony.tractus.techonology.Technology;

public class Player
{
	// viewable to other players
	private Technology currentTech;
	private ArrayList<Player> allies;
	private boolean atWar;

	// not viewable to other players
	private double money;
	private ArrayList<Technology> researched;
	private ArrayList<Trade> trades;
	private int playerNumber;

	// Fog of War (light)
	// explored terrain needs a way to be kept track of
	private static Map map; // same map for all players
	private ArrayList<Unit> units;

	public Player(Map map, int playerNumber)
	{
		setCurrentTech(new Technology());
		setAllies(new ArrayList<Player>());
		setAtWar(false);
		setMoney(0);
		setResearched(new ArrayList<Technology>());
		setTrades(new ArrayList<Trade>());
		this.setPlayerNumber(playerNumber);
		this.setMap(map);
		setUnits(new ArrayList<Unit>());
	}
	
	public void sendMessage()
	{
		
	}
	
	public void updatePlayer()
	{
		
	}

	// setters and getters for all instance variables, nothing special, will
	// probably altered later
	public Technology getCurrentTech()
	{
		return currentTech;
	}

	public void setCurrentTech(Technology currentTech)
	{
		this.currentTech = currentTech;
	}

	public ArrayList<Player> getAllies()
	{
		return allies;
	}

	public void setAllies(ArrayList<Player> allies)
	{
		this.allies = allies;
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

	public ArrayList<Technology> getResearched()
	{
		return researched;
	}

	public void setResearched(ArrayList<Technology> researched)
	{
		this.researched = researched;
	}

	public ArrayList<Trade> getTrades()
	{
		return trades;
	}

	public void setTrades(ArrayList<Trade> trades)
	{
		this.trades = trades;
	}

	public int getPlayerNumber()
	{
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber)
	{
		this.playerNumber = playerNumber;
	}

	public Map getMap()
	{
		return map;
	}

	public void setMap(Map map)
	{
		Player.map = map;
	}

	public ArrayList<Unit> getUnits()
	{
		return units;
	}

	public void setUnits(ArrayList<Unit> units)
	{
		this.units = units;
	}
}
