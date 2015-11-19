package ap.adm.phd.utilities;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javafx.beans.property.SimpleObjectProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class SerializableObjectProperty<T> extends SimpleObjectProperty<T> implements Externalizable{

    public SerializableObjectProperty() {
		super();
	}

	@Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject((T)get());
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        set((T)in.readObject());
    }
}
