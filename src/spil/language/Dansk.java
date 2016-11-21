package spil.language;

import spil.DiceCup;
import spil.Player;

public class Dansk implements Language{

	public Dansk(){}

	/** 
	 * Welcome message for user with commands available.
	 * @return
	 */
	@Override
	public String welcomeMsg(){
		return "Velkommen til spillet!";
	}

	/** 
	 * Ask for the number of players that will participate 
	 */

	public String askForPlayers()
	return "Hvor mange spillere skal være med? Der kan vælges fra 2 til 6";


	/** 
	 * Asks for player name.
	 * @return
	 */
	@Override
	public String askForPlayerName(int playerNumber){
		return "Indtast spiller " + playerNumber + "'s navn";
	}

	/** 
	 * Tells user that the game will start shortly. 
	 * @return
	 */
	@Override
	public String readyToBegin(){
		return "\nSpillet vil nu begynde. Spillet er vundet af den spiller, der står tilbage når de andre er bankerot!\nDu kan skrive help når det bliver din tur, for en åbne en hjælpemenu "; // Skal bruger trykke på noget for at starte?
	}

	/**
	 * Premessage at the start of players turn, tells player help option. 
	 * @return
	 */
	public String preMsg(Player player){
		return "\nDet er " + player.getName() + "'s tur, tryk på 'enter' for at slå!"; // getbank.getbalance
	}

	/**
	 * Displays the result of the dice roll. 
	 * @return
	 */
	@Override
	public String rollResult(DiceCup diceCup){
		return "Du slog en " + diceCup.getDices()[0].getFaceValue() + "'er og en " + diceCup.getDices()[1].getFaceValue() + "'er";
	}

	/**
	 * Switch case that displays the field message that was landed on.
	 * @return
	 */
	@Override
	public String fieldMsg(Field fields){
		String fieldString;
		switch (Field.getID()) {
		case 1:  fieldString = "Du bliver inviteret til fest hos stamme lejren!";
		break;
		case 2:  fieldString = "Du finder et stort krater og undersøger nærmere!";
		break;
		case 3:  fieldString = "Du er ankommet til et højt bjerg!";
		break;
		case 4:  fieldString = "Du er nået til den kolde ørken!";
		break;
		case 5:  fieldString = "Du er kommet til en mørk krotte! ";
		break;
		case 6:  fieldString = "Du er ankommet til en stor mur!";
		break;
		case 7:  fieldString = "Du er ankommet til den famøse bjergby! ";
		break;
		case 8:  fieldString = "Du er nået til det syde kastel!";
		break;
		case 9:  fieldString = "Du passerer den store slotsport";
		break;
		case 10: fieldString = "Du kæmper dig op i det høje tårn!";
		break;
		case 11: fieldString = "Du er inviteret ind i det store slot!";
		break;	
		case 12: fieldString = "Du går forsigtigt igennem den befæstede by";
		break;	
		case 13: fieldString = "Du ser klosteret i distancen og undersøger det nærmere";
		break;	
		case 14: fieldString = "Du efterforsker bjerget nærmere og finder bjerghytter!";
		break;	
		case 15: fieldString = "Du faldet ned i et stort hul! ";
		break;	
		case 16: fieldString = "Du udforsker en krotte der ligner en guldmine";
		break;	
		case 17: fieldString = "Du har fundet en forladt campingvogn!";
		break;	
		case 18: fieldString = "Second Sail"; // WTF oversættelse?
		break;	
		case 19: fieldString = "Sea Grover";
		break;	
		case 20: fieldString = "The Buccaneers";
		break;	
		case 21: fieldString = "Privateer Armade";
		break;	
		default: fieldString = "Ukendt felt DESVÆRRE!";
		break;
		}
		return fieldString;
	}

	
	/**
	 * If field is already owned it will show this message. 
	 */
	public String fieldAlreadyOwned(Field fields){
		return "Du ejer allerede dette felt!";
	}
	
	/**
	 * For fields that can be bought and is not owned, this message will show. 
	 */
	public String fieldNotOwned(Field fields){
			return "Dette felt er ikke ejet endnu, du kan købe det for" + fields[ID].getprice() + " mønter";
	}
	
	/**
	 * If territory field is owned by another player and landed on it will show this message. 
	 */
	
	public String territoryFieldOwned(Field fields){
		return "Dette felt er ejet af " + fields.getowner() +  " du skal betale " + fields.getrent[ID]() + " mønter til ejeren";
	}

	
	/**
	 * If player landed on refuge field it will show this message. 
	 */
	
	public String refugeField(Field fields){
		return "Du modtager" + fields[ID].getprice + " mønter";
	}
	
	/**
	 * If player landed on labor camp field that is already owned, this message will show. 
	 */
	
	public String laborcampFieldOwned(Field fields){
		return "Dette felt er ejet af " + fields.getowner() + " Du skal betale " + 100*dicecup.getsum() + " mønter";
	}
	
	/** 
	 * Message for the unique tax field Goldmine
	 */
	public String taxFieldGoldmine(Field fields){
		return "Du skal betale 2000 i skat";
	}
	/** 
	 * Message for the unique tax field Caravan
	 */
	public String taxFieldCaravan(Field fields){
		return "Du kan vælge enten at betale 4000 mønter eller 10% af din pengebeholdning";
	}
	/** 
	 * Message for fleet field
	 */
	public String fleetFieldOwned(Field fields){
		return "Du skal betale for antallet af samme type felter ejeren ejer."; // Skal finde metode der kan se antal af fleets ejet af ejer. 
	}
	
	public String fleetFieldOwned(Field fields){
		return "Du har nu købt feltet!";
	}
	
	/**
	 * Prints how many points the player have after the throw.
	 * @return
	 */
	@Override
	public String postMsg(Player player){
		return "Efter denne runde har " + player.getName() + " nu " + player.getBank().getBalance() + " mønter";
	}

	/**
	 * Prints who won with how many points.
	 * @return
	 */
	@Override
	public String winnerMsg(Player player){
		return player.getName() + " har vundet spillet med " + player.getBank().getBalance() + "mønter!";
	}
	/**
	 * Prints the available commands in the menu.
	 * @return
	 */
	@Override
	public String menu(){
		return "Tast 1 for at skifte antal sider på terningerne.\n" +
				"Tast 2 for at ændre sprog.\n" +
				"Tast 3 for at vise scoren.\n"+
				"Tast 4 for at afslutte spillet.\n" +
				"Tast 5 for at fortsætte spillet.";
	}

	/**
	 * Prints the rules of the game.
	 * @return
	 */
	@Override
	public String printRules(){
		return "Dette spil er et terningespil mellem 2 personer. Du slår med terninger og lander på et felt fra 2-12. \nDisse felter har enten en negativ eller positiv effekt på din beholdning. Her er vist listen over felterne: \n"
				+ "2. Tower: +250 \n"
				+ "3. Crater: -100 \n"
				+ "4. Palace gates: +100 \n"
				+ "5. Cold Desert: -20 \n"
				+ "6. Walled city: +180 \n"
				+ "7. Monastery: 0 \n"
				+ "8. Black cave: -70 \n"
				+ "9. Huts in the mountain: +60 \n"
				+ "10. The Werewall (werewolf-wall): -80, men spilleren får en ekstra tur \n"
				+ "11. The pit: -50 \n"
				+ "12. Goldmine: +650";
	}

	/**
	 * Prints the score. 
	 * @return
	 */
	@Override
	public String printScore(Player[] players){
		StringBuilder str = new StringBuilder();
		str.append("Stillingen er:");
		for (int i = 0; i < players.length; i++) 
			str.append("\n" + players[i].getName() + " har " + players[i].getBank().getBalance());
		return str.toString();
	}

	/** 
	 * Prints how to change the dices.
	 * @return
	 */
	@Override
	public String changeDices(){
		return "Indtast hvor mange øjne de to terninger skal have, på formatet \"x,y\" - summen skal være 12"; // Summen måtte kun gå op til 12?
	}

	/**
	 * Prints that the dices were changed successfully.
	 * @return
	 */
	@Override
	public String printDiceChangeSucces(){
		return "Terningerne er nu ændret!";
	}

	/**
	 * Prints a error message if the dices couldn't be changed.
	 * @return
	 */
	@Override
	public String printDiceChangeNotExecuted(){
		return "Terningerne kunne ikke ændres";
	}

	/**
	 * Notifies of language change
	 * @return String
	 */
	@Override
	public String notifyLangChange(){
		return "Sproget er nu sat til dansk!";
	}
}
