package cards;

import extraData.Card;
import game.Player;

public class ChargedLaser extends Card {

	public ChargedLaser() {
		this.name = "Charged Laser";
		this.setColor("Red");
		this.setType("Spell");
		this.setPriority(15);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal - 1;
		if (opponent.grave.size() + self.grave.size() > 15) {
			opponent.lifeTotal = opponent.lifeTotal - 2;
			self.draw();
		}
		if (opponent.grave.size() + self.grave.size() > 30) {
			opponent.lifeTotal = opponent.lifeTotal - 3;
			self.draw();
			opponent.randomDiscard();
		}
	}
}
