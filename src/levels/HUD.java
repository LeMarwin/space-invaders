package levels;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/*
 * Keeps track of time and score. Both score and time are ints. The latter is in milliseconds.
 */
public class HUD {

	private int milliseconds;
	private int seconds;
	private int score;
	
	Label timestamp;
	Label scoreline;
	
	public HUD(int ms, int s) {
		milliseconds = ms;
		score = s;
		scoreline = new Label("Score:" + score);
		scoreline.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		Font labelFont = Font.font( "Times New Roman", FontWeight.BOLD, 18 );
		scoreline.setFont(labelFont);
		scoreline.relocate(550, 30);
		
		timestamp = new Label("Time:" + milliseconds);
		timestamp.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		timestamp.setFont(labelFont);
		timestamp.relocate(20, 30);
	}
	
	public void updateScore(int ds){
		score += ds;
		scoreline.setText("Score:"+score);
	}
	
	public void updateTime(double dt){
		milliseconds += dt;
		if(milliseconds > 1000){
			milliseconds -= 1000;
			seconds++;
		}
		timestamp.setText("Time: " +seconds+":"+ Integer.toString(milliseconds));
	}
	
	public Label getScore(){
		return scoreline;
	}
	
	public Label getTime(){
		return timestamp;
	}
	
	public int getRawScore(){
		return score;
	}
	
	public int getRawTime(){
		return seconds*1000 + milliseconds;
	}
}
