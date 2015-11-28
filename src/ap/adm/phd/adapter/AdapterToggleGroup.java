package ap.adm.phd.adapter;

public class AdapterToggleGroup {
	AdapterToggle selectedToggle;
	AdapterToggle[] toggles;
	public String setSelectedToggle(AdapterToggle selectedToggle_){ selectedToggle = selectedToggle_; }
	public String getToggles(){return toggles; }
}
