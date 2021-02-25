package cards;

import extraData.Card;
import game.Player;

public class Mushrooms extends Card {

	public Mushrooms() {
		this.name = "Mushrooms";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(7);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getDeck().size() > 0) {
			if (self.getDeck().get(0).getType().equals("Creature")) {
				self.draw();
			}
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		self.lifeTotal += 1;
		if (self.getDeck().size() > 0) {
			if (self.getDeck().get(0).getType().equals("Creature")) {
				self.lifeTotal += 1;
			}
		}
	}
}
