package menu;

import application.GameApp;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/*
 * Selecting the difficulty.
 * Right now only 4 levels.
 */
public class LevelSelectMenu extends Menu{
	
	public LevelSelectMenu(Parent arg0, GameApp listener) {
		super(arg0,listener,"Select difficulty");
		// TODO Auto-generated constructor stub
		initMenu();
		appListener = listener;
	}

	public void initMenu() {

	    Button back = new Button("BACK");
	    back.relocate(150, 400);
	    back.getStyleClass().add("button-big");
	    back.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				appListener.handleMessage("BACK");
			}
        });
	    Button lvl[] = new Button[5];
	    for(int i =0; i<5;i++){
	    	lvl[i] = new Button ("Lvl. " + (i+1));
	    	final String msg = "LVL" + (i + 1);
	    	lvl[i].setOnMouseClicked(new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent e) {
					appListener.handleMessage(msg);
				}
	        });
	    	lvl[i].getStyleClass().add("button-small");
	    	if(i>3){
	    		lvl[i].getStyleClass().add("button-disabled");
	    	}
	    	root.getChildren().add(lvl[i]);
	    }
	    
	    lvl[0].relocate(150, 120);
	    lvl[1].relocate(350, 120);
	    lvl[2].relocate(150, 210);
	    lvl[3].relocate(350, 210);
	    lvl[4].relocate(250, 300);
	    root.getChildren().add(back);
	}
}
