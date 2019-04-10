package cards;

import game.Player;

public class JunkChucker extends Card {

	
	public JunkChucker() {
		this.name = "Junk Chucker";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal-=self.getHand().size();
	}

}
