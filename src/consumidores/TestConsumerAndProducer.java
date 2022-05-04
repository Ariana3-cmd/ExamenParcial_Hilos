package consumidores;

public class TestConsumerAndProducer {
	 
    public static void main(String[] args) {
        Resource resource = new Resource();
                 // hilo de producción
        Producer p1 = new Producer(resource);
                 // Hilo del consumidor
        Consumer c1 = new Consumer(resource);
 
        new Thread(p1).start();
 
        new Thread(c1).start();
    }
}
