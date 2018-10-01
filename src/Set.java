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
    	
    	for(int i = 0; i<this.size; i++) {
    		if((src.getIdent()).equals(this.getIndentValue(i).toString())) {
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

    public boolean isEmpty(){
	    if(this.size == 0)
	        return true;
        else
	        return false;
    }

    public void remove(int i){
	    Identifier emptyIdent = new Identifier();
	    this.set[i] = emptyIdent;
    }

	public Identifier get() {
		return set[0];
	}
	
	private StringBuffer getIndentValue(int i) {
		StringBuffer sb2 = new StringBuffer(set[i].getIdent());
		return sb2;
	}

	public void printSet(){
        StringBuffer sb = new StringBuffer("{");
        int i = 0;

        while(this.set[i]!=null){
            sb.append(this.getIndentValue(i).toString());
            sb.append(" ");
            i++;
        }

        if(sb.length() > 1)
            sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        System.out.printf("%s\n", sb);
    }
	
    public Set difference(Set set2){
        Set differenceSet = new Set();
        boolean intersectFound;

        for(int i = 0; i<this.size;i++){
            intersectFound = false;
            for(int j = 0 ; j<set2.size(); j++){
                if((this.getIndentValue(i).toString()).equals((set2.getIndentValue(j).toString()))){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
            	Identifier A = new Identifier(getIndentValue(i));
            	differenceSet.add(A);
            }
        }
        
        for(int k = 0; k<set2.size;k++){
            intersectFound = false;
            for(int l = 0 ; l<this.size(); l++){
                if((this.getIndentValue(l).toString()).equals((set2.getIndentValue(k).toString()))){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
            	Identifier A = new Identifier(set2.getIndentValue(k));
            	differenceSet.add(A);
            }
        }
        return differenceSet;
    }

    public Set intersection(Set set2){
        Set intersectionSet = new Set();
            for(int i = 0; i<this.size;i++){
                for(int j = 0; j<set2.size();j++){
                    if((this.getIndentValue(i).toString()).equals((set2.getIndentValue(j).toString()))){
                        Identifier A = new Identifier(this.getIndentValue(i));
                        intersectionSet.add(A);
                    }
                }
            }
        return intersectionSet;
    }

    public Set union(Set set2){
        Set unionSet = new Set();
        boolean intersectFound;
        for(int i = 0; i<this.size;i++){
            intersectFound = false;
            for(int j = 0 ; j<set2.size(); j++){
                if((this.getIndentValue(i).toString()).equals((set2.getIndentValue(j).toString()))){
                    intersectFound = true;
                }
            }
            if(!intersectFound) {
               Identifier identFound = new Identifier(this.getIndentValue(i));
               unionSet.add(identFound);
            }
        }

        for(int k=0;k<set2.size();k++){
                Identifier identFound2 = new Identifier(set2.getIndentValue(k));
                unionSet.add(identFound2);
        }
        return unionSet;
    }

    public Set symmetricDifference(Set set2){
	    Set intersectSet = this.intersection(set2);
	    Set symdifSet = new Set();

        for(int j = 0; j<this.size;j++){
            boolean intersectFound = false;
            for(int k = 0; k<intersectSet.size;k++){
                if(this.getIndentValue(j).toString().equals(intersectSet.getIndentValue(k).toString())){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                Identifier foundIdent = new Identifier(this.getIndentValue(j));
                symdifSet.add(foundIdent);
            }
        }

        for(int l = 0; l<set2.size();l++){
            boolean intersectFound = false;
            for(int m = 0; m<intersectSet.size;m++){
               if(set2.getIndentValue(l).toString().equals(intersectSet.getIndentValue(m).toString())){
                    intersectFound = true;
               }
            }
            if(!intersectFound){
                Identifier foundIdent2 = new Identifier(set2.getIndentValue(l));
                symdifSet.add(foundIdent2);
            }
        }
        return symdifSet;
    }
}