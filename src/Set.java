

public class Set implements SetInterface {

    private static final int MAX_NUM_OF_ELEMENTS = 10;
    private int size;
    private Identifier[] set;
    
	public Set(){
        set = new Identifier[MAX_NUM_OF_ELEMENTS];
        size = 0;
    }

	public void add(Identifier a) {
		set[size] = a;
		size++;
	}

	public int size(){
	    return size;
    }

	
    public void difference(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2, int arrayInputer1Counter, int arrayInputer2Counter){
        StringBuffer differenceString = new StringBuffer("{");
        boolean intersectFound;

        for(int i = 0; i<arrayInputer1Counter;i++){
            intersectFound = false;
            for(int j = 0 ; j<arrayInputer2Counter; j++){
                if((arrayInput1[i].toString()).equals((arrayInput2[j].toString()))){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                differenceString.append(arrayInput1[i]);
                differenceString.append(", ");
            }
        }

        for(int k = 0; k<arrayInputer2Counter;k++){
            intersectFound = false;
            for(int l = 0; l<arrayInputer1Counter;l++){
                if((arrayInput2[k].toString()).equals(arrayInput1[l].toString()))
                    intersectFound = true;
            }
            if(!intersectFound){
                differenceString.append(arrayInput2[k]);
                differenceString.append(", ");
            }
        }

        if(differenceString.length() != 1)
            differenceString.delete(differenceString.length()-2, differenceString.length());
        differenceString.append("}");

        System.out.printf("difference = %s\n", differenceString);
    }

    public StringBuffer[] intersection(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2, int arrayInputer1Counter, int arrayInputer2Counter){
        StringBuffer intersectionString = new StringBuffer("{");
        StringBuffer[] intersectArray = new StringBuffer[10];
        int arrayCounter=0;

        for(int i = 0; i<arrayInputer1Counter; i++){
            for(int j = 0; j<arrayInputer2Counter; j++){
                if((arrayInput1[i].toString()).equals((arrayInput2[j].toString()))){
                    intersectionString.append(arrayInput1[i]);
                    intersectionString.append(", ");
                    intersectArray[arrayCounter] = arrayInput1[i];
                    arrayCounter++;
                }
            }
        }

        if(intersectionString.length() != 1)
            intersectionString.delete(intersectionString.length() - 2 ,intersectionString.length());
        intersectionString.append("}");

        System.out.printf("intersection = %s\n", intersectionString);
        return intersectArray;
    }

    public void union(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2, int arrayInputer1Counter, int arrayInputer2Counter){
        StringBuffer unionString = new StringBuffer("{");
        boolean intersectFound;
        for(int i = 0; i<arrayInputer1Counter;i++){
            intersectFound = false;
            for(int j = 0 ; j<arrayInputer2Counter; j++){
                if((arrayInput1[i].toString()).equals((arrayInput2[j].toString()))){
                    intersectFound = true;
                }
            }
            if(!intersectFound) {
                unionString.append(arrayInput1[i]);
                unionString.append(", ");
            }
        }

        for(int k=0;k<arrayInputer2Counter;k++){
                unionString.append(arrayInput2[k]);
                unionString.append(", ");
        }

        if(unionString.length() != 1)
            unionString.delete(unionString.length()-2, unionString.length());
        unionString.append("}");

        System.out.printf("union = %s\n", unionString);

    }

    public void symmetricDifference(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2, int arrayInputer1Counter, int arrayInputer2Counter){
        StringBuffer symmetricDifferenceString = new StringBuffer("{");
        int intersectArrayLength = 0;
        StringBuffer[] intersectArray = intersection(arrayInput1,arrayInput2,arrayInputer1Counter,arrayInputer2Counter);
        for(int i = 0; i<intersectArray.length;i++){
            if(intersectArray[i] != null)
                intersectArrayLength++;
        }

        for(int j = 0; j<arrayInputer1Counter;j++){
            boolean intersectFound = false;
            for(int k = 0; k<intersectArrayLength;k++){
                if(arrayInput1[j].toString().equals(intersectArray[k].toString())){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                symmetricDifferenceString.append(arrayInput1[j]);
                symmetricDifferenceString.append(", ");
            }
        }
        for(int l = 0; l<arrayInputer2Counter;l++){
            boolean intersectFound = false;
            for(int m = 0; m<intersectArrayLength;m++){
                if(arrayInput2[l].toString().equals(intersectArray[m].toString())){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                symmetricDifferenceString.append(arrayInput2[l]);
                symmetricDifferenceString.append(", ");
            }
        }

        if(symmetricDifferenceString.length() != 1)
            symmetricDifferenceString.delete(symmetricDifferenceString.length() - 2 ,symmetricDifferenceString.length());
        symmetricDifferenceString.append("}");

        System.out.printf("sym. difference = %s" , symmetricDifferenceString);

    }

}
