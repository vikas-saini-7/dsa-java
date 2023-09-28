// import java.sql.Array;
import java.util.HashSet;

public class Recursion2 {
    // Tower of Hanoi 
    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("Transfer disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Transfer disk "+n+" from "+src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);
    }
        // towerOfHanoi(n, "S", "H", "D");

    // Reverse String 
    public static void printRev( String str, int idx){
        if(idx == 0){
            System.out.print(str.charAt(idx));
            return;
        }

        System.out.print(str.charAt(idx));
        printRev(str, idx-1);
    }
        // String str = "abcd";
        // printRev(str, str.length()-1 );

    // Find First and Last occurence of element 
    public static int first = -1;
    public static int last = -1;

    public static void findOcurrence(String str, int idx, char element){
        if(idx == str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }

        char currChar = str.charAt(idx);
        if(currChar == element){
            if(first == -1){
                first = idx;
            } else {
                last = idx;
            }
        }
        findOcurrence(str, idx+1, element);
        }
        // findOcurrence(str, 0, 'a');

    // is Array Sorted ?
    public static boolean isSorted(int arr[], int idx){
        if( idx == arr.length-1){
            return true;
        }

        if(arr[idx] < arr[idx+1]){
            return isSorted(arr, idx+1);
        } else {
            return false;
        }
    }
        // int arr[] = {1, 2, 3, 4, 2};
        // System.out.println(isSorted(arr, 0));

    // Move all X at the end 
    public static void moveAllX(String str, int idx, int count, String newString){
        if(idx == str.length()){
            for( int i=0; i<count; i++){
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if(currChar == 'x'){
            count++;
            moveAllX(str, idx+1, count, newString);
        } else {
            newString += currChar;
            moveAllX(str, idx+1, count, newString);
        }
    }
    //     String str = "axbcxxd";
    //     moveAllX(str, 0, 0, "");

    // Remove Duplication 
    public static boolean[] map = new boolean[26];

    public static void removeDuplicates(String str, int idx, String newString){

        if(idx == str.length()){
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a']){
            removeDuplicates(str, idx+1, newString);
        } else {
            newString += currChar;
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newString);
        }
    }
    //     String str = "abbccdda";
    //     removeDuplicates(str, 0, "");

    // Subsequences 
    public static void subsequences(String str, int idx, String newString){
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        // to be 
        subsequences(str, idx+1, newString+currChar);
        // not to be 
        subsequences(str, idx+1, newString);
    }
    
    
    // Unique Subsequences 

    public static void subsequences(String str, int idx, String newString, HashSet<String> set){
        if(idx == str.length()){
            if(set.contains(newString)){
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char currChar = str.charAt(idx);
        // to be 
        subsequences(str, idx+1, newString+currChar, set);
        // not to be 
        subsequences(str, idx+1, newString, set);
    }
    
    public static void main(String args[]){
        String str = "abcdef";
        HashSet<String> set = new HashSet<>();
        subsequences(str, 0, "", set);
    }
}
