package cards;

import extraData.Card;
import game.Player;

public class Herdcaller extends Card {

	public Herdcaller() {
		this.name = "Herdcaller";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(4);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getDeck().size() > 0) {
			if (self.getDeck().get(0).getType().equals("Creature")) {
				self.millX(1);
			} else {
				self.draw();
			}
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.getDeck().size() > 0) {
			if (self.getDeck().get(0).getType().equals("Creature")) {
				self.millX(1);
			}
		}
	}
}
