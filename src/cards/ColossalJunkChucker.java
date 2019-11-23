package cards;

import extraData.Card;
import game.Player;

public class ColossalJunkChucker extends Card {

	public ColossalJunkChucker() {
		this.name = "Colossal Junk Chucker";
		this.setType("Mech");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= self.getHand().size();
		opponent.lifeTotal -= self.getHand().size();
		while (self.getHand().size() > 0) {
			self.randomDiscard();
		}
	}
}
