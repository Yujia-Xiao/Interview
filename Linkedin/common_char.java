public class CommonCharacters {
    static public void commonCharracters(String[] strings) {
        int[] alphabets = new int[26];
        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (!string.substring(0, i).contains(c + "")) {
                    alphabets[c - 97]++;
                }
            }
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == strings.length) {
                System.out.println((char) (i + 97));
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = { "aghkafgklt", "dfghako", "qwemnaarkf" };
        commonCharracters(strings);
    }
}