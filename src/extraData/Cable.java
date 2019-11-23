package extraData;

import game.Player;

public class Cable extends Card {

	public Cable() {
		this.name = "Cable";
		this.setType("Junk");
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.cardCount(self.grave, "Cable") + self.cardCount(self.rfg, "Cable") >= 16) {
			opponent.lifeTotal = 0;
		}
	}
}
