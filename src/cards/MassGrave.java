package cards;

import extraData.Card;
import game.Player;

public class MassGrave extends Card {

	public MassGrave() {
		this.name = "Mass Grave";
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		addCounters(self.grave.size());
		if (this.getCounters() > 150) {
			opponent.lifeTotal = 0;
		}
	}
}
