package cards;

import extraData.Cable;
import extraData.Card;
import game.Player;

public class Pylon extends Card {

	public Pylon() {
		this.name = "Pylon";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		self.grave.add(new Cable());
	}
}
