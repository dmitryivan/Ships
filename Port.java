public class Port {
    private int counter;
    
    public Port(int i) {
        counter = i;
    }

    public synchronized void leave(ShipWithPort ship) {
        System.out.println("Ship "+ ship.getName() + " Finished and leaves the port");
        counter++;
        this.notifyAll();
    }
  
    public synchronized void enter(ShipWithPort ship) throws InterruptedException {
        while (counter == 0) {
            this.wait();
        }
        System.out.println("Ship "+ ship.getName() + " Entered the port.");
        counter--;
    }
    
    public synchronized void unload(ShipWithPort ship){
        System.out.println("Ship "+ ship.getName() + " Unloaded 1 container, containers left: "  + ship.getContainers() );
        try {
			this.wait(1000);
	    } catch (InterruptedException e) {System.out.println(e);}
    }
}
