package guncreator.categories;

import guns.weopons.data.ScopeData;

public class ScopeCategory extends Category<ScopeData>{

	private JBox scope;
	private JBox see_in_night;
	private JAdjustbar zoom_amount;
	private JAdjustbar spread;
	private JGunSound toggle_sound;
	
	public ScopeCategory() {
		super("SCOPE");

	}

	@Override
	public EditPanel<ScopeData> createEditPanel() {
		
		 	EditPanel<ScopeData> panel = new EditPanel<ScopeData>() {

			@Override
			protected ScopeData generateData() {
				
				return new ScopeData(scope.getValue(), ((int)zoom_amount.getValue()), see_in_night.getValue(), spread.getValue(), toggle_sound.getGunSound());
			}

			@Override
			public void initWithData(ScopeData data) {
				scope.setValue(data.isScopeable());
				see_in_night.setValue(data.isSeeingInNight());
				zoom_amount.setValue(data.getZoomAmount());
				spread.setValue(data.getSpread());
				toggle_sound.setSound(data.getToggleSound());
			}
			
		};
		 
			scope = new JBox("Waffe kann zoomen");
			panel.addComponent(scope);
			
			zoom_amount = new JAdjustbar("Zoomstärke", "", 0, 20, 1);
			panel.addComponent(zoom_amount);
			
			see_in_night = new JBox("Zoom hat Nachtsicht");
			panel.addComponent(see_in_night);
			
			spread = new JAdjustbar("Streuung", "", 0, 5, 0.1f);
			panel.addComponent(spread);
			
			toggle_sound = new JGunSound("Umschalt");
			panel.addComponent(toggle_sound);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {

		return toggle_sound.isDataValid();
	}

}
