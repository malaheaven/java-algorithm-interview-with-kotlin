package strings;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sorted = new String(chars);

            if (!map.containsKey(sorted)){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);

            }else{
                map.get(sorted).add(str);
            }

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.groupAnagrams(strs));
    }
}
