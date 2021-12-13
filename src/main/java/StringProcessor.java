public class StringProcessor {
    //возвращает строку, в которой исходная строка s записана n раз
    public static String repeatString(String s, int n) {
        if (n<0) throw new IllegalArgumentException("n<0");
        if (n == 0) {
            return "";
        }
        String result = "";
        for (int i = 0; i < n; i++) {
            result += s;
        }
        return result;
    }

    //возвращает количество вхождений второй строки в первую
    public static int containNum(String first, String second) {
        int result = 0;
        int i = first.indexOf(second);
        while (i >= 0) {
            result += 1;
            i = first.indexOf(second, i + 1);
        }
        return result;
    }

    //замена 1 на "один", 2 на "два", 3 на "три"
    public static String replaceSubString(String rplS0) {
        String rplS1 = rplS0.replaceAll("1", "один");
        String rplS2 = rplS1.replaceAll("2", "два");
        String rplS3 = rplS2.replaceAll("3", "три");

        return rplS3;
    }

    //удаление каждого второго по счёту символа
    public static StringBuilder deleteSecondChar(StringBuilder initial) {
        int i = 0;
        while (i < initial.length() - 1) {
            initial = initial.deleteCharAt(++i);
        }
        return initial;
    }

}
