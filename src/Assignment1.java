
import java.io.IOException;
import java.util.Scanner;
public class Assignment1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
        StringBuffer[] AB = new StringBuffer[10];
        IdentInterface ParserInterface = new implementIdent();

        AB = ParserInterface.stringParser(sc);
        System.out.println(AB[0]);
        System.out.println(AB[1]);
        System.out.println(AB[2]);

    }
}
