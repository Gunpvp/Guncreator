package guncreator.categories;

import guns.weopons.data.BurstfireData;

public class BurstfireCategory extends Category<BurstfireData>{

	private JAdjustbar shots_per_burst;
	private JAdjustbar delay_between;
	
	public BurstfireCategory() {
		super("BURSTFIRE");
	}

	@Override
	public EditPanel<BurstfireData> createEditPanel() {
		
		 	EditPanel<BurstfireData> panel = new EditPanel<BurstfireData>() {

			@Override
			protected BurstfireData generateData() {
				
				return new BurstfireData((int) shots_per_burst.getValue(), (int) delay_between.getValue());
				
			}

			@Override
			public void initWithData(BurstfireData data) {
				
				
			}
		};
		 
		//shots per burst
		shots_per_burst = new JAdjustbar("Schüsse pro Feuerstoß:", "", 0, 10, 1);
		panel.addComponent(shots_per_burst);
		
		//shot delay
		delay_between = new JAdjustbar("Verzögerung:", "Ticks", 0, 40, 1);
		panel.addComponent(delay_between);
		
		return panel;
		
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
