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


    void difference(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2, int arrayInputer1Counter, int arrayInputer2Counter);
    /*
     * PRE -
     * POST - The difference between Set 1 and Set 2 has been calculated, formatted and printed
     */

    StringBuffer[] intersection(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2, int arrayInputer1Counter, int arrayInputer2Counter);
    /*
     * PRE -
     * POST - The intersection between Set 1 and Set 2 has been calculated, formatted and printed
     */

    void union(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2, int arrayInputer1Counter, int arrayInputer2Counter);
    /*
     * PRE -
     * POST - The union between Set 1 and Set 2 has been calculated, formatted and printed
     */

    void symmetricDifference(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2, int arrayInputer1Counter, int arrayInputer2Counter);
    /*
     * PRE -
     * POST - The symmetric difference between Set 1 and Set 2 has been calculated, formatted and printed
     */


}

