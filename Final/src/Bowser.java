import java.util.Random;

public class Bowser implements Fighter{
	String name;
	String color;
	int hp;
	int dp;
	String ability;
	Random r = new Random();
	int tW=0;
public Bowser(String name,String color, int hp,int dp,String ability) {
	this.name=name;
	this.color=color;
	this.hp=hp;
	this.dp=dp;
	this.ability=ability;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public int getHp() {
	return hp;
}
public void setHp(int hp) {
	this.hp = hp;
}
public int getDp() {
	return dp;
}
public void setDp(int dp) {
	this.dp = dp;
}
public String getAbility() {
	return ability;
}
public void setAbility(String ability) {
	this.ability = ability;
}
public int sword() {
	return dp;
}
public int health() {
	return hp;
}
public void fight(String name2,String color2,int hp2,int dp2,String ability2) {	
	System.out.println(color+" "+name+" is fighting "+color+" "+name2);
	while(hp>0||hp2>0){
		switch(r.nextInt(2)){
		case 0:
			hp=hp-dp2;
		case 1:
			hp2=hp2-dp;
		}
	}
	System.out.println("Ending Hit Points: "+color+" "+name+": "+hp+" vs. "+color2+" "+name2+": "+hp2);
}
public String toString() {
	return "Tournament winner with: "+tW+" total wins is... "+color+" "+name+"!";
}
public void settW() {
	this.tW=tW+1;
}
}