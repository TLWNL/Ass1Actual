import java.util.Scanner;

interface IdentInterface{
    /*
     * Elements: characters of type Char
     * Structure: linear
     * Domain: Identifiers that begin with a letter and have a length of at least 1 character
     *
     * constructors
     *
     * Identifier(StringBuffer sb);
     * PRE -
     * POST - A new Identifier has been created
     *
     * CopyIdentifier(Identifier src);
     * PRE -
     * POST - A copy of the src Identifier has been created
     */

    void initIdent(char c);
    /*
     * PRE -
     * POST - The StringBuffer now contains character c
     */


    void add(char c);
    /*
     * PRE -
     * POST - The char c has been added to the destination StringBuffer
     */

    void remove(int i);
    /*
     * PRE -
     * POST - The character at index i of the StringBuffer has been removed
     */




    

}