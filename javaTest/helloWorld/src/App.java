import java.util.*;
   public class App {
    public static void main(String[] args) throws Exception {
  

String[] refTable={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","(",")","*",
"+",",","-",".","/"};
List<String> refTable1 = new ArrayList<>(Arrays.asList(refTable));


System.out.println("enter word");
Scanner sc=new Scanner(System.in);
String word = sc.nextLine();
String plaintiff = word.toUpperCase();

System.out.println(Arrays.toString(refTable));
//USER INPUTTING OFFSET CHARACTER
System.out.println("enter a character from the refTable" );
String chosen=sc.nextLine();
//Validating userinput with refTable
if(refTable1.contains(chosen)==false){
System.out.println("Character not found from the reference table");
}else{
//REORDERING THE ARRAY
String[] reordered = new String[44];

System.arraycopy(refTable, 0, reordered, 0, 44);
 int shift = Arrays.asList(refTable).indexOf(chosen);
 for(int i = 0; i < shift; i++){    
    int j;
    String last;  
    last = reordered[reordered.length-1];    
    for(j = reordered.length-1; j > 0; j--){    
        reordered[j] = reordered[j-1];    
    }
        reordered[0] = last;    
    }  


System.out.println("Choose 1 to encode or 2 to decode");
Integer choice=sc.nextInt();
if(choice==1){
    String actualAns=encode(plaintiff,refTable,reordered);
    System.out.println(actualAns);
}else{
    String actualAns=decode(plaintiff,refTable,reordered);
    System.out.println(actualAns);
}

}
    }

  public static String encode(String plaintiff,String[] refTable,String[] reordered){


    System.out.println("Encoding " + plaintiff);

    // for(int i=0; i<refTable.length;i++){
    //      reordered[i] = refTable[(shift+i)%refTable.length];
    // }


   // System.out.println(Arrays.toString(reordered));

    //TOTAL NUMBER OF CHARACTERS IN PLAINTIFF
    long totalCharacters = plaintiff.chars().count();
    //System.out.println(totalCharacters);
    Integer totalChar = (int) (long) totalCharacters;


 
    //LOOP TO CHANGE EVERY SINGLE WORD IN PLAINTIFF
    String[] ans = new String[totalChar];

for(int i=0;i<totalChar;i++){
    //PULLING OUT AN INDIVIDUAL CHARACTER FROM PLAINTIFF
String test=Character.toString(plaintiff.charAt(i));
if(test.equals(" ")){
    ans[i]=" ";
}else{
    //Cross reference the index of character from refTable to reordered
int aB=Arrays.asList(refTable).indexOf(test);
ans[i]=reordered[aB];
}
}

//System.out.println(Arrays.toString(ans));

String actualAns="";
for(int i=0;i<ans.length;i++){
actualAns+=ans[i];
  
}
//System.out.println(actualAns);
     
return actualAns;

    }



    public static String decode(String plaintiff,String[] refTable, String[] reordered){

        System.out.println("Decoding " + plaintiff);
//TOTAL NUMBER OF CHARACTERS IN PLAINTIFF
  long totalCharacters = plaintiff.chars().count();
  //System.out.println(totalCharacters);
  Integer totalChar = (int) (long) totalCharacters;


    //LOOP TO CHANGE EVERY SINGLE WORD IN PLAINTIFF
    String[] ans = new String[totalChar];
    for(int i=0;i<totalChar;i++){
         //PULLING OUT AN INDIVIDUAL CHARACTER FROM PLAINTIFF
        String test=Character.toString(plaintiff.charAt(i));
        if(test.equals(" ")){
            ans[i]=" ";
        }else{
                //Cross reference the index of character from refTable to reordered
        int aB=Arrays.asList(reordered).indexOf(test);
        ans[i]=refTable[aB];
        }
        }

//System.out.println(Arrays.toString(ans));
String actualAns="";
for(int i=0;i<ans.length;i++){
actualAns+=ans[i];
  
}
// System.out.println(actualAns);
            
return actualAns;

}
}