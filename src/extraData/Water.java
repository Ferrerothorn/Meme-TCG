package extraData;

import game.Player;

public class Water extends Card {

	public Water() {
		this.name = "Water";
		this.setType("Junk");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal++;
		self.rfg.add(this);
		self.grave.add(this);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
