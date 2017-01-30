package levels;

import application.GameApp;
import collision.CollisionDetectionInterface;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import units.AbstractAlien;
import units.Player;
import units.Rocket;
import units.SpaceObject;
import units.Player.Direction;

/*
 * Implements the core mechanics like updating changes and dispatching events
 */
public abstract class GameWorld {

    protected Group  root;
    protected ObservableList<AbstractAlien> aliens = FXCollections.observableArrayList();
    protected ObservableList<Rocket> rockets = FXCollections.observableArrayList();
    protected Scene scene;
    protected Player player;
    protected Boolean pause;
    protected GameApp appListener;
    protected CollisionDetectionInterface detector;
    protected HUD hud;
    
    public GameWorld(GameApp listener, CollisionDetectionInterface cdi){
    	appListener = listener;
    	detector = cdi;
    }
    
    public ObservableList<AbstractAlien> getAliens() {
        return aliens;
    }
    
    public ObservableList<Rocket> getRockets() {
        return rockets;
    }
        
    public Scene getScene(){
    	return scene;
    }
    
    abstract void initLevel();
    
    protected void init(){
    	pause = false;
        root = new Group();
        scene = new Scene(root,640,480);
        scene.setFill(Color.BLACK);
        hud = new HUD(0,0);
        root.getChildren().addAll(hud.getScore(),hud.getTime());
        
        aliens.addListener(new ListChangeListener<SpaceObject>() {
            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends SpaceObject> c) {
                while (c.next()) {
                    for (SpaceObject remitem : c.getRemoved()) {
                        root.getChildren().remove(remitem.getSprite());
                    }
                    for (SpaceObject additem : c.getAddedSubList()) {
                        ImageView shape = additem.getSprite();
                        root.getChildren().add(shape);
                        shape.relocate(additem.getX(), additem.getY());
                    }
                }
            }
        });

        rockets.addListener(new ListChangeListener<SpaceObject>() {
            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends SpaceObject> c) {
                while (c.next()) {
                    for (SpaceObject remitem : c.getRemoved()) {
                        root.getChildren().remove(remitem.getSprite());
                    }
                    for (SpaceObject additem : c.getAddedSubList()) {
                        ImageView shape = additem.getSprite();
                        root.getChildren().add(shape);
                        shape.relocate(additem.getX(), additem.getY());
                    }
                }
            }
        });
        initLevel();
		initKeys();
    }
    
    protected void initKeys(){
	    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
            	switch(event.getText()){
	            	case " ": shoot(); break;
	            	case "a": if(!pause) player.steer(Direction.LEFT); break;
	            	case "d": if(!pause) player.steer(Direction.RIGHT); break;
	            	case "p": pause();
            	}
            }
        });
    }
    
    protected void shoot(){
    	double rx = player.getX() + Player.width/2 - Rocket.width/2;
    	double ry = player.getY();
    	rockets.add(new Rocket(this,rx,ry));
    }
    
    protected void pause(){
    	if(!pause){
    		pause = true;
    		appListener.handleMessage("PAUSE");
    	} else{
    		pause = false;
    		appListener.handleMessage("UNPAUSE");
    	}
    }
    
    public void updateScene(double dt){
    	hud.updateTime(dt);
    	for (SpaceObject so: rockets){
    		so.updatePosition(dt);
    	}
    	for (SpaceObject so: aliens){
    		so.updatePosition(dt);
    	}
    	checkCollisions();
    	checkWin();
    }
    
    private void checkCollisions(){
    	for(Rocket r: rockets){
    		for(AbstractAlien a: aliens){
    			if(detector.collide(a, r)){
    				rockets.remove(r);
    				aliens.remove(a);
    				hud.updateScore(1);;
    			}
    		}
    	};
    }
    
    private void checkWin(){
    	if(aliens.isEmpty()){
    		appListener.receiveTimeScore(hud.getRawTime(), hud.getRawScore());
    	}
    }
    
    public void gameFailed(){
    	appListener.handleMessage("GAMEOVER");
    }
}
