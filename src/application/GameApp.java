package application;

public interface GameApp {
	public void handleMessage(String message);
	public void recieveName(String name);
	public void receiveTimeScore(int time,int score);
	public void saveScore();
}