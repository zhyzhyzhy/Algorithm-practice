import java.util.LinkedList;
import java.util.List;

/**
三步反转法
例如，字符串 abcdef ，若要让def翻转到abc的前头，只要按照下述3个步骤操作即可：
首先将原字符串分为两个部分，即X:abc，Y:def；
将X反转，X->X^T，即得：abc->cba；将Y反转，Y->Y^T，即得：def->fed。
反转上述步骤得到的结果字符串X^TY^T，即反转字符串cbafed的两部分（cba和fed）给予反转，cbafed得到defabc，
形式化表示为(X^TY^T)^T=YX，这就实现了整个反转。
*/
class Solution {
    public static void main(String[] args) {
        char[] chs = new char[] {'a','b','c','d','e','f'};
        Solution solution = new Solution();
        solution.rotateChs(chs, 3);
        System.out.println(chs);
    }
    public void swapChars(char[] chs, int begin, int end) {
        while (begin < end) {
            char temp  = chs[begin];
            chs[begin] = chs[end];
            chs[end] = temp;
            begin++;
            end--;
        }
    }
    //把前length个字符移到chs的末尾
    public void rotateChs(char[] chs, int length) {
        swapChars( chs, 0, length - 1);
        swapChars( chs, length, chs.length - 1);
        swapChars( chs, 0, chs.length - 1);
    }
}
