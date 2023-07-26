public class Client {
    public static void main(String[] args) {
        ProducerConsumer sys = new ProducerConsumer();
        ProducerThread prod = new ProducerThread(sys);
        ConsumerThread cons = new ConsumerThread(sys);
        Thread p = new Thread(prod);
        Thread c = new Thread(cons);
        p.start();
        c.start();
    }
        
}   
