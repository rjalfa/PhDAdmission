package ap.adm.phd.utilities;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javafx.beans.property.SimpleDoubleProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class SerializableDoubleProperty extends SimpleDoubleProperty implements Externalizable{
	public SerializableDoubleProperty() {
		super();
	}
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(get());
    }
 
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        set(in.readDouble());
    }
}