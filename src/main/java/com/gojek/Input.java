package com.gojek;

/*
 * @author Ahmad Emir Alfatah
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

 public class Input
 {
    private String argument;
    private BufferedReader data;
    private Parking_lot parking_lot;

    public Input(String argument)
    {
        this.argument = argument;
        parking_lot = new Parking_lot();
    }

    public String getArgument()
    {
        return argument;
    }

    public void parser() 
    {
        if(argument.equals("iteractive")){
            iteractiveParse();
        }
        else{
            fileParse(argument);
        }
    }

    public void iteractiveParse()
    {
        try{
            data = new BufferedReader(new InputStreamReader(System.in));
            boolean next = true;
            while(next)
            {
                String command = data.readLine();
                if(command.equals("exit")){
                    System.out.println("exit the program");
                    next = false;
                }
                else{
                    runCommand(command);
                }
            }
        }
        catch(IOException e){
            System.out.println("Wrong Command input or wrong parameter");
            e.printStackTrace();
        }
    }

    public void fileParse(String filename)
    {
        try{
            data = new BufferedReader(new FileReader(filename));
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        
        String command;
        try{
            while((command = data.readLine()) != null)
            {
                runCommand(command);
            }
        }
        catch(IOException e){
            System.out.println("Wrong Command input or wrong parameter");
            e.printStackTrace();
        }
    }

    public void runCommand(String command)
    {
        String splitCommand[] = command.split(" ");
        switch(splitCommand[0])
        {
            case "create_parking_lot":
                parking_lot.createParkingLot(splitCommand[1]);
                break;
            case "park":
                parking_lot.parkCar(splitCommand[1],splitCommand[2]);
                break;
            case "leave":
                parking_lot.leavePark(splitCommand[1]);
                break;
            case "status":
                parking_lot.cekStatus();
                break;
            case "registration_numbers_for_cars_with_colour":
                parking_lot.cekRegistrationNumberWithColour(splitCommand[1]);
                break;
            case "slot_numbers_for_cars_with_colour" :
                parking_lot.cekSlotNumberWithColour(splitCommand[1]);
                break;  
            case "slot_number_for_registration_number" :
                parking_lot.cekSlotNumberWithRegistrationNumber(splitCommand[1]);
                break;   
            default:
                System.out.println("invalid input");        
        }
    }
 }