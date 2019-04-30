package cards;

import extraData.Card;
import game.Player;

public class LesserDemon extends Card {

	public LesserDemon() {
		this.name = "Lesser Demon";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.addCounter();
		self.lifeTotal -=2;
		self.draw();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if(this.getCounters()>0) {
			opponent.lifeTotal -= 2;
		}
	}
}
