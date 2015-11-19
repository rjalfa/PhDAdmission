package ap.adm.phd.utilities;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javafx.beans.property.SimpleBooleanProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class SerializableBooleanProperty extends SimpleBooleanProperty implements Externalizable{
	public SerializableBooleanProperty() {
		super();
	}
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(get());
    }
 
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        set(in.readBoolean());
    }
}