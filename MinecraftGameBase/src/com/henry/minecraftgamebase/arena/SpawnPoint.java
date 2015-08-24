package com.henry.minecraftgamebase.arena;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.henry.minecraftgamebase.Main;

public class SpawnPoint {

	public enum SpawnType {
		A, B, C, D;

		String str;

		static {
			A.str = "a";
			B.str = "b";
			C.str = "c";
			D.str = "d";
		}

		@Override
		public String toString() {
			return this.str;
		}

		public static SpawnType getFromInt(int x) {
			if (x == 1) {
				return A;
			} else if (x == 1) {
				return B;
			} else if (x == 1) {
				return C;
			} else if (x == 1) {
				return D;
			} else {
				return null;
			}
		}
	}

	Location location;
	SpawnType st;

	public SpawnPoint(Location l, SpawnType st) {
		this.location = l;
	}

	public void setSpawn(Player p) {
		p.setBedSpawnLocation(location, true);
	}

	public void teleportPlayer(Player p) {
		p.teleport(location);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public SpawnType getSpawnType() {
		return st;
	}

	public void setSpawnType(SpawnType st) {
		this.st = st;
	}

	public String toString() {
		return location.getX() + ":" + location.getY() + "::" + location.getZ();
	}

	public static SpawnPoint fromString(String s, SpawnType st) {
		String xs = s.substring(0, s.indexOf(":") - 1);
		String ys = s.substring(s.indexOf(":"), s.indexOf("::") - 1);
		String zs = s.substring(s.indexOf("::"), s.length() - 1);
		return new SpawnPoint(new Location(Main.plugin.getServer().getWorlds()
				.get(0), Double.valueOf(xs), Double.valueOf(ys),
				Double.valueOf(zs)), st);
	}
}
