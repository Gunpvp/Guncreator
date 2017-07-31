package guncreator.utils;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;

public class EnumChecker {

	public static boolean isValidMaterial(String material) {
		
		try {
			
			Material.valueOf(material);
			
			return true;
			
		} catch (IllegalArgumentException e) {
			
			return false;
			
		}
		
	}
	
	public static boolean isValidSound(String sound) {
		
		try {
			
			Sound.valueOf(sound);
			
			return true;
			
		} catch (IllegalArgumentException e) {
			
			return false;
			
		}
		
	}
	
	public static boolean isValidEffect(String effect) {
		try {
			Effect.valueOf(effect);
			
			return true;
			
		} catch (IllegalArgumentException e) {
			
			return false;
			
		}
	}
}
