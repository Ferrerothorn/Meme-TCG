package LegacyCards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class SellSoul extends Card {

	public SellSoul() {
		this.name = "Sell Soul";
		this.setColor("Black");
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -= self.grave.size();
		self.movePile(self.getHand(), self.grave);
		Collections.shuffle(self.getHand());
	}
}
