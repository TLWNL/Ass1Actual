import java.util.Scanner;
import java.util.regex.Pattern;

public class Identifier implements IdentInterface {



    public Identifier(StringBuffer sb){
        StringBuffer ident = new StringBuffer(sb);
    }

    public Identifier(){
        StringBuffer ident = new StringBuffer("wow");
    }

    public StringBuffer stringParser(Scanner in) {

        StringBuffer arrayInput = new StringBuffer();
        int checker = 0;
        int numOfElements = 0;
        if (nextCharIs(in, '{')){
            nextChar(in);
            nextChar(in);
            do {
                if(nextCharIs(in, ' ')){
                    arrayInput.append(nextChar(in));
                    checker = 1;
                    numOfElements++;
                }
                else if (nextCharIsLetter(in)) {
                    checker = 0;
                    arrayInput.append(nextChar(in));
                }
                else if (nextCharIsDigit(in) && checker != 1) {
                    arrayInput.append(nextChar(in));
                }
                else {
                    numOfElements++;
                    System.out.println("Input invalid, error detected at element number " + numOfElements);
                    break;
                }
            }while (!nextCharIs(in, '}'));
        }



        return arrayInput;
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

    boolean nextCharIsLetter(Scanner in) {
        return in.hasNext("[a-zA-Z]");
    }
}