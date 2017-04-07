public class Button {
    private ButtonServer server = new Lamp();
    private ButtonServer server2 = new Microwave();
    public  Button(Lamp lamp, Microwave micro){
        server = lamp;
        server2 = micro;
    }
    public void poll() {
    	boolean condition = (new java.util.Random(System.currentTimeMillis())).nextBoolean();
    	if ( condition ) {
	        server.turnOn();
            server2.turnOn();
    	}
    }

    public static void main(String[] args) {
    	Button b = new Button(new Lamp(), new Microwave());
    	while (true) {
	        b.poll();
	        try {
        		Thread.sleep(1000); // pause 1 sec
	        }
    	    catch (InterruptedException e) {
    	    	e.printStackTrace();
	        }
    	}
    }
}

class Lamp implements ButtonServer{
    public Lamp(){}
    @Override
    public void turnOn() {
    	System.out.println("Lamp on.");
    }
    @Override
    public void turnOff() {
    	System.out.println("Lamp off.");
    }
}

interface ButtonServer{
    public void turnOn();
    public void turnOff();
}

class Microwave implements ButtonServer{
    public Microwave(){} 
    @Override
    public void turnOn() {
    	System.out.println("Microwave on.");
    }
    @Override
    public void turnOff() {
    	System.out.println("Microwave off.");
    }
}
