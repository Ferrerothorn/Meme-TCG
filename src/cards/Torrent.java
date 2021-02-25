package cards;

import extraData.Card;
import game.Utils;
import game.Player;

public class Torrent extends Card {

	public Torrent() {
		this.name = "Torrent";
		this.setColor("Blue");
		this.setType("Spell");
		this.setPriority(8);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		Boolean c1 = Utils.flipACoin();
		Boolean c2 = Utils.flipACoin();

		if (c1 == true || c2 == true) {
			opponent.millX(1);
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
