package guncreator.categories;

import javax.swing.JButton;

import guns.weopons.data.ExplosionData;

public class ExplosionCategory extends Category<ExplosionData> {

	public ExplosionCategory() {
		super("EXPLOSION");
	}

	@Override
	public EditPanel<ExplosionData> createEditPanel() {
		
		EditPanel<ExplosionData> panel = new EditPanel<ExplosionData>() {
			
			protected ExplosionData generateData() {
				return null;
			}
			
		};
		
		panel.add(new JButton("Hallo Leichti!"));
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
