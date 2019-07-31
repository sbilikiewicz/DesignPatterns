import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.Serializable;
import org.junit.Test;

import junit.framework.Assert;

public class SingletonInitTest {

	@Test
	public void testEquals() {
		SingletonInit.SingletonSimpleLazy firstInstance = SingletonInit.SingletonSimpleLazy.getInstance();
		SingletonInit.SingletonSimpleLazy secondInstance = SingletonInit.SingletonSimpleLazy.getInstance();
		Assert.assertEquals(firstInstance, secondInstance);	
	}
	
//Test polega na próbie pobrania instancji metodą: getInstance() przez dwa niezależne wątki.
//Test uznajemy za zaliczony, jeżeli obie instancje znajdują się w tym samym miejscu w pamięci.
//Natomiast jeżeli jedna z nich jest pusta lub zostały utworzone dwa obiekty, test uznajemy za niezaliczony.
	@Test
	public void TestInstance() throws InterruptedException {
		
		Runnable task1 = () -> {
			SingletonInit.SingletonReflection.firstInstance = SingletonInit.SingletonReflection.getInstance();
		};
		Runnable task2 = () -> {
			SingletonInit.SingletonReflection.secondInstance = SingletonInit.SingletonReflection.getInstance();
		};
		 
		int testSuccess = 0;
		int testFail = 0;
		for (int i = 0; i < 10000; i++) {
			SingletonInit.SingletonReflection.instance = null;
		    ExecutorService service = Executors.newFixedThreadPool(2);
		    service.submit(task1);
		    service.submit(task2);
		    service.shutdown();
		    service.awaitTermination(1, TimeUnit.SECONDS);
		 
		    if (SingletonInit.SingletonReflection.firstInstance != null && SingletonInit.SingletonReflection.secondInstance != null && SingletonInit.SingletonReflection.firstInstance.equals(SingletonInit.SingletonReflection.secondInstance)) {
		        testSuccess++;
		    } else {
		        testFail++;
		    }
		}
		 
		System.out.println(String.format("testSuccess: %d, testFail: %d", testSuccess, testFail));
	}
	
	@Test
	public void testSerialization() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		SingletonInit.SingletonSerializable firstInstance = SingletonInit.SingletonSerializable.getInstance();
		SingletonInit.SingletonSerializable secondInstance = null;
		
		//serializacja z obiektu do pliku
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("SingletonSerializable.ser"))){
		    out.writeObject(firstInstance);
		}
		
		//deserializacja z pliku do obiektu 
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("SingletonSerializable.ser"))){
		    secondInstance =  (SingletonInit.SingletonSerializable) in.readObject();
		}
		 
		Assert.assertEquals(firstInstance, secondInstance);
	}
	
	@Test
	public void testDeserializable() throws FileNotFoundException, IOException, ClassNotFoundException {
    	
		//serializacja z obiektu do pliku
		SingletonInit.SingletonSerializable firstInstance = SingletonInit.SingletonSerializable.getInstance();
		firstInstance.setMessage("Message");
    	ObjectOutput out = new ObjectOutputStream(new FileOutputStream("SingletonSerializable.ser"));
    	out.writeObject(firstInstance);
    	out.close();
    	
    	firstInstance.setMessage("Message 123");
    	System.out.println("First instance: " + firstInstance.getMessage());
    	
    	//deserializacja z pliku do obiektu
    	ObjectInput in = new ObjectInputStream(new FileInputStream("SingletonSerializable.ser"));
    	SingletonInit.SingletonSerializable secondInstance = (SingletonInit.SingletonSerializable) in.readObject();
    	in.close();
    	
    	System.out.println("First instance: " + firstInstance.getMessage());
        System.out.println("Second instance: " + secondInstance.getMessage() + "\n");
    	
    	Assert.assertEquals(firstInstance.hashCode(), secondInstance.hashCode());
    }
}
