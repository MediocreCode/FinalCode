
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.regex.Pattern;

import javafx.animation.AnimationTimer;
public class RunDriver extends Application{
/*
 * Raleigh Dial
 * Sprinting for an A
 */
	Button start = new Button();
	static Stage myStage = new Stage();
	static HomeScreenGraphic hsg = new HomeScreenGraphic();
	static GameSceneFX gsf = new GameSceneFX();
	java.awt.Graphics g;
	static Scene gameSceneScene;
	static String name = new String();
	static int raceNum;
	static String email = new String();
	int i = 0;
	static Player p1 = new Player();
	static Player p2 = new Player();
	static Player p3 = new Player();
	static KeyCode lastCode = KeyCode.LEFT;
	//Timer timer = new Timer();
	//TimerTask timertask = new TimerStuff();
	AnimationTimer timer3;
	double j=0;
	int k=0;
	double time;
	public static void main(String[] args) {
		launch (args);

	}
	public void start(Stage primaryStage) throws Exception {
		hsg.getHomeText();
		hsg.getHomeTF();
		hsg.getStart();
		hsg.getHomeEM();
		hsg.getHomeNum();

		start = hsg.getStart();
		start.setOnAction(this::startGame);
		
		Group myGroup = hsg.getGroup();
		Scene myScene = new Scene(myGroup, 750, 500, Color.ANTIQUEWHITE);
		myStage.setTitle("Game");
		myStage.setScene(myScene);
		myStage.show();
		}
	public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";    
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	public static boolean isNumeric(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}

	public void startGame(ActionEvent args) {
		
		if(isValid(""+hsg.getHomeEMText())&&isNumeric(hsg.getHomeNumText())) {
		gsf.changeCounter(hsg.getPlayerName(),hsg.getHomeNumText());
		p1.setPlace1();
		Image img = new Image("file:src/Shep.png");
		p2.setPlayerImg(img);
		p2.setx(0);
		p2.sety(125);
		p3.setPlayerImg(img);
		p3.setx(0);
		p3.sety(275);
		Group myGroup = new Group(gsf.getGroup(p1.playerView,p2.getPlayerImg(),p3.getPlayerImg()));
		Scene myScene = new Scene(myGroup, 750, 500, Color.BLUEVIOLET);
		myScene.setOnKeyReleased(this::keyMove);
		myStage.setScene(myScene);
		//timer.schedule(timertask, 0,50);
		timer3 = new AnimationTimer() {//Struggled with Timer for an hour than found this
            @Override
            public void handle(long now) {
            	time= j/100;
            	gsf.clock(Double.toString(time));
            	p2.move((int)j++);
            	p3.move(k+=2);
               }
            };
		timer3.start();}else {
			hsg.error();
		}
		}
	public void keyMove(KeyEvent event) {
		KeyCode myCode = event.getCode();
		
		if(myCode== KeyCode.LEFT&&lastCode == KeyCode.RIGHT) {
			p1.moveRight();
			lastCode = KeyCode.LEFT;
		}
		if(myCode== KeyCode.RIGHT&&lastCode == KeyCode.LEFT) {
			p1.moveRight();
			lastCode = KeyCode.RIGHT;
		}
		if(p1.getx()>750) {
			timer3.stop();
			if(time<3.72) {
			gsf.finished(time,"1st!");
			}else if(time>=3.72&&time<7.55) {
				gsf.finished(time, "2nd!");
			}else{
				gsf.finished(time, "3rd!");
			}
		}
}
}
