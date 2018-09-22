

public class Set implements SetInterface {

    private static final int MAX_NUM_OF_ELEMENTS = 10;
    private int size;
    private Identifier[] set;
    
	public Set(){
        set = new Identifier[MAX_NUM_OF_ELEMENTS];
        size = 0;
    }
	
	public void initSet() {
		set = null;
		set = new Identifier[MAX_NUM_OF_ELEMENTS];
		size = 0;
	}

	public void CopySet(Set src){
	    this(src.set)
    }

	public void add(Identifier a) {
		set[size] = a;
		size++;
	}

	public int size(){
	    return size;
    }
	
	public StringBuffer get(int i) {
		StringBuffer sb = new StringBuffer(set[i].get());
		
		return sb;
	}


	
    public void difference(Set set2){
        StringBuffer differenceString = new StringBuffer("{");
        boolean intersectFound;

        for(int i = 0; i<size;i++){
            intersectFound = false;
            for(int j = 0 ; j<set2.size(); j++){
                if((get(i).toString()).equals((set2.get(j).toString()))){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                differenceString.append(get(i));
                differenceString.append(" ");
            }
        }
        /*
        for(int k = 0; k<set2.size();k++){
            intersectFound = false;
            for(int l = 0; l<size;l++){
                if((get(k).toString()).equals((set2.get(l).toString())))
                    intersectFound = true;
            }
            if(!intersectFound){
                differenceString.append(set2.get(k));
                differenceString.append(" ");
            }
        }
        */
        if(differenceString.length() != 1)
            differenceString.delete(differenceString.length()-1, differenceString.length());
        differenceString.append("}");

        System.out.printf("difference = %s\n", differenceString);
    }

    public StringBuffer[] intersection(Set set2){
        StringBuffer intersectionString = new StringBuffer("{");
        StringBuffer[] intersectArray = new StringBuffer[10];
        int arrayCounter=0;
            for(int i = 0; i<size;i++){
                for(int j = 0; j<set2.size();j++){
                if((get(i).toString()).equals((set2.get(j).toString()))){
                    intersectionString.append(get(i));
                    intersectArray[arrayCounter] = get(i);
                    arrayCounter++;
                }
            }
        }

        if(intersectionString.length() != 1)
            intersectionString.delete(intersectionString.length() ,intersectionString.length());
        intersectionString.append("}");

        System.out.printf("intersection = %s\n", intersectionString);
        return intersectArray;
    }

    public void union(Set set2){
        StringBuffer unionString = new StringBuffer("{");
        boolean intersectFound;
        for(int i = 0; i<size;i++){
            intersectFound = false;
            for(int j = 0 ; j<set2.size(); j++){
                if((get(i).toString()).equals((set2.get(j).toString()))){
                    intersectFound = true;
                }
            }
            if(!intersectFound) {
                unionString.append(get(i));
                unionString.append(" ");
            }
        }

        for(int k=0;k<set2.size();k++){
                unionString.append(set2.get(k));
                unionString.append(" ");
        }

        if(unionString.length() != 1)
            unionString.delete(unionString.length()-1, unionString.length());
        unionString.append("}");

        System.out.printf("union = %s\n", unionString);

    }

    public void symmetricDifference(Set set2){
        StringBuffer symmetricDifferenceString = new StringBuffer("{");
        int intersectArrayLength = 0;
        StringBuffer[] intersectArray = this.intersection(set2);
        for(int i = 0; i<intersectArray.length;i++){
            if(intersectArray[i] != null)
                intersectArrayLength++;
            System.out.printf("Size of Intersection is: %d", intersectArray);

        }

        for(int j = 0; j<size;j++){
            boolean intersectFound = false;
            for(int k = 0; k<intersectArrayLength;k++){
                if(get(k).toString().equals(intersectArray[k].toString())){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                symmetricDifferenceString.append(get(j));
                symmetricDifferenceString.append(" ");
            }
        }
        for(int l = 0; l<set2.size();l++){
            boolean intersectFound = false;
            for(int m = 0; m<intersectArrayLength;m++){
                if(this.get(l).toString().equals(intersectArray[m].toString())){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                symmetricDifferenceString.append(set2.get(l));
                symmetricDifferenceString.append(" ");
            }
        }

        if(symmetricDifferenceString.length() != 1)
            symmetricDifferenceString.delete(symmetricDifferenceString.length() - 1,symmetricDifferenceString.length());
        symmetricDifferenceString.append("}");

        System.out.printf("sym. difference = %s" , symmetricDifferenceString);

    }

}
