package FactoryMethod;

import SimpleFactory.SimpleWineFactory;
import SimpleFactory.Wine;

public class WineTest {
    public static void main(String[] args){
    	
    	long time1 = System.currentTimeMillis();
    	
    	WineFactoryMethod italianX = new ItalianFactory();
        FactoryMethod.Wine wineX = italianX.getWine("San Clemente");
    		
    	long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        
        WineFactoryMethod italian = new ItalianFactory();
        FactoryMethod.Wine wine = italian.getWine("San Clemente");
        if (wine != null)
        		System.out.println(wine.toString());
        
        wine = italian.getWine("Paladin");
        if (wine != null)
        		System.out.println(wine.toString());

        WineFactoryMethod spanish = new SpanishFactory();
        wine = spanish.getWine("Crianza");
        if (wine != null)
        		System.out.println(wine.toString());
        
        wine = spanish.getWine("Morales");
        if (wine != null)
        		System.out.println(wine.toString());
        
        wine = spanish.getWine("Carlo");
        if (wine != null)
        		System.out.println(wine.toString());
    }
}
