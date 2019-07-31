package AbstractFactory;

public class Spanish extends Wine {
	private String Name;
    private int Year;
    private String Color;
    private String Sweetness;
    private int Price;

    public Spanish(String Name, int Year, String Color, String Sweetness, int Price){
        this.Name = Name;
        this.Year = Year;
        this.Color = Color;
        this.Sweetness = Sweetness;
        this.Price = Price;
    }
    
    @Override
    public String Name() {
        return this.Name;
    }

    @Override
    public int Year() {
        return this.Year;
    }

    @Override
    public String Color() {
        return this.Color;
    }
    @Override
    public String Sweetness() {
        return this.Sweetness;
    }

    @Override
    public int Price() {
        return this.Price;
    }

}