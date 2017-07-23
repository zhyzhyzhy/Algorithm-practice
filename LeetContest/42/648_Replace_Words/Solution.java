import java.util.*;

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < dict.size(); j++) {
                if (strings[i].startsWith(dict.get(j))) {
                    strings[i] = dict.get(j);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length - 1; i++) {
            builder.append(strings[i]);
            builder.append(" ");
        }
        builder.append(strings[strings.length - 1]);
        return builder.toString();
    }
}