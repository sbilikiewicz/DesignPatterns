package FactoryMethod;

public abstract class WineFactoryMethod {

    abstract Wine getWine(String name);

    public Wine showWine(String region) {
        Wine wine = getWine(region);
        return wine;
    }
}
