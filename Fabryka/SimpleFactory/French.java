package SimpleFactory;

public class French extends Wine {

	public French() {
        this.Name = "Aloxe-Corton";
        this.Year = 2016;
        this.Color = "Red";
        this.Sweetness = "Dry";
        this.Price = 250;
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
