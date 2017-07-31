package guncreator.categories;

import guns.weopons.data.SneakData;

public class SneakCategory extends Category<SneakData>{

	private JBox sneak_depending;
	private JBox block_recoil;
	private JAdjustbar spread;
	
	public SneakCategory() {
		super("SNEAK");
		
	}

	@Override
	public EditPanel<SneakData> createEditPanel() {
		
		 	EditPanel<SneakData> panel = new EditPanel<SneakData>() {

			@Override
			protected SneakData generateData() {
				
				return new SneakData(sneak_depending.getValue(), block_recoil.getValue(), spread.getValue());
				
			}

			@Override
			public void initWithData(SneakData data) {
				
				sneak_depending.setValue(data.isSneakDepending());
				block_recoil.setValue(data.isBlockRecoil());
				spread.setValue((int) data.getSpread());
				
			}
			
		};
		
		panel.setLayout(null);
		
		//sneak depending
		sneak_depending = new JBox("Sneak ändert Eigenschaften:");
		panel.addComponent(sneak_depending);
		
		//block recoil
		block_recoil = new JBox("Rückstoß blockieren:");
		panel.addComponent(block_recoil);
		
		//spread
		spread = new JAdjustbar("Streuung:", "", 0, 5, 0.1f);
		panel.addComponent(spread);
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return true;
	}

}
