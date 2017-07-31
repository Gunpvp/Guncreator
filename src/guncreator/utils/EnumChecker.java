package guncreator.utils;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffectType;

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
		
		return PotionEffectType.getByName(effect) != null;
		
	}
}
