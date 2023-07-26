public class ConsumerThread implements Runnable{
    ProducerConsumer sys;
    public ConsumerThread(ProducerConsumer sys){
        this.sys = sys;
    }
    public void run(){
        try{
            while(true){
                sys.consume();
            }
            

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
