import java.util.*;
class compiler 
{
	public static void ID(String s){
		char[] letter={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
			'w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
			'W','X','Y','Z'};
		int[] digit={0,1,2,3,4,5,6,7,8,9};
		
		char[] ch=new char[s.length()];
        for(int i=0;i<s.length();i++)
			ch[i]=s.charAt(i);

		for(int i=0, k=0;  i<letter.length ;k=(k++)%10,i++){
			if(ch[0]==letter[i]){
			     //System.out.print("<letter> ");
				 break;}
			else if(ch[0]>='\u0030'&&ch[0]<='\u0039'){
			      //System.out.print("not accepted pattern : wrong symbol in the beginning\"digit\"\n");
			       return;}
		    else if( '\u0041'>ch[0]  || '\u007A'<ch[0] ){ 
				//System.out.print("not accepted pattern : wrong symbol in the beginning\"symbol\"\n");
			       return;
			}
			else if('\u005A'<ch[0] && '\u0061'>ch[0] ){
                 //System.out.print("not accepted pattern : wrong symbol in the beginning\"symbol\"\n");
			       return;
			}
			else
				continue;
		}
			    
        boolean r=false;
		for(int i=1;i<ch.length;i++){
            for(int j=0, k=0;j<letter.length; k=(k++)%10, j++){
				if(ch[i]==letter[j]){
					//System.out.print("<letter> ");
					r=true;
					continue;}
				else if(ch[i]>='\u0030'&&ch[i]<='\u0039'){//Integer.parseInt(String.valueOf(ch[i]))==digit[k]
                    //System.out.print("<digit> ");
					r=true;
					break;}
				else if(ch[i]=='_'){
					r=true;
					//System.out.print("<underscore> ");
					break;}
				else{
					if(i==letter.length){
					//System.out.print("not accepted pattern : wrong symbol\n");
					return;}
					else
						continue;}

			}
			
        }
			if(r)
				System.out.print("ID ");//continue;
			else{
				//System.out.print("not accepted pattern : wrong symbol\n");
					return;}

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
				System.out.print("WS ");
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
		System.out.print("Enter a string : \n");
		String  str=in.nextLine();
		

		//System.out.print("Enter number/s : \n");
		//int no=in.nextInt();
		

        //System.out.print("Enter string : \n");
		//String str=in.nextLine();
		String s="";
		String accp="";
		for(int i=0; i<str.length();i++){
			if(str.charAt(i)=='"'){
			STR(str.substring(s.length(),str.length()));
			if(s.length()!=accp.length()){
				System.out.print("STR ");
				s=str.substring(i);
				accp+=s;
			}}
			else if(str.charAt(i)>='\u0041'&&str.charAt(i)<='\u005A'||str.charAt(i)>='\u0061'&&str.charAt(i)<='\u007A'){
			ID(str.substring(s.length(),str.length()));
			if(s.length()!=accp.length()){
				System.out.print("ID ");
				s=str.substring(i);
				accp+=s;
			}}
			else if(str.charAt(i)>='\u0030'&&str.charAt(i)<='\u0039')
		    INT(str.substring(s.length(),str.length()));
			if(s.length()!=accp.length()){
				System.out.print("INT ");
				s=str.substring(i);
				accp+=s;
			}
			else if(str.charAt(i)==' '||str.charAt(i)=='\t'||str.charAt(i)=='\n'){
			WS(str.substring(s.length(),str.length()));
			if(s.length()!=accp.length()){
				System.out.print("WS ");
				s=str.substring(i);
				accp+=s;
			}}
			else{
            SYM(str.substring(s.length(),str.length()));
			if(s.length()!=accp.length()){
				System.out.print("SYM");
				s=str.substring(i);
				accp+=s;
			}}
			
		}

		


		

	}
}
______________________________________________________________


%{#include<string.h>
enum{
LOOKUP=0,
VERB,
ADJ,
ADV,
NOUN,
PREP,
PRON,
CONJ};
int state;
int add_word(int type, char *word);
int lookup_word(char *word);
{state=LOOKUP;}/*end of line, return to default state */
^verb{state=VERB;}
^adj{state=ADJ;}
^adv{state=ADV;}
^noun{state=NOUN;}
^prep{state=PREP;}
^pron{state=PRON;}
^conj{state=CONJ;}
[a-zA-Z]+{
/*a normal word, define it or look it up*/
if(state!=LOOKUP){
/*define the current word*/
add_word(state,yytext);
}else{
switch(lookup_word(yytext)){
case VERB:printf("%s:adjective\n",yytext);break;
case ADV:printf("%s:adverb\n",yytext);break;
case NOUN:printf("%s:noun\n",yytext);break;
case PREP:printf("%s:preposition\n",yytext);break;
case PRON:printf("%s:pronoun\n",yytext);break;
case CONJ:printf("%s:conjunction\n",yytext);break;
default:printf("%s:don't recognize\n",yytext);break;
}
}
}
%}



--------------------------------------------
printf("-------SYMBOL TABLE-------\n");
if(ID){printf("index:",index,"\ttoken:ID\n");index++;}
if(INT){printf("index:",index,"\ttoken:INT\n");index++;}
if(SYM){printf("index:",index,"\ttoken:SYM\n");index++;}
if(ARITHMETIC){printf("index:",index,"\ttoken:ARITHMETIC\n");index++;}
if(ASSIGNMENT){printf("index:",index,"\ttoken:ASSIGNMENT\n");index++;}
if(KW){printf("index:",index,"\ttoken:KEYWORD\n");index++;}
if(UNARY){printf("index:",index,"\ttoken:UNARY\n");index++;}
if(RELATIONAL){printf("index:",index,"\ttoken:RELATIONAL\n");index++;}