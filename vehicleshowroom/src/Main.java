import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int visitor = 30;
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int t = 0;
        while(true){
            System.out.println("PRESS 1 to add vehicle in showroom : ");
            System.out.println("PRESS 2 to remove vehicle from showroom : ");
            System.out.println("PRESS 3 to see all vehicles in showroom : ");
            System.out.println("PRESS 4 to exit : ");
            t = in.nextInt();
            if(t==1){
                System.out.println("PRESS 1 to add normal vehicle in showroom : ");
                System.out.println("PRESS 2 to add sports vehicle in showroom : ");
                System.out.println("PRESS 3 to add heavy vehicle in showroom : ");
                int x = in.nextInt();
                if(x==1){
                    in.nextLine();
                    System.out.println("Enter model number : ");
                    String modelNumber = in.nextLine();
                    System.out.println("Enter engine type : ");
                    String engineType = in.nextLine();
                    System.out.println("Enter tire size : ");
                    int tireSize = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter engine power : ");
                    String enginePower = in.nextLine();
                    Vehicle normalVehicle = new NormalVehicle(modelNumber,engineType,enginePower,tireSize);
                    vehicleList.add(normalVehicle);
                } else if (x==2) {
                    visitor+=20;
                    in.nextLine();
                    System.out.println("Enter model number : ");
                    String modelNumber = in.nextLine();
                    System.out.println("Enter tire size : ");
                    int tireSize = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter engine power : ");
                    String enginePower = in.nextLine();
                    System.out.println("Enter turbo number : ");
                    int turbo = in.nextInt();
                    Vehicle sportsVehicle = new SportsVehicle(modelNumber,enginePower,tireSize,turbo);
                    vehicleList.add(sportsVehicle);
                }else if (x==3){
                    in.nextLine();
                    System.out.println("Enter model number : ");
                    String modelNumber = in.nextLine();
                    System.out.println("Enter tire size : ");
                    int tireSize = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter engine power : ");
                    String enginePower = in.nextLine();
                    System.out.println("Enter weight : ");
                    int weight = in.nextInt();
                    Vehicle heavyVehicle = new HeavyVehicle(modelNumber,enginePower,tireSize,weight);
                    vehicleList.add(heavyVehicle);
                }
            } else if (t==2) {
                System.out.println("Enter model number to remove vehicle from showroom : ");
                in.nextLine();
                String model = in.nextLine();
                Vehicle deleteV=null;
                for (Vehicle v:vehicleList) {
                    if(v.getModelNumber().equals(model)){
                        deleteV = v;
                        break;
                    }
                }
                vehicleList.remove(deleteV);
            } else if (t==3) {
                if(vehicleList.isEmpty()){
                    System.out.println("ShowRoom is Empty : ");
                }else {
                    System.out.println("Total visitors is : "+visitor);
                    System.out.println("Vehicle List In The ShowRoom ");
                    for (Vehicle v: vehicleList) {
                        System.out.println(v);
                    }
                }
            } else if (t==4) {
                break;
            }

        }

    }
}