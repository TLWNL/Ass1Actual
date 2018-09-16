import java.util.Scanner;
import java.util.regex.Pattern;

public class implementIdent implements IdentInterface {

        public void InitIdent(){

        }



        public void parseIdent(Scanner in, StringBuffer dest)
        {
            // Check if the first character that is to be read is a number
            if(dest.length() == 0 && nextCharIsDigit(in)){
                // Throw an error
            }

            while(!nextCharIs(in, ' ')){
                dest.append(nextChar(in));
            }
        }

        public char nextChar(Scanner in){
            return in.next().charAt(0);
        }


        public boolean nextCharIs(Scanner in, char c){
            return in.hasNext(Pattern.quote(c+""));
        }


        public boolean nextCharIsDigit(Scanner in){
            return in.hasNext("[0-9]");
        }
}