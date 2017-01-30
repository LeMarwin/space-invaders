package menu;

import application.GameApp;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/*
 * Abstraction of a menu page for a Strategy pattern.
 * Implements basic initialization: sets sizes, fills the background and prints the title.
 */
public abstract class Menu extends Scene{

	protected Group root;
	protected Canvas canvas;
	protected String title;
	protected GameApp appListener;
	
	public Menu(Parent arg0, GameApp listener, String menuTitle) {
		super(arg0);
		// TODO Auto-generated constructor stub
		title = menuTitle;
		appListener = listener;
		baseInit(arg0);
	}
	
	protected void baseInit(Parent parent){
		this.setFill(Color.BLACK);
		root = (Group) parent;
		canvas = new Canvas( 640, 480 );
	    root.getChildren().add( canvas );
	         
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	         
	    gc.setFill( Color.WHITE );
	    gc.setStroke( Color.YELLOW );
	    gc.setLineWidth(2);
	    Font titleFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
	    gc.setFont( titleFont );
	    gc.fillText(title, 180, 80 );
	    gc.strokeText(title, 180, 80 );
	}
	
	public abstract void initMenu();
}
