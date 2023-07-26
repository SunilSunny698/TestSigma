public class ProducerConsumer {
    private boolean isProduced;

    public synchronized void produce(){
        try{
            System.out.println("Producer is producing...");
            Thread.sleep(2000);

            isProduced=true;
            notify();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized void consume(){
        try{
            while(!isProduced){
                System.out.println("Consumer is waiting..");
                wait();

            }

            System.out.println("Consumer is consuming...");
            Thread.sleep(1000);
            isProduced=false;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
