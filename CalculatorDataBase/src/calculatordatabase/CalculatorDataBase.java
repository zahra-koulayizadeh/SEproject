/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatordatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Zahra
 */
/*
    A class which stores the results of the calculation in a file,
    and read from that file when is needed.
    This class has 2 methods. One for writring in file, the other for reading
    from it.
*/
public class CalculatorDataBase {

    static String output = "./result.txt"; //filename which the results will be stored.
    static BufferedWriter writer; //writer to the file.
    static BufferedReader reader ; //reader from file.

    public void WriteHistory(String Answer) throws IOException {
        /*
            Recieves a string as a result of the calculation
            and stores it in a specific file.
        */  
        writer = new BufferedWriter(new FileWriter(output));
        writer.write(Answer);
        writer.write("\n"); //for going to the first line of the next line.
        writer.close(); //closing writer after we are done.
    }
    

    public ArrayList<String> ReadHistory() throws IOException {
        /*
            A method for reading from the file and returning the results
            which are stored.
        */
        
        //We store the strings we had read from the file to this ArrayList
        //and return this after we read from the file.
        ArrayList<String> History = new ArrayList<>(); 
        reader = new BufferedReader(new FileReader(output));
        String line = ""; //each line that we read from the file. in each iteration.
        boolean IsFileFinished = false; //a flag for showing if we reached to the end of the file.
        while (!IsFileFinished) { //iteration over file until we reach the last line.
            line = reader.readLine();
            if (line == null) {
                break;
            }
            History.add(line);
        }
        reader.close(); //closing reader.
        return History;
    }
}
