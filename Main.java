import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {

	//	Semaphore port = new Semaphore(3);
     //     for (int i=0; i<10; i++){
     //     new Ship(i, port);
    //	}
        
        Port p = new Port(3);
        for (int i=0; i<10; i++){
	      new ShipWithPort(i, p);
    	}
    }
}
