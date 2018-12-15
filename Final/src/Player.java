import java.util.TimerTask;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player{

		static int x=0;
		static int y=0;
		static int i=0;
		String playerName;
		Image playerImg = new Image("file:src/Player.png");
		ImageView playerView = new ImageView(playerImg);

public void setPlace1() {
	x = 0;
	y = 200;
	playerView.setX(x);
	playerView.setY(y);
}
public void moveRight() {
	x+=10;
	playerView.setX(x);
}

public void setScale() {
	playerView.setScaleX(.75);
	playerView.setScaleY(.75);
}
		public int getx() {
			return x;
		}
		public void setx(int x) {
			playerView.setX(x);
		}
		public void move(int i) {
			x=i;
			playerView.setX(x);
		}
		
		public int gety() {
			return y;
		}
		public void sety(int y) {
			playerView.setY(y);
		}
		public String getPlayerName() {
			return playerName;
		}
		public ImageView getPlayerImg() {
			return playerView;
		}
		public void setPlayerImg(Image playerImg) {
			this.playerImg = playerImg;
			this.playerView = new ImageView(playerImg);
		}
}
