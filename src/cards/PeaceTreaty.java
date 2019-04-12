package cards;

import game.Player;

public class PeaceTreaty extends Card {

	public PeaceTreaty() {
		this.name = "Peace Treaty";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if ((self.rfg.size() + opponent.rfg.size() > 15) || self.grave.size() + opponent.grave.size() > 40) {
			opponent.lifeTotal = 0;
		}
	}
}
