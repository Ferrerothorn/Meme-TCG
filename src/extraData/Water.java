package extraData;

import game.Player;

public class Water extends Card {

	public Water() {
		this.name = "Water";
		this.setType("Junk");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
		this.rfgThis(self);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
