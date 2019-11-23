package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class Gardening extends Card {

	public Gardening() {
		this.name = "Gardening";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.grave.size()>0) {
			Collections.shuffle(self.grave);
			if(!self.grave.get(0).getName().contains("Plant")) {
				self.rfg.add(self.grave.remove(0));
			}
		}
		if (self.grave.size()>0) {
			Collections.shuffle(self.grave);
			if(!self.grave.get(0).getName().contains("Plant")) {
				self.rfg.add(self.grave.remove(0));
			}
		}
		
		if (opponent.grave.size()>0) {
			Collections.shuffle(opponent.grave);
			if(!opponent.grave.get(0).getName().contains("Plant")) {
				opponent.rfg.add(opponent.grave.remove(0));
			}
		}
		if (opponent.grave.size()>0) {
			Collections.shuffle(opponent.grave);
			if(!opponent.grave.get(0).getName().contains("Plant")) {
				opponent.rfg.add(opponent.grave.remove(0));
			}
		}
		
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
