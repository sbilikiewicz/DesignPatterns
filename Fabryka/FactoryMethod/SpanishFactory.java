package FactoryMethod;

public class SpanishFactory extends WineFactoryMethod{
    Wine getWine(String name){
        if (name.equals("Crianza")){
            return new SpanishCrianza();
        } else if (name.equals("Morales")){
            return new SpanishMorales();
        } else {
        	System.out.println("Wine not found");
        	return null;
        }
    }
}
