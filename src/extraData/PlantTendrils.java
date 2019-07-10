package extraData;

import game.Player;

public class PlantTendrils extends Card {

	public PlantTendrils() {
		this.name = "Plant Tendrils";
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.lifeTotal -= 2;
	}
}
