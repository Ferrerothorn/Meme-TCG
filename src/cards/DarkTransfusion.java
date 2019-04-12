package cards;

import java.util.Collections;

import game.Player;

public class DarkTransfusion extends Card {

	public DarkTransfusion() {
		this.name = "Dark Transfusion";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.getDeck().add(new CorruptedBlood());
		opponent.getDeck().add(new CorruptedBlood());
		Collections.shuffle(opponent.getDeck());
		self.getDeck().add(this);
		self.grave.remove(this);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		self.getDeck().add(this);
		self.grave.remove(this);
	}
}
