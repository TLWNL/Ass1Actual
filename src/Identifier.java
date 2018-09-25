

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
	
	public Identifier(StringBuffer sbr){
	    sb = new StringBuffer(sbr);
	}

	public void initIdent(){
		sb.append("A");
	}

    public void add(char c){
		sb.append(c);
	}



	public void remove(int i){
		sb.deleteCharAt(i);
	}

    public StringBuffer getIdent(){
	    return 	sb;
    }
}