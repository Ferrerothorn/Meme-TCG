package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import cards.*;
import extraData.*;

public class Game {

	public static ArrayList<Player> players = new ArrayList<>();
	public static ArrayList<String> cardPool = new ArrayList<>();
	public static Boolean debug = false;
	public static Scanner input = new Scanner(System.in);
	public static int deathsByMill = 0;

	public static void main(String[] args) {
		instantiateCardpool();
		while (true) {
			System.out.println();
			System.out.println("===Choose a command===");
			System.out.println("0: Generate a blind meta deck.");
			System.out.println("1: Generate a deck with a list of must-include cards.");
			System.out.println("2: Analyse the top 8 meta.");
			System.out.println("22: Debug generation: Top Cut is entire tourney.");
			System.out.println("3: Run a single game.");
			System.out.println("5: Compare two decks.");
			System.out.println("6: Compare one deck against a multitude of other decks.");
			System.out.println("7: Generate a 'solution' to a deck.");
			System.out.println("999: Quit.");
			System.out.println();
			int choice = 5;
			choice = input.nextInt();
			input.nextLine();

			switch (choice) {

			case 0:
				runTournament(1, "", "");
				break;
			case 1:
				System.out.println("Please enter your list of required cards.");
				String mandatoryCards = input.nextLine();
				System.out.println("Please enter your list of banned cards.");
				String bannedCards = input.nextLine();
				runTournament(1, mandatoryCards, bannedCards);
				break;
			case 2:
				runTournament(8, "", "");
				break;
			case 22:
				runTournament(300000, "", "");
				break;
			case 3:
				runSingleGame();
				break;
			case 5:
				runBestOf25k();
				break;
			case 6:
				System.out
						.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String bossInfo = input.nextLine();
				String[] parseBossName = bossInfo.split(":");
				Player boss = new Player(parseBossName[0]);
				boss.setDeck(parseDeckFromLine(parseBossName[1]));

				System.out.println("Enter any number of other decklists in the same format, separated by '/'.");
				String gauntletInfo = input.nextLine();
				System.out.println();
				String[] gauntlet = gauntletInfo.split("/");

				for (String s : gauntlet) {
					String[] parsedNames = s.split(":");
					Player opp = new Player(parsedNames[0]);
					opp.setDeck(parseDeckFromLine(parsedNames[1]));

					if (boss.getDeck().size() + opp.getDeck().size() != 80) {
						debug("One or more decks isn't correct (@40 cards).");
						debug(boss.name + ": " + boss.getDeck().size());
						debug(opp.name + ": " + opp.getDeck().size());
						break;
					}

					System.out.println(boss.getName() + " wins " + grindGames(boss, opp, 25000) + "% of games against "
							+ opp.getName() + ".");
				}
				break;

			case 7:
				System.out.println(
						"Enter the desired enemy deck's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String p1input = input.nextLine();
				String[] p1info = p1input.split(":");
				Player p1 = new Player(p1info[0]);
				p1.setDeck(parseDeckFromLine(p1info[1]));

				System.out.println("Please enter your list of required cards.");
				mandatoryCards = input.nextLine();

				System.out.println("What percent winrate is acceptable?");
				int threshold = Integer.parseInt(input.nextLine());

				counterThisDeck(p1, mandatoryCards, threshold);
				break;
			case 999:
				input.close();
				System.exit(0);
				break;
			}
		}
	}

	private static void counterThisDeck(Player p1, String mandatoryCards, int threshold) {
		int wins = 0;

		while (((wins * 100) / 5000) < threshold) {
			wins = 0;
			players.clear();
			generateDecklists(1, mandatoryCards, "");
			Player p = players.remove(0);
			for (int i = 0; i < 2500; i++) {
				if (play(p, p1).equals(p)) {
					wins++;
				}
				if (play(p1, p).equals(p)) {
					wins++;
				}
			}
			if (((wins * 100) / 5000) > 50) {
				System.out.println("" + ((wins * 100) / 5000) + ":" + p.showDecklist());
			}
		}
	}

	public static int grindGames(Player p1, Player p2, int bestOf) {
		int wins = 0;
		int gamesPlayed = 0;
		while (bestOf > 0) {
			if (play(p1, p2).equals(p1)) {
				wins++;
			}
			gamesPlayed++;
			bestOf--;
			if (play(p2, p1).equals(p1)) {
				wins++;
			}
			gamesPlayed++;
			bestOf--;
		}
		return ((100 * wins) / gamesPlayed);
	}

	private static void runBestOf25k() {
		System.out.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p1input = input.nextLine();
		String[] p1info = p1input.split(":");
		Player p1 = new Player(p1info[0]);
		p1.setDeck(parseDeckFromLine(p1info[1]));

		System.out.println("Enter player 2's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p2input = input.nextLine();
		String[] p2info = p2input.split(":");
		Player p2 = new Player(p2info[0]);
		p2.setDeck(parseDeckFromLine(p2info[1]));

		if (p1.getDeck().size() + p2.getDeck().size() != 80) {
			debug("One or more decks isn't correct (@40 cards).");
			debug(p1.name + ": " + p1.getDeck().size());
			debug(p1.name + ": " + p1.showDecklist());
			debug(p2.name + ": " + p2.getDeck().size());
			debug(p2.name + ": " + p2.showDecklist());
			System.exit(0);
		}
		System.out.println(
				p1.getName() + " wins " + grindGames(p1, p2, 25000) + "% of games against " + p2.getName() + ".");
		players.clear();
	}

	private static void runSingleGame() {
		System.out.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p1inf = input.nextLine();
		String[] parse = p1inf.split(":");
		Player p1 = new Player(parse[0]);
		p1.setDeck(parseDeckFromLine(parse[1]));

		System.out.println("Enter player 2's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p2info = input.nextLine();
		String[] parsename2 = p2info.split(":");
		Player p2 = new Player(parsename2[0]);
		p2.setDeck(parseDeckFromLine(parsename2[1]));

		if (p2.getDeck().size() + p1.getDeck().size() != 80) {
			debug("One or more decks isn't correct (@40 cards).");
			debug(p1.name + ": " + p1.getDeck().size());
			debug(p1.name + ": " + p1.showDecklist());
			debug(p2.name + ": " + p2.getDeck().size());
			debug(p2.name + ": " + p2.showDecklist());
			System.exit(0);
		}
		debug = true;
		System.out.println(play(p1, p2).getName() + " wins!");
	}

	private static void runTournament(int cullToThisNumber, String mandatoryCards, String bannedCards) {
		System.out.println("Generating 300k decklists.");
		generateDecklists(300000, mandatoryCards, bannedCards);
		Collections.shuffle(players);
		System.out.println("Running tournament.");
		while (players.size() > cullToThisNumber) {
			Player p1 = players.remove(0);
			Player p2 = players.remove(0);
			debug();
			debug(p1.showDecklist());
			debug(p2.showDecklist());
			int p1winrate = grindGames(p1, p2, 8);
			if (p1winrate >= 50) {
				players.add(p1);
			}
			if (p1winrate <= 50) {
				players.add(p2);
			}
			debug("======" + players.size() + "======");
		}
		System.out.println(analyseTopCut());
	}

	public static ArrayList<Card> parseDeckFromLine(String p1deck) {
		ArrayList<Card> deck = new ArrayList<Card>();
		if (p1deck.length() > 0) {
			String[] cards = p1deck.split(",");
			for (String s : cards) {
				String[] cardQty = s.split("-");
				for (int i = Integer.parseInt(cardQty[1]); i > 0; i--) {
					Card c = findCardByName(cardQty[0]);
					deck.add(c);
				}
			}
			Collections.shuffle(deck);
		}
		return deck;
	}

	private static Card findCardByName(String string) {
		for (String c : cardPool) {
			if (c.equals(string)) {
				return newCardByName(string);
			}
		}
		debug("Can't find a card called: " + string);
		System.exit(0);
		return null;
	}

	private static void debug(String string) {
		if (debug && !string.contains("Still able to add") && !string.contains("Finding card")) {
			System.out.println(string);
		} else {
			if (string.contains("====")) {
				System.out.println(string);
			}
		}
	}

	private static void debug() {
		if (debug) {
			debug("");
		}
	}

	private static String analyseTopCut() {
		System.out.println();
		System.out.println();
		HashMap<String, Integer> topCut = new HashMap<>();
		for (Player p : players) {
			for (Card c : p.getDeck()) {
				topCut.put(c.getName(), topCut.getOrDefault(c.getName(), 0) + 1);
			}
		}
		topCut = sortByValues(topCut);
		String decklist = "";
		Iterator it = topCut.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			decklist += pair.getKey() + "-" + pair.getValue() + ",";
		}
		return decklist;
	}

	private static HashMap sortByValues(HashMap map) {
		LinkedList list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	public static Player play(Player p1, Player p2) {
		int turn = 1;
		p1.lifeTotal = 30;
		p2.lifeTotal = 30;
		p1.toggleGraveAbilities(true);
		p2.toggleGraveAbilities(true);
		p1.playsPerTurn = 2;
		p2.playsPerTurn = 2;

		if (p1.deck.cards.size() != 40 || p2.deck.cards.size() != 40) {
			System.out.println("Definitely a problem.");
			System.out.println("P1 deck: " + p1.deck.cards.size());
			System.out.println("P1 deck: " + p1.showDecklist());
			System.out.println("P2 deck: " + p2.deck.cards.size());
			System.out.println("P2 deck: " + p2.showDecklist());
			System.exit(0);
		}
		p1.shuffle();
		p2.shuffle();
		p1.draw(6);
		p2.draw(6);
		while (p1.isAlive() && p2.isAlive() && turn <= 50) {

			int p1playsPerTurn = p1.playsPerTurn;
			int p2playsPerTurn = p2.playsPerTurn;
			p1.draw();
			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}

			while (p1playsPerTurn > 0 && p1.getHand().size() > 0) {
				p1.makePlay(p2, debug);
				p1playsPerTurn--;
				if (!p1.isAlive() || !p2.isAlive()) {
					break;
				}
			}

			if (!p1.isAlive() || !p2.isAlive()) {
				ArrayList<Card> triggers = new ArrayList<>();
				if (p1.getGraveAbilities()) {
					triggers.addAll(p1.grave);
					Collections.shuffle(triggers);
					for (Card c : triggers) {
						c.graveAbility(p1, p2);
						if (!p2.isAlive() || !p1.isAlive()) {
							break;
						}
					}
					triggers.clear();
					debug(p1.name + "'s grave triggers. (" + p1.getLife() + ")-(" + p2.getLife() + ")");
				}
			}

			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}

			p2.draw();
			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
			while (p2playsPerTurn > 0 && p2.getHand().size() > 0) {
				p2.makePlay(p1, debug);
				p2playsPerTurn--;
				if (!p2.isAlive() || !p1.isAlive()) {
					break;
				}
			}
			if (!p2.isAlive() || !p1.isAlive()) {
				break;
			}

			if (!p1.isAlive() || !p2.isAlive()) {
				ArrayList<Card> triggers = new ArrayList<>();
				if (p2.getGraveAbilities()) {
					triggers.addAll(p2.grave);
					Collections.shuffle(triggers);
					for (Card c : triggers) {
						c.graveAbility(p2, p1);
						if (!p2.isAlive() || !p1.isAlive()) {
							break;
						}
					}
					triggers.clear();
					debug(p2.name + "'s grave triggers. (" + p2.getLife() + ")-(" + p1.getLife() + ")");
				}
			}

			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
			turn++;
		}

		if (p1.isAlive() && p2.isAlive()) {
			if (p1.lifeTotal > p2.lifeTotal) {
				p1.cleanup();
				p2.cleanup();
				return p1;
			}
			p1.cleanup();
			p2.cleanup();
			return p2;
		}

		if (p1.isAlive()) {
			p1.cleanup();
			p2.cleanup();
			return p1;
		}
		p1.cleanup();
		p2.cleanup();
		return p2;
	}

	public static void generateDecklists(int i, String mandatoryCards, String bannedCards) {
		for (int ps = 0; ps < i; ps++) {
			Player p = new Player("P" + (ps + 1));
			ArrayList<Card> mandatory = parseDeckFromLine(mandatoryCards);
			p.getDeck().addAll(mandatory);
			while (p.getDeck().size() < 32) {
				String card = fetchCardFactoringBans(bannedCards);
				debug("Finding card: " + card);
				while (cardCount(p.getDeck(), card) < 4) {
					Card c = findCardByName(card);
					p.getDeck().add(c);
				}
			}

			while (p.getDeck().size() < 40) {
				Collections.shuffle(cardPool);
				String s = cardPool.get(0);
				debug("Finding card: " + s);
				Card c = findCardByName(s);
				if (cardCount(p.getDeck(), c.getName()) < 4) {
					debug("Still able to add: " + s);
					p.getDeck().add(c);
				} else {
					debug("Got enough: " + s);
				}
			}
			players.add(p);
		}
	}

	private static String fetchCardFactoringBans(String bannedCards) {
		Collections.shuffle(cardPool);
		if (bannedCards.contains(cardPool.get(0))) {
			return fetchCardFactoringBans(bannedCards);
		}
		return cardPool.get(0);
	}

	private static int cardCount(ArrayList<Card> deck, String name) {
		int i = 0;
		for (Card cs : deck) {
			if (cs.getName().equals(name)) {
				i++;
			}
		}
		return i;
	}

	public static void instantiateCardpool() {
		cardPool.add("Accumulated Knowledge");
		cardPool.add("Amnesia");
		cardPool.add("Ancestral Recall");
		cardPool.add("Apparition");
		cardPool.add("Body Swap");
		cardPool.add("Burial");
		cardPool.add("Burst Heal");
		cardPool.add("Channel the Depths");
		cardPool.add("Charged Laser");
		cardPool.add("Checkmate");
		cardPool.add("Colossal Junk Chucker");
		cardPool.add("Comeback Zap");
		cardPool.add("Corporate Shredder");
		cardPool.add("Cowardly Robot");
		cardPool.add("Damnation");
		cardPool.add("Dark Contract");
		cardPool.add("Dark Pact");
		cardPool.add("Dark Transfusion");
		cardPool.add("Dark Zap");
		cardPool.add("Divine Zap");
		cardPool.add("Donate");
		cardPool.add("Doomsday Device");
		cardPool.add("Eternal Flame");
		cardPool.add("Eternal Herb");
		cardPool.add("Eventual Zap");
		cardPool.add("Export");
		cardPool.add("Genome");
		cardPool.add("Gesper");
		cardPool.add("Giga Zap");
		cardPool.add("Greater Demon");
		cardPool.add("Grindstone");
		cardPool.add("Griselbrand");
		cardPool.add("Handy Robot");
		cardPool.add("Heal");
		cardPool.add("Ignite");
		cardPool.add("Increasing Heal");
		cardPool.add("Insurance Plan");
		cardPool.add("Junk Chucker");
		cardPool.add("Junk Hunter");
		cardPool.add("Lesser Demon");
		cardPool.add("Life Zap");
		cardPool.add("Mass Grave");
		cardPool.add("Mend");
		cardPool.add("Mighty Wrench");
		cardPool.add("Mill");
		cardPool.add("Miller");
		cardPool.add("Monastery");
		cardPool.add("Mulch Munch");
		cardPool.add("Parry");
		cardPool.add("Peace Treaty");
		cardPool.add("Poison Frog");
		cardPool.add("Pylon");
		cardPool.add("Recycle");
		cardPool.add("Regrow");
		cardPool.add("Remembrance");
		cardPool.add("Repair");
		cardPool.add("Robot Assassin");
		cardPool.add("Rotato Potato");
		cardPool.add("Royal Robot");
		cardPool.add("Sacrifice");
		cardPool.add("Search the Darkness");
		cardPool.add("Sinkhole");
		cardPool.add("Slow Flare");
		cardPool.add("Sparkwave");
		cardPool.add("Sycamore");
		cardPool.add("Tasty Bread");
		cardPool.add("Tempo Drain");
		cardPool.add("Tent");
		cardPool.add("The Rack");
		cardPool.add("Thought Scour");
		cardPool.add("Time Stop");
		cardPool.add("Timetwister");
		cardPool.add("Upper Hand");
		cardPool.add("Vitality Artifact");
		cardPool.add("Waifu");
		cardPool.add("Wheel of Fate");
		cardPool.add("Wicked Robot");
		cardPool.add("Zap Cannon");
		cardPool.add("Zap Machine");
		cardPool.add("Zap Magnifier");
		cardPool.add("Zap and Tap");
		cardPool.add("Zap");
		cardPool.add("Zapstarter");
		cardPool.add("Doubling Zap");
		cardPool.add("Trial");
		cardPool.add("Cloning Gallery");
		cardPool.add("Bargaining");
		cardPool.add("Arcane Zap");
		cardPool.add("Exorcise");
		cardPool.add("Titan");
		cardPool.add("Thief");
		cardPool.add("Huge Plant");
		cardPool.add("Gardening");
		cardPool.add("Monk");
		cardPool.add("Shuttle Zap");
		cardPool.add("Hero");
		cardPool.add("Paladin");
		cardPool.add("Dark Knight");
		cardPool.add("Ice Wizard");
		cardPool.add("Fire Wizard");
		cardPool.add("Bishop");
		cardPool.add("Assassin");
		cardPool.add("Bandit");
		cardPool.add("Archer");
		cardPool.add("Crossbowman");
		cardPool.add("Pirate");
		cardPool.add("Guild Master");
		cardPool.add("Eternal Ice");

	}

	public static Card newCardByName(String string) {
		debug("Been asked to add a " + string + ".");
		if (!string.contains("Copied ")) {
			switch (string) {
			case "Fire Wizard":
				return new FireWizard();
			case "Eternal Ice":
				return new EternalIce();
			case "Guild Master":
				return new GuildMaster();
			case "Ice Wizard":
				return new IceWizard();
			case "Bishop":
				return new Bishop();
			case "Assassin":
				return new Assassin();
			case "Bandit":
				return new Bandit();
			case "Crossbowman":
				return new Crossbowman();
			case "Archer":
				return new Archer();
			case "Pirate":
				return new Pirate();
			case "Paladin":
				return new Paladin();
			case "Hero":
				return new Hero();
			case "Dark Knight":
				return new DarkKnight();
			case "Shuttle Zap":
				return new ShuttleZap();
			case "Exorcise":
				return new Exorcise();
			case "Gardening":
				return new Gardening();
			case "Plant Tendrils":
				return new PlantTendrils();
			case "Huge Plant":
				return new HugePlant();
			case "Titan":
				return new Titan();
			case "Arcane Zap":
				return new ArcaneZap();
			case "Bargaining":
				return new Bargaining();
			case "Upper Hand":
				return new UpperHand();
			case "Cloning Gallery":
				return new CloningGallery();
			case "Trial":
				return new Trial();
			case "Doubling Zap":
				return new DoublingZap();
			case "Griselbrand":
				return new Griselbrand();
			case "Divine Zap":
				return new DivineZap();
			case "Monastery":
				return new Monastery();
			case "Sacrifice":
				return new Sacrifice();
			case "Miller":
				return new Miller();
			case "Wheel of Fate":
				return new WheelOfFate();
			case "Genome":
				return new Genome();
			case "Insurance Plan":
				return new InsurancePlan();
			case "Rotato Potato":
				return new RotatoPotato();
			case "Dark Contract":
				return new DarkContract();
			case "Lesser Demon":
				return new LesserDemon();
			case "Increasing Heal":
				return new IncreasingHeal();
			case "Tent":
				return new Tent();
			case "Zap Machine":
				return new ZapMachine();
			case "Eternal Flame":
				return new EternalFlame();
			case "Repair":
				return new Repair();
			case "Thief":
				return new Thief();
			case "Monk":
				return new Monk();
			case "Checkmate":
				return new Checkmate();
			case "Mighty Wrench":
				return new MightyWrench();
			case "Recycle":
				return new Recycle();
			case "Export":
				return new Export();
			case "Tasty Bread":
				return new TastyBread();
			case "Greater Demon":
				return new GreaterDemon();
			case "Remembrance":
				return new Remembrance();
			case "Vitality Artifact":
				return new VitalityArtifact();
			case "Time Stop":
				return new TimeStop();
			case "Slow Flare":
				return new SlowFlare();
			case "Royal Robot":
				return new RoyalRobot();
			case "Burst Heal":
				return new BurstHeal();
			case "Eventual Zap":
				return new EventualZap();
			case "Mass Grave":
				return new MassGrave();
			case "Zap Cannon":
				return new ZapCannon();
			case "Accumulated Knowledge":
				return new AccumulatedKnowledge();
			case "Doomsday Device":
				return new DoomsdayDevice();
			case "Pylon":
				return new Pylon();
			case "Amnesia":
				return new Amnesia();
			case "Ancestral Recall":
				return new AncestralRecall();
			case "Apparition":
				return new Apparition();
			case "Body Swap":
				return new BodySwap();
			case "Burial":
				return new Burial();
			case "Charged Laser":
				return new ChargedLaser();
			case "Colossal Junk Chucker":
				return new ColossalJunkChucker();
			case "Comeback Zap":
				return new ComebackZap();
			case "Corporate Shredder":
				return new CorporateShredder();
			case "Cowardly Robot":
				return new CowardlyRobot();
			case "Damnation":
				return new Damnation();
			case "Dark Pact":
				return new DarkPact();
			case "Dark Transfusion":
				return new DarkTransfusion();
			case "Dark Zap":
				return new DarkZap();
			case "Donate":
				return new Donate();
			case "Eternal Herb":
				return new EternalHerb();
			case "Gesper":
				return new Gesper();
			case "Giga Zap":
				return new GigaZap();
			case "Grindstone":
				return new Grindstone();
			case "Handy Robot":
				return new HandyRobot();
			case "Heal":
				return new Heal();
			case "Ignite":
				return new Ignite();
			case "Junk Chucker":
				return new JunkChucker();
			case "Junk Hunter":
				return new JunkHunter();
			case "Life Zap":
				return new Lifezap();
			case "Mend":
				return new Mend();
			case "Mill":
				return new Mill();
			case "Mulch Munch":
				return new MulchMunch();
			case "Parry":
				return new Parry();
			case "Peace Treaty":
				return new PeaceTreaty();
			case "Poison Frog":
				return new PoisonFrog();
			case "Regrow":
				return new Regrow();
			case "Robot Assassin":
				return new RobotAssassin();
			case "Search the Darkness":
				return new SearchTheDarkness();
			case "Sinkhole":
				return new Sinkhole();
			case "Channel the Depths":
				return new ChannelTheDepths();
			case "Sparkwave":
				return new Sparkwave();
			case "Sycamore":
				return new Sycamore();
			case "Tempo Drain":
				return new TempoDrain();
			case "The Rack":
				return new TheRack();
			case "Thought Scour":
				return new ThoughtScour();
			case "Timetwister":
				return new Timetwister();
			case "Waifu":
				return new Waifu();
			case "Wicked Robot":
				return new WickedRobot();
			case "Zap":
				return new Zap();
			case "Zap and Tap":
				return new ZapAndTap();
			case "Zapstarter":
				return new Zapstarter();
			case "Zap Magnifier":
				return new ZapMagnifier();
			case "Corrupted Blood":
				return new CorruptedBlood();
			case "Pigeon":
				return new Pigeon();
			case "Holy Grail":
				return new HolyGrail();
			case "Cable":
				return new Cable();
			case "Ice":
				return new Ice();
			default:
				return new ErrorMessage(string);
			}
		}
		return new ErrorMessage(string);
	}
}
