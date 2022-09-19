package ru.sfedu.islabs.lab2;

import java.util.*;

public class Ex3_enhanced {
    public static String cypherText = "жфяюфялав уфяда ъ вяиелфй злиекиымшиъдфй щъыалфюдфй.\n" +
            "ажу жфяеаряиувтыъв ла ъыеаыикмшиъдми м слфкфпиуиюци.д\n" +
            "ъыеаыикмшиъдмс фылфъвыъв ажу, фълфюлцс юффещнилмис дфыфецх\n" +
            "вюувтыъв чауумъымшиъдми еадиыц ъыеаыикмшиъдфкф ларлашилмв (чежу). ю\n" +
            "сфеъдмх ъыеаыикмшиъдмх вяиелцх ъмуах (съвъ) юффещниллцх ъму (юъ) ег\n" +
            "жемлвыф мъжфуьрфюаыь ыиесмл «еадиылцй жфяюфялцй деийъие\n" +
            "ъыеаыикмшиъдфкф ларлашилмв» (еждъл). ю юфиллф-сфеъдмх ъмуах (юсъ) ъёа\n" +
            "м яещкмх кфъщяаеъыю щжфыеичувиыъв ыиесмл «аыфслав жфяюфялав уфяда\n" +
            "ъ чауумъымшиъдмсм еадиыасм» (жуаеч). флм жеияларлашилц яу��\n" +
            "жфеанилмв юанлцх юфиллф-аясмлмъыеаымюлцх пилыефю, жщлдыфю\n" +
            "щжеаюуилмв, кещжжмефюфд юффещниллцх ъму жефымюлмда, юфиллфсфеъдмх чар, жфеыфю м яе., фъщбиъыюувв жуаюалми ю утчцх еайфлах\n" +
            "смефюфкф фдиала ъдецылф, ли юъжуцюав ю лаяюфялфи жфуфнилми.еждъл м\n" +
            "жуаеч жемсилвтыъв дад ъасфъыфвыиуьлф, ыад м ю ъфъыаюи кещжжмефюфд\n" +
            "съвъ м еарлфефялцх ъму. сфкщы мсиыь ла юффещнилмм зггидымюлци\n" +
            "ъеияъыюа чфеьчц ъ жефымюфуфяфшлцсм ъмуасм жефымюлмда, ъеияъыюа\n" +
            "лачутяилмв, ъюврм м щжеаюуилмв, лаюмкапмм, юфъжеибилмв\n" +
            "лиъалдпмфлмефюаллфкф яфъыщжа д еадиылф-вяиелфсщ фещнмт, яещкми\n" +
            "еаямфзуидыефллци юцшмъумыиуьлци м ыихлмшиъдми ъеияъыюа.\n" +
            "ъыеаыикмшиъдми ажу вюувтыъв фълфюлфй чфиюфй иямлмпий м щяаелцс\n" +
            "дфсжфлилыфс съвъ м ъфъыфвы ла юффещнилмм юсг ефъъмм, юсъ ъёа,\n" +
            "юиумдфчемыалмм, геалпмм м дмыав.";

    public static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static String char_freq = "оинесартвкляпдмыугхчбйжзюцьфэшщъё";

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
            if(frequency.contains(tmp)) frequency.add(tmp);
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
