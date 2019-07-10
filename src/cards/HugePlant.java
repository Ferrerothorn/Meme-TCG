package cards;

import extraData.Card;
import extraData.PlantTendrils;
import game.Player;

public class HugePlant extends Card {

	public HugePlant() {
		this.name = "Huge Plant";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.setCounters(self.grave.size());
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.grave.size()<this.getCounters()) {
			self.grave.add(new PlantTendrils());
		}
		this.setCounters(self.grave.size());
	}
}
