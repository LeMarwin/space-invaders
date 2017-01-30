package units;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import levels.GameWorld;

/*
 * "Easy" alien. Simply slides downwards.
 */
public class AlienEasy extends AbstractAlien {

	public static double width = 48;
	public static double height = 27;
	
	private ImageView img;
	
	public AlienEasy(GameWorld owner, double _x, double _y) {
		super(owner, _x, _y);
		img = new ImageView(new Image(new File("res/alienEasy.png").toURI().toString()));
		velocity = 0.02;
		// TODO Auto-generated constructor stub
	}	

	@Override
	public ImageView getSprite() {
		return img;
	}

	@Override
	public void updatePosition(double dt) {
		if(y > 400)
		{
			owner.gameFailed();
		} else{
			y = y + velocity*dt;
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
