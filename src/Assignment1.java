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
        int checker = 0;
        boolean identifierRead = false;
        boolean exitCondition = true;

        if (nextChar(input) ==  '{'){
            Identifier ident = new Identifier();

            if(nextCharIs(input, ' '))      // Skips space right after '{'
                nextChar(input);

            do {
                // Add Identifier to set
                if(nextCharIs(input, ' ')){
                   if(!identifierRead){
                       nextChar(input);
                   }
                    else if(set.dupChecker(ident)) {
                        set.add(ident);
                        nextChar(input);
                        checker = 1;
                        identifierRead = false;
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
                    identifierRead = true;
                    checker = 2;
                    ident.add(nextChar(input));
                }
                else if (nextCharIsDigit(input) && checker != 1) {
                    identifierRead = true;
                    ident.add(nextChar(input));
                }
                else if(nextCharIs(input, '}')) {
                	exitCondition = false;
                }
                else {
                    System.out.println("Input invalid, error detected");
                    input.nextLine();
                    set.initSet();
                    return false;
                }
            } while(exitCondition);
            if(set.dupChecker(ident)) {
                if(checker != 0) {
                    if(identifierRead){
                        set.add(ident);
                        nextChar(input);
                    }
                }
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
        Set differenceSet = set1.difference(set2);
        System.out.printf("difference = ");
        differenceSet.printSet();
        Set intersectionSet = set1.intersection(set2);
        System.out.printf("intersection = ");
        intersectionSet.printSet();
        Set unionSet = set1.union(set2);
        System.out.printf("union = ");
        unionSet.printSet();
        System.out.printf("sym. dif. = ");
        Set symdifSet = set1.symmetricDifference(set2);
        symdifSet.printSet();
        set1.initSet();
        set2.initSet();
    }
}
