

import java.util.Scanner;
import java.util.regex.Pattern;

public class implementIdent implements IdentInterface {

    public void initIdent(){
        StringBuffer identBuffer = new StringBuffer();
    }

    public int counterCounter (StringBuffer[] in) {
    	int counter = 0;
    	for(int i = 0; i<in.length;i++) {
    		if(in[i]!=null) {
    			counter++;
    		}
    	}
    	return counter;
    }
    
    public StringBuffer[] stringParser(Scanner in) {

        StringBuffer arrayInput = new StringBuffer();
        StringBuffer[] A = new StringBuffer[10];
        int checker = 0;
        int numOfElements = 0;
        if (nextCharIs(in, '{')){
            nextChar(in);
            nextChar(in);
            do {
                System.out.println("start of do");
                if(nextCharIs(in, ' ')){
                    System.out.println("1");
                    nextChar(in);
                    System.out.println(arrayInput);
                    A[numOfElements]= new StringBuffer (arrayInput);
                    arrayInput.delete(0, (arrayInput.length()));
                    checker = 1;
                    numOfElements++;
                }
                else if (nextCharIsLetter(in)) {
                    System.out.println("2");
                    checker = 0;
                    arrayInput.append(nextChar(in));
                }
                else if (nextCharIsDigit(in) && checker != 1) {
                    System.out.println("3");
                    arrayInput.append(nextChar(in));
                }
                else {
                    numOfElements++;
                    System.out.println("Input invalid, error detected at element number " + numOfElements);
                    break;
                }
            }while (!nextCharIs(in, '}'));
        }



        return A;
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