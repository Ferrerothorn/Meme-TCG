package extraData;

import game.Player;

public class HolyGrail extends Card {

	public HolyGrail() {
		this.name = "Holy Grail";
		this.setType("Junk");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += 5000;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
