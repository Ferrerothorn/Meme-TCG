package cards;

import java.util.Collections;

import game.Player;

public class DarkTransfusion extends Card {

	public DarkTransfusion() {
		this.name = "Dark Transfusion";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		Card c = opponent.rfgTop();
		if (c != null) {
			c.onentry(self, opponent);
			c.graveAbility(self, opponent);
		}
		opponent.getDeck().add(new CorruptedBlood());
		Collections.shuffle(opponent.getDeck());
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		// self.getDeck().add(this);
		// self.grave.remove(this);
	}
}
