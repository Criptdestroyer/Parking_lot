package com.gojek;
/*
 * @author Ahmad Emir Alfatah
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class InputTest 
{
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ByteArrayInputStream testIn;

    @Before
    public void setStream()
    {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanStream()
    {
        System.setOut(null);
    }

    @Test
    public void testGetArgument()
    {
        //declare object input
        Input input = new Input("file_inputs.txt");

        //expected output
        String expectedArg = "file_inputs.txt";

        //test
        assertEquals(expectedArg,input.getArgument());
    }

    @Test
    public void testInputFile()
    {
        //declare object input
        Input input = new Input("file_inputs.txt");
        input.parser();

        //expected output
        String expectedOutput = "Created a parking lot with 6 slots\n"
                                +"Allocated slot number: 1\n"
                                +"Allocated slot number: 2\n"
                                +"Allocated slot number: 3\n"
                                +"Allocated slot number: 4\n"
                                +"Allocated slot number: 5\n"
                                +"Allocated slot number: 6\n"
                                +"Slot number 4 is free\n"
                                +"Slot No.    Registration No    Colour\n"
                                +"1           KA-01-HH-1234      White\n"
                                +"2           KA-01-HH-9999      White\n"
                                +"3           KA-01-BB-0001      Black\n"
                                +"5           KA-01-HH-2701      Blue\n"
                                +"6           KA-01-HH-3141      Black\n"
                                +"Allocated slot number: 4\n"
                                +"Sorry, parking lot is full\n"
                                +"KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333\n"
                                +"1, 2, 4\n"
                                +"6\n"
                                +"Not found\n";

        //test
        assertEquals(expectedOutput,output.toString());
    }

    @Test
    public void testInteractive()
    {
        //expected
        String expectedOutput = "Created a parking lot with 5 slots\n"
                                +"Allocated slot number: 1\n"
                                +"Allocated slot number: 2\n"
                                +"Allocated slot number: 3\n"
                                +"Allocated slot number: 4\n"
                                +"Allocated slot number: 5\n"
                                +"Slot number 4 is free\n"
                                +"Slot No.    Registration No    Colour\n"
                                +"1           KA-01-HH-1234      White\n"
                                +"2           KA-01-HH-9999      White\n"
                                +"3           KA-01-BB-0001      Black\n"
                                +"5           KA-01-HH-2701      Blue\n"
                                +"Allocated slot number: 4\n"
                                +"Sorry, parking lot is full\n"
                                +"KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333\n"
                                +"1, 2, 4\n"
                                +"5\n"
                                +"Not found\n"
                                +"exit the program\n";

        
        //test create parking lot
        provideInput("create_parking_lot 5\n"
                    +"park KA-01-HH-1234 White\n"
                    +"park KA-01-HH-9999 White\n"
                    +"park KA-01-BB-0001 Black\n"
                    +"park KA-01-HH-7777 Red\n"
                    +"park KA-01-HH-2701 Blue\n"
                    +"leave 4\n"
                    +"status\n"
                    +"park KA-01-P-333 White\n"
                    +"park DL-12-AA-9999 White\n"
                    +"registration_numbers_for_cars_with_colour White\n"
                    +"slot_numbers_for_cars_with_colour White\n"
                    +"slot_number_for_registration_number KA-01-HH-2701\n"
                    +"slot_number_for_registration_number MH-04-AY-1111\n"
                    +"exit"
        );

        Input input = new Input("iteractive");
        input.iteractiveParse();
        
        assertEquals(expectedOutput,output.toString());
    }

    @Test
    public void testRunCommand()
    {
        Input input = new Input();

        //expected
        String expectedOutput = "invalid input\n"
                                +"argument not found\n";

        //test
        input.runCommand("parkss");
        input.runCommand("park");
        assertEquals(expectedOutput,output.toString());
    }

    private void provideInput(String data)
    {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
