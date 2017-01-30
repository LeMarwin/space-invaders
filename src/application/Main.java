package application;
	
import collision.PreciseCollision;
import collision.SimpleCollision;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import levels.GameWorld;
import levels.LevelOne;
import levels.LevelTwo;
import menu.GameOver;
import menu.LevelSelectMenu;
import menu.MainMenu;
import menu.Menu;
import menu.NameMenu;
import menu.Scoreboard;
import menu.VictoryScreen;
import javafx.scene.Group;


public class Main extends Application implements GameApp {
	
	private static String appTitle = "Space Invaders";
	private static String scoresFile = "res/scores.csv";
	private Stage stage;
	private Score currentScore;
	private Scores scores;
	private Timeline timeline;
	private int timestep = 1;

	
	private enum MenuPages{
		NAME, MAIN, LEVEL, SCORE, GAMEOVER, VICTORY
	}
	
	private void showMenu(MenuPages pg){
	    Group group = new Group();
	    Menu menu;
	    
		switch(pg)
		{
		case NAME: 
			menu = new NameMenu(group,this);
			break;
		case MAIN: 
			menu = new MainMenu(group,this);
			break;
		case LEVEL:
			menu = new LevelSelectMenu(group,this);
			break;
		case GAMEOVER:
			menu = new GameOver(group, this, currentScore.name);
			break;
		case VICTORY:
			menu = new VictoryScreen(group, this, currentScore);
			break;
		case SCORE:
			menu = new Scoreboard(group, this, scores);
			break;
		default:
			menu = new NameMenu(group,this);
			break;
		}
	    menu.getStylesheets().add("css/styles.css");
	    stage.setScene( menu );
	    stage.show();
	}
	
	@Override
	public void start(Stage primaryStage) {
		currentScore = new Score(100,"Pepe",0,0);
		scores = new Scores(scoresFile);	
		stage = primaryStage;
		stage.setTitle(appTitle);
		stage.setResizable(false);
		showMenu(MenuPages.NAME);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void handleMessage(String message) {
		System.out.println(message);
		switch (message){
		case "QUIT":
			try {
				this.stage.close();
				this.stop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "NEW_GAME":
			showMenu(MenuPages.LEVEL);
			break;
		case "BACK":
			showMenu(MenuPages.MAIN);
			break;
		case "PAUSE":
			timeline.stop();
			break;
		case "UNPAUSE":
			timeline.play();
			break;
		case "GAMEOVER":
			timeline.stop(); showMenu(MenuPages.GAMEOVER);
			break;
		case "SAVE":
			saveScore(); showMenu(MenuPages.MAIN);
			break;
		case "SCOREBOARD":
			showMenu(MenuPages.SCORE);
			break;
		case "LVL1":
			startLvl(new LevelOne(this, new SimpleCollision()));
			break;
		case "LVL2":
			startLvl(new LevelTwo(this, new SimpleCollision()));
			break;
		case "LVL3":
			startLvl(new LevelOne(this, new PreciseCollision()));
			break;
		case "LVL4":
			startLvl(new LevelTwo(this, new PreciseCollision()));
			break;
		}
	}

	@Override
	public void recieveName(String name) {
		currentScore.name = name;
		showMenu(MenuPages.MAIN);
	}
	
	private void startLvl(GameWorld gw){
        try {
            stage.setScene(gw.getScene());
            stage.show();
    	    timeline = new Timeline (
    	    	    new KeyFrame (
    	    	        Duration.millis(timestep),
    	    	        ae -> {
    	    	            gw.updateScene(timestep);
    	    	        }
    	    	    )
    	    	);

    	    	timeline.setCycleCount(Timeline.INDEFINITE);
    	    	timeline.play();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void receiveTimeScore(int t, int s) {
		timeline.stop();
		currentScore.time = t;
		currentScore.score = s;
		showMenu(MenuPages.VICTORY);
	}
	
	public void saveScore(){
		System.out.println(currentScore.name+","+currentScore.score+","+currentScore.time);
		scores.saveScore(currentScore);
	}
}
