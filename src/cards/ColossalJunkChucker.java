package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class ColossalJunkChucker extends Card {

	public ColossalJunkChucker() {
		this.name = "Colossal Junk Chucker";
		this.setType("Spell");
		this.setColor("Red");
		this.setPriority(99);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int damage = 0;
		ArrayList<String> differentNames = new ArrayList<>();
		for (Card c : self.grave) {
			if (differentNames.contains(c.getName())) {
				damage++;
			} else {
				differentNames.add(c.getName());
			}
		}
		opponent.lifeTotal -= damage;
	}
}
