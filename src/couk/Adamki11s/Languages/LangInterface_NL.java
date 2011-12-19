package couk.Adamki11s.Languages;

public class LangInterface_NL {

	public String getString(String s){
		return parseString(s);
	}

	private String parseString(String s){
		if(s.equalsIgnoreCase("Hello")){
			return "Hallo";
		}
		if(s.equalsIgnoreCase("[Warzone] By Adamki11s of the MineDev team.")){
			return "[Warzone] Door Adamki11s van het MineDev team.";
		}
		if(s.equalsIgnoreCase("version")){
			return "versie";
		}
		if(s.equalsIgnoreCase("enabled successfully")){
			return "Succesvol geactiveerd";
		}
		if(s.equalsIgnoreCase("Warzone disabled successfully")){
			return "Warzone succesvol gedeactiveerd";
		}
		if(s.equalsIgnoreCase("Statistics reset for player : ")){
			return "Statistieken reset voor speler: ";
		}
		if(s.equalsIgnoreCase("This player does not exist in the warzone database!")){
			return "Deze speler bestaat niet in de Warzone database!";
		}
		if(s.equalsIgnoreCase("You must provide the block id!")){
			return "U moet een block id verstrekken!";
		}
		if(s.equalsIgnoreCase("You do not have permission to disable Warzone!")){
			return "U heeft geen permissie om Warzone te deactiveren!";
		}
		if(s.equalsIgnoreCase("Search cancelled successfully.")){
			return "Zoekopdracht is succesvol beëindigd.";
		}
		if(s.equalsIgnoreCase("You are not searching for a game!")){
			return "U zoekt niet naar een spel!";
		}
		if(s.equalsIgnoreCase("Returned to previous location.")){
			return "Terug naar vorige locatie.";
		}
		if(s.equalsIgnoreCase("No return location exists!")){
			return "Vorige locatie bestaat niet!";
		}
		if(s.equalsIgnoreCase("has no statistics to display.")){
			return "heeft geen statistieken om weer te geven.";
		}
		if(s.equalsIgnoreCase("You have no statistics to display!")){
			return "U heeft geen statistieken om weer te geven!";
		}
		if(s.equalsIgnoreCase("You do not have permissions to do this!")){
			return "U heeft geen permissie om dat te doen!";
		}
		if(s.equalsIgnoreCase("Invalid Sword Type")){
			return "Ongeldig Zwaard Type";
		}
		if(s.equalsIgnoreCase("You must be level")){
			return "U heeft level";
		}
		if(s.equalsIgnoreCase("or above to do this")){
			return "of hoger nodig om dat te doen.";
		}
		if(s.equalsIgnoreCase("Sword preference changed to")){
			return "Zwaard voorkeur gewijzigd naar";
		}
		if(s.equalsIgnoreCase("Invalid Material Type!")){
			return "Ongeldig Materiaal Type!";
		}
		if(s.equalsIgnoreCase("Armour type changed to")){
			return "Pantser type gewijzigd naar";
		}
		if(s.equalsIgnoreCase("sucessfully!")){
			return "succesvol!";
		}
		if(s.equalsIgnoreCase("to wield this armour!")){
			return "nodig om dit pantser te gebruiken!";
		}
		if(s.equalsIgnoreCase("Error : Armour type can only be")){
			return "Error : Pantser type kan alleen zijn:";
		}
		if(s.equalsIgnoreCase("Chill in the lobby while we find a match for you.")){
			return "Wacht in de lobby tot een spel voor u is gevonden.";
		}
		if(s.equalsIgnoreCase("Searching for players...")){
			return "Zoeken naar spelers...";
		}
		if(s.equalsIgnoreCase("You are already searching!")){
			return "U bent al aan het zoeken!";
		}
		if(s.equalsIgnoreCase("Do &e/warzone stop search &redto cancel")){
			return "Typ &e/warzone stop search &redom te stoppen";
		}
		if(s.equalsIgnoreCase("No players found, request timed out.")){
			return "Geen spelers gevonden, verzoek is beëindigd.";
		}
		if(s.equalsIgnoreCase("Timeout in")){
			return "Beëindiging over";
		}
		if(s.equalsIgnoreCase("match found with")){
			return "spel gevonden met";
		}
		if(s.equalsIgnoreCase("Selecting random map...")){
			return "Willekeurige map world geselecteerd...";
		}
		if(s.equalsIgnoreCase("All maps are occupied! Please wait.")){
			return "Alle maps zijn bezet! Even geduld.";
		}
		if(s.equalsIgnoreCase("Map Chosen")){
			return "Map Gekozen";
		}
		if(s.equalsIgnoreCase("Loading map...")){
			return "Map wordt geladen...";
		}
		if(s.equalsIgnoreCase("Map Loaded")){
			return "Map geladen";
		}
		if(s.equalsIgnoreCase("Let battle commence!")){
			return "Laat de strijd beginnen!";
		}
		if(s.equalsIgnoreCase("The warzone world is not editable!")){
			return "De Warzone wereld is niet aanpasbaar!";
		}
		if(s.equalsIgnoreCase("You quit unexpectedly!")){
			return "U bent onverwacht gestopt!";
		}
		if(s.equalsIgnoreCase("Inventory was restored successfully.")){
			return "Inventaris is succesvol hersteld.";
		}
		if(s.equalsIgnoreCase("You quit during a game! Returned to initial location.")){
			return "U stopte tijdens het spel! Terug naar vorige locatie.";
		}
		if(s.equalsIgnoreCase("Time Left")){//Shows on sign. make sure message is not too long
			return "Tijd over";
		}
		if(s.equalsIgnoreCase("You struckdown")){
			return "U heeft neergeslagen:";
		}
		if(s.equalsIgnoreCase("You got struckdown by")){
			return "U bent neergeslagen door";
		}
		if(s.equalsIgnoreCase("You shot")){
			return "U heeft neergeschoten:";
		}
		if(s.equalsIgnoreCase("You got shot by")){
			return "U bent neergeschoten door";
		}
		if(s.equalsIgnoreCase("Quit the game!")){
			return "Verlaat het spel!";
		}
		if(s.equalsIgnoreCase("remaining.")){
			return "over.";
		}
		if(s.equalsIgnoreCase("The match was a draw!")){
			return "Het is gelijkspel!";
		}
		if(s.equalsIgnoreCase("You gained")){
			return "U heeft ontvangen";
		}
		if(s.equalsIgnoreCase("Game over!")){
			return "Spel over!";
		}
		if(s.equalsIgnoreCase("was victorious!")){
			return "heeft gewonnen!";
		}
		if(s.equalsIgnoreCase("won with")){
			return "heeft gewonnen met";
		}
		if(s.equalsIgnoreCase("kills.")){
			return "kills.";
		}
		return "";
	}
	
}
