package units;

import java.io.File;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import levels.GameWorld;

/*
 * Rocket.
 * Spawns at player's ship's location and goes upwards until hits alien or border.
 */
public class Rocket extends SpaceObject {

	public static double width = 24;
	static double height = 42;
	
	private ImageView img;
	
	public Rocket(GameWorld owner, double _x, double _y) {
		super(owner, _x, _y);
		// TODO Auto-generated constructor stub
		velocity = 0.1;
		img = new ImageView(new Image(new File("res/rocket.png").toURI().toString()));
	}

	@Override
	public ImageView getSprite() {
		// TODO Auto-generated method stub
		return img;
	}

	@Override
	public void updatePosition(double dt) {
		// TODO Auto-generated method stub
		if(y <= 50)
		{
			owner.getRockets().remove(this);
		} else{
			y = y - velocity*dt;
		}
		this.getSprite().relocate(x, y);
	}
	
	public Point2D getTip(){
		return new Point2D(x,y);
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
}
