package couk.Adamki11s.NPC;

import couk.Adamki11s.Extras.Random.ExtrasRandom;

public class NPC_Messages {
	
	ExtrasRandom exr = new ExtrasRandom();
	
	public AINPC getAINPCFromName(String name){
		if(name.equalsIgnoreCase("Adamki11s")){
			return AINPC.Adamki11s;
		} 
		else if(name.equalsIgnoreCase("Afforess")){
				return AINPC.Afforess;
			}
		 else if(name.equalsIgnoreCase("alta189")){
				return AINPC.alta189;
			}
		 else if(name.equalsIgnoreCase("Coestar")){
				return AINPC.Coestar;
			}
		 else if(name.equalsIgnoreCase("cronikkk")){
				return AINPC.cronikkk;
			}
		 else if(name.equalsIgnoreCase("Dinnerbone")){
				return AINPC.Dinnerbone;
			}
		 else if(name.equalsIgnoreCase("EvilSeph")){
				return AINPC.EvilSeph;
			}
		 else if(name.equalsIgnoreCase("Honeydew")){
				return AINPC.Honeydew;
			}
		 else if(name.equalsIgnoreCase("iPhysX")){
				return AINPC.iPhysX;
			}
		 else if(name.equalsIgnoreCase("Israphel")){
				return AINPC.Israphel;
			}
		 else if(name.equalsIgnoreCase("jamescosten")){
				return AINPC.jamescosten;
			}
		 else if(name.equalsIgnoreCase("Notch")){
				return AINPC.Notch;
			}
		 else if(name.equalsIgnoreCase("Xephos")){
				return AINPC.Xephos;
			}
		 else {
				return AINPC.Adamki11s;
			}		
	}
	
	public String getRandomMessage(AINPC ainpc){
		String msg = "";
		switch(ainpc){
		case Adamki11s: msg = getAdamki11sMessage(); break;
		case Afforess: msg = getAfforessMessage(); break;
		case alta189: msg = getAlta189Message(); break;
		case Coestar: msg = getCoestarMessage(); break;
		case cronikkk: msg = getCronikkkMessage(); break;
		case Dinnerbone: msg = getDinnerboneMessage(); break;
		case EvilSeph: msg = getEvilSephMessage(); break;
		case Honeydew: msg = getHoneydewMessage(); break;
		case iPhysX: msg = getiPhysXMessage(); break;
		case Israphel: msg = getIsraphelMessage(); break;
		case jamescosten: msg = getJCMessage(); break;
		case Notch: msg = getNotchMessage(); break;
		case Xephos: msg = getXephos(); break;
		}
		return msg;
		
	}

	private String getAdamki11sMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Proud developer of the Warzone plugin!"; break;
		case 1: msg = "I am part of the Minedev team XD"; break;
		case 2: msg = "Fun in Minecraft, powered by Warzone :D"; break;
		}
		return msg;
	}
	
	private String getAfforessMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "I'm older than I look..."; break;
		case 1: msg = "Are you using Bukkit Contrib?"; break;
		case 2: msg = "Go talk with someone else"; break;
		
		}
		return msg;
	}
	
	private String getAlta189Message() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Minemail anyone?"; break;
		case 1: msg = "Co-Owner of Minedev :)"; break;
		case 2: msg = "I can build good with redstone :D"; break;
		
		}
		return msg;
	}
	
	private String getCoestarMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Let's Play!"; break;
		case 1: msg = "http://www.youtube.com/user/Coestar :)"; break;
		case 2: msg = "What'cha lookin at?"; break;
		
		}
		return msg;
	}
	
	private String getCronikkkMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Hai I'm Crawnik!"; break;
		case 1: msg = "RAWR!"; break;
		case 2: msg = "I love Mountys :D"; break;
		
		}
		return msg;
	}
	
	private String getDinnerboneMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Bukkit Administrator!"; break;
		case 1: msg = "Hey friend :)"; break;
		case 2: msg = "Don't worry, your game'll start soon"; break;
		
		}
		return msg;
	}
	
	private String getEvilSephMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Lead Administrator of Bukkit!"; break;
		case 1: msg = "Speak only when spoken to"; break;
		case 2: msg = "Huh?"; break;
		
		}
		return msg;
	}
	
	private String getHoneydewMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Watch out for Israphel!"; break;
		case 1: msg = "Yogscast :)"; break;
		case 2: msg = "Make sure to take frequent breaks :P"; break;
		
		}
		return msg;
	}
	
	private String getiPhysXMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "We are Minedev!"; break;
		case 1: msg = "Derp"; break;
		case 2: msg = "Good luck beating me at Warzone :D"; break;
		
		}
		return msg;
	}
	
	private String getIsraphelMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "GRRRRR!"; break;
		case 1: msg = "Don't touch me!"; break;
		case 2: msg = "Seriously...Get off me."; break;
		
		}
		return msg;
	}

	private String getNotchMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "MOJANG :)"; break;
		case 1: msg = "Minecraft BETA"; break;
		case 2: msg = "I am NOTCH!"; break;
		
		}
		return msg;
	}
	
	private String getJCMessage() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Hey guys and welcome to another review :)"; break;
		case 1: msg = "Happy farmer :D"; break;
		case 2: msg = "Subscribe!"; break;
		
		}
		return msg;
	}
	
	private String getXephos() {
		int randomMessage = exr.getRandomInt(3, 0);
		String msg = "";
		
		switch(randomMessage){
		case 0: msg = "Yogoscast with Honeydew!"; break;
		case 1: msg = "I'm on youtube!"; break;
		case 2: msg = "Lets play...Warzone!"; break;
		
		}
		return msg;
	}

}
