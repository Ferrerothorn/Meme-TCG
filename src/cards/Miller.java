package cards;

import extraData.Card;
import game.Player;

public class Miller extends Card {

	public Miller() {
		this.name = "Miller";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.fatigue = 2100000000;
	}
}
