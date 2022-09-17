package ru.sfedu.islabs;

public class lab1_enhanced {
    public static int shift;
    public static int alphabet_length = (int) 'z' - (int) 'a' + 1;

    public static void main(String[] args) {
        lab1_enhanced l=new lab1_enhanced();
        String c_text=l.crypt("hello zorld");
        System.out.println(c_text);
        System.out.println(l.decrypt(c_text));
    }

    public String crypt(String text) {
        shift = 11;
        StringBuilder rez = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                int i = (int)c - (int)'a';
                i = (i + shift + alphabet_length) % alphabet_length + (int)'a';
                System.out.println(i);
                rez.append((char) i);
                shift= i - (int)'a';
            } else
                rez.append(" ");
        }
        return rez.toString();
    }

    public String decrypt(String text) {
        shift = 11;
        StringBuilder rez = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                int i = (int)c - (int)'a';
                i = (i - shift + alphabet_length) % alphabet_length + (int)'a';
                System.out.println(i);
                rez.append((char) i);
                shift= c - (int)'a';
            } else
                rez.append(" ");
        }
        return rez.toString();
    }
}
