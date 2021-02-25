package cards;

import extraData.Card;
import game.Player;

public class Zombie extends Card {

	public Zombie() {
		this.name = "Zombie";
		this.setColor("Black");
		this.setType("Creature");
		this.setPriority(15);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (opponent.handSize() == 0) {
			opponent.lifeTotal -= 4;
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (opponent.handSize() == 0) {
			//self.recur(this);
			this.shuffleBackIntoDeck(self);
			self.draw();
		}
	}
}
