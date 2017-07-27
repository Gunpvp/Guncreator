package guncreator.categories;

import java.io.Serializable;

public abstract class Category<DATA extends Serializable> {
	
	private String name;
	private EditPanel<DATA> edit_panel;
	
	public Category(String name) {
		this.name = name;
		this.edit_panel = createEditPanel();
	}
	
	public String getName() {
		return name;
	}

	public EditPanel<DATA> getEditPanel() {
		return edit_panel;
	}

	public abstract EditPanel<DATA> createEditPanel();
	public abstract boolean isEverythingFilledOut();
	
}
