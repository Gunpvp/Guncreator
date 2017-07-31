package guncreator.categories;

import guns.weopons.data.EffectData;

public class EffectCategory extends Category<EffectData> {

	public EffectCategory(String name) {
		super(name);
	}

	@Override
	public EditPanel<EffectData> createEditPanel() {
		EditPanel<EffectData> panel = new EditPanel<EffectData>() {
			
			@Override
			public void initWithData(EffectData data) {
				
			}
			
			@Override
			protected EffectData generateData() {
				return null;
			}
		};
		
		return panel;
	}

	@Override
	public boolean isEverythingFilledOut() {
		return false;
	}

}
