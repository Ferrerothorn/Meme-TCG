package cards;

import java.util.Random;

import extraData.Card;
import game.Player;

public class WheelOfFate extends Card {

	public WheelOfFate() {
		this.name = "Wheel of Fate";
		this.setType("Mech");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		Random r = new Random();
		this.setCounters(r.nextInt(4));
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		this.setCounters((this.getCounters() + 1) % 4);
		switch (this.getCounters()) {
		case 0:
			opponent.lifeTotal -= 1;
		case 1:
			self.lifeTotal += 2;
		case 2:
			self.draw();
		case 3:
			opponent.randomDiscard();
		}
	}
}
