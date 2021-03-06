import java.util.Scanner;
import java.util.ArrayList;

public class l001Basic{
    private static Scanner scn = new Scanner(System.in);

    /* Introduction to Recursion  */

    public static void printDecreasing1(int n){
        if(n == 0) return;
        System.out.println("Hi"+n);
        printDecreasing1(n-1);
        System.out.println("Bye"+n);
    }

    // Find output when called for n = 5 ?
    public static void fun(int n){
        if(n == 0){
            System.out.println("i have to stop" + n);
            return;
        }
        for(int i=0;i<3;++i) System.out.print(n + "@" +i);
        System.out.println();
        if(n%2 == 0){
            System.out.println("heading towards child function"+n);
        }
        fun(n-1);
        if(n%2 != 0){
            System.out.println("Back to parent function"+n);
        }
        
    }

    public static void printDecreasing(int n){
        if(n==0) return ;
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n==0) return ;
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static void printIncreasingDecreasing(int n){
        if(n==0) return ;
        System.out.println(n);
        printIncreasingDecreasing(n-1);
        System.out.println(n);
    }

    public static int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }

    public static int powerLinear(int x, int n){
        if(n==0) return 1;
        return x*powerLinear(x,n-1);
    }

    public static int powerLogarithmic(int x, int n){
        if(n==0) return 1;
        if(n%2 == 1) return x*powerLogarithmic(x,n/2)*powerLogarithmic(x,n/2);
        else return powerLogarithmic(x,n/2)*powerLogarithmic(x,n/2);
    }

    public static void printZigZag(int n){
        if(n==0) return;
        System.out.print(n+" ");
        printZigZag(n-1);
        System.out.print(n+" ");
        printZigZag(n-1);
        System.out.print(n+" ");
    }

    //Tower of Hanoi t1 to t2 via t3
    public static void toh(int n, int t1, int t3, int t2){
        if(n==0) return;
        toh(n-1,t1,t2,t3);
        System.out.println(n+"["+t1+" -> "+t2+"]");
        toh(n-1,t3,t1,t2);
    }

    /* Recursion in Arrays  */

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length) return;
        System.out.println(arr[idx]);
        displayArr(arr,idx+1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx == arr.length) return;
        displayArrReverse(arr,idx+1);
        System.out.println(arr[idx]);
    }

    // maxOfArray(arr,n-1);
    public static int maxOfArray(int[] arr, int idx){
        if(idx == 0) return arr[0];
        int ans=maxOfArray(arr,idx-1);
        if(ans<arr[idx]) ans=arr[idx];
        return ans;
    }

    // firstIndex(arr,0,x)
    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length) return -1;
        if(arr[idx] == x) return idx;
        return firstIndex(arr,idx+1,x);
    }

    // lastIndex(arr,n-1,x) traversing n-1 to 0
    public static int lastIndex1(int[] arr, int idx, int x){
        if(idx == -1) return -1;
        if(arr[idx] == x) return idx;
        return lastIndex1(arr,idx-1,x);
    }

    // lastIndex(arr,n-1,x) traversing 0 to n-1
    public static int lastIndex2(int[] arr, int idx, int x){
        if(idx == arr.length) return -1;
        int res = lastIndex2(arr,idx+1,x);
        if(res == -1 && arr[idx] == x)  return idx;
        return res;
    }

    // All Indices Of Array
    // public static int func(int[] arr, int x, int idx){
    //     if(idx==arr.length) return 0;
    //     int res=func(arr,x,idx+1);
    //     if(arr[idx]==x) ++res;
    //     return res;
    // }
    // public static void fillx(int[] xrr, int xidx, int[] arr,int idx,int x){
    //     if(xidx == xrr.length || idx == arr.length) return;
    //     if(arr[idx]==x){
    //         xrr[xidx++]=idx;
    //     }
    //     fillx(xrr,xidx,arr,idx+1,x);
    // }
    // public static int[] allIndices(int[] arr, int x, int idx, int count) {
    //     // write ur code here
    //     int freq = func(arr,x,0);
    //     int[] xrr = new int[freq];
    //     fillx(xrr,0,arr,0,x);
    //     return xrr;
    // }

    // All Indices of Array
    public static int[] allIndices(int[] arr, int x, int idx, int count) {
        if(idx == arr.length){
            int[] base = new int[count];
            return base;
        }
        if(arr[idx] == x) ++count;
        int[] ans = allIndices(arr,x,idx+1,count);
        if(arr[idx] == x) ans[count-1] = idx ;
        return ans;
    }

    /* Recursion with ArrayList */
    
    public static ArrayList<String> getSubSequence(String str) {
        if(str.length()==0){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("");
            return arrayList;
        }
        int n=str.length();
        ArrayList<String> arrayList = getSubSequence(str.substring(1,n)); // or str.substring(1));
        int len = arrayList.size();
        for(int i=0;i<len;++i){
            arrayList.add(str.charAt(0)+arrayList.get(i));
        }
        return arrayList;
    }

    static String[] codes = {".;","abc","def","ghi","jkl",
        "mno","pqrs","tu","vwx","yz"};
    public static ArrayList <String> getKPC(String str, int idx){
        if(idx == str.length()){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(idx);
        int cidx = (int)(ch-'0');
        ArrayList <String> al = getKPC(str,idx+1);
        ArrayList <String> nal = new ArrayList<>();
        for(int i=0;i<codes[cidx].length();++i){
            char curr = codes[cidx].charAt(i);
            for(int j=0;j<al.size();++j){
                nal.add(curr+al.get(j));
            }
        }
        return nal;
    } 

    // print a rectangle of stars n*m
    public static void printRectangleNXM(int cr,int cc, int n ,int m){
        if(cc==m){
            cc=0;
            ++cr;
            System.out.println();
        }
        if(cr==n) return;
        System.out.print("*"+"\t");
        printRectangleNXM(cr,cc+1,n,m);
    }
    /*
    *******
    *******
    *******
    *******
    */
    public static void printRectangle(int cst,int nst,int nor,int n,int m){
        if(nor==n+1) return;
        if(cst == nst+1) {
            System.out.println();
            printRectangle(1,nst,nor+1,n,m);
            return;
        }
        System.out.print("*");
        printRectangle(cst+1,nst,nor,n,m);
    }

    /*
    *
    **
    ***
    ****
    *****
    */
    public static void printTriangle(int cst,int nst,int nor,int n,int m){
        if(nor==n+1) return;
        if(cst == nst+1) {
            System.out.println();
            printTriangle(1,nst+1,nor+1,n,m);
            return;
        }
        System.out.print("*");
        printTriangle(cst+1,nst,nor,n,m);
    }

    // Is given array a palindrome
    public static boolean isPalin(int[] arr, int si, int ei){
        if(si>ei) return true;
        return (arr[si]==arr[ei] && isPalin(arr,si+1,ei-1));
    }

    // Reverse Array by Recursion
    public static void reverseArray(int[] arr, int si, int ei){
        if(si>=ei) return;
        int temp=arr[si];
        arr[si]=arr[ei];
        arr[ei]=temp;
        reverseArray(arr,si+1,ei-1);
    }

    // Inverse of Array by Recursion
    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-13inversearray/problem
    public static void inverseArray(int[] arr, int idx){
        if(idx == arr.length) return;
        int val = arr[idx];
        inverseArray(arr,idx+1);
        arr[val] = idx;
    }

    // Hackerrank Pep https://www.hackerrank.com/contests/pepdec62017/challenges/filters/page:8
    // SumOfDigitInString
    public static int sumOfDigitsInString(String str, int idx){
        if(idx == str.length()) return 0;
        int val = (int)(str.charAt(idx)-'0');
        return val + sumOfDigitsInString(str,idx+1);
    }

    // stringToNum(str,str.length()-1,1)
    public static long stringToNum(String str, int idx,long pwr){
        if(idx == -1) return 0;
        long val = (str.charAt(idx)-'0')*pwr;
        return val + stringToNum(str,idx-1,pwr*10); 
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-18stringonetwoarereverse
    public static boolean stringOneTwoAreReverse(String str1, int idx1, String str2, int idx2){
        if(idx1==str1.length() && idx2==-1) return true;
        return (str1.charAt(idx1)==str2.charAt(idx2) && stringOneTwoAreReverse(str1,idx1+1,str2,idx2-1));
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-19palindromeofstring
    public static boolean ok(char ch1, char ch2){
        if(ch1>='A' && ch1<='Z'){
            ch1 = (char)(ch1 + ('a'-'A'));
        }
        if(ch2>='A' && ch2<='Z'){
            ch2 = (char)(ch2 + ('a'-'A'));
        }
        return ch1 == ch2;
    }
    public static boolean isPalin2(String str, int si, int ei){
        if(si>=ei) return true;
        return (ok(str.charAt(si),str.charAt(ei)) && isPalin2(str,si+1,ei-1));
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-20separateduplicates
    public static String separateDuplicates(String str){
        if(str.length() <= 1) return str;
        char ch = str.charAt(0);
        String recString = separateDuplicates(str.substring(1));
        if(ch == recString.charAt(0)) return ch +"*"+recString;
        else return ch + recString;
    }
    public static void separateDuplicates(String str, int idx, String ans){
        if(idx == str.length()-1){
            System.out.println(ans+str.charAt(str.length()-1));
            return;
        }
        char ch = str.charAt(idx);
        if(ch == str.charAt(idx+1)){
            separateDuplicates(str,idx+1,ans+ch+"*");
        }
        else{
            separateDuplicates(str,idx+1,ans+ch);
        }
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-21removeadjacentduplicates
    public static String removeAdjacentDuplicates(String str){
        if(str.length()<=1) return str;
        char ch = str.charAt(0);
        String recString = removeAdjacentDuplicates(str.substring(1));
        if(ch == recString.charAt(0)) return recString;
        else return ch + recString;
    }
    public static void removeAdjacentDuplicates(String str, int idx, String ans){
        if(idx == str.length()-1){
            System.out.println(ans+str.charAt(str.length()-1));
            return;
        }
        if(str.charAt(idx)==str.charAt(idx+1)){
            removeAdjacentDuplicates(str,idx+1,ans);
        }
        else{
            removeAdjacentDuplicates(str,idx+1,ans+str.charAt(idx));
        }
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-22movecharacters
    public static String moveCharacters(String str,char ch){
        if(str.length()==1) return str;
        char chr = str.charAt(0);
        String res = moveCharacters(str.substring(1),ch);
        if(ch == chr) return res + chr;
        else return chr + res;
    }
    public static void moveCharacters(String str, String ans, char ch, int idx,int count){
        if(idx==str.length()){
            for(int i=0;i<count;++i) ans+=ch;
            System.out.println(ans);
            return;
        }
        if(str.charAt(idx)==ch) moveCharacters(str,ans,ch,idx+1,count+1);
        else moveCharacters(str,ans+str.charAt(idx),ch,idx+1,count);
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-23countorremovehi
    public static long countHi(String str){
        if(str.length()<2) return 0;
        if(str.charAt(0)=='h' && str.charAt(1)=='i') return 1 + countHi(str.substring(2));
        else return countHi(str.substring(1));
    }
    public static String removeHi(String str){
        if(str.length()<2) return str;
        if(str.charAt(0)=='h' && str.charAt(1)=='i') return removeHi(str.substring(2));
        else return str.charAt(0) + removeHi(str.substring(1));
    }
    public static void removeHi(String str,String ans){
        if(str.length()<2){
            ans += str;
            System.out.println(ans);
            return;
        }
        if(str.charAt(0)=='h' && str.charAt(1)=='i') removeHi(str.substring(2),ans);
        else removeHi(str.substring(1),ans + str.charAt(0));
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-24replacehiwithpep
    public static String replaceHiWithpep(String str){
        if(str.length()<2) return str;
        if(str.charAt(0)=='h' && str.charAt(1)=='i') return "pep"+replaceHiWithpep(str.substring(2));
        else return str.charAt(0) + replaceHiWithpep(str.substring(1));
    }
    public static void replaceHiWithpep(String str,String ans){
        if(str.length()<2){
            ans += str;
            System.out.println(ans);
            return;
        }
        if(str.charAt(0)=='h' && str.charAt(1)=='i') replaceHiWithpep(str.substring(2),ans+"pep");
        else replaceHiWithpep(str.substring(1),ans + str.charAt(0));
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-25hiwithouthit
    public static long countHiWithoutHit(String str){
        if(str.length()<2) return 0;
        if(str.charAt(0)=='h' && str.charAt(1)=='i'){
            if(str.length()>=3 && str.charAt(2)=='t') return countHiWithoutHit(str.substring(3));
            else return 1 + countHiWithoutHit(str.substring(2));
        }
        else return countHiWithoutHit(str.substring(1));
    }
    public static String removeHiWithoutHit(String str){
        if(str.length()<2) return str;
        if(str.charAt(0)=='h' && str.charAt(1)=='i'){
            if(str.length()>=3 && str.charAt(2)=='t') return "hit" + removeHiWithoutHit(str.substring(3));
            else return removeHiWithoutHit(str.substring(2));
        } 
        else return str.charAt(0) + removeHiWithoutHit(str.substring(1));
    }
    public static void removeHiWithoutHit(String str,String ans){
        if(str.length()<2){
            ans += str;
            System.out.println(ans);
            return;
        }
        if(str.charAt(0)=='h' && str.charAt(1)=='i'){
            if(str.length()>=3 && str.charAt(2)=='t') removeHiWithoutHit(str.substring(3),ans+"hit");
            else removeHiWithoutHit(str.substring(2),ans);
        }
        else removeHiWithoutHit(str.substring(1),ans + str.charAt(0));
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-26replacehiwithouthit
    public static String replaceHiWithoutHit(String str){
        if(str.length()<2) return str;
        if(str.charAt(0)=='h' && str.charAt(1)=='i'){
            if(str.length()>=3 && str.charAt(2)=='t') return "hit" + replaceHiWithoutHit(str.substring(3));
            else return "pep" + replaceHiWithoutHit(str.substring(2));
        } 
        else return str.charAt(0) + replaceHiWithoutHit(str.substring(1));
    }
    public static void replaceHiWithoutHit(String str,String ans){
        if(str.length()<2){
            ans += str;
            System.out.println(ans);
            return;
        }
        if(str.charAt(0)=='h' && str.charAt(1)=='i'){
            if(str.length()>=3 && str.charAt(2)=='t') replaceHiWithoutHit(str.substring(3),ans+"hit");
            else replaceHiWithoutHit(str.substring(2),ans+"pep");
        } 
        else replaceHiWithoutHit(str.substring(1),ans + str.charAt(0));
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-27twincountoverlap
    public static long twinCountOverlap(String str){
        if(str.length()<3) return 0;
        if(str.charAt(0)==str.charAt(2) && str.charAt(0)!=str.charAt(1)) return 1+twinCountOverlap(str.substring(1));
        else return twinCountOverlap(str.substring(1));
    }
    public static void twinCountOverlap(String str,int count){
        if(str.length()<3){
            System.out.println(count);
            return;
        }
        if(str.charAt(0)==str.charAt(2) && str.charAt(0)!=str.charAt(1)) twinCountOverlap(str.substring(1),count+1);
        else twinCountOverlap(str.substring(1),count);
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-28twincountwithoutoverlap
    public static long twinCountWithoutOverlap(String str){
        if(str.length()<3) return 0;
        if(str.charAt(0)==str.charAt(2) && str.charAt(0)!=str.charAt(1)) return 1+twinCountWithoutOverlap(str.substring(3));
        else return twinCountWithoutOverlap(str.substring(1));
    }
    public static void twinCountWithoutOverlap(String str,int count){
        if(str.length()<3){
            System.out.println(count);
            return;
        }
        if(str.charAt(0)==str.charAt(2) && str.charAt(0)!=str.charAt(1)) twinCountWithoutOverlap(str.substring(3),count+1);
        else twinCountWithoutOverlap(str.substring(1),count);
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-29countofaaa
    public static long countOfaaaOverlapAllowed(String str){
        if(str.length()<3) return 0;
        if(str.charAt(0)=='a' && str.charAt(1)=='a' && str.charAt(2)=='a') return 1+countOfaaaOverlapAllowed(str.substring(1));
        else return countOfaaaOverlapAllowed(str.substring(1));
    }
    public static void countOfaaaWithoutOverlap(String str,int count){
        if(str.length()<3){
            System.out.println(count);
            return;
        }
        if(str.charAt(0)=='a' && str.charAt(1)=='a' && str.charAt(2)=='a') countOfaaaWithoutOverlap(str.substring(3),count+1);
        else countOfaaaWithoutOverlap(str.substring(1),count);
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-30printallpossiblecode
    public static void printAllPossibleCode(String str, String ans, int idx){
        if(idx==str.length()){
            System.out.println(ans);
            return;
        }
        if(idx==str.length()-1){
            printAllPossibleCode(str,ans+(char)('a'+(str.charAt(idx)-'0')-1),idx+1);
            return;
        }
        int val=(str.charAt(idx)-'0')*10+(str.charAt(idx+1)-'0');
        int tval=(str.charAt(idx)-'0');
        if(val==10 || val ==20){
            printAllPossibleCode(str, ans+(char)('a'+val-1), idx+2);
        }
        else if(val>26){
            printAllPossibleCode(str, ans+(char)('a'+tval-1), idx+1);
        }
        else{
            printAllPossibleCode(str, ans+(char)('a'+tval-1), idx+1);
            printAllPossibleCode(str, ans+(char)('a'+val-1), idx+2);
        }
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-31specificstringbetweenparanthesis
    public static void specificStringBetweenParanthesis(String str, String ans, int idx,int flag){
        if(idx==str.length()){
            System.out.println(ans);
            return;
        }
        if(str.charAt(idx)=='(' && flag==0){
            specificStringBetweenParanthesis(str, ans+"(", idx+1, 1);
        }
        else if(flag==1 && str.charAt(idx)==')'){
            specificStringBetweenParanthesis(str, ans+")", idx+1, 0);
        }
        else if(flag==1){
            specificStringBetweenParanthesis(str, ans+str.charAt(idx), idx+1, 1);
        }
        else if(flag==0){
            specificStringBetweenParanthesis(str, ans, idx+1, 0);
        }
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-32balancedparanthesis
    // -> https://www.geeksforgeeks.org/check-for-balanced-parenthesis-without-using-stack/
    
    //https://nados.io/question/print-subsequence?zen=true
    // printSS(str,"",0);
    public static void printSS(String str, String ans, int idx) {
        if(idx == str.length()){
            System.out.println(ans);
            return;
        }
        printSS(str,ans+str.charAt(idx),idx+1);
        printSS(str,ans,idx+1);
    }

    

    public static void main(String[] args){
        // printDecreasing(5);
        // fun(5); //find output for this by dry run !
        // System.out.println(getKPC("78",0));
        // printRectangleNXM(0,0,3,5);
        // int n=4,m=5;    printTriangle(1,1,1,n,m);
        // printRectangle(1,m,1,n,m);
        
    }
}