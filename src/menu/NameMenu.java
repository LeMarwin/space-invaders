package menu;

import application.GameApp;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/*
 * First menu, which prompts to enter the name
 */
public class NameMenu extends Menu {
	public void initMenu(){
	    
	    Font labelFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
	    Label l = new Label("Enter your name");
	    l.setFont(labelFont);
	    l.setTextFill(Color.WHITE);
	    l.relocate(150, 180);
	    
	    Label name = new Label("_");
	    name.setTextFill(Color.LIGHTGOLDENRODYELLOW);
	    name.setFont(labelFont);
	    //name.setMinWidth(380);
	    name.relocate(150, 250);

	    Button start = new Button("Start");
	    start.relocate(150, 330);
	    start.getStyleClass().add("button-small");
	    Button quit = new Button("Quit");
	    quit.relocate(350, 330);
	    quit.getStyleClass().add("button-small");
	    root.getChildren().addAll(start,quit);
	    root.getChildren().addAll(l,name);
	    
	    quit.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				appListener.handleMessage("QUIT");
			}
        });

	    start.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				String t = name.getText();
				if(t.startsWith("_")){t = t.substring(1,t.length());}
				appListener.recieveName(t);
			}
	    	
	    });
	    this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                String t = name.getText();
                if(t.startsWith("_")){t = t.substring(1,t.length());}
                if(event.getCode() == KeyCode.BACK_SPACE&&t.length()>0){
                	t = t.substring(0, t.length()-1);
                	name.setText(t);
                }else{
                	String key = event.getText();
                	if(t.length()<16&&key!=","&&key!="\""){
                		name.setText(t + key);
                	}
                }
            }
            
        });
	}
	
	
	public NameMenu(Parent arg0, GameApp listener) {
		super(arg0, listener, "Space Invaders");
		// TODO Auto-generated constructor stub
		initMenu();
	}

}
