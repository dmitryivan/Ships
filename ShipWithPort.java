public class ShipWithPort implements Runnable{
private Port port;
private final int name;
private  int containers=3;

public ShipWithPort(int name, Port port) {
	this.port = port;
	this.name=name;
	new Thread(this).start();
}
    public int getContainers() {
	return containers;
}

public void setContainers(int containers) {
	this.containers = containers;
}

public int getName() {
	return name;
}
   
    public void run(){
        try {
			port.enter(this);
		} catch (InterruptedException e) {System.out.println(e);}
            
        for (; containers > 0; containers--){
            port.unload(this);
        }
        port.leave(this);  
    }
}

