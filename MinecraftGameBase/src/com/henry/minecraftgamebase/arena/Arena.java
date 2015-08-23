package com.henry.minecraftgamebase.arena;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Arena {

	public enum ArenaType {
		ONE_TEAM, TWO_TEAM, THREE_TEAM, FOUR_TEAM
	}

	public Arena(String name, String description, int maxPlayers, ArenaType at) {
		this.name = name;
		this.desciption = description;
		this.maxPlayers = maxPlayers;
		this.manager = new ArenaManager(this);
		this.setPlayers(new ArrayList<Player>());
	}

	public ArenaManager manager;

	private String name;
	private String desciption;
	private int maxPlayers;

	private Lobby[] lobbies;
	private SpawnPoint[] spawns;

	private boolean complete = false;

	private ArenaType arenaType;

	private boolean isActive = false;
	private boolean isPlaying = false;

	private ArrayList<Player> players;

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player p) {
		this.players.add(p);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public ArenaType getArenaType() {
		return arenaType;
	}

	public void setArenaType(ArenaType arenaType) {
		this.arenaType = arenaType;
	}

	public boolean checkIfComplete() {
		boolean b = false;

		// TODO: check lobbies, spawns, and all info

		return b;
	}

	public void initializeArenaForType() {
		int x = 2;
		if (this.arenaType.equals(ArenaType.ONE_TEAM)) {
			x = 1;
		} else if (this.arenaType.equals(ArenaType.TWO_TEAM)) {
			x = 2;
		} else if (this.arenaType.equals(ArenaType.THREE_TEAM)) {
			x = 3;
		} else if (this.arenaType.equals(ArenaType.FOUR_TEAM)) {
			x = 4;
		}
		this.lobbies = new Lobby[x];
		this.spawns = new SpawnPoint[x];
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public SpawnPoint[] getSpawns() {
		return spawns;
	}

	public void setSpawns(SpawnPoint[] spawns) {
		this.spawns = spawns;
	}

	public Lobby[] getLobbies() {
		return lobbies;
	}

	public void setLobbies(Lobby[] lobbies) {
		this.lobbies = lobbies;
	}

}