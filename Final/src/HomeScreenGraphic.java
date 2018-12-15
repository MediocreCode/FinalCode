import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HomeScreenGraphic {
	Button start = new Button("Start");
	TextField homeTF = new TextField("Enter Name");
	TextField homeEM = new TextField("Enter Email");
	TextField homeNum = new TextField("Enter Race Number");
	Text homeText = new Text("GAME!");
	String playerName;
	Group root;
	Text hs=new Text();
	public Group getGroup() {
		root = new Group(start,homeTF,homeText,hs,homeEM,homeNum);
		return root;
	}
	//Getters
	public Button getStart() {
		start.setLayoutX(250);
		start.setLayoutY(400);
		return start;
	}
	public TextField getHomeTF() {
		homeTF.setLayoutX(250);
		homeTF.setLayoutY(250);
		return homeTF;
	}
	public TextField getHomeNum() {
		homeNum.setLayoutX(250);
		homeNum.setLayoutY(350);
		return homeNum;
	}
	public String getHomeNumText() {
		String str = homeNum.getText();
		
		return str;
	}
	public String getHomeEMText() {
		String str = homeEM.getText();
		
		return str;
	}
	public TextField getHomeEM() {
		homeEM.setLayoutX(250);
		homeEM.setLayoutY(300);
		return homeEM;
	}
	public Text getHomeText() {
		homeText.setLayoutX(350);
		homeText.setLayoutY(200);
		homeText.setStroke(Color.BROWN);
		return homeText;
	}
	public String getPlayerName() {
		playerName = homeTF.getText();
		return playerName;
	}
	public Text HighScore(String str) {
		hs.setText(str);
		hs.setLayoutX(250);
		hs.setLayoutY(100);
		hs.setStroke(Color.WHITE);
		return hs;
	}
	public void error() {
		homeText.setX(-100);
		homeText.setText("Invalid Email or Race Number. Check Again.");
	}
}
