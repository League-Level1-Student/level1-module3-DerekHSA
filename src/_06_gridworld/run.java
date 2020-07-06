package _06_gridworld;

import java.awt.Color;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class run {
public static void main(String[] args) {
	World zawarudo = new World();
	
	Bug tg = new Bug();
	Location l = new Location(9, 8);
	Location i = new Location(9, 7);
	Location p = new Location(9, 9);
	
	
	
	
	

	for (int Y = 0; Y < 10; Y++) {
		for (int X = 0; X <10; X++) {
			zawarudo.add(new Location(Y,X),new Flower());
		}
		
		}
	
	
	zawarudo.show();
	tg.setColor(Color.BLUE);
	zawarudo.add(l, tg);
	tg.turn();
	tg.turn();
	Flower sc = new Flower();
	Flower fc = new Flower();
	zawarudo.add(i, sc);
	zawarudo.add(p, fc);
	
		
		
	}
}

