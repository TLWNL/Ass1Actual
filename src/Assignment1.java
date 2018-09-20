
import java.io.IOException;
import java.util.Scanner;
public class Assignment1 {

    public static void main(String[] args) {

        StringBuffer[] A1 = new StringBuffer[10];
        StringBuffer[] A2 = new StringBuffer[10];

        IdentInterface ParserInterface = new implementIdent();
        SetInterface CalcInterface = new implementSet();
        
        Scanner sc1 = new Scanner(System.in);
        sc1.useDelimiter("");


        A1 = ParserInterface.stringParser(sc1);
        int A1Counter = ParserInterface.counterCounter(A1);
        
        Scanner sc2 = new Scanner(System.in);
        sc2.useDelimiter("");
        A2 = ParserInterface.stringParser(sc2);
        int A2Counter = ParserInterface.counterCounter(A2);
        /*System.out.println(AB[0]);
        System.out.println(AB[1]);
        System.out.println(AB[2]);

        StringBuffer[] A1 = {new StringBuffer("eel"),
                             new StringBuffer("nut"),
                             new StringBuffer("mouse"),
                             new StringBuffer("mouse2")};

        StringBuffer[] A2 = {new StringBuffer("eel"),
                             new StringBuffer("w"),
                             new StringBuffer("xyz"),
                             new StringBuffer("nut")};*/
        CalcInterface.intersection(A1, A2, A1Counter, A2Counter);
        CalcInterface.difference(A1,A2, A1Counter, A2Counter);
        CalcInterface.union(A1,A2, A1Counter, A2Counter);




    }
}
