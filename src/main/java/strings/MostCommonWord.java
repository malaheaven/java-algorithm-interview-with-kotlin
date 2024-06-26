package strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {

        // 공백 쉼표로 문자열 나누기
        String[] str = paragraph.split("[\\s,]+");
        Map<String, Integer> map = new HashMap<>();

        // 문자 빈도수 map으로 저장
        for (String s : str) {
            String lowerCase = s.toLowerCase().replaceAll("[^a-z]", "");

            if (map.containsKey(lowerCase)) {
                map.put(lowerCase, map.get(lowerCase) + 1);
            } else {
                map.put(lowerCase, 1);
            }
        }

        // 금지된 단어 map에서 제거하기
        for (String s : banned) {
            map.remove(s.toLowerCase());
        }

        // 가장 많은 빈도수 나온 단어 검출하기
//        String mostCommon = null;
//        int maxCount = 0;
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > maxCount) {
//                mostCommon = entry.getKey();
//                maxCount = entry.getValue();
//            }
//        }
//
//        return mostCommon;
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};

        MostCommonWord mostCommonWord = new MostCommonWord();
        System.out.println(mostCommonWord.mostCommonWord(paragraph, banned));
    }
}
