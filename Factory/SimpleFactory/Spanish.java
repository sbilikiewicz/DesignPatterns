package SimpleFactory;

public class Spanish extends Wine {
    public Spanish() {
    	this.Name = "Crianza";
        this.Year = 2015;
        this.Color = "Red";
        this.Sweetness = "Dry";
        this.Price = 100;
        WineDetails();
    }
    
    public void WineDetails() {
    	System.out.println("--------------");
        System.out.println("Name: " + Name);
        System.out.println("Year: " + Year);
        System.out.println("Color: " + Color);
        System.out.println("Sweetness: " + Sweetness);
        System.out.println("Price: " + Price);
        System.out.println("--------------");
    }
}
