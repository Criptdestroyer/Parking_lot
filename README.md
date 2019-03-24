# Parking Lot v1.4.2 - GO_SQUADS TECH 3.0
### Author: Ahmad Emir Alfatah
<hr>
This is my solution for Parking Lot program assignment (<a>Parking Lot v.1.4.2.pdf</a>)

## Requirements
- JDK 8 or above
- Maven 3.5.3 or above // build tool
- Ruby // for Ruby functional specs

## Bin directory
In Parking_lot root directory has a bin directory for setup, testing and run the program
1. ```./bin/setup``` is a executable script for install dependencies and compile the code and then run ruby unit test suite
2. ```./bin/run_functional_tests``` is a executable script for run ruby unit test suite
3. ```./bin/parking_lot```
        or
    ```./bin/parking_lot [filename]``` is a executable script for runs the program and takes an input file as an argument

## Usage
#### Build
```./bin/setup```
#### Run Ruby functional specs
```./bin/run_functional_tests```
#### Run Program
File input mode:
```./bin/parking_lot file_inputs.txt```
Interactive mode:
```./bin/parking_lot```

If executable script not run please input ```command chmod +x [script file]``` in terminal. Then run again
