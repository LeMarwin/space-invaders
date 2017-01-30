package levels;

import application.GameApp;
import collision.CollisionDetectionInterface;
import units.AlienHard;
import units.Player;

/*
 * 4 rows by 4 evasive aliens moving in different directions
 */
public class LevelTwo extends GameWorld {

	int col = 4;
	int row = 4;
	
	public LevelTwo(GameApp listener, CollisionDetectionInterface cdi) {
		super(listener, cdi);
		appListener = listener;
		init();
		// TODO Auto-generated constructor stub
	}

	@Override
	void initLevel() {
    	player = new Player(this,310, 400);
        root.getChildren().add(player.getSprite()); 
        
        double voffset = -row*(AlienHard.height + 20);
        AlienHard.Direction dir = AlienHard.Direction.LEFT;
        for(int i = 1; i < row ;i++){
        	double hoffset = 150;  
        	for(int j=0; j<col ;j++){
        		aliens.add(new AlienHard(this,hoffset,voffset,dir));
        		hoffset += (AlienHard.width + 50);
        	}
        	voffset += (AlienHard.height + 20);
    		if(dir == AlienHard.Direction.LEFT){
    			dir = AlienHard.Direction.RIGHT;
    		}else{
    			dir = AlienHard.Direction.LEFT;
    		}
        }
	}

}
