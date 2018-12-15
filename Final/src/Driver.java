import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver{
	/*
	 * Raleigh Dial
	 * Final Exam 3
	 * 
	 * Writing this in the Minneapolis airport while a young child is throwing a trantrum.
	 * Let's see how it goes :)
	 */
	static int j;
	static int i;
	static int loser;
	static ArrayList<Fighter> players = new ArrayList();
	static Random r = new Random();
	public static void main(String[] args) throws IOException {
		
		File file = new File("./src/Smash.txt"); 
		BufferedReader read = new BufferedReader(new FileReader(file));
		String line;
		while((line = read.readLine()) != null){
			Scanner myScan = new Scanner(line).useDelimiter(",");
			while(myScan.hasNext()) {
				Link link = new Link(myScan.next(),myScan.next(),myScan.nextInt(),myScan.nextInt(),myScan.next());
				players.add(link);
				Luigi luigi = new Luigi(myScan.next(),myScan.next(),myScan.nextInt(),myScan.nextInt(),myScan.next());
				players.add(luigi);
				Mario mario = new Mario(myScan.next(),myScan.next(),myScan.nextInt(),myScan.nextInt(),myScan.next());
				players.add(mario);
				Bowser bowser = new Bowser(myScan.next(),myScan.next(),myScan.nextInt(),myScan.nextInt(),myScan.next());
				players.add(bowser);
				Pika pika = new Pika(myScan.next(),myScan.next(),myScan.nextInt(),myScan.nextInt(),myScan.next());
				players.add(pika);
			}
		}
		
		while(players.size()>1) {
			i = r.nextInt(players.size());
			j = r.nextInt(players.size());
			while(j==i) {
				j = r.nextInt(players.size());
			}
		loser = Fighter.fight(players.get(i).getName(), players.get(i).getColor(), players.get(i).getHp(), players.get(i).getDp(),
				players.get(i).getAbility(),players.get(j).getName(), players.get(j).getColor(), players.get(j).getHp(), players.get(j).getDp(),
				players.get(j).getAbility());
		if(loser==1) {
			players.get(j).settW();
			players.remove(players.get(i));
		}else {
			players.get(i).settW();
			players.remove(players.get(j));
		}
		}
		System.out.println(players.get(0).toString());
	}
}
