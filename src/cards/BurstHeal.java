package cards;

import extraData.Card;
import game.Player;

public class BurstHeal extends Card {

	public BurstHeal() {
		this.name = "Burst Heal";
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.lifeTotal < 10) {
			self.lifeTotal = 20;
			if (self.grave.remove(this)) {
				self.rfg.add(this);
			}
		}
	}
}
