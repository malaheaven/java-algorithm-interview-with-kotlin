import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {


        Arrays.sort(logs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String[] str1 = o1.split(" ", 2);
                String[] str2 = o2.split(" ", 2);


                // 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전 순으로 한다.
                // 문자가 동일할 경우에는 식별자 순으로 한다.
                // 숫자 로그는 입력 순서대로 한다.

                if (!Character.isDigit(str1[1].charAt(0)) && !Character.isDigit(str2[1].charAt(0))) {
                    if (str1[1].equals(str2[1])) {
                        return str1[0].compareTo(str2[0]);
                    } else {
                        return str1[1].compareTo(str2[1]);
                    }
                }

                if (Character.isDigit(str1[1].charAt(0)) && Character.isDigit(str2[1].charAt(0))) {
                    return 0;
                }

                return Character.isDigit(str1[1].charAt(0)) ? 1 : -1;
            }
        });


        return logs;
    }


    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        ReorderDataInLogFiles r = new ReorderDataInLogFiles();
        System.out.println(Arrays.toString(r.reorderLogFiles(logs)));
    }
}
