package ru.sfedu.islabs;

public class lab1_standart {
    //public static int shift = 11;
    public static int alphabet_length = (int) 'z' - (int) 'a' + 1;

    public String crypt(String text, int shift) {
        return f(1,text, shift);
    }

    public String decrypt(String text, int shift) {
        return f(-1,text, shift);
    }

    private String f(int s,String text, int shift) {
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
