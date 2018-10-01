import java.util.Scanner;

interface SetInterface {
    /*
     * Elements: identifiers of the type Identifier
     * Structure: linear
     * Domain: 0 to 20 elements
     *
     * Constructors
     *
     * InitSet();
     * @precondition -
     * @@postcondition - A new Set-object has been created and contains the empty set
     *
     * Set(Set src);
     * @precondition -
     * @postcondition - A new Set-object has been created and contains a copy of src
     */


    void initSet();
    /*
     * @precondition -
     * @postcondition - The set has been emptied
     */

    void add(Identifier a);
    /* CHANGE TO BOOLEAN
     * @precondition -
     * @postcondition - TRUE: Identifier a has been added to the set
     *                  FALSE: Identifier a has not been added to the set
     */

    void printSet();
    /*
     * @precondition -
     * @postcondition - The Set has been printed out
     *
     */

    int size();
    /*
     * @precondition -
     * @postcondition - The size of the set has been returned
     */

    void remove(int i);
    /* CHANGE TO BOOLEAN
     * @precondition -
     * @postcondition - The element at index i of the set has been removed
     */

    boolean isEmpty();
    /*
     * @precondition -
     * @postcondition - TRUE: The set is empty
     *        FALSE: The set is not empty
     */

    //StringBuffer get(int i);
    /*
     * @precondition -
     * @postcondition - Returns element i of the set in the form of a StringBuffer
     */

    Set difference(Set set2);
    /*
     * @precondition -
     * @postcondition - The difference between Set 1 and Set 2 has been calculated, formatted and printed
     */

    Set intersection(Set set2);
    /*
     * @precondition -
     * @postcondition - The intersection between Set 1 and Set 2 has been calculated, formatted and printed
     */

    Set union(Set set);
    /*
     * @precondition -
     * @postcondition - The union between Set 1 and Set 2 has been calculated, formatted and printed
     */

    Set symmetricDifference(Set set2);
    /*
     * @precondition -
     * @postcondition - The symmetric difference between Set 1 and Set 2 has been calculated, formatted and printed
     */

    public boolean dupChecker(Identifier src);
    /* CHANGE TO CONTAINS
     * @precondition -
     * @postcondition - TRUE: The identifiers are not duplicates
     *      - FALSE: The identifiers are duplicates
     */
}
