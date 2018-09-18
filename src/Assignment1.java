
import java.io.IOException;
import java.util.Scanner;
public class Assignment1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
        StringBuffer intersection = new StringBuffer();
        StringBuffer[] AB = new StringBuffer[10];
        IdentInterface ParserInterface = new implementIdent();
        SetInterface CalcInterface = new implementSet();

        /*AB = ParserInterface.stringParser(sc);
        System.out.println(AB[0]);
        System.out.println(AB[1]);
        System.out.println(AB[2]);*/

        StringBuffer[] A1 = {new StringBuffer("ape"),
                             new StringBuffer("nut"),
                             new StringBuffer("mouse"),
                             new StringBuffer("mouse2")};

        StringBuffer[] A2 = {new StringBuffer("eel"),
                             new StringBuffer("w"),
                             new StringBuffer("xyz"),
                             new StringBuffer("nut")};
        CalcInterface.intersection(A1, A2);
        CalcInterface.difference(A1,A2);
        CalcInterface.union(A1,A2);
        CalcInterface.symmetricDifference(A1,A2);




    }
}
