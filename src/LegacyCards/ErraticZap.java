package LegacyCards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class ErraticZap extends Card {

	public ErraticZap() {
		this.name = "Erratic Zap";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<String> differentTypes = new ArrayList<>();
		for (Card c : self.getDeck()) {
			if (!differentTypes.contains(c.getType())) {
				differentTypes.add(c.getType());
			}
		}
		opponent.lifeTotal -= differentTypes.size();
	}
}
