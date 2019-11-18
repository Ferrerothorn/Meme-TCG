package cards;

import extraData.Card;
import game.Player;

public class Paladin extends Card {

	public Paladin() {
		this.name = "Paladin";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.movePile(self.grave, self.rfg);
		self.lifeTotal += 12;
	}
}
