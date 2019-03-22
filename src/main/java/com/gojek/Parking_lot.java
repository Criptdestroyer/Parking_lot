package com.gojek;

/*
 * @author Ahmad Emir Alfatah
 */
import java.util.ArrayList;
public class Parking_lot
{
    private ArrayList<Car> slot = new ArrayList<>();
    private int MAX_SIZE = 0;

    public int getMaxSize()
    {
        return MAX_SIZE;
    }

    public ArrayList getSlot()
    {
        return slot;
    }

    public void createParkingLot(String size)
    {
        int temp = Integer.parseInt(size);
        for(int i=MAX_SIZE; i<temp; i++)
        {
            slot.add(null);
        }
        MAX_SIZE=temp;
        System.out.println("Created a parking lot with "+size+" slots");
    }

    public void parkCar(String number, String colour)
    {
        if(cekParkingLot()){
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
                System.out.println("Allocated slot number: "+(i+1));
            }else if(i == MAX_SIZE-1){
                System.out.println("Sorry, parking lot is full");
            }
            i++;
        }
        
    }

    public void leavePark(String numSlot)
    {
        if(cekParkingLot()){
            return;
        }

        int num = Integer.parseInt(numSlot)-1;
        if(num >= 0 && num < MAX_SIZE){
            if(slot.get(num)==null){
                System.out.println("There is no car in slot "+numSlot);
            }else{
                slot.set(num,null);
                System.out.println("Slot number "+numSlot+" is free");
            }
        }else{
            System.out.println("There is no slot with number "+numSlot);
        }
    }

    public void status()
    {
        if(cekParkingLot()){
            return;
        }

        System.out.println("Slot No.    Registration No    Colour");
        boolean empty = true;
        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                empty = false;
                Car carInfo = slot.get(i);
                System.out.println((i+1)+"           "+ carInfo.getRegNumber() +"      "+ carInfo.getColour());
            }
        }
        if(empty){
            System.out.println("           All Slot is free");
        }
    }

    public void regNumWcol(String colour)
    {
        if(cekParkingLot()){
            return;
        }

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
            System.out.println("Not Found");
        }else{
            System.out.println(temp);
        }
    }

    public void slotNumWcol(String colour)
    {
        if(cekParkingLot()){
            return;
        }
        
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
            System.out.println("Not found");
        }else{
            System.out.println(temp);
        }
    }

    public void slotNumWnum(String number)
    {
        if(cekParkingLot()){
            return;
        }

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
            System.out.println("Not found");
        }else{
            System.out.println(temp);
        }
        
    }

    public boolean cekParkingLot()
    {
        boolean cek = false;
        if(MAX_SIZE==0){
            System.out.println("Parking lot size must to set first");
            return true;
        }
        return cek;
    }
}