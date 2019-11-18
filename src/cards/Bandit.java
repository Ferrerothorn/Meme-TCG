package cards;

import java.util.Collections;

import extraData.Card;
import game.Game;
import game.Player;

public class Bandit extends Card {

	public Bandit() {
		this.name = "Bandit";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int heroes = 0;
		if (self.getDeck().size() > 0) {
			for (Card c : self.getDeck()) {
				if (c.getType().equals("Hero")) {
					heroes++;
				}
			}
		}
		if (opponent.getDeck().size() > 0) {
			for (int i = heroes; i > 0; i--) {
				Collections.shuffle(opponent.getDeck());
				Card o = opponent.getDeck().get(0);
				if (!o.getName().contains("Copied ")) {
					Card c = Game.newCardByName(o.getName());
					c.setName("Copied " + c.getName());
					self.getDeck().add(c);
					Collections.shuffle(self.getDeck());
				}
			}
		} else {
			opponent.draw();
		}
	}
}
