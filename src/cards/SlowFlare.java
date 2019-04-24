package cards;

import extraData.Card;
import game.Player;

public class SlowFlare extends Card {

	public SlowFlare() {
		this.name = "Slow Flare";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.randomDiscard();
		this.setCounters(3);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (this.getCounters()>0) {
			int damage = 4-this.getCounters();
			opponent.lifeTotal -= damage;
			this.takeCounter();
		}
	}
}
