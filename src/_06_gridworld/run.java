package _06_gridworld;

import java.awt.Color;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class run {
public static void main(String[] args) {
	World zawarudo = new World();
	Bug tg = new Bug();
	Location l = new Location(4,4);
	zawarudo.show();
	tg.setColor(Color.BLUE);
	zawarudo.add(l, tg);
	tg.turn();
}
}
