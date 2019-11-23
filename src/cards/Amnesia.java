package cards;

import extraData.Card;
import game.Player;

public class Amnesia extends Card {

	public Amnesia() {
		this.name = "Amnesia";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.randomDiscard();
		opponent.randomDiscard();
	}
}
