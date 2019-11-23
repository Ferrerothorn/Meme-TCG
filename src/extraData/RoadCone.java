package extraData;

import game.Player;

public class RoadCone extends Card {

	public RoadCone() {
		this.name = "Road Cone";
		this.setType("Junk");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
	}
	
}
