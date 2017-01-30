package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import javafx.scene.control.Label;

public class Scores {

	private String path;
	private List<Score> scores;
	
	public int maxScoreFileSize = 10;
	
	public Scores(String filePath) {
		path = filePath;
		scores = new ArrayList<Score>();
	}
	
	@SuppressWarnings("unused")
	private void makeDummy(){
		for(int i = 1; i<30;i++){
			Score sc = new Score(i,"name" + i, i*1234, i*4);
			scores.add(sc);
		}
	}
	
	public void readScores(){
		
		int i = 0;
	    try
	    {
	      FileReader fr = new FileReader(path);
	      BufferedReader br = new BufferedReader(fr);
	      String stringRead = br.readLine();

	      while( stringRead != null && i < maxScoreFileSize )
	      {
	        StringTokenizer st = new StringTokenizer(stringRead, ",");
	        String p = st.nextToken( );
	        String n = st.nextToken( );  /** PROBLEM */
	        String t = st.nextToken( ); /** PROBLEM */
	        String s = st.nextToken( );

	        Score temp = new Score(p,n,t,s);
	        scores.add(temp);

	        // read the next line
	        stringRead = br.readLine();
	        i++;
	      }
	      br.close( );
	    }
	    catch(IOException ioe){
	    	ioe.printStackTrace();
	    }
	    
	    while(i<maxScoreFileSize){
	    	scores.add(new Score(20,"--",Integer.MAX_VALUE,Integer.MAX_VALUE));
	    	i++;
	    }
	}
	
	private void writeScores(){
		try {
			PrintWriter file = new PrintWriter(path);
			for(int i=0;i<scores.size() && i < maxScoreFileSize;i++){
			  Score s = scores.get(i);
			  String t = (i == scores.size()-1 || i == maxScoreFileSize) ? "" : "\n";
			  file.write(		  Integer.toString(s.pos)   	+
							"," + s.name 						+
							"," + Integer.toString(s.time/1000)	+
							":" + Integer.toString(s.time%1000)	+
							"," + Integer.toString(s.score) 	+ t  
						);
			}
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveScore(Score newbie){
		readScores();
		scores.add(newbie);
		scores.sort(new Comparator<Score>() {
			@Override
			public int compare(Score arg0, Score arg1) {
				return arg0.time > arg1.time ? 1 : arg0.time < arg1.time ? -1 : 0 ;
			};
		});
		for(int i =0; i< scores.size();i++){
			scores.get(i).pos=i+1;
		}
		writeScores();
	}
	
	public Label getPos(int i, int r){
		return scores.get(i).getPos(r);
	}
	public Label getName(int i, int r){
		return scores.get(i).getName(r);
	}
	public Label getTime(int i, int r){
		return scores.get(i).getTime(r);
	}
	public Label getScore(int i, int r){
		return scores.get(i).getScore(r);
	}
	public Boolean isEmpty() {
		return scores.isEmpty();
	}
}
