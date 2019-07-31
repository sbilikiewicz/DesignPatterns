package SimpleFactory;

public class SimpleWineTest {
    public static void main(String[] args) {
    	
    	//FrenchWine
        Wine wine1 = SimpleWineFactory.getWine("French");
        if (wine1 == null)
        	System.out.println("Type not detected"); 
        
        //PortugalWine
        Wine wine2 = SimpleWineFactory.getWine("Portugal");
        if (wine2 == null)
        	System.out.println("Type not detected");
        
        //SpanishWine
        Wine wine3 = SimpleWineFactory.getWine("Spanish");
        if (wine3 == null)
        	System.out.println("Type not detected");
        
        //ItalianWine
        Wine wine4 = SimpleWineFactory.getWine("Italian");
        if (wine4 == null)
        	System.out.println("Type not detected");
        
        //PolishWine
        Wine wine5 = SimpleWineFactory.getWine("Polish");
        if (wine5 == null)
        	System.out.println("Type not detected");
        
        long time1 = System.currentTimeMillis();
    	
    	Wine wineX = SimpleWineFactory.getWine("Italian");
    	Wine wineXX = SimpleWineFactory.getWine("Spanish");
    	
    	long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        
    }

}
