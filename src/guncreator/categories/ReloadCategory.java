package guncreator.categories;

import guns.weapons.data.ReloadData;

public class ReloadCategory extends Category<ReloadData> {

	private JBox reload_ammo;
	private JBox reload_individual;
	private JBox fully_automatic;
	private JAdjustbar reload_amount;
	private JAdjustbar reload_duration;
	private JGunSound reload_sound_start;
	private JGunSound reload_sound_finish;
	
	public ReloadCategory() {
		super("RELOAD");
	}

	@Override
	public EditPanel<ReloadData> createEditPanel() {
		
		 	EditPanel<ReloadData> panel = new EditPanel<ReloadData>() {

			@Override
			protected ReloadData generateData() {
								
				return new ReloadData(reload_ammo.getValue(), reload_individual.getValue(), fully_automatic.getValue(), (int) reload_amount.getValue(), (int) reload_duration.getValue(), reload_sound_start.getGunSound(), reload_sound_finish.getGunSound());
				
			}

			@Override
			public void initWithData(ReloadData data) {
				
				reload_ammo.setValue(data.isReloadingWithAmmo());
				reload_individual.setValue(data.isReloadingIndividually());
				fully_automatic.setValue(data.isFullyAutomatic());
				reload_amount.setValue(data.getReloadAmount());
				reload_duration.setValue(data.getReloadDuration());
				reload_sound_start.setSound(data.getReloadSoundStart());
				reload_sound_finish.setSound(data.getReloadSoundFinish());
				
			}
			
		};
		
		panel.setLayout(null);
		
		//reload ammo
		reload_ammo = new JBox("Waffe nachladbar:");
		panel.addComponent(reload_ammo);
		
		//reload individual
		reload_individual = new JBox("Nur einzeln nachladbar:");
		panel.addComponent(reload_individual);
		
		//fully automatic
		fully_automatic = new JBox("Waffe vollautomatisch:");
		panel.addComponent(fully_automatic);
		
		//reload amount
		reload_amount = new JAdjustbar("Nachlademenge:", "", 0,100, 1);
		panel.addComponent(reload_amount);
		
		//reload duration
		reload_duration = new JAdjustbar("Nachladezeit:", "Ticks", 0, 100, 1);
		panel.addComponent(reload_duration);
		
		//reload sound start
		reload_sound_start = new JGunSound("Reload start");
		panel.addComponent(reload_sound_start);
		
		//Shooter Sound
		reload_sound_finish = new JGunSound("Reload finish");
		panel.addComponent(reload_sound_finish);
		
		
		return panel;
	}
		
		

	@Override
	public boolean isEverythingFilledOut() {
		return reload_sound_start.isDataValid() && reload_sound_finish.isDataValid();
	}

}
