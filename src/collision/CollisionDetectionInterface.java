package collision;

import units.Rocket;
import units.SpaceObject;

public interface CollisionDetectionInterface {
	public Boolean collide(SpaceObject a, Rocket r);
}
