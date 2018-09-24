import java.util.Scanner;

interface SetInterface {
    /*
     * Elements: identifiers of the type StringBuffer
     * Structure: linear
     * Domain: 0 to 10 elements
     *
     * Constructors
     *
     * InitSet();
     * PRE -
     * POST - A new Set-object has been created and contains the empty set
     *
     * Set(Set src);
     * PRE -
     * POST - A new Set-object has been created and contains a copy of src
     */


    void initSet();
    /*
     * PRE -
     * POST -
     */

    void add(Identifier a);
    /*
     * PRE -
     * POST - Identifier a has been added to the set
     */

    void printSet();
    /*
     * PRE -
     * POST - The Set has been printed out
     *
     */

    int size();
    /*
     * PRE -
     * POST - The size of the set has been returned
     */

    //StringBuffer get(int i);
    /*
     * PRE -
     * POST - Returns element i of the set in the form of a StringBuffer
     */

    Set difference(Set set2);
    /*
     * PRE -
     * POST - The difference between Set 1 and Set 2 has been calculated, formatted and printed
     */

    Set intersection(Set set2);
    /*
     * PRE -
     * POST - The intersection between Set 1 and Set 2 has been calculated, formatted and printed
     */

    Set union(Set set);
    /*
     * PRE -
     * POST - The union between Set 1 and Set 2 has been calculated, formatted and printed
     */

    Set symmetricDifference(Set set2);
    /*
     * PRE -
     * POST - The symmetric difference between Set 1 and Set 2 has been calculated, formatted and printed
     */

    public boolean dupChecker(Identifier src);
    /*
     * PRE -
     * POST - TRUE: The identifiers are not duplicates
     *      - FALSE: The identifiers are duplicates
     */

}

