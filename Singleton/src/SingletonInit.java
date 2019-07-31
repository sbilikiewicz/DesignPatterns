import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonInit {

	public static void main(String[] args) {
		
		SingletonSimpleEager singleton = SingletonSimpleEager.getInstance();
		
	}
	
// Inicjacja singletonu eager tworzonego przy starcue aplikacji
	public static class SingletonSimpleEager {
	 
	    private static final SingletonSimpleEager instance = new SingletonSimpleEager();
	 
	    private SingletonSimpleEager() {
	    	System.out.println("Test");
	    }
	 
	    public static SingletonSimpleEager getInstance() {
	        return instance;
	    }
	}
	
// Inicjacja singletonu lazy tworzonego przy wywolaniu	
	public static class SingletonSimpleLazy {
		
		static SingletonSimpleLazy instance;
		static SingletonSimpleLazy firstInstance;
		static SingletonSimpleLazy secondInstance;
		
	    private SingletonSimpleLazy() {
	    }
	 
	    public static SingletonSimpleLazy getInstance() {
	        if(instance == null){
	            instance = new SingletonSimpleLazy();
	        }
	        return instance;
	    }
	}
	
//Inicjacja singletonu odpornego na dublowanie instancji
//Dzięki oznaczeniu zmiennej jako volatile niezależnie od tego, który wątek próbuje ją odczytać, jej wartość będzie zawsze spójna
	public static class SingletonReflection {
	    static volatile SingletonReflection instance;
	    static volatile SingletonReflection firstInstance;
	    static volatile SingletonReflection secondInstance;
	 
	    private SingletonReflection() {
	        if (instance != null) {
	            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
	        }
	    }
	    
//Dodanie synchronized powoduje iz tylko jeden watek moze tu wejsc w danym momencie
//Jednak ta metoda mocno zwalnia aplikacje dlatego uzywamy blokady z podwojnym zatwierdzeniem
	    public static SingletonReflection getInstance() {
	    	if (instance == null) {
	            synchronized (SingletonSimpleLazy.class) {
	                if (instance == null) {
	                    instance = new SingletonReflection();
	                }
	            }
	        }
	        return instance;
	    }
	}
	
//Serializacja
	    public static class SingletonSerializable implements Serializable {
	     
	    	static volatile SingletonSerializable instance;
	    	private String message = "Message";
	     
	        private SingletonSerializable() {
	        }
	     
	        public static SingletonSerializable getInstance() {
	            if (instance == null) {
	                instance = new SingletonSerializable();
	            }
	            return instance;
	        }
	     
	        protected Object readResolve() throws ObjectStreamException {
	            if (instance == null)
	                instance = this;
	            instance.setMessage(this.getMessage());
	            return instance;
	        }
	    
	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
	  }
	}
