package menu;

import application.GameApp;
import application.Score;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/*
 * Victory screen.
 * Shows score and asks whether to save it or not
 */
public class VictoryScreen extends Menu {

	private Score score;
	
	public VictoryScreen(Parent arg0, GameApp listener, Score score) {
		super(arg0, listener, "Victory!");
		// TODO Auto-generated constructor stub
		this.score = score;
		initMenu();
	}

	@Override
	public void initMenu() {
		// TODO Auto-generated method stub
		int s = score.time/1000;
		int ms = score.time%1000;
		Font labelFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
		Label you = new Label(score.name + ", you have won!");
		Label rule = new Label("Score: " + score.score + "; Time: " + s + ":" + Integer.toString(ms));
	    you.setFont(labelFont);
	    you.setTextFill(Color.WHITE);
	    you.relocate(100, 150);
	    rule.setFont(labelFont);
	    rule.setTextFill(Color.WHITE);
	    rule.relocate(100, 250);
	    root.getChildren().addAll(you,rule);
	    
	    Button save = new Button("Save score");
	    save.relocate(120, 330);
	    save.getStyleClass().add("button-small");
	    save.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				
				appListener.handleMessage("SAVE");
			}
        });
	    
	    Button back = new Button("Back to menu");
	    back.relocate(320, 330);
	    back.getStyleClass().add("button-small");
	    back.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				appListener.handleMessage("BACK");
			}
        });
	    root.getChildren().addAll(save,back);
	}

}
