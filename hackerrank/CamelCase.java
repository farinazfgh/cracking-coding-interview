package hackerrank;

public class CamelCase {
    // saveChangesInTheEditor
    //""
    //null
    //a
    //B
    //
    static int camelcase(String s) {
        int num=1;

        if(s==null||s.length()==0)return 0;

        char[] charArray=s.toCharArray();

        for(int i=1;i< charArray.length;i++){
            //a:97 z: 122 A:65 Z:90
            int temp=(int)charArray[i];
            if(( temp>=65)&&(temp<=90))num++;
        }
        return num;
    }
}
