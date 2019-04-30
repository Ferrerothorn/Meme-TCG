package cards;

import extraData.Card;
import game.Player;

public class Overdrive extends Card {

	public Overdrive() {
		this.name = "Overdrive";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -= self.getHand().size();
		self.playsPerTurn = self.getHand().size();
	}
}
