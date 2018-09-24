

import java.util.Scanner;
import java.util.regex.Pattern;

public class Identifier implements IdentInterface {

    private StringBuffer sb;

    public Identifier(StringBuffer sb){
        StringBuffer ident = new StringBuffer(sb);
    }

    public void add(char c){
        sb.append(c);
    }

    public void initIdent(char c){
        sb.append(c);
    }

    public void remove(int i){
        sb.deleteCharAt(i);
    }

  /*
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
    */

}