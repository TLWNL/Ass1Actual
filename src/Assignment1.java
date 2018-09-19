
import java.io.IOException;
import java.util.Scanner;
public class Assignment1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
        StringBuffer intersection = new StringBuffer();
        StringBuffer[] A1 = new StringBuffer[10];
        IdentInterface ParserInterface = new implementIdent();
        SetInterface CalcInterface = new implementSet();

        A1 = ParserInterface.stringParser(sc);
        int A1Counter = ParserInterface.counterCounter(A1);
        /*System.out.println(AB[0]);
        System.out.println(AB[1]);
        System.out.println(AB[2]);

        StringBuffer[] A1 = {new StringBuffer("eel"),
                             new StringBuffer("nut"),
                             new StringBuffer("mouse"),
                             new StringBuffer("mouse2")};*/

        StringBuffer[] A2 = {new StringBuffer("eel"),
                             new StringBuffer("w"),
                             new StringBuffer("xyz"),
                             new StringBuffer("nut")};
        CalcInterface.intersection(A1, A2, A1Counter);
        CalcInterface.difference(A1,A2, A1Counter);
        CalcInterface.union(A1,A2, A1Counter);




    }
}
