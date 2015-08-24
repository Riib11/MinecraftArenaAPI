package com.henry.minecraftgamebase.arena;

import com.henry.minecraftgamebase.arena.builder.Cuboid;

public class Lobby extends Cuboid {

	// max height is 100 blocks
	public Lobby(double x1, double y1, double z1, double x2, double y2,
			double z2) {
		super(x1, y1, z1, x2, y2, z2);
	}

	public Lobby(Cuboid c) {
		super(c);
	}

	@SuppressWarnings("unused")
	private boolean complete = false;

	public boolean checkIfComplete() {
		if (this.corner1.equals(this.corner2)) {
			return false;
		}
		return true;
	}
}