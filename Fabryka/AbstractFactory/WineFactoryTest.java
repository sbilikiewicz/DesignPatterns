package AbstractFactory;

public class WineFactoryTest {
    public static void main(String[] args) {
        testAbstractWineFactory();
    }
    
    private static void testAbstractWineFactory() {
    	//Italian
    	long time1 = System.currentTimeMillis();
        Wine italian = WineFactory.getWine(new ItalianFactory("San Clemente", 2014, "Red", "Dry", 150));
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        
        System.out.println("--Abstract");
        System.out.println("Name: " + italian.Name());
        System.out.println("Year: " + italian.Year());
        System.out.println("Color: " + italian.Color());
        System.out.println("Sweetness: " + italian.Sweetness());
        System.out.println("Price: " + italian.Price());
        System.out.println("--");
        //Spanish
        Wine spanish = WineFactory.getWine(new SpanishFactory("Crianza", 2015, "Red", "Dry", 100));
        System.out.println("--Abstract");
        System.out.println("Name: " + spanish.Name());
        System.out.println("Year: " + spanish.Year());
        System.out.println("Color: " + spanish.Color());
        System.out.println("Sweetness: " + spanish.Sweetness());
        System.out.println("Price: " + spanish.Price());
        System.out.println("--");
    }
}
