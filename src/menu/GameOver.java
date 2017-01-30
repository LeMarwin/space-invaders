package menu;

import application.GameApp;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/*
 * Game over screen.
 */
public class GameOver extends Menu {

	private String name;
	public GameOver(Parent arg0, GameApp listener, String playerName) {
		super(arg0, listener, "   Game Over   ");
		// TODO Auto-generated constructor stub
		name = playerName;
		initMenu();
	}

	@Override
	public void initMenu() {
	    Font labelFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
	    Label you = new Label(name);
	    Label fail = new Label("You have lost");
	    you.setFont(labelFont);
	    you.setTextFill(Color.WHITE);
	    you.relocate(150, 150);
	    fail.setFont(labelFont);
	    fail.setTextFill(Color.WHITE);
	    fail.relocate(150, 250);
	    
	    Button back = new Button("Back to menu");
	    back.relocate(150, 330);
	    back.getStyleClass().add("button-big");
	    root.getChildren().addAll(back,you,fail);
	    
	    back.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				appListener.handleMessage("BACK");
			}
        });
	}

}
