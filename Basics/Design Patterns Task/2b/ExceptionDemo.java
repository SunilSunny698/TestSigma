public class ExceptionDemo {
    public static void main(String[] args) {
        try{
            throw new ExceptionLevel1("Exception");
        } catch(ExceptionLevel4 e){
            System.out.println("Caught at 4 "+e.getMessage());
        }
        catch(ExceptionLevel3 e){
            System.out.println("Caught at 3 "+e.getMessage());
        }
        catch(ExceptionLevel2 e){
            System.out.println("Caught at 2 "+e.getMessage());
        }
        catch(ExceptionLevel1 e){
            System.out.println("Caught at 1 "+e.getMessage());
        }
    }
}
