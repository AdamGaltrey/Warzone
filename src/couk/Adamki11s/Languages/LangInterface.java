package couk.Adamki11s.Languages;

public class LangInterface{
	
	public Langs lang = Langs.ENGLISH;
	
	private LangInterface_EN langGB = new LangInterface_EN();
	private LangInterface_FR langFR = new LangInterface_FR();
	private LangInterface_DE langDE = new LangInterface_DE();
	private LangInterface_DA langDA = new LangInterface_DA();
	private LangInterface_PL langPL = new LangInterface_PL();
	private LangInterface_NL langNL = new LangInterface_NL();
	
	public Langs getLang(){
		return lang;
	}
	
	public LangInterface(Langs l){
		lang = l;
	}
	
	public String getObj(String msg){
		switch(lang){
			case DANISH: return langDA.getString(msg);
			case DUTCH: return langNL.getString(msg);
			case ENGLISH: return langGB.getString(msg);
			case FRENCH: return langFR.getString(msg);
			case GERMAN: return langDE.getString(msg);
			case POLISH: return langPL.getString(msg);
			default: return langGB.getString(msg);
		}
	}
	
	public enum Langs{
		DANISH,
		DUTCH,
		ENGLISH,
		FRENCH,
		GERMAN,
		POLISH;
		
		@Override
		public String toString(){
			return super.toString();
		}
	}



}
