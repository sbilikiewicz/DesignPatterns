
import java.io.Serializable;

//Serializable - dzięki temu mozna skorzystac z deepClone - obiekt mozna zapisac i odczytac pozniej jako strumień bajtów
public class Parent implements Cloneable, Serializable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private Child child;
    private String name;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

