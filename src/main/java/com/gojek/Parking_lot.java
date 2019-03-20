package com.gojek;

/*
 * @author Ahmad Emir Alfatah
 */
import java.util.ArrayList;
public class Parking_lot
{
    private ArrayList<Car> slot = new ArrayList<>();
    private int MAX_SIZE = 0;

    public void createParkingLot(String size)
    {
        int temp = Integer.parseInt(size);
        for(int i=MAX_SIZE; i<temp; i++)
        {
            slot.add(null);
        }
        MAX_SIZE=temp;
        System.out.print("Created a parking lot with "+size+" slots\n");
    }

    public void parkCar(String number, String colour)
    {
        if(MAX_SIZE==0){
            System.out.print("Parking lot size must to set first\n");
            return;
        }
        int i = 0;
        boolean setSlot = false;
        while(i < MAX_SIZE && !setSlot)
        {
            if(slot.get(i) == null){
                Car car = new Car(number,colour);
                slot.set(i,car);
                setSlot = true;
                System.out.print("Allocated slot number: "+(i+1)+"\n");
            }else if(i == MAX_SIZE-1){
                System.out.print("Sorry, parking lot is full\n");
            }
            i++;
        }
        
    }

    public void leavePark(String numSlot)
    {
        int num = Integer.parseInt(numSlot)-1;
        if(num >= 0 && num < MAX_SIZE){
            slot.set(num,null);
            System.out.print("Slot number "+numSlot+" is free\n");
        }else{
            System.out.print("There is no slot with number "+numSlot+"\n");
        }
    }

    public void status()
    {
        System.out.print("Slot No.\tRegistration No\t\tColour\n");
        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                Car carInfo = slot.get(i);
                System.out.print((i+1)+"\t\t"+ carInfo.getRegNumber() +"\t\t"+ carInfo.getColour()+"\n");
            }
        }
    }

    public void regNumWcol(String colour)
    {
        boolean firstString = true;
        String temp = "";

        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                Car carInfo = slot.get(i);
                if(carInfo.getColour().equals(colour)){
                    if(firstString){
                        temp+=carInfo.getRegNumber();
                        firstString = false;
                    }else{
                        temp+=", "+carInfo.getRegNumber();
                    }   
                }
            }
        }
        if(temp.length()==0){
            System.out.print("Not Found\n");
        }else{
            System.out.print(temp+"\n");
        }
    }

    public void slotNumWcol(String colour)
    {
        boolean firstString = true;
        String temp = "";
        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                Car carInfo = slot.get(i);
                if(carInfo.getColour().equals(colour)){
                    if(firstString){
                        temp+= (i+1);
                        firstString = false;
                    }else{
                        temp+=", "+(i+1);
                    }
                }
            }
        }
        if(temp.length()==0){
            System.out.print("Not Found\n");
        }else{
            System.out.print(temp+"\n");
        }
    }

    public void slotNumWnum(String number)
    {
        boolean firstString = true;
        String temp = "";
        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                Car carInfo = slot.get(i);
                if(carInfo.getRegNumber().equals(number)){
                    if(firstString){
                        temp+= (i+1);
                        firstString = false;
                    }else{
                        temp+=", "+(i+1);
                    }
                }
            }
        }
        if(temp.length()==0){
            System.out.print("Not Found\n");
        }else{
            System.out.print(temp+"\n");
        }
        
    }

}