package extraData;

import game.Player;

public class KillerBee extends Card {

	public KillerBee() {
		this.name = "Killer Bee";
		this.setType("Junk");
		this.setPriority(99);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -= 2;
		self.draw();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
