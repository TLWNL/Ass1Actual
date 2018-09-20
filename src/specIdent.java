import java.util.Scanner;

interface IdentInterface{
    /*
     * Elements: characters of type Char
     * Structure: linear
     * Domain: ??
     *
     * constructors
     *
     * CreateIdent(StringBuffer toIdent);
     * PRE -
     * POST - A new Identifier-object has been created
     *
     * CopyIdent(Identifier toCopy);
     * PRE -
     * POST - A copy of the Identifier-object has been created
     */

    Identifier CreateIdent(StringBuffer toIdent);

    Identifier CopyIdent(Identifier toCopy);


    void initIdent();
    /*
     * PRE -
     * POST - The identifier is empty
     */

    void parseIdent(Scanner in, StringBuffer dest);
    /*
     * PRE -
     * POST - The identifier has been filled with data
     */

    char nextChar(Scanner in);
    /*
     * PRE -
     * POST - The next character is read and returned
     */

    boolean nextCharIs(Scanner in, char c);
    /*
     * PRE -
     * POST - TRUE: The next character is equal to the character in parameter
     *        FALSE: The next character is not equal to the character in parameter
     */

    boolean nextCharIsDigit(Scanner in);
    /*
     * PRE -
     * POST - TRUE: The next character is a digit
     *        FALSE: The next character is not a digit
     */

    StringBuffer[] stringParser(Scanner in);
    
    int counterCounter (StringBuffer[] in);

}