import java.util.Scanner;

interface IdentInterface{
    /*
     * Elements: characters of type Char
     * Structure: linear
     * Domain: Identifiers that begin with a letter and have a length of at least 1 character
     *
     * constructors
     *
     * Identifier();
     * PRE -
     * POST - A new Identifier has been created
     *
     * Identifier(Identifier src);
     * PRE -
     * POST - A copy of the src Identifier has been created
     */

    void initIdent();
    /*
     * PRE -
     * POST - The Identifier now contains the char "A"
     */

    void add(char c);
    /*
     * PRE -
     * POST - The char c has been added to the Identifier
     */

    void remove(int i);
    /*
     * PRE -
     * POST - The character at index i of the Identifier has been removed
     */

    Identifier getIdent();
    /*
     * PRE -
     * POST - The identifier has been returned
     */
}