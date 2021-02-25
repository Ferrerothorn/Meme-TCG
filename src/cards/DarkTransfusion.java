package cards;

import java.util.Collections;

import extraData.Card;
import extraData.CorruptedBlood;
import game.Player;

public class DarkTransfusion extends Card {

	public DarkTransfusion() {
		this.name = "Dark Transfusion";
		this.setType("Spell");
		this.setColor("Black");
		this.setPriority(4);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.getDeck().add(new CorruptedBlood());
		Collections.shuffle(opponent.getDeck());
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
