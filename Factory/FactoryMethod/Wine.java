package FactoryMethod;

public abstract class Wine {
	protected String Name;
    protected int Year;
    protected String Color;
    protected String Sweetness;
    protected int Price;
    
    public String toString() {
        return  "Name = " + Name +
                ", Year = " + Year +
                ", Color = " + Color +
                ", Sweetness = " + Sweetness +
                ", Price = " + Price;
    }
}

