package SimpleFactory;

public class Portugal extends Wine {

    public Portugal() {
    	this.Name = "Aveleda";
        this.Year = 2018;
        this.Color = "White";
        this.Sweetness = "Semi-Dry";
        this.Price = 80;
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