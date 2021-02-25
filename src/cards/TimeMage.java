package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class TimeMage extends Card {

	public TimeMage() {
		this.name = "Time Mage";
		this.setColor("White");
		this.setType("Creature");
		this.setPriority(10);
	}

	@Override
	public void onentry(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.grave.size() > self.getDeck().size()) {
			ArrayList<Card> temp = new ArrayList<Card>();
			temp.addAll(self.grave);
			self.grave.clear();
			self.grave.addAll(self.getDeck());
			self.getDeck().clear();
			self.getDeck().addAll(temp);
			self.draw();
		}
	}
}
