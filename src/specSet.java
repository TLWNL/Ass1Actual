import java.util.Scanner;

interface SetInterface {
    /*
     * Elements: identifiers of the type StringBuffer
     * Structure: linear
     * Domain: 0 to 20 elements
     *
     * Constructors
     *
     * InitSet();
     * PRE -
     * POST - A new Set-object has been created and contains the empty set
     *
     * InitSet (InitSet src);
     * PRE -
     * POST - A new Set-object has been created and contains a copy of src
     */


    void add(Identifier a);
    /*
     * PRE -
     * POST - Identifier a has been added to the set
     */

    int size();
    /*
     * PRE -
     * POST - The size of the set has been returned
     */

    void difference(Set set1, Set[] set2);
    /*
     * PRE -
     * POST - The difference between Set 1 and Set 2 has been calculated, formatted and printed
     */

    StringBuffer[] intersection(Set set1, Set[] set2);
    /*
     * PRE -
     * POST - The intersection between Set 1 and Set 2 has been calculated, formatted and printed
     */

    void union(Set set1, Set[] set2);
    /*
     * PRE -
     * POST - The union between Set 1 and Set 2 has been calculated, formatted and printed
     */

    void symmetricDifference(Set set1, Set[] set2);
    /*
     * PRE -
     * POST - The symmetric difference between Set 1 and Set 2 has been calculated, formatted and printed
     */


}

