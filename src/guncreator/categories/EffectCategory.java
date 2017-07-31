package guncreator.categories;

import guncreator.utils.EnumChecker;
import guns.weopons.data.EffectData;

public class EffectCategory extends Category<EffectData> {

	private JBox effecting;
	private JInputField effect_name;
	private JAdjustbar delay;
	private JAdjustbar amplitude;
	
	public EffectCategory() {
		super("EFFECT");
	}

	@Override
	public EditPanel<EffectData> createEditPanel() {
		EditPanel<EffectData> panel = new EditPanel<EffectData>() {
			
			@Override
			public void initWithData(EffectData data) {
				effecting.setValue(data.isEffecting());
				effect_name.setValue(data.getEffect_name());
				delay.setValue(data.getDelay());
				amplitude.setValue(data.getAmplitude());
			}
			
			@Override
			protected EffectData generateData() {
				return new EffectData(effecting.getValue(), effect_name.getValue(), ((int)delay.getValue()), ((int)amplitude.getValue()));
			}
		};
		
		effecting = new JBox("Waffe erzeugt Effekt");
		panel.addComponent(effecting);
		
		effect_name = new JInputField("Name des Effektes:");
		panel.addComponent(effect_name);
		
		delay = new JAdjustbar("Dauer", "s", 0, 60, 1);
		panel.addComponent(delay);
		
		amplitude = new JAdjustbar("Effektstärke", "", 0, 20, 1);
		panel.addComponent(amplitude);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return EnumChecker.isValidEffect(effect_name.getValue());
	}

}
