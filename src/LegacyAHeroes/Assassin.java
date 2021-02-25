package LegacyAHeroes;

import extraData.Card;
import game.Game;
import game.Player;

public class Assassin extends Card {

	public Assassin() {
		this.name = "Assassin";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int heroes = 0;
		if (self.getDeck().size() > 0) {
			for (Card c : self.grave) {
				if (c.getType().equals("Hero")) {
					heroes++;
				}
			}
		}
		heroes /= 2;
		for (int i = heroes; i > 0; i--) {
			Card c = Game.newCardByName("Robot Assassin");
			c.setName("Copied " + c.getName());
			self.grave.add(c);
		}
	}
}
