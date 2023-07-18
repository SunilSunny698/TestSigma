// 4. Write a program for TicketCounter as mentioned below
// a. User can get Bus/Train/Flight ticket from Multiple Vendors
// b. Take at least 3 vendors for each
// c. Ticket pricing Strategy should vary from vendor to vendor based on the distance.
// d. Minimum charges for each category defined as Bus (100), Train(50), Flight( 500).
// For each vendor of bus per km fare should differ 2%
// For each vendor of train per km fare should differ 5%
// For each vendor of fight per km fare should differ 8%
// (Note: Create a vendor fare data table with above fare details)

// Inputs:
// Category : Bus/ Train/ Flight
// Vendor: < vendor selected based under the category >
// Distance: < km >

// Final output :
// Total fare
import java.util.Scanner;
class TicketCounter{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final double busbase = 100;
        final double flightbase = 500;
        final double trainbase = 50;

        double[] bv = new double[3];
        double[] fv = new double[3];
        double[] tv = new double[3];
        bv[0]=10;
        fv[0]=20;
        tv[0]=30;
        for(int i=1;i<3;i++){
            bv[i]=bv[i-1]+bv[i-1]*0.02;
            tv[i]=tv[i-1]+tv[i-1]*0.05;
            fv[i]=fv[i-1]+fv[i-1]*0.08;
        }

        System.out.println("Enter category bus/flight/train: ");
        String cat = in.next();
        System.out.println("Enter vendor categort 1/2/3: ");
        int ven = in.nextInt();
        System.out.println("Enter distance: ");
        int km = in.nextInt();

        double base=0,vendor=0,fare=0;
        switch(cat){
            case "bus":
                base=busbase;
                vendor=bv[ven-1];
                break;
            case "train":
                base=trainbase;
                vendor=tv[ven-1];
                break;
            case "flight":
                base=flightbase;
                vendor=fv[ven-1];
                break;
        }

        fare=base+(km*vendor);
        System.out.println("Your Fare: "+fare);




        
    }
}
