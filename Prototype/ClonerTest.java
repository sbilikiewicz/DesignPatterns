import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClonerTest {

    static public void main(String[] args) {
    	//Utworzenie rodzica i dziecka
        Parent parent = new Parent();
        parent.setChild(new Child());
        parent.setName("anna");

        //Klonowanie rodzica
        //jezeli obiekt posiada referencje do innych obiektów to zostną skopiowane jedynie referencje(nie skopiuje tych obiektów)
        Parent parentClone;
        try {
            parentClone = (Parent)parent.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
        
        parent.setName("joanna");
        
        System.out.println("Klonowanie płytkie");
        
        System.out.println("imie rodzica " + parent.getName());
        System.out.println("imie dziecka " + parentClone.getName());
        
        //Prawda + obiekty muszą mieć różne adresy pamięci
        System.out.println(parent != parentClone);
        
        //Prawda, ponieważ zwracamy tą samą klasę
        System.out.println(parent.getClass() == parentClone.getClass());
        
        //Domyślna metoda equals sprawdza referencje więc powinna zwrócić false
        System.out.println(parent.equals(parentClone));

        
        System.out.println("Głębokie kopiowanie");
        
        parentClone = (Parent)Cloner.deepClone(parent);
        
        System.out.println("imie rodzica " + parent.getName());
        System.out.println("imie dziecka " + parentClone.getName());
        
        //Prawda + obiekty muszą mieć różne adresy pamięci
        System.out.println(parent != parentClone);
        
        //Prawda, ponieważ zwracamy tą samą klasę
        System.out.println(parent.getClass() == parentClone.getClass()); 
        
        //głębokiego kopiowania z kolekcją
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> listClone = (List<String>)Cloner.deepClone(list);
        
        System.out.println(listClone);
    }
}