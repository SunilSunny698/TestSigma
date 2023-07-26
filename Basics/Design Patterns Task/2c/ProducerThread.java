public class ProducerThread extends Thread{
    ProducerConsumer sys;
    public ProducerThread(ProducerConsumer sys){
        this.sys = sys;
    }
    public void run(){
        while(true){
            try{
                sys.produce();
                Thread.sleep(5000);
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }    
}
