package SimpleFactory;

public class SimpleWineFactory {

	//Implementacja fabryki jako singleton
    private static SimpleWineFactory simpleWineFactory;
    public static SimpleWineFactory getInstance() {
        if (simpleWineFactory == null) {
        	simpleWineFactory = new SimpleWineFactory();
        }
        return simpleWineFactory;
    }


    public static Wine getWine(String region){
    	if(region.equals("French"))
    		return new French();
        else if(region.equals("Portugal"))
            return new Portugal();
        else if(region.equals("Spanish"))
            return new Spanish();
        else if(region.equals("Italian"))
            return new Italian();
        else {
        	System.out.println("Region not found!");
        return null;
        }
    }
}
