// 5. Write a program for copying the file using streams.

import java.io.*;

public class FileCopying {
    public static void main(String[] args) {
        File s=new File("sample.txt");
        File d=new File("copy.txt");
        try{
            FileInputStream fis = new FileInputStream(s);
            FileOutputStream fos = new FileOutputStream(d);
            int i;
            while((i=fis.read())!=-1){
                fos.write(i);
            }
            fis.close();
            fos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
