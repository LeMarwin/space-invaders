package units;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import levels.GameWorld;

/*
 * "Hard" alien, aka "evasive" alien.
 * Slides downwards with alternating left-right slides.
 */
public class AlienHard extends AbstractAlien {

	public static double width = 48;
	public static double height = 29;
	
	private double time = 0;
	private ImageView img;
	
	static public enum Direction{
		LEFT, RIGHT
	};
	private int steps = 1;
	Direction current;
	
	public AlienHard(GameWorld owner, double _x, double _y, Direction dir) {
		super(owner, _x, _y);
		img = new ImageView(new Image(new File("res/alienHard.png").toURI().toString()));
		current = dir;
		velocity = 0.02;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageView getSprite() {
		// TODO Auto-generated method stub
		return img;
	}

	@Override
	public void updatePosition(double dt) {
		time += dt;
		if(y > 400)
		{
			owner.gameFailed();
		} else{
			y = y + velocity*dt;
		}
		if(time > 500){
			time = 0;
			if(current == Direction.LEFT){
				x = x - width; 
				steps++;
				if(steps == 2){
					current = Direction.RIGHT;
					steps = 0;
				}
			}else{
				x = x + width; 
				steps++;
				if(steps == 2){
					current = Direction.LEFT;
					steps = 0;
				}
			}
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
