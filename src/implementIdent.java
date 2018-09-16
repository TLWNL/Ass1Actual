import java.util.Scanner;
import java.util.regex.Pattern;

public class implementIdent {

        // Initializes a StringBuffer
        public static void initIdent(){

        }

        public static void firstCharCheck(Scanner in){
            if(nextChar(in) != '{'){
                //Throw an error
            }

        }
        // Reads char for char using Scanner, until space has been read.
        // Parses read data into a StringBuffer
        public static void parseIdent(Scanner in, StringBuffer dest)
        {
            // Check if the first character that is to be read is a number
            if(dest.length() == 0 && nextCharIsDigit(in)){
                // Throw an error
            }

            while(!nextCharIs(in, ' ')){
                dest.append(nextChar(in));
            }
        }

        // Method to read 1 character
        public static char nextChar(Scanner in){
            return in.next().charAt(0);
        }

        // Method to check if the next character to be read when
        // calling nextChar() is equal to the provided character.
        public static boolean nextCharIs(Scanner in, char c){
            return in.hasNext(Pattern.quote(c+""));
        }

        // Method to check if the next character to be read when
        // calling nextChar() is a digit
        public static boolean nextCharIsDigit(Scanner in){
            return in.hasNext("[0-9]");
        }
}