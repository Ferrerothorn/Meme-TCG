package cards;

import java.util.ArrayList;
import java.util.Collections;

import extraData.Card;
import game.Player;

public class Burial extends Card {

	
	public Burial() {
		this.name = "Burial";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		if (opponent.grave.size()!=0) {
			Collections.shuffle(opponent.grave);
			String c = opponent.grave.get(0).getName();
			
			ArrayList<Card> hatelist = new ArrayList();
			
			for (Card cs: opponent.grave) {
				if(cs.getName().equals(c)) {
					hatelist.add(cs);
				}
			}
			for (Card cs: opponent.getHand()) {
				if(cs.getName().equals(c)) {
					hatelist.add(cs);
				}
			}
			for (Card cs: opponent.getDeck()) {
				if(cs.getName().equals(c)) {
					hatelist.add(cs);
				}
			}
			
			opponent.rfg.addAll(hatelist);
			opponent.getHand().removeAll(hatelist);
			opponent.grave.removeAll(hatelist);
			opponent.getDeck().removeAll(hatelist);
		}
		else {
			self.draw();
		}
	}	
}
