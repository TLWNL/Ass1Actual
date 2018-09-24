
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

        //StringBuffer arrayInput = new StringBuffer();
        int checker = 0;
        int numOfElements = 0;
        if (nextChar(input) ==  '{'){
            Identifier ident = new Identifier();
            do {
            	
                // Add Identifier to set
                if(nextCharIs(input, ' ')){
                	if(set.dupChecker(ident)) {
                        //ident.remove(0);                           //removes the garbage value
                    	set.add(ident);                               // Skip the space
                    	nextChar(input);

                    	// ! What is checker for? !
                        checker = 1;
                        numOfElements++;
                        ident = new Identifier();
                	}
                	else {
                		set.initSet();
                		System.out.println("Input invalid, error detected, duplicate identifier");
                		return false;
                	}
                }

                // Read character into identifier
                else if (nextCharIsLetter(input)) {
                    checker = 0;

                    if(numOfElements == 0){
                        //while(!nextCharIs(input, ' ')){         // Skip the spaces
                            ident.add(nextChar(input));
                        //}
                    }
                    else{
                        ident.add(nextChar(input));
                    }
                }
                // ??
                else if (nextCharIsDigit(input) && checker != 1) {
                    ident.add(nextChar(input));
                }
                else {
                    numOfElements++;
                    System.out.println("Input invalid, error detected");
                    input.nextLine();
                    set.initSet();
                    return false;
                }
            } while(!nextCharIs(input, '}'));
            if(set.dupChecker(ident)) {
                //ident.remove(0);                           //removes the garbage value
            	set.add(ident);                               // Skip the space
            	nextChar(input);

            	// ! What is checker for? !
                checker = 1;
                numOfElements++;
                ident = new Identifier();
        	}
        	else {
        		set.initSet();
        		System.out.println("Input invalid, error detected, duplicate identifier");
        		return false;
        	}
            if (nextCharIsDigit(input) || nextCharIsLetter(input) || nextCharIs(input, ' ')) {
            	System.out.println("Input invalid, characters after } detected");
            	input.nextLine();
            	set.initSet();
            	return false;
            }
        }
        else {
        	input.nextLine();
        	set.initSet();
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

        /*for (int i = 0; i< set1.size(); i++) {
    	System.out.println(set1.get(i));
    	}
    	for (int i = 0; i< set1.size(); i++) {
    	System.out.println(set2.get(i));
    	}*/
        Set differenceSet = set1.difference(set2);
        differenceSet.printSet();
        System.out.println("DONE\n");
        set1.initSet();
        set2.initSet();
        
        
    }
}

