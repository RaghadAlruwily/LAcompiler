package lacompiler;
import java.util.*;
public class LACompiler {
    public static String ID(String s){
		//char[] letter={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
		//	'w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
		//	'W','X','Y','Z'};
		//int[] digit={0,1,2,3,4,5,6,7,8,9};
		String ns=s;
		String str="";
		//char[] ch=new char[s.length()];
      //  for(int i=0;i<s.length();i++)
			//ch[i]=s.charAt(i);

		for(int i=0;  i<s.length() ;i++){
			if(s.charAt(i)>='\u0041'&& s.charAt(i)<='\u005A'|| s.charAt(i)>='\u0061'&& s.charAt(i)<='\u007A'){
			     str+=s.charAt(0);//System.out.print("<letter> ");
				break;}
			else if(s.charAt(i)>='\u0030'&& s.charAt(i)<='\u0039'){
			      //System.out.print("not accepted pattern : wrong symbol in the beginning\"digit\"\n");
			       return ns;}
		    else if( '\u0041'>s.charAt(i) || '\u007A'<s.charAt(i) ){ 
				//System.out.print("not accepted pattern : wrong symbol in the beginning\"symbol\"\n");
			       return ns;
			}
			else if('\u005A'<s.charAt(i) && '\u0061'>s.charAt(i) ){
                 //System.out.print("not accepted pattern : wrong symbol in the beginning\"symbol\"\n");
			       return ns;
			}
			else
				continue;
		}
			    
        boolean r=false;
		for(int i=1;i<s.length();i++){
				if(s.charAt(i)>='\u0041'&& s.charAt(i)<='\u005A'|| s.charAt(i)>='\u0061'&& s.charAt(i)<='\u007A'){
					 str+=s.charAt(i);//System.out.print("<letter> ");
					r=true;
					continue;}
				else if(s.charAt(i)>='\u0030'&&s.charAt(i)<='\u0039'){//Integer.parseInt(String.valueOf(ch[i]))==digit[k]
                    str+=s.charAt(i);//System.out.print("<digit> ");
					r=true;
					continue;}
				else if(s.charAt(i)=='_'){
					r=true;
					str+=s.charAt(i);//System.out.print("<underscore> ");
					continue;}
				else if(s.charAt(i)==' ')
					return ns;
				else{
					if(i==s.length()){
					//System.out.print("not accepted pattern : wrong symbol\n");
					return ns;}
					else
						break;}

			
			
        }
			if(r)
				return str;//System.out.print("ID ");//continue;
			else{
				//System.out.print("not accepted pattern : wrong symbol\n");
					return ns;}

}//method
   public static void INT(String s){
        int[] digit={0,1,2,3,4,5,6,7,8,9};
        int countNo=0;

		int len=s.length();
		for(int i=0; i<len; i++){
			int c=(Character.valueOf(s.charAt(i)))%48;
			for(int j=0; j<digit.length;j++){
				
				char ch=s.charAt(i);
				//System.out.print(ch+" ");
				//System.out.print(((Object)c).getClass().getSimpleName()+" char: "+((Object)ch).getClass().getSimpleName());
		    	if(c==digit[j]){
					countNo++;
					//System.out.print(" <digit,"+digit[j]+">");
					continue;
				}
				
			} if(countNo==0){
			//System.out.println(" error: not accepted number");
			return;}
			
		}
		System.out.print("INT ");

}//method
    public static void STR(String s){
		if(s.charAt(0)=='"' && s.charAt(s.length()-1)=='"'){
			for(int i=1; i<s.length()-1; i++){
				if(s.charAt(i)>='\u0041'&& s.charAt(i)<='\u005A'|| s.charAt(i)>='\u0061'&& s.charAt(i)<='\u007A')
					continue;
				else{
					//System.out.print("unexpected input\t");
					return;
				}
			}
		
		}
		else
			return;

		System.out.print("STR ");
    

}//method

    public static void SYM(String s){
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)=='<'){
				if(s.charAt(i+1)=='>'||s.charAt(i+1)=='='){
				System.out.print("SYM ");
				i+=2;}
	            else
					System.out.print("SYM ");
				break;
				}
		    if(s.charAt(i)=='>'){
				if(s.charAt(i+1)=='='){
					System.out.print("SYM ");
					i+=2;}
				else
					System.out.print("SYM ");
				break;
			}
			if(s.charAt(i)==':'){
				if(s.charAt(i+1)=='='){
					System.out.print("SYM ");
					i+=2;}
				else
					System.out.print("SYM ");
				break;
			}
			if(s.charAt(i)=='.'){
				if(s.charAt(i)=='.'){
					System.out.print("SYM ");
					i+=2;}
				else
					System.out.print("SYM ");
				break;
			}
			if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)==','||s.charAt(i)=='='||s.charAt(i)==';'||s.charAt(i)=='('||
				s.charAt(i)==')'||s.charAt(i)=='['||s.charAt(i)==']')
				System.out.print("SYM ");
		}

	}
    public static void WS(String s){
		int count=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '||s.charAt(i)=='\t'||s.charAt(i)=='\n'){
				//System.out.print("WS ");
				break;}
			if(s.charAt(i)=='\\' )
				if(s.charAt(i+1)=='t' ||s.charAt(i+1)=='n'){
				    System.out.print("WS ");
				     count++;
					 break;}
			//else
				//return;
			}
		if(count==0)
			return;
		
	}

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		//System.out.print("Enter a string : \n");
		//String  str=in.nextLine();
		//System.out.print("\\u"+Integer.toHexString(' '|0x1000).substring(1));
                System.out.println('\u0020');
		


		

	}
    
}
