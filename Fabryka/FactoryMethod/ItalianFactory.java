package FactoryMethod;

public class ItalianFactory extends WineFactoryMethod {
    Wine getWine(String name){
       if (name.equals("San Clemente")){
           return new ItalianSanClemente();
       } else {
       	System.out.println("Wine not found");
       	return null;
       }
    }
}
