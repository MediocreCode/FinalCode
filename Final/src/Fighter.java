import java.util.Random;

public interface Fighter {
Random r = new Random();

	static int fight(String name,String color,int hp,int dp,String ability,String name2,String color2,int hp2,int dp2,String ability2) {	
		System.out.println(color+" "+name+" is fighting "+color2+" "+name2+" using "+ability);
		System.out.println("Starting Hit Points: "+color+" "+name+": "+hp+" vs. "+color2+" "+name2+": "+hp2);
		boolean isWin = false;
		while(!isWin) {
			switch(r.nextInt(2)){
			case 0:
				hp=hp-dp2;
				break;
			case 1:
				hp2=hp2-dp;
				break;
		}if(hp<0) {
			isWin=true;
		}if(hp2<0) {
			isWin=true;
		}
		}
		System.out.println("Ending Hit Points: "+color+" "+name+": "+hp+" vs. "+color2+" "+name2+": "+hp2);
		if(hp<hp2) {
			System.out.println("WINNER IS "+color2+" "+name2+"!\n");
			return 1;
		}else {
			System.out.println("WINNER IS "+color+" "+name+"!\n");
			return 2;
		}
	}
	String getName();
	int getHp();
	int getDp();
	String getColor();
	String getAbility();
	void settW();
}
