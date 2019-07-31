package SimpleFactory;

public class Italian extends Wine {

    public Italian() {
    	this.Name = "San Clemente";
        this.Year = 2014;
        this.Color = "Red";
        this.Sweetness = "Dry";
        this.Price = 150;
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
