package ap.adm.phd.adapter;

public class AdapterDatePicker {
	Date date;
	Boolean isDisabled;
	public Date getValue(){ return date; }
	public Date setValue(Date date_){ date = date_; }
	public void setDisable(Boolean val){ isDisabled = val; }
}
