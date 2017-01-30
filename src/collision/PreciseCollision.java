package collision;

import javafx.scene.shape.Rectangle;
import units.Rocket;
import units.SpaceObject;

public class PreciseCollision implements CollisionDetectionInterface {

	public PreciseCollision() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean collide(SpaceObject a, Rocket r) {
		double w = a.getWidth();
		double h = a.getHeight();
		double cx = a.getX() + w/2;
		double cy = a.getY() + h/2;
		return new Rectangle(cx - w/6,cy-h/6,w/3,h/3).contains(r.getTip());
	}

}
