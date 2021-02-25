package cards;

import extraData.Card;
import game.Player;

public class MassGrave extends Card {

	public MassGrave() {
		this.name = "Mass Grave";
		this.setType("Spell");
		this.setColor("Black");
		this.setPriority(5);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		addCounters(self.grave.size());
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		addCounters(self.grave.size());
		if (this.getCounters() >= 100) {
			opponent.lifeTotal = 0;
		}
	}
}
