package game;

/*
 * 
 * 
 * 
 * 
Dredge:Gesper-4,Mend-4,Thought Scour-4,Cowardly Robot-4,Grindstone-4,Eternal Herb-4,Poison Frog-2,The Rack-4
Wicked Robot Control:Wicked Robot-3,Thought Scour-2,Gesper-2,Zap-2,Poison Frog-2,Mend-2,Junk Chucker-2,The Rack-2,Ancestral Recall-2,Mulch Munch-2,Zap and Tap-2,Handy Robot-2,Eternal Herb-2,Tempo Drain-2,Comeback Zap-1
Dark x Light:Zap-3,Mulch Munch-3,Dark Zap-3,Amnesia-3,Peace Treaty-2,Zapstarter-2,Body Swap-2,Sinkhole-2,Mend-2,The Rack-2,Zap and Tap-2,Sycamore-2,Parry-2
Steve Turbo Discard:Tempo Drain-2,Amnesia-4,Poison Frog-4,Heal-4,Mend-4,Burial-4,Regrow-1,Wicked Robot-3,Grindstone-3,Eternal Herb-1
Seemingly Good Random:Ignite-3,Grindstone-2,Zap-2,Zapstarter-2,Poison Frog-2,Sinkhole-2,Mend-2,Regrow-2,Life Zap-2,Mulch Munch-2,Handy Robot-2,Mill-2,Amnesia-2,Colossal Junk Chucker-2,Parry-1
Burn Slayer:Zap-4,Heal-4,Sparkwave-4,Giga Zap-4,Comeback Zap-4,Mend-4,Handy Robot-3,Wicked Robot-2,Zapstarter-1
Eternal Mill:Grindstone-4,Eternal Herb-4,Parry-3,Life Zap-2,Handy Robot-2,Mill-4,Heal-3,Regrow-3,Thought Scour-3,Burial-2
Needham Burn:Zap-4,Zap and Tap-4,Sparkwave-4,Giga Zap-4,Comeback Zap-4,Mend-4,Handy Robot-3,Wicked Robot-2,Zapstarter-1
Adam Lifegain:Eternal Herb-4,Sycamore-2,Accumulated Knowledge-4,Junk Chucker-4,Handy Robot-2,Sinkhole-4,Colossal Junk Chucker-2,Mend-4,Mulch Munch-4
Peace Treaty:Mend-4,Grindstone-2,Peace Treaty-4,Wicked Robot-2,Damnation-3,Junk Chucker-1,Dark Zap-3,Handy Robot-2,Apparition-2,Mill-3,Tempo Drain-2,Corporate Shredder-2
Body Swap Anti Burn:Heal-3,Mulch Munch-3,Ignite-3,Tempo Drain-3,Wicked Robot-2,Sparkwave-2,Zapstarter-2,Body Swap-2,Comeback Zap-2,Giga Zap-2,Burial-2,Life Zap-2,Eternal Herb-2
Handy Shredder:Handy Robot-4,Corporate Shredder-4,Zap and Tap-3,Mend-3,Regrow-3,Burial-2,Cowardly Robot-2,Apparition-2,Comeback Zap-2,Parry-2,Tempo Drain-2,Peace Treaty-1
Jund:Poison Frog-4,Accumulated Knowledge-3,Giga Zap-3,Sparkwave-2,Mulch Munch-2,Burial-2,Eternal Herb-2,Sycamore-2,Cowardly Robot-4,Dark Zap-4,Damnation-2
The Uncounterable:Grindstone-3,Burial-3,Corporate Shredder-2,Wicked Robot-2,Body Swap-2,The Rack-2,Comeback Zap-2,Ancestral Recall-2,Giga Zap-2,Mulch Munch-2,Life Zap-2,Mill-2,Amnesia-2,Damnation-2
Corrupted Blood:Dark Transfusion-4,Dark Zap-4,Search the Darkness-2,Dark Pact-1,Wicked Robot-2,Handy Robot-3,Amnesia-3,Tempo Drain-2,Charged Laser-2,Mend-4,Timetwister-3
Dark.dek:Poison Frog-4,Dark Transfusion-4,Corporate Shredder-2,Donate-3,Junk Chucker-4,Dark Pact-4,Comeback Zap-1,The Rack-2,Giga Zap-2,Handy Robot-2,Apparition-1,Damnation-1
Corporate Peace Frog:Corporate Shredder-4,Poison Frog-4,Zap-3,Wicked Robot-3,Peace Treaty-2,Heal-2,Comeback Zap-2,The Rack-2,Handy Robot-3,Eternal Herb-2,Mill-3
Pylon Alignment:Pylon-4,Sycamore-4,Mend-4,Thought Scour-4,Handy Robot-4,Eternal Herb-4,Gesper-4,Apparition-2
Assassin Control:Robot Assassin-3,Damnation-3,Grindstone-2,Peace Treaty-2,Sparkwave-2,Wicked Robot-2,The Rack-2,Dark Transfusion-2,Mulch Munch-2,Donate-2,Dark Zap-2,Waifu-2,Colossal Junk Chucker-2,Channel the Depths-2
Waifu Control:Apparition-3,Dark Pact-2,The Rack-2,Junk Chucker-2,Comeback Zap-2,Dark Transfusion-3,Zap and Tap-2,Burial-2,Mulch Munch-2,Waifu-3,Colossal Junk Chucker-2,Tempo Drain-2,Damnation-3
Dredge Slayer:Timetwister-3,Corporate Shredder-3,Mend-3,Mulch Munch-3,Handy Robot-3,Poison Frog-2,Sinkhole-2,The Rack-2,Burial-2,Sycamore-2,Apparition-2,Mill-2,Grindstone-1
Assassin Burn:Zap-4,Giga Zap-4,Ignite-4,Robot Assassin-4,Mill-4,Grindstone-4,Amnesia-4,The Rack-2
Damn Peaceful:Mend-4,Grindstone-3,Peace Treaty-4,Wicked Robot-1,Damnation-3,Zap-4,Handy Robot-2,Giga Zap-2,Mill-3,Tempo Drain-2,Corporate Shredder-2
Doomsday Combo:Robot Assassin-4,Doomsday Device-3,Corporate Shredder-3,Peace Treaty-3,Poison Frog-3,Sycamore-2,Donate-2,Body Swap-2,Sinkhole-2,Comeback Zap-2,Colossal Junk Chucker-2,Tempo Drain-2
Burst Transfusion:Mulch Munch-3,Damnation-3,Doomsday Device-3,Peace Treaty-2,Robot Assassin-2,Dark Pact-2,Comeback Zap-2,Dark Transfusion-2,Vitality Artifact-3,Handy Robot-2,Zap Magnifier-2,Burst Heal-2,Apparition-2

Assassin Burn:Zap-4,Giga Zap-4,Ignite-4,Robot Assassin-4,Mill-4,Grindstone-4,Amnesia-4,The Rack-2/Pylon Alignment:Pylon-4,Sycamore-4,Mend-4,Thought Scour-4,Handy Robot-4,Eternal Herb-4,Gesper-4,Apparition-2/Waifu Control:Apparition-3,Dark Pact-2,The Rack-2,Junk Chucker-2,Comeback Zap-2,Dark Transfusion-3,Zap and Tap-2,Burial-2,Mulch Munch-2,Waifu-3,Colossal Junk Chucker-2,Tempo Drain-2,Damnation-3/Corporate Peace Frog:Corporate Shredder-4,Poison Frog-4,Zap-3,Wicked Robot-3,Peace Treaty-2,Heal-2,Comeback Zap-2,The Rack-2,Handy Robot-3,Eternal Herb-2,Mill-3/Dredge:Gesper-4,Mend-4,Thought Scour-4,Cowardly Robot-4,Grindstone-4,Eternal Herb-4,Poison Frog-2,The Rack-4/Wicked Robot Control:Wicked Robot-3,Thought Scour-2,Gesper-2,Zap-2,Poison Frog-2,Mend-2,Junk Chucker-2,The Rack-2,Ancestral Recall-2,Mulch Munch-2,Zap and Tap-2,Handy Robot-2,Eternal Herb-2,Tempo Drain-2,Comeback Zap-1/Dark x Light:Zap-3,Mulch Munch-3,Dark Zap-3,Amnesia-3,Peace Treaty-2,Zapstarter-2,Body Swap-2,Sinkhole-2,Mend-2,The Rack-2,Zap and Tap-2,Sycamore-2,Parry-2/Steve Turbo Discard:Tempo Drain-2,Amnesia-4,Poison Frog-4,Heal-4,Mend-4,Burial-4,Regrow-1,Wicked Robot-3,Grindstone-3,Eternal Herb-1/Seemingly Good Random:Ignite-3,Grindstone-2,Zap-2,Zapstarter-2,Poison Frog-2,Sinkhole-2,Mend-2,Regrow-2,Life Zap-2,Mulch Munch-2,Handy Robot-2,Mill-2,Amnesia-2,Colossal Junk Chucker-2,Parry-1/Burn Slayer:Zap-4,Heal-4,Sparkwave-4,Giga Zap-4,Comeback Zap-4,Mend-4,Handy Robot-3,Wicked Robot-2,Zapstarter-1/Eternal Mill:Grindstone-4,Eternal Herb-4,Parry-3,Life Zap-2,Handy Robot-2,Mill-4,Heal-3,Regrow-3,Thought Scour-3,Burial-2/Needham Burn:Zap-4,Zap and Tap-4,Sparkwave-4,Giga Zap-4,Comeback Zap-4,Mend-4,Handy Robot-3,Wicked Robot-2,Zapstarter-1/Adam Lifegain:Eternal Herb-4,Sycamore-2,Accumulated Knowledge-4,Junk Chucker-4,Handy Robot-2,Sinkhole-4,Colossal Junk Chucker-2,Mend-4,Mulch Munch-4/Body Swap Anti Burn:Heal-3,Mulch Munch-3,Ignite-3,Tempo Drain-3,Wicked Robot-2,Sparkwave-2,Zapstarter-2,Body Swap-2,Comeback Zap-2,Giga Zap-2,Burial-2,Life Zap-2,Eternal Herb-2/Peace Treaty:Mend-4,Grindstone-2,Peace Treaty-4,Wicked Robot-2,Damnation-3,Junk Chucker-1,Dark Zap-3,Handy Robot-2,Apparition-2,Mill-3,Tempo Drain-2,Corporate Shredder-2/Handy Shredder:Handy Robot-4,Corporate Shredder-4,Zap and Tap-3,Mend-3,Regrow-3,Burial-2,Cowardly Robot-2,Apparition-2,Comeback Zap-2,Parry-2,Tempo Drain-2,Peace Treaty-1/Jund:Poison Frog-4,Accumulated Knowledge-3,Giga Zap-3,Sparkwave-2,Mulch Munch-2,Burial-2,Eternal Herb-2,Sycamore-2,Cowardly Robot-4,Dark Zap-4,Damnation-2/Dredge Slayer:Timetwister-3,Corporate Shredder-3,Mend-3,Mulch Munch-3,Handy Robot-3,Poison Frog-2,Sinkhole-2,The Rack-2,Burial-2,Sycamore-2,Apparition-2,Mill-2,Grindstone-1/The Uncounterable:Grindstone-3,Burial-3,Corporate Shredder-2,Wicked Robot-2,Body Swap-2,The Rack-2,Comeback Zap-2,Ancestral Recall-2,Giga Zap-2,Mulch Munch-2,Life Zap-2,Mill-2,Amnesia-2,Damnation-2/Corrupted Blood:Dark Transfusion-4,Dark Zap-4,Search the Darkness-2,Dark Pact-1,Wicked Robot-2,Handy Robot-3,Amnesia-3,Tempo Drain-2,Charged Laser-2,Mend-4,Timetwister-3/Peaceful Boi:Peace Treaty-4,Sparkwave-3,Zap and Tap-3,Thought Scour-2,Poison Frog-2,Heal-2,The Rack-2,Giga Zap-2,Burial-2,Handy Robot-2,Mill-2,Amnesia-2,Damnation-2/Dark.dek:Poison Frog-4,Dark Transfusion-4,Corporate Shredder-2,Donate-3,Junk Chucker-4,Dark Pact-4,Comeback Zap-1,The Rack-2,Giga Zap-2,Handy Robot-2,Apparition-1,Damnation-1
 */

import java.util.ArrayList;
import java.util.Collections;

import extraData.Card;

public class Player {

	Deck deck = new Deck();
	ArrayList<Card> hand = new ArrayList<Card>();
	public ArrayList<Card> grave = new ArrayList<Card>();
	public ArrayList<Card> rfg = new ArrayList<Card>();
	String name;
	public int maxLifeTotal = 30;
	public int lifeTotal;
	public int playsPerTurn = 2;

	public Player(String newName) {
		name = newName;
		lifeTotal = maxLifeTotal;
	}

	public ArrayList<Card> getDeck() {
		return deck.cards;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<Card> getGrave() {
		return grave;
	}

	public void setGrave(ArrayList<Card> grave) {
		this.grave = grave;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void draw() {
		if (deck.size() > 0) {
			hand.add(deck.remove(0));
		} else {
			this.lifeTotal = lifeTotal - 5;
		}
	}

	public void shuffle() {
		deck.shuffle();
	}

	public void randomDiscard() {
		if (hand.size() > 0) {
			Collections.shuffle(hand);
			grave.add(hand.remove(0));
		}
	}

	public void millX(int x) {
		for (int i = 0; i < x; i++) {
			if (deck.size() > 0) {
				grave.add(deck.remove(0));
			}
		}
	}

	public void add(Card c) {
		deck.add(c);
	}

	public void drawX(int x) {
		for (int i = 0; i < x; i++) {
			draw();
		}
	}

	public boolean isAlive() {
		return lifeTotal > 0;
	}

	public void makePlay(Player opponent) {
		if (hand.size() > 0) {
			Collections.shuffle(hand);
			Card c = hand.remove(0);
			grave.add(c);
			c.onentry(this, opponent);
			c.afterResolving(this, opponent);
			// System.out.println(this.name + " casts " + c.getName() + ". (" + lifeTotal +
			// ")-(" + opponent.getLife() + ")");
		}
	}

	public void cleanup() {
		this.deck.addAll(this.grave);
		this.grave.clear();
		this.deck.addAll(this.rfg);
		this.rfg.clear();
		this.deck.addAll(this.hand);
		this.hand.clear();
		this.deck.remove("Corrupted Blood");
		this.deck.remove("Cable");
		for (Card c : this.getDeck()) {
			c.setCounters(0);
		}
		this.lifeTotal = 30;
//		if (this.deck.size() != 30) {
//			System.out.println("Deck isn't 30 cards: cleanup seems to not be working.");
//			System.out.println(this.showDecklist());
//			System.exit(0);
//		}
	}

	public int getLife() {
		return lifeTotal;
	}

	public int cardCount(ArrayList<Card> grave2, String string) {
		int i = 0;
		for (Card cs : grave2) {
			if (cs.getName().equals(string)) {
				i++;
			}
		}
		return i;
	}

	public void movePile(ArrayList<Card> targetPile, ArrayList<Card> sourcePile) {
		targetPile.addAll(sourcePile);
		sourcePile.clear();
	}

	public void rfgFromDeck(int x) {
		for (int i = 0; i < x; i++) {
			if (getDeck().size() > 0) {
				rfg.add(getDeck().remove(0));
			}
		}
	}

	public Card rfgTop() {
		if (getDeck().size() > 0) {
			Card c = getDeck().remove(0);
			rfg.add(c);
			return c;
		}
		return null;
	}

	public String showDecklist() {
		ArrayList<String> cards = new ArrayList<String>();
		for (Card c : getDeck()) {
			cards.add(c.getName());
		}
		Collections.sort(cards);
		return cards.toString();
	}
}
