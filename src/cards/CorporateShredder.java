package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class CorporateShredder extends Card {

	public CorporateShredder() {
		this.name = "Corporate Shredder";
		this.setType("Creature");
		this.setColor("Green");
		this.setPriority(6);
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (opponent.grave.size() > 0) {
			Collections.shuffle(opponent.grave);
			opponent.rfg.add(opponent.grave.remove(0));
		}
	}
}
