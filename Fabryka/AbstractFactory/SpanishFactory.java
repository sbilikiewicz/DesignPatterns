package AbstractFactory;

public class SpanishFactory implements WineAbstractFactory{
    private String Name;
    private int Year;
    private String Color;
    private String Sweetness;
    private int Price;

    public SpanishFactory(String Name, int Year, String Color, String Sweetness, int Price){
        this.Name = Name;
        this.Year = Year;
        this.Color = Color;
        this.Sweetness = Sweetness;
        this.Price = Price;
    }
    
    @Override
    public Wine showWine() {
        return new Spanish(Name, Year, Color, Sweetness, Price);
    }
}
