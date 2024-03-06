package examples.serealize;

import java.io.Serial;
import java.io.Serializable;

public class Pet implements Serializable {

    @Serial
    private static final long serialVersionUID = -5699925170711544017L;
    private String name;
    private Type type;


    public Pet(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " : " + type;
    }
}
