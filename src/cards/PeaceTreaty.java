package cards;

import extraData.Card;
import game.Player;

public class PeaceTreaty extends Card {

	public PeaceTreaty() {
		this.name = "Peace Treaty";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if ((self.rfg.size() > 10 && opponent.rfg.size() > 10) || self.grave.size() > 20 && opponent.grave.size() > 20) {
			opponent.lifeTotal = 1;
		}
	}
}
