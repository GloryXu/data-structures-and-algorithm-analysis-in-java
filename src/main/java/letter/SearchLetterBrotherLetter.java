package letter;

import java.util.*;

/**
 * 通过一个单词从字典中找到该单词的兄弟单词
 *
 * 给你一个单词a，如果通过交换单词中字母的顺序可以得到另外的单词b，那么定义b是a的兄弟单词。
 * 现在给你一个字典，用户输入一个单词，让你根据字典找出这个单词有多少个兄弟单词。
 */
public class SearchLetterBrotherLetter {

    static Map<String, List<String>> dictionary = new HashMap<>();
    static char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//    static char[] letters = new char[]{'a','b','c'};
    static int count = 2000;

    static {
        int i = 0;
        while (i < count) {
            int letterCount = new Random().nextInt(6) + 1;
            StringBuffer letter = new StringBuffer(), letterSorted;
            for (int j = 0;j < letterCount;j++) {
                letter.append(letters[new Random().nextInt(letters.length)]);
            }
            letterSorted = sortLetter(letter);

            String key = letterSorted.toString();
            String value = letter.toString();
            if (i == count - 1) {
                key = "abd";
                value = "dba";
            }
            List<String> listT = dictionary.get(key);
            if (listT == null) {
                listT = new ArrayList<>();
                listT.add(value);
                dictionary.put(key, listT);
            } else {
                listT.add(value);
            }
            i++;
        }
        System.out.println(dictionary);
    }

    /**
     * 按字母进行排序
     *
     * @param oriLetter
     * @return
     */
    public static StringBuffer sortLetter(StringBuffer oriLetter) {
        if (oriLetter == null) {
            throw new NullPointerException("oriLetter can't be null");
        }
        StringBuffer result = new StringBuffer().append(oriLetter.charAt(0));
        for (int i = 1; i < oriLetter.length(); i++) {
            char temp = oriLetter.charAt(i);
            int j = 0;
            int resultLength = result.length();
            while (result.charAt(j) < temp) {
                j++;
                if (j > resultLength - 1) {
                    break;
                }
            }
            result.insert(j, temp);
        }
        return result;
    }

    public static void main(String[] args) {
        StringBuffer temp = new StringBuffer("bc");
        List<String> list = dictionary.get(sortLetter(temp).toString());
        if (list == null) {
            System.out.println("This letter" + temp.toString() + " don't have brother letter.");
        } else {
            System.out.println("This letter" + temp.toString() + " have brother letter.");
            for (String str : list) {
                System.out.print(str + ",");
            }
        }

    }

}
