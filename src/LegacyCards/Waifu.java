package LegacyCards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class Waifu extends Card {

	
	public Waifu() {
		this.name = "Waifu";
		this.setType("Hero");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.getDeck().addAll(self.getHand());
		self.getHand().clear();
		Collections.shuffle(self.getDeck());
		self.draw(5);
	}	
}
