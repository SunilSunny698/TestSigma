// 6. Write a program to read a log file and load it to the list of objects.
// (log structure : {id; message; error code;})

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Log {
    String id;
    String message;
    String errorCode;
    Log(String id,String message,String errorCode){
        this.id=id;
        this.message=message;
        this.errorCode=errorCode;
    }
    void display(){
        System.out.println(this.id+this.message+this.errorCode);
    }
}

public class ReadLog {
    public static void main(String[] args) {
        ArrayList<Log> listlogs = new ArrayList<Log>(100);
        File f = new File("logfile.log");
        try{
            FileInputStream fis = new FileInputStream(f);
            Scanner s = new Scanner(fis);
            while(s.hasNextLine()){
                String[] data=s.nextLine().split(":");
                Log l=new Log(data[0],data[1],data[2]);
                listlogs.add(l);
            }
            fis.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("Output");
            for (Log l:listlogs) {
                l.display();
            }
        }
    }
}
