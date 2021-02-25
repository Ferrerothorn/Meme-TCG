package LegacyCards;

import extraData.Card;
import game.Player;

public class JunkChucker extends Card {

	
	public JunkChucker() {
		this.name = "Junk Chucker";
		this.setType("Mech");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal-=self.getHand().size();
	}

}
