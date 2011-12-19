package couk.Adamki11s.Languages;

public class LangInterface_PL {

	public String getString(String s){
		return parseString(s);
		}

		private String parseString(String s){
		if(s.equalsIgnoreCase("Hello")){
		return "Witam";
		}
		if(s.equalsIgnoreCase("[Warzone] By Adamki11s of the MineDev team.")){
		return "[Warzone] napisany przez Adamki11s z zespolu MineDev .";
		}
		if(s.equalsIgnoreCase("version")){
		return "Wersja";
		}
		if(s.equalsIgnoreCase("enabled successfully")){
		return "Wlaczony pomyslnie";
		}
		if(s.equalsIgnoreCase("Warzone disabled successfully")){
		return "Warzone wylaczony";
		}
		if(s.equalsIgnoreCase("Statistics reset for player : ")){
		return "Statystyki zostaly wyczyszczone dla gracza : ";
		}
		if(s.equalsIgnoreCase("This player does not exist in the warzone database!")){
		return "Ten gracz nie wystepuje bazie warzone!";
		}
		if(s.equalsIgnoreCase("You must provide the block id!")){
		return "Musisz podac identyfikator bloku (id)!";
		}
		if(s.equalsIgnoreCase("You do not have permission to disable Warzone!")){
		return "Nie masz uprawnien do wylaczenia warzone!";
		}
		if(s.equalsIgnoreCase("Search cancelled successfully.")){
		return "Anulowano wyszukiwanie przeciwnika.";
		}
		if(s.equalsIgnoreCase("You are not searching for a game!")){
		return "Nie szukasz przeciwnika!";
		}
		if(s.equalsIgnoreCase("Returned to previous location.")){
		return "Powrot do poprzedniej lokacji.";
		}
		if(s.equalsIgnoreCase("No return location exists!")){
		return "Lokacja powrotna nie istnieje!";
		}
		if(s.equalsIgnoreCase("has no statistics to display.")){
		return "nie posiada statystyk.";
		}
		if(s.equalsIgnoreCase("You have no statistics to display!")){
		return "Nie posiadasz statystyk!";
		}
		if(s.equalsIgnoreCase("You do not have permissions to do this!")){
		return "Nie posiadasz uprawnien do tego!";
		}
		if(s.equalsIgnoreCase("Invalid Sword Type")){
		return "Niewlasciwy typ miecza";
		}
		if(s.equalsIgnoreCase("You must be level")){
		return "Musisz miec poziom";
		}
		if(s.equalsIgnoreCase("or above to do this")){
		return "lub wyzszy by zrobic to";
		}
		if(s.equalsIgnoreCase("Sword preference changed to")){
		return "Miecz zmieniony na";
		}
		if(s.equalsIgnoreCase("Invalid Material Type!")){
		return "Niewlasciwy typ materialu!";
		}
		if(s.equalsIgnoreCase("Armour type changed to")){
		return "Typ uzbrojenia zmieniony na";
		}
		if(s.equalsIgnoreCase("sucessfully!")){
		return "Pomyslnie!";
		}
		if(s.equalsIgnoreCase("to wield this armour!")){
		return "by nosic to uzbrojenie!";
		}
		if(s.equalsIgnoreCase("Error : Armour type can only be")){
		return "Blad : Uzbrojenie moze byc tylko";
		}
		if(s.equalsIgnoreCase("Chill in the lobby while we find a match for you.")){
		return "Poczekaj w lobby do czasu az zostanie Ci przydzielony przeciwnik.";
		}
		if(s.equalsIgnoreCase("Searching for players...")){
		return "Wyszukiwanie przeciwnika...";
		}
		if(s.equalsIgnoreCase("You are already searching!")){
		return "Juz szukasz przeciwnika!";
		}
		if(s.equalsIgnoreCase("Do &e/warzone stop search &redto cancel")){
		return "Wpisz &e/warzone stop search &redaby przerwac szukanie";
		}
		if(s.equalsIgnoreCase("No players found, request timed out.")){
		return "Nie znaleziono przeciwnika, czas oczekiwania uplynal.";
		}
		if(s.equalsIgnoreCase("Timeout in")){
		return "Czas oczekiwania";
		}
		if(s.equalsIgnoreCase("match found with")){
		return "rozgrywka z";
		}
		if(s.equalsIgnoreCase("Selecting random map...")){
		return "Wybieram losowo mape...";
		}
		if(s.equalsIgnoreCase("All maps are occupied! Please wait.")){
		return "Wszystkie mapy zajete! Prosze czekac.";
		}
		if(s.equalsIgnoreCase("Map Chosen")){
		return "Mapa wybrana";
		}
		if(s.equalsIgnoreCase("Loading map...")){
		return "Ladowanie mapy...";
		}
		if(s.equalsIgnoreCase("Map Loaded")){
		return "Mapa zaladowana";
		}
		if(s.equalsIgnoreCase("Let battle commence!")){
		return "Niech rozpocznie sie bitwa!";
		}
		if(s.equalsIgnoreCase("The warzone world is not editable!")){
		return "Swiat warzone nie jest edytowalny!";
		}
		if(s.equalsIgnoreCase("You quit unexpectedly!")){
		return "Wyszedles niespodziewanie!";
		}
		if(s.equalsIgnoreCase("Inventory was restored successfully.")){
		return "Wyposarzenie przywrocone pomyslnie.";
		}
		if(s.equalsIgnoreCase("You quit during a game! Returned to initial location.")){
		return "Wyszedles podczas walki! Powrot do startowej lokalizacji.";
		}
		if(s.equalsIgnoreCase("Time Left")){//Shows on sign. make sure message is not too long
		return "Pozostalo";
		}
		if(s.equalsIgnoreCase("You struckdown")){
		return "Zabiles";
		}
		if(s.equalsIgnoreCase("You got struckdown by")){
		return "Zostales zabity przez";
		}
		if(s.equalsIgnoreCase("You shot")){
		return "Ustrzeliles";
		}
		if(s.equalsIgnoreCase("You got shot by")){
		return "Zostales ustrzelony";
		}
		if(s.equalsIgnoreCase("Quit the game!")){
		return "Wyjscie z gry!";
		}
		if(s.equalsIgnoreCase("remaining.")){
		return "pozostalo.";
		}
		if(s.equalsIgnoreCase("The match was a draw")){
		return "Mecz zakonczyl sie remisem!";
		}
		if(s.equalsIgnoreCase("You gained")){
		return "Uzyskales";
		}
		if(s.equalsIgnoreCase("Game over!")){
		return "Koniec gry!";
		}
		if(s.equalsIgnoreCase("was victorious!")){
		return "jest zwyciezca!";
		}
		if(s.equalsIgnoreCase("won with")){
		return "wygral z";
		}
		if(s.equalsIgnoreCase("kills.")){
		return "fragow.";
		}
		return "";
		}
	
}
