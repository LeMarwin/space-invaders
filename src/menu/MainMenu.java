package menu;

import application.GameApp;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/*
 * Main menu. New game. Scoreboard. Quit.
 */
public class MainMenu extends Menu{
	
	public void initMenu(){

		Button newGame = new Button("New Game");
	    Button scoreboard = new Button("Scoreboard");
	    Button quit = new Button("Quit");
	    
	    newGame.relocate(150, 150);
	    newGame.getStyleClass().add("button-big");
	    newGame.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				appListener.handleMessage("NEW_GAME");
			}
        });
	    
	    scoreboard.relocate(150, 250);
	    scoreboard.getStyleClass().add("button-big");
	    scoreboard.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				appListener.handleMessage("SCOREBOARD");
			}
        });

	    quit.relocate(150, 350);
	    quit.getStyleClass().add("button-big");
	    quit.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				appListener.handleMessage("QUIT");
			}
        });
	    root.getChildren().addAll(newGame,scoreboard,quit);	    
	}
	
	public MainMenu(Parent arg0, GameApp listener) {
		super(arg0,listener, "Space Invaders");
		// TODO Auto-generated constructor stub
		initMenu();
	}

}
