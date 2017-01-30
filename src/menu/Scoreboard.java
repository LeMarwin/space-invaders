package menu;

import application.GameApp;
import application.Scores;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/*
 * Scoreboard page.
 * As of now all scores are in a single table.
 * TODO: Split tables by level.
 */
public class Scoreboard extends Menu {

	Font labelFont = Font.font( "Times New Roman", FontWeight.BOLD, 20 );
	Scores scores;
	
	public Scoreboard(Parent arg0, GameApp listener, Scores scores) {
		super(arg0, listener, "Scoreboard");
		// TODO Auto-generated constructor stub
		this.scores = scores;
		initMenu();
	}

	private void addHeaders(GridPane gp){
		Label posL = new Label("¹");
		posL.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		posL.setFont(labelFont);
		GridPane.setConstraints(posL, 0, 0);
		Label nameL = new Label("Name");
		nameL.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		nameL.setFont(labelFont);
		GridPane.setConstraints(nameL, 1, 0);
		Label timeL = new Label("Time");
		timeL.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		timeL.setFont(labelFont);
		GridPane.setConstraints(timeL, 2, 0);
		Label scoreL = new Label("Score");
		scoreL.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		scoreL.setFont(labelFont);
		GridPane.setConstraints(scoreL, 3, 0);
		gp.add(new Separator(), 0, 1);
		gp.add(new Separator(), 1, 1);
		gp.add(new Separator(), 2, 1);
		gp.add(new Separator(), 3, 1);
		gp.getChildren().addAll(posL,nameL,timeL,scoreL);
	}
	
	@Override
	public void initMenu() {
		// TODO Auto-generated method stub
		GridPane gridpane = new GridPane();
		addHeaders(gridpane);
		if(scores.isEmpty()){scores.readScores();}
		for(int i = 2; i<12;i++){
	    	gridpane.getChildren().addAll(scores.getPos(i-2, i),scores.getName(i-2, i), scores.getTime(i-2, i), scores.getScore(i-2, i));
	    }
	    gridpane.relocate(95, 110);
	    gridpane.getColumnConstraints().add(new ColumnConstraints(50));
	    gridpane.getColumnConstraints().add(new ColumnConstraints(150));
	    gridpane.getColumnConstraints().add(new ColumnConstraints(150));
	    gridpane.getColumnConstraints().add(new ColumnConstraints(100));
	    root.getChildren().add(gridpane);
	    
	    Button back = new Button("Back");
	    back.getStyleClass().add("button-big");
	    back.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				appListener.handleMessage("BACK");
			}
        });
	    back.relocate(120, 400);
	    root.getChildren().add(back);
	}

}
