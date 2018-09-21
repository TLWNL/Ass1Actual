
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Assignment1 {

    static final int MAX_NUMBER_OF_ELEMENTS = 10;

    PrintStream out;
    
    public static void main(String[] args) {
    	new Assignment1().start();
    }

    boolean askBothSets (Scanner input, Set set1, Set set2) {
        return askSet(input, "Give first set : ", set1) &&
               askSet(input, "Give second set : ", set2);
    }
    
    boolean askSet (Scanner input, String question, Set set) {
        do {
            System.out.printf("%s", question);
            if (! input.hasNextLine()) {
                out.printf("\n"); // otherwise line with ^D will be overwritten
                return false;
            }
        } while (! inputContainsCorrectSet(input, set));
        return true;
    }


    void start () {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("");
        Set set1 = new Set(),
            set2 = new Set();
        
        while (askBothSets(in, set1, set2)) {
            calculateAndGiveOutput(set1, set2);
            
        }
    }
    
    boolean inputContainsCorrectSet (Scanner input, Set set) {

        StringBuffer arrayInput = new StringBuffer();
        int checker = 0;
        int numOfElements = 0;
        if (nextChar(input) ==  '{'){
            
            do {
                Identifier idento = new Identifier(arrayInput);
                idento.initIdent('A');

                if(nextCharIs(input, ' ')){
                	set.add(idento);
                	nextChar(input);
                    checker = 1;
                    numOfElements++;
                }
                else if (nextCharIsLetter(input)) {
                    checker = 0;
                    if(numOfElements == 0){
                        idento.add(nextChar(input));
                        //removes the garbage value
                        idento.remove(0);
                    }
                    else{
                        idento.add(nextChar(input));
                    }

                    
                }
                else if (nextCharIsDigit(input) && checker != 1) {
                    idento.add(nextChar(input));
                }
                else {
                    numOfElements++;
                    System.out.println("Input invalid, error detected at element number " + numOfElements);
                    input.nextLine();
                    return false;
                }
            }while (!nextCharIs(input, '}'));
            nextChar(input);
            if (nextCharIsDigit(input) || nextCharIsLetter(input) || nextCharIs(input, ' ')) {
            	System.out.println("Input invalid, characters after } detected");
            	input.nextLine();
            	return false;
            }
        }
        else {
        	input.nextLine();
        	return false;
        }
        System.out.println("entered auth");
        input.nextLine();
        return true;

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
    
    public void calculateAndGiveOutput (Set set1, Set set2) {
    	
    }
}

