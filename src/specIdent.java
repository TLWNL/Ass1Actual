import java.util.Scanner;

interface IdentInterface{
    /*
     * Elements: characters of type Char
     * Structure: linear
     * Domain: Identifiers that begin with a letter and have a length of at least 1 character and all other characters
     * are alphanumeric
     *
     * constructors
     *
     * Identifier();
     * @precondition -
     * @postcondition - A new Identifier has been created that starts with a character A
     *
     * Identifier(Identifier src);
     * @precondition -
     * @postcondition - A deep copy of the src Identifier has been created
     */

    void initIdent();
    /*
     * @precondition -
     * @postcondition - The Identifier now contains the char "A"
     */

    void add(char c);
    /*
     * @precondition -
     * @postcondition - The char c has been added to the Identifier
     */

    void remove(int i);
    /*
     * @precondition -
     * @postcondition - The character at index i of the Identifier has been removed
     */

    String getIdent();
    /*
     * @precondition -
     * @postcondition - The identifier has been returned
     */

    // ADD .EQUAlS FUNCTIOn
    // ADD SIZE FUNCTION

    int size();
    /*
     * @precondition -
     * @postcondition - The size of the identifier has been returned
     */

    boolean equals(Identifier identifier2);
    /*
     * @precondition -
     * @postcondition - TRUE: The two identifiers are the same
     *                  FALSE: The two identifiers are not the same
     */

}
