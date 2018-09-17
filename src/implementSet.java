

public class implementSet implements SetInterface {

    public void InitSet(){

    }


    public void parseSet(StringBuffer in, StringBuffer arrayDest){

    }

    public void difference(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2){
        StringBuffer differenceString = new StringBuffer("{");
        boolean intersectFound;

        for(int i = 0; i<arrayInput1.length;i++){
            intersectFound = false;
            for(int j = 0 ; j<arrayInput2.length; j++){
                if((arrayInput1[i].toString()).equals((arrayInput2[j].toString()))){
                    intersectFound = true;
                }
            }
            if(!intersectFound){
                differenceString.append(arrayInput1[i]);
                differenceString.append(", ");
            }
        }

        for(int k = 0; k<arrayInput2.length;k++){
            intersectFound = false;
            for(int l = 0; l<arrayInput1.length;l++){
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

    public void intersection(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2){
        StringBuffer intersectionString = new StringBuffer("{");

        for(int i = 0; i<arrayInput1.length; i++){
            for(int j = 0; j<arrayInput2.length; j++){
                if((arrayInput1[i].toString()).equals((arrayInput2[j].toString()))){
                    intersectionString.append(arrayInput1[i]);
                    intersectionString.append(", ");
                }
            }
        }

        if(intersectionString.length() != 1)
            intersectionString.delete(intersectionString.length() - 2 ,intersectionString.length());
        intersectionString.append("}");

        System.out.printf("intersection = %s\n", intersectionString);
    }

    public void union(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2){

    }

    public void symmetricDifference(StringBuffer[] arrayInput1, StringBuffer[] arrayInput2){

    }

}
