package ru.sfedu.islabs.lab2;

import java.util.*;

public class Ex2_enhanced {
    public static String cypherText = "шцагщг иахшцкихпг м агюбцгэ ы бюпгшцх гцбэщбу фщъайъцхмх\n" +
            "ы мбщжъ 1940-е йй. иах гмцхыщбэ клгшцхх клъщче, хээхйахабыгытхе хё\n" +
            "йъаэгщхх. ш шгэбйб щглгпг акмбыбьшцыб гайъщцхщч шцаъэхпбшо ьбюхцошд\n" +
            "ы дьъащбу бюпгшцх эгмшхэгпощбу щъёгыхшхэбшцх, иах мбцбабу ыбёэбрщб\n" +
            "бьщбыаъэъщщбъ агёыхцхъ гцбэщбу фщъайъцхмх х щгклщб-цъещхлъшмбйб\n" +
            "ибцъщжхгпг ы бюпгшцх дьъащбйб цбипхыщбйб жхмпг (дцж), ьбпйбъ ыаъэд\n" +
            "бшцгыпдд бцмачцчэ ыбиабш ъйб хшибпоёбыгщхд ы ыбъщщче жъпде.ы 1953 й.\n" +
            "ы гайъщцхщъ щглгпхшо агюбцч иб иабэчтпъщщбу ьбючлъ кагщг. ёг 1958–1972\n" +
            "йй. ючпх ыыъьъщч ы фмшипкгцгжхн лъцчаъ хшшпъьбыгцъпошмхе аъгмцбаг\n" +
            "бьхщ хё мбцбаче ючп хэибацхабыгщ хё штг, бшцгпощчъ шмбщшцакхабыгщч х\n" +
            "ибшцабъщч шбюшцыъщщчэх шхпгэх. ы 1969 й. ы фшъушъ, ы 40 мэ бц\n" +
            "шцбпхжч гайъщцхщч юкфщбш-гуаъшг, ючпг икяъщг пгюбагцбащгд\n" +
            "кшцгщбымг иб агьхбехэхлъшмбу иъаъагюбцмъ бюпклъщщбйб дьъащбйб\n" +
            "цбипхыг (бдц), щб ы 1973 й. ибшпъ ычьъпъщхд бм. 1 мй ипкцбщхд бщг ючпг\n" +
            "ьъэбщцхабыгщг. ы 1974 й. ы пхэъ, ы 100 мэ м шъыъак бц юкфщбш-гуаъшг,\n" +
            "ючпг икяъщг иъаыгд гцбэщгд фпъмцабшцгщжхд (гфш) «гцклг-1»,\n" +
            "ибшцабъщщгд иах ибэбях щъэъжмбу мбэигщхх «шхэъщш». гфш ючпг шбёьгщг\n" +
            "щг бшщбыъ цдръпбыбьщ йб аъгмцбаг щг иахабьщбэ кагщъ фпъмцахлъшмбу ��\n" +
            "эбящбшцон 357 эыц.";

    public static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static String char_freq = "оаниетрсвлмкпгыбяудйчэцхзьщшжюфъё";

    public static void main(String[] args) {
        List<Character> letters = new ArrayList<>();
        List<Float> frequency = new ArrayList<>();

        String cypher_text_format = cypherText.replaceAll("[^а-я]", "");
        int numHits;
        int z = 0;
        float tmp = 0;

        for(char c : alphabet.toCharArray()){
            numHits = 0;
            for(char x : cypherText.toCharArray()){
                if(x == c) numHits++;
            }
            letters.add(c);
            tmp = numHits/(float)cypher_text_format.length();
            if(frequency.contains(tmp)) frequency.add(tmp + (float)0.00000001);
            else frequency.add(tmp);

            System.out.println(letters.get(z) + ": " + frequency.get(z));
            z++;
        }

        char[] char_freq_arr = char_freq.toCharArray();
        HashMap<Character, Character> substitute = new HashMap<>();
        float k;
        Character tmp2;
        for(int j = 0; j < alphabet.length(); j++){
            k = Collections.max(frequency);
            tmp2 = letters.get(frequency.indexOf(k));
            substitute.put(tmp2, char_freq_arr[j]);
            frequency.remove(k);
            letters.remove(tmp2);
        }

        System.out.println(Arrays.toString(substitute.entrySet().toArray()));

        char[] arr = cypherText.toCharArray();
        for(int i = 0; i < cypherText.length(); i++) {
            if(Character.isLetter(arr[i])) arr[i] = substitute.get(arr[i]);
        }
        System.out.println(String.valueOf(arr));
    }
}