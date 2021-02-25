package game;

import java.util.Random;

public class Utils {

	public static Boolean flipACoin() {
		Random r = new Random();
		int coin = r.nextInt(2);
		return coin == 0;
	}
	
}
