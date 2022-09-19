package ru.sfedu.islabs.lab2;

import java.util.*;

public class Algo {
    public static String frequency_analysis(String src_text, String src_freq, String src_alphabet) {
        List<Character> letters = new ArrayList<>();
        List<Float> frequency = new ArrayList<>();

        String cypher_text_format = src_text.replaceAll("[^а-я]", "");
        //System.out.println(cypher_text_format);
        int numHits;
        int z = 0;
        float tmp = 0;

        for (char c : src_alphabet.toCharArray()) {
            numHits = 0;
            for (char x : src_text.toCharArray()) {
                if (x == c) numHits++;
            }
            letters.add(c);
            tmp = numHits / (float) cypher_text_format.length();
            if (frequency.contains(tmp)) frequency.add(tmp);
            else frequency.add(tmp);

            //System.out.println(letters.get(z) + ": " + frequency.get(z));
            z++;
        }

        char[] char_freq_arr = src_freq.toCharArray();
        HashMap<Character, Character> substitute = new HashMap<>();
        float k;
        Character tmp2;
        for (int j = 0; j < src_alphabet.length(); j++) {
            k = Collections.max(frequency);
            tmp2 = letters.get(frequency.indexOf(k));
            substitute.put(tmp2, char_freq_arr[j]);
            frequency.remove(k);
            letters.remove(tmp2);
        }

        System.out.println(Arrays.toString(substitute.entrySet().toArray()));

        char[] arr = src_text.toCharArray();
        for (int i = 0; i < src_text.length(); i++) {
            //if (Character.isLetter(arr[i])) arr[i] = substitute.get(arr[i]);
            if (src_alphabet.contains(String.valueOf(arr[i]))) arr[i] = substitute.get(arr[i]);
            System.out.print(arr[i]);
        }
        //System.out.println(String.valueOf(arr));
        return String.valueOf(arr);
    }
}
