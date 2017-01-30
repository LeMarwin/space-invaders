package units;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import levels.GameWorld;

/*
 * Player's ship.
 * Slides left-right.
 */
public class Player extends SpaceObject {

	static public double width = 48;
	static public double height = 48;
	
	static public enum Direction{
		LEFT, RIGHT
	};
	
	static ImageView img = new ImageView(new Image(new File("res/player.png").toURI().toString()));

	public Player(GameWorld owner, double _x, double _y) {
		super(owner, _x, _y);
		img.relocate(_x, _y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageView getSprite() {
		// TODO Auto-generated method stub
		return img;
	}

	@Override
	public void updatePosition(double dt) {

	}
	
	public void steer(Direction dir){
		switch(dir){
		case LEFT:
			if(x>30) {x = x - 10;}
			break;
		case RIGHT:
			if(x < 562) {x = x + 10;}
			break;
		}
		
		img.relocate(x, y);
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
