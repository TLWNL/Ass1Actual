

import java.util.Scanner;
import java.util.regex.Pattern;

public class Identifier implements IdentInterface {
	
	private StringBuffer sb = new StringBuffer();


	public Identifier(){
	    StringBuffer ident = new StringBuffer("A");
	}

	public Identifier(Identifier src){
        StringBuffer foundIdentString = new StringBuffer(this.sb);
        Identifier foundIdent = new Identifier();
        for(int i = 0; i< foundIdentString.length(); i++){
            foundIdent.add(foundIdentString.charAt(i));
        }
    }


    public void add(char c){
		sb.append(c);
	}

	public void initIdent(){
		sb.append("A");
	}

	public void remove(int i){
		sb.deleteCharAt(i);
	}

	// ! NOT SURE ABOUT THIS ONE, I BELIEVE IT SHOULD RETURN A RANDOM ELEMENT BUT HOW DOES THAT WORK FOR IDENTS !
    public Identifier getIdent(){
	    return this;
    }

    public StringBuffer convertToSb(){
	    StringBuffer convertedIdentifier = new StringBuffer();
	    for(int i = 0; i<sb.length(); i++){
	        convertedIdentifier.append(sb.charAt(i));
        }
        return convertedIdentifier;
    }


}