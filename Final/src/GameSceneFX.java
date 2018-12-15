
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
public class GameSceneFX{
	Text counter = new Text();
	Text fin = new Text();
	static String pName;
	Group root = new Group();
	Scene myScene;
	int i= 0;
	String hs="";
	Text clock = new Text();
	int j=0;
	int f=0;
	
	public String getName(String name) {
		return name;
	}
	public Group getGroup(ImageView p1,ImageView p2,ImageView p3) {
		root = new Group(p1,counter,fin,clock,p2,p3);
		return root;
	}
	public Scene getScene() {
		myScene = new Scene(root,750, 500, Color.BLACK);
		return myScene;
	}
	public Text changeCounter(String name,String string) {
		counter.setX(0);
		counter.setY(20);
		counter.setText(name+": "+string);
		clock.setX(375);
		clock.setY(20);
		clock.setStroke(Color.AQUA);
		clock.setText(""+i);
		return counter;
	}
	public void finished(double x,String place) {
		fin.setText("You finished at "+Double.toString(x)+"s in "+place);
		fin.setX(300);
		fin.setY(225);
		fin.setScaleX(4);
		fin.setScaleY(4);
		fin.setStroke(Color.CHARTREUSE);
	}
	public void clock(String x) {
		clock.setText(x);
	}
}