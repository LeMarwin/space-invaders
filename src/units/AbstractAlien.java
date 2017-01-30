package units;

import levels.GameWorld;

/*
 * Abstraction of alien.
 * Adds no functionality to SpaceObject, simply allows to separate alien containers from other containers.
 */
public abstract class AbstractAlien extends SpaceObject{
	
	public AbstractAlien(GameWorld owner, double _x, double _y) {
		super(owner, _x, _y);
		// TODO Auto-generated constructor stub
	}

}
