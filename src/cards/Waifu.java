package cards;

import java.util.Collections;

import game.Player;

public class Waifu extends Card {

	
	public Waifu() {
		this.name = "Waifu";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.getDeck().addAll(self.getHand());
		self.getHand().clear();
		Collections.shuffle(self.getDeck());
		self.drawX(5);
	}	
}
