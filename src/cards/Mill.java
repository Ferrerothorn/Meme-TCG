package cards;

import extraData.Card;
import game.Player;

public class Mill extends Card {

	public Mill() {
		this.name = "Mill";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.millX(4);
	}

}
