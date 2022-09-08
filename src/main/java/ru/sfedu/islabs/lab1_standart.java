package ru.sfedu.islabs;

public class lab1_standart {
    public static int shift = 11;
    public static int alphabet_length = (int) 'z' - (int) 'a' + 1;

    public String crypt(String text) {
        return f(1,text);
    }

    public String decrypt(String text) {
        return f(-1,text);
    }

    private String f(int s,String text) {
        StringBuilder rez = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                int i = (int)c - (int)'a';
                i = (i + s*shift + alphabet_length) % alphabet_length + (int)'a';
                System.out.println(i);
                rez.append((char) i);
            } else
                rez.append(" ");
        }
        return rez.toString();
    }
}
