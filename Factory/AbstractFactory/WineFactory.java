package AbstractFactory;

public class WineFactory {
    public static Wine getWine(WineAbstractFactory factory){
        return factory.showWine();
    }
}
