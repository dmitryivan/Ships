import java.util.concurrent.Semaphore;

public class Ship implements Runnable{
private Semaphore port;
private final int name;
private  int containers=3;

	public Ship(int name, Semaphore port) {
    	this.port = port;
    	this.name=name;
    	new Thread(this).start();
    }
    
    public void run(){
        try {
            port.acquire();
            System.out.println("Ship "+ name + " Entered the port.");
            
            for (; containers > 0; containers--){
                System.out.println("Ship "+ name + "  Unloaded 1 container,"+ " containers left: "  + containers );
                synchronized (port) {
                	port.wait(1000);
                }
            }
            System.out.println("Ship "+ name + " Finished and leaves the port ");
        } catch (InterruptedException e) { 
           System.out.println(e);
        } finally {
           port.release();  
        }
    }
}

