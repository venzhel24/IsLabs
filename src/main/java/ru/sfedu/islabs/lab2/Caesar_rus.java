package ru.sfedu.islabs.lab2;

public class Caesar_rus {
    public static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public String crypt(String text, int shift) {
        return f(1,text, shift);
    }

    public String decrypt(String text, int shift) {
        return f(-1,text, shift);
    }

    private String f(int s,String text, int shift) {
        StringBuilder rez = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (alphabet.indexOf(c) != -1) {
                int i = alphabet.indexOf(c);
                i = (i + s*shift + alphabet.length()) % alphabet.length();
                //System.out.println(i);
                rez.append(alphabet.charAt(i));
            } else
                rez.append(c);
        }
        return rez.toString();
    }
}
