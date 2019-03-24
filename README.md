# Parking Lot v1.4.2 - GO_SQUADS TECH 3.0
### Author: Ahmad Emir Alfatah
<hr>
This is my solution for Parking Lot program assignment(<a>Parking Lot v.1.4.2.pdf</a>)

## Requirements
- JDK 8 or above
- Maven 3.5.3 or above // build tool
- Ruby // for Ruby functional specs

## Bin directory
In Parking_lot root directory has a bin directory for setup, testing and run the program
<ol>
    <li>
        ```
        ./bin/setup
        ```
        <p>./bin/setup is a executable script for install dependencies and compile the code and then run ruby unit test suite</p>
    </li>
    <li>
        ```
        ./bin/run_functional_tests
        ```
        <p>./bin/run_functional_tests is a executable script for run ruby unit test suite</p>
    </li>
    <li>
        ```
        ./bin/parking_lot
        //or
        ./bin/parking_lot [filename] 
        ```
        <p>./bin/parking_lot or ./bin/parking_lot [filename] is a executable script for runs the program and takes an input file as an argument</p>
    </li>
</ol>

## Usage
<ol>
    <li>
        <b>Build</b>
        <p>`./bin/setup`</p>
    </li>
    <li>
        <b>Run Ruby functional specs</b>
         <p>`./bin/run_functional_tests`</p>
    </li>
    <li>
        <b>Run Program</b>
        <ul>
            <li>File input mode: `./bin/parking_lot file_inputs.txt`</li>
            <li>Interactive mode: `./bin/parking_lot`</li>
        </ul>
    </li>
    <p>If executable script not run please input `command chmod +x [script file]` in terminal. Then run again</p>
</ol>


