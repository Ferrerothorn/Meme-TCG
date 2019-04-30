package cards;

import java.util.Random;

import extraData.Card;
import game.Player;

public class Tent extends Card {

	public Tent() {
		this.name = "Tent";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		Random r = new Random();
		int x = r.nextInt(4);
		this.setCounters(x);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		this.setCounters((this.getCounters() + 1) % 4);
		if (this.getCounters() == 0) {
			self.lifeTotal += 8;
		}

	}
}
