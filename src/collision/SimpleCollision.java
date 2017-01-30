package collision;

import javafx.scene.shape.Rectangle;
import units.Rocket;
import units.SpaceObject;

public class SimpleCollision implements CollisionDetectionInterface {

	public SimpleCollision() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean collide(SpaceObject a, Rocket r) {
		return new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight()).contains((r.getTip()));
	}

}
