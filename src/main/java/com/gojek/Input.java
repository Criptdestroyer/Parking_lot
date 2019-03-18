package com.gojek;

/*
 * author : Ahmad Emir Alfatah
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
    public Input(String argument)
    {
        this.argument = argument;
        parser();
    }

    public void parser() 
    {
        if(argument.equals("iteractive")){
            iteractiveParse();
        }else{
            fileParse(argument);
        }
    }

    public void iteractiveParse()
    {
        data = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("in building");
    }

    public void fileParse(String filename)
    {
        try{
            data = new BufferedReader(new FileReader(filename));
        }catch(FileNotFoundException e){
            System.out.println(e);
            e.printStackTrace();
        }
        
        String args;
        try{
            while((args = data.readLine()) != null)
            {
                System.out.println(args);
            }
        }catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
        
    }

    
 }