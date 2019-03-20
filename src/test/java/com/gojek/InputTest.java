package com.gojek;
/*
 * @author Ahmad Emir Alfatah
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class InputTest 
{
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

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
        Input input = new Input("file_inputs.txt");
        String expectedOutput = "Create a parking lot with 6 slots\n"
                                +"Allocated slot number: 1\n"
                                +"Allocated slot number: 2\n"
                                +"Allocated slot number: 3\n"
                                +"Allocated slot number: 4\n"
                                +"Allocated slot number: 5\n"
                                +"Allocated slot number: 6\n"
                                +"Slot number 4 is free\n"
                                +"Slot No.        Registration No         Colour\n"
                                +"1               KA-01-HH-1234           White\n"
                                +"2               KA-01-HH-9999           White\n"
                                +"3               KA-01-BB-0001           Black\n"
                                +"5               KA-01-HH-2701           Blue\n"
                                +"6               KA-01-HH-3141           Black\n"
                                +"Allocated slot number: 4\n"
                                +"Sorry, parking lot is full\n"
                                +"KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333\n"
                                +"1, 2, 4\n"
                                +"6\n"
                                +"Not Found\n";

        // assertEquals(expectedOutput,input.fileParse("file_inputs.txt"));

    }
}
