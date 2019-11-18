package cards;

import extraData.Card;
import game.Player;

public class DarkKnight extends Card {

	public DarkKnight() {
		this.name = "Dark Knight";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int damage = (30 - self.lifeTotal);
		int damageModifier = 3;
		if (self.containsClass(self.grave, "Hero")) {
			damageModifier = 2;
		}
		damage /= damageModifier;
		if (damage == 0) {
			self.draw();
		} else {
			opponent.lifeTotal -= damage;
		}
	}
}
