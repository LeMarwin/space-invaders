package units;

import javafx.scene.image.ImageView;
import levels.GameWorld;

/*
 * Any drawable game object.
 * Has position and velocity (the use of velocity is optional, though)
 * Also has statically fixed width and height and associated image-sprite
 * Knows it's owner to be able to delete itself.
 */
public abstract class SpaceObject {

	public abstract ImageView getSprite();
	
	protected double x;
	protected double y;
	protected GameWorld owner;
	protected double velocity;
	
	
	static double width;
	static double height;
	
	public SpaceObject(GameWorld _owner) {
		// TODO Auto-generated constructor stub
		owner = _owner;
	}
	
	public SpaceObject(GameWorld _owner, double _x, double _y){
		x = _x;
		y = _y;
		owner = _owner;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public abstract void updatePosition(double dt);
	public abstract double getWidth();
	public abstract double getHeight();
}
