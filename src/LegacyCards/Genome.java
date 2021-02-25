package LegacyCards;

import extraData.Card;
import game.Player;

public class Genome extends Card {

	public Genome() {
		this.name = "Genome";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.randomDiscard();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (opponent.getHand().size() <= 2) {
			opponent.lifeTotal--;
		}
	}
}
