package LegacyCards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class Gardening extends Card {

	public Gardening() {
		this.name = "Gardening";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (opponent.grave.size() > 0) {
			Collections.shuffle(opponent.grave);
			opponent.rfg.add(opponent.grave.remove(0));
		}
		if (opponent.grave.size() > 0) {
			Collections.shuffle(opponent.grave);
			opponent.rfg.add(opponent.grave.remove(0));
		}

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
