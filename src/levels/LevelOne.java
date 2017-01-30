package levels;

import application.GameApp;
import collision.CollisionDetectionInterface;
import units.AlienEasy;
import units.AlienHard;
import units.Player;
import units.Rocket;
import units.AlienHard.Direction;


/*
 * First level. 5x4 simple aliens and the topmost row are evasive ones.
 */
public class LevelOne extends GameWorld {

	int col = 6;
	int row = 4;
	double shootCooldown = 400;
	double prevShoot = -shootCooldown;
	
	public LevelOne(GameApp listener, CollisionDetectionInterface cdi) {
		super(listener, cdi);
		appListener = listener;
		init();
		// TODO Auto-generated constructor stub
	}

	@Override
	void initLevel() {
    	player = new Player(this,310, 400);
        root.getChildren().add(player.getSprite()); 
        
        double voffset = -row*(AlienEasy.height + 15);
    	double hoffset = 150;
    	for(int j=0; j<col ;j++){
    		aliens.add(new AlienHard(this,hoffset,voffset, Direction.LEFT));
    		hoffset += (AlienHard.width + 15);
    	}
    	
        for(int i = 1; i < row ;i++){
        	hoffset = 150;
        	voffset += (AlienEasy.height + 15);
        	for(int j=0; j<col ;j++){
        		aliens.add(new AlienEasy(this,hoffset,voffset));
        		hoffset += (AlienEasy.width + 15);
        	}
        }
	}

	@Override
	protected void shoot(){
		double t = hud.getRawTime();
		if((t - prevShoot) >= shootCooldown){
			prevShoot = t;
	    	double rx = player.getX() + Player.width/2 - Rocket.width/2;
	    	double ry = player.getY();
	    	rockets.add(new Rocket(this,rx,ry));
		}
	}
}
