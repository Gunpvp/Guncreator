package guncreator.categories;

import guns.weopons.data.ShootingData;

public class ShootCategory extends Category<ShootingData> {

	public ShootCategory() {
		super("SHOOTING");
	}

	@Override
	public EditPanel<ShootingData> createEditPanel() {
		
		EditPanel<ShootingData> shooting = new EditPanel<ShootingData>() {
			
			@Override
			protected ShootingData generateData() {
				return null;
			}
		};
		
		return shooting;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
