package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Score {

	public int pos;
	public String name;
	public int score;
	public int time;
	Font labelFont = Font.font( "Times New Roman", FontWeight.BOLD, 20 );
	
	public Score(int p, String n, int t, int s) {
		pos = p;
		name = n;
		score = s;
		time = t;
	}

	public Score(String p, String n, String t, String s) {
		pos = Integer.parseInt(p);
		name = n;
		score = Integer.parseInt(s);
		String ts[] = t.split(":");
		if(ts.length!=2){
			time = 0;
		}else
		{
			time = Integer.parseInt(ts[0])*1000 + Integer.parseInt(ts[1]);
		}
	}

	public Label getPos(int r){
		Label posLabel = new Label(Integer.toString(pos));
		posLabel.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		posLabel.setFont(labelFont);
		GridPane.setConstraints(posLabel, 0, r);
		return posLabel;
	}	

	public Label getName(int r){
		Label nameL = new Label(name);
		nameL.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		nameL.setFont(labelFont);
		GridPane.setConstraints(nameL, 1, r);
		return nameL;
	}
	
	public Label getTime(int r){
		Label timeL = new Label(Integer.toString(time/1000) + ":" + Integer.toString(time%1000));
		timeL.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		timeL.setFont(labelFont);
		GridPane.setConstraints(timeL, 2, r);
		return timeL;
	}
	
	public Label getScore(int r){
		Label scoreL = new Label(Integer.toString(score));
		scoreL.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		scoreL.setFont(labelFont);
		GridPane.setConstraints(scoreL, 3, r);
		return scoreL;
	}
}
