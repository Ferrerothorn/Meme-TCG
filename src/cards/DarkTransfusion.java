package cards;

import java.util.Collections;

import extraData.Card;
import extraData.CorruptedBlood;
import game.Player;

public class DarkTransfusion extends Card {

	public DarkTransfusion() {
		this.name = "Dark Transfusion";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.rfgTop();
		opponent.getDeck().add(new CorruptedBlood());
		Collections.shuffle(opponent.getDeck());
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
