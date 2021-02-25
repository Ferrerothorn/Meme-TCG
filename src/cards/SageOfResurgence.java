package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class SageOfResurgence extends Card {

	public SageOfResurgence() {
		this.name = "Sage of Resurgence";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(99);
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		Collections.shuffle(self.rfg);
		if (self.rfg.size() > 0) {
			self.grave.add(self.rfg.get(0));
			self.rfg.remove(0);
		}
		if (self.rfg.size() > 0) {
			self.grave.add(self.rfg.get(0));
			self.rfg.remove(0);
		}
	}
}
