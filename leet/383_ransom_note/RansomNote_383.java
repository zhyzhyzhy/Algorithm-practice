
/**
 * Created by zhy on 8/21/16.
 */
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        char[] temp1 = ransomNote.toCharArray();
        for(int i = 0; i < temp1.length; i++) {
            arr1[temp1[i]-97]++ ;
        }

        char[] temp2 = magazine.toCharArray();
        for(int i = 0; i < temp2.length; i++) {
            arr2[temp2[i]-97]++;
        }

        for(int i = 0; i < temp1.length; i++) {
            if(arr1[temp1[i]-97] > arr2[temp1[i]-97])
                return false;
        }
        return true;

    }
}
