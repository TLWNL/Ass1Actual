public class Set implements SetInterface {

    private static final int MAX_NUM_OF_ELEMENTS = 10;
    private int size;
    private Identifier[] set;
    
	public Set(){
        this.set = new Identifier[MAX_NUM_OF_ELEMENTS];
    }

    public Set(Set src) {
        int i = 0;

        while (this.set[i] != null) {
            this.set[i] = src.set[i];
            i++;
        }
    }
    

	public boolean dupChecker(Identifier src) {
    	
    	for(int i = 0; i<size; i++) {
    		if((src.getIdent().toString()).equals(this.get(i).toString())) {
    			return false;
    		}
    		else {
    	    	return true;
    		}
    	}
    	return true;
    }
	
	public void initSet() {
        this.set = null;
        this.set = new Identifier[MAX_NUM_OF_ELEMENTS];
        this.size = 0;
	}

	public void add(Identifier a) {
		this.set[size] = a;
		size++;
	}

	public int size(){
	    return size;
    }

	public StringBuffer get(int i) {
		StringBuffer sb2 = new StringBuffer(set[i].getIdent());
		
		return sb2;
	}

    public void printSet(){
	    StringBuffer sb = new StringBuffer("{");
        int i = 0;

	    while(this.set[i]!=null){
	        System.out.println(this.get(i));
            sb.append(this.get(i).toString());
            sb.append(" ");
            i++;
        }

        // removes the last space
        sb.deleteCharAt(sb.length()-1);
	    sb.append("}");

	    System.out.printf("%s\n", sb);
    }
	
    public Set difference(Set set2){

        Set differenceSet = new Set();
        int difSetCounter = 0;
        boolean intersectFound;

        for(int i = 0; i<this.size;i++){
            intersectFound = false;
            for(int j = 0 ; j<set2.size(); j++){
                // !!! RIGHT HERE IS WHERE THE 'BUG' HAPPENS, IT OUTPUTS MEMORY LOCATION INSTEAD OF STRING REP
                if((this.get(i).toString()).equals((set2.get(j).toString()))){
                	
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                /*differenceSet.set[difSetCounter] = new Identifier(this.set[i]);
                difSetCounter++;
                differenceSet.set[difSetCounter] = new Identifier(set2.set[i]);
                difSetCounter++;*/
            	Identifier A = new Identifier(get(i));
            	differenceSet.set[difSetCounter] = A;
            	difSetCounter++;
            }
        }
        
        for(int k = 0; k<set2.size;k++){
            intersectFound = false;
            for(int l = 0 ; l<this.size(); l++){
                // !!! RIGHT HERE IS WHERE THE 'BUG' HAPPENS, IT OUTPUTS MEMORY LOCATION INSTEAD OF STRING REP
                if((this.get(l).toString()).equals((set2.get(k).toString()))){
                	
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                /*differenceSet.set[difSetCounter] = new Identifier(this.set[i]);
                difSetCounter++;
                differenceSet.set[difSetCounter] = new Identifier(set2.set[i]);
                difSetCounter++;*/
            	Identifier A = new Identifier(set2.get(k));
            	differenceSet.set[difSetCounter] = A;
            	difSetCounter++;
            }
        }
        return differenceSet;
    }

    public StringBuffer[] intersection(Set set2){
        StringBuffer intersectionString = new StringBuffer("{");
        StringBuffer[] intersectArray = new StringBuffer[10];
        int arrayCounter=0;
            for(int i = 0; i<size;i++){
                for(int j = 0; j<set2.size();j++){
                if((this.set[i].toString()).equals((set2.set[j].toString()))){
                    //intersectionString.append(get(i));
                    //intersectArray[arrayCounter] = get(i);
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
                //if((get(i).toString()).equals((set2.get(j).toString()))){
                    //intersectFound = true;
                //}
            }
            if(!intersectFound) {
               // unionString.append(get(i));
                unionString.append(" ");
            }
        }

        for(int k=0;k<set2.size();k++){
                //unionString.append(set2.get(k));
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
            //System.out.printf("Size of Intersection is: %d", intersectArrayLength);

        }

        for(int j = 0; j<size;j++){
            boolean intersectFound = false;
            for(int k = 0; k<intersectArrayLength;k++){
                //if(get(j).toString().equals(intersectArray[k].toString())){
                //    intersectFound = true;
                //}
            }
                        if(!intersectFound){
               // symmetricDifferenceString.append(get(j));
                symmetricDifferenceString.append(" ");
            }
        }
        for(int l = 0; l<set2.size();l++){
            boolean intersectFound = false;
            for(int m = 0; m<intersectArrayLength;m++){
               // if(set2.get(l).toString().equals(intersectArray[m].toString())){
               //     intersectFound = true;
               //}
            }
            if(!intersectFound){
                //symmetricDifferenceString.append(set2.get(l));
                symmetricDifferenceString.append(" ");
            }
        }

        if(symmetricDifferenceString.length() != 1)
            symmetricDifferenceString.delete(symmetricDifferenceString.length() - 1,symmetricDifferenceString.length());
        symmetricDifferenceString.append("}");

        System.out.printf("sym. difference = %s\n" , symmetricDifferenceString);

    }

}
