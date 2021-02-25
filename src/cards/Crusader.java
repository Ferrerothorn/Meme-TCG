package cards;

import extraData.Card;
import game.Player;

public class Crusader extends Card {

	public Crusader() {
		this.name = "Crusader";
		this.setType("Hero");
		this.setColor("White");
		this.setPriority(9);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 1;
		for (Card c : self.grave) {
			if (c.getType().equals("Hero") && !c.getName().equals("Crusader")) {
				opponent.lifeTotal -= 3;
				self.movePile(self.getDeck(), self.getGrave());
				self.shuffle();
				break;
			}
		}
	}
}
