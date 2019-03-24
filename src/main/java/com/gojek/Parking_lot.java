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
        if(temp > MAX_SIZE){ //if in case user update the max size of parking_lot, user can't update less than MAX_SIZE because can make availble car in slot will delete
            for(int i=MAX_SIZE; i<temp; i++) //add null to arraylist from MAX_SIZE until New Size
            {
                slot.add(null);
            }
            MAX_SIZE=temp;
            System.out.println("Created a parking lot with "+size+" slots");
        }
        else{
            System.out.println("number size must larger than MAX_SIZE");
        }
        
    }

    public void parkCar(String number, String colour)
    {
        if(cekParkingLot()){ //check if parking lot size hasn't been made
            return;
        }

        int i = 0;
        boolean setSlot = false;
        while(i < MAX_SIZE && !setSlot) //loop until MAX_SIZE and setSlot is true
        {
            if(slot.get(i) == null){
                Car car = new Car(number,colour);
                slot.set(i,car);
                setSlot = true; //stop loop
                System.out.println("Allocated slot number: "+(i+1));
            }
            else if(i == MAX_SIZE-1){
                System.out.println("Sorry, parking lot is full");
            }
            i++;
        }
        
    }

    public void leavePark(String numSlot)
    {
        if(cekParkingLot()){ //check if parking lot size hasn't been made
            return;
        }

        int num = Integer.parseInt(numSlot)-1;
        if(num >= 0 && num < MAX_SIZE){ //check number slot
            if(slot.get(num)==null){ // if slot is empty
                System.out.println("There is no car in slot "+numSlot);
            }
            else{ 
                slot.set(num,null);
                System.out.println("Slot number "+numSlot+" is free");
            }
        }
        else{
            System.out.println("There is no slot with number "+numSlot);
        }
    }

    public void cekStatus()
    {
        if(cekParkingLot()){ //check if parking lot size hasn't been made
            return;
        }

        System.out.println("Slot No.    Registration No    Colour");
        boolean empty = true; //if there is no car in parking lot
        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                empty = false; //parking lot have a cars
                Car carInfo = slot.get(i);
                System.out.println((i+1)+"           "+ carInfo.getRegNumber() +"      "+ carInfo.getColour());
            }
        }
        if(empty){ 
            System.out.println("           All Slot is free");
        }
    }

    public void cekRegistrationNumberWithColour(String colour)
    {
        if(cekParkingLot()){ //check if parking lot size hasn't been made
            return;
        }

        boolean firstString = true; 
        String temp = "";

        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                Car carInfo = slot.get(i);
                if(carInfo.getColour().equals(colour)){
                    if(firstString){ //if first string is true
                        temp+=carInfo.getRegNumber();
                        firstString = false; //firstString is false
                    }
                    else{
                        temp+=", "+carInfo.getRegNumber();
                    }   
                }
            }
        }

        if(temp.length()==0){ //if not found
            System.out.println("Not found");
        }
        else{
            System.out.println(temp);
        }
    }

    public void cekSlotNumberWithColour(String colour)
    {
        if(cekParkingLot()) //check if parking lot size hasn't been made
        {
            return;
        }
        
        boolean firstString = true;
        String temp = "";
        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                Car carInfo = slot.get(i);
                if(carInfo.getColour().equals(colour)){
                    if(firstString){ //if first string is true
                        temp+= (i+1);
                        firstString = false; //firstString is false
                    }
                    else{
                        temp+=", "+(i+1);
                    }
                }
            }
        }
        if(temp.length()==0){ //if not found
            System.out.println("Not found");
        }
        else{
            System.out.println(temp);
        }
    }

    public void cekSlotNumberWithRegistrationNumber(String number)
    {
        if(cekParkingLot()){ //check if parking lot size hasn't been made
            return;
        }

        boolean firstString = true;
        String temp = "";
        for(int i=0; i<MAX_SIZE; i++)
        {
            if(slot.get(i)!=null){
                Car carInfo = slot.get(i);
                if(carInfo.getRegNumber().equals(number)){
                    if(firstString){  //if first string is true
                        temp+= (i+1);
                        firstString = false; //firstString is false
                    }
                    else{
                        temp+=", "+(i+1);
                    }
                }
            }
        }
        
        if(temp.length()==0){ //if not found
            System.out.println("Not found");
        }
        else{
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