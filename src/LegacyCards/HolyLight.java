package LegacyCards;

import extraData.Card;
import game.Player;

public class HolyLight extends Card {

	public HolyLight() {
		this.name = "Holy Light";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.rfg.size() > 0) {
			opponent.lifeTotal -= self.rfg.size();
		} else {
			self.draw();
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}
}
