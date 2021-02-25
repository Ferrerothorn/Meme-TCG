package LegacyCards;

import extraData.Card;
import game.Player;

public class PullFromEternity extends Card {

	public PullFromEternity() {
		this.name = "Pull From Eternity";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.rfg.size() > 0) {
			self.movePile(self.grave, self.rfg);
		} else {
			self.draw();
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
