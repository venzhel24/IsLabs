package ru.sfedu.islabs.lab2;

import java.util.*;

public class Ex1_enhanced {
    public static String cypherText = "обнмчшйчшенчё мса амнбчцжц вмнбыуршчуа рнбцалчцжц\n" +
            "обцлурчущш у бньнчуа влбшлнжуенвщую, цонбшлурчц-влбшлнжуенвщую у\n" +
            "цонбшлурчёю йшмше чш щцчлучнчлшсхчёю, цщншчвщую (гцбвщую)\n" +
            "лншлбшю рцнччёю мнэвлруэ (лрм) у чш цлмнсхчёю влбшлнжуенвщую\n" +
            "(цонбшяуцччёю) чшобшрснчуаю. арсазлва ешвлхз «амнбчцэ лбушмё». щ\n" +
            "цвчцрчёг оцлнчяушсхчёг йшмшешг швав цлчцвалва: чшчнвнчун\n" +
            "бшщнлчцдцгдцрёю фмшбцр оц цдтнщлшг обцлурчущш чш йчшеулнсхчёю\n" +
            "фмшснчуаю цл шибцмбцгцр дшйубцршчуа, цднвоненчун оцммнбыщу в\n" +
            "рцймфюш вус цдкнжц чшйчшенчуа (вцч) у мб. швав веулшзлва жудщуг\n" +
            "вбнмвлрцг щшщ жсцдшсхчцжц, лшщ у бнжуцчшсхчцжц вмнбыуршчуа\n" +
            "рнбцалчёю обцлурчущцр, гцжфл обугнчалхва рц рвню румшю рцэч у\n" +
            "щцчъсущлцр (щшщ амнбчёю, лшщ у цдёечёю). швав угнзлва р вцвлшрн ррв\n" +
            "бцввуу, вьш у щулша.р вьш цвчцрф швав вцвлшрсазл лаынсён\n" +
            "(влбшлнжуенвщун) дцгдшбмубцркущу (лд, вг. лаынсёэ дцгдшбмубцркущ) р-52ч\n" +
            "у р-2ш, врнмнччён р 5 шрушщбёсхнр р вцвлшрн 8-э у 12-э рцймфьчёю шбгуэ,\n" +
            "щцлцбён шмгучувлбшлурчц оцмеучнчё дцнрцгф шрушяуцччцгф\n" +
            "щцгшчмцршчуз ррв вьш. чш рццбфынчуу лд чшюцмалва щбёсшлён бшщнлё\n" +
            "(вг. щбёсшлша бшщнлш) рцймфьчцжц дшйубцршчуа (щбрд) дцсхьцэ\n" +
            "мшс чцвлу (р амнбчцг у чнамнбчцг цвчшкнчуу) у шрушдцгдё. р фвсцруаю ��\n" +
            "губчцжц рбнгнчу дцнрцн мныфбвлрц влбшлнжуенвщцэ дцгдшбмубцрцечцэ\n" +
            "шрушяунэ (вдш) вьш чн цвфкнвлрсанлва. в янсхз оцммнбышчуа\n" +
            "обшщлуенвщую чшрёщцр снлчцжц вцвлшрш цбжшчуйфзлва оцснлё оц осшчшг\n" +
            "дцнрцэ оцмжцлцрщу. р фжбцышнгёэ онбуцм бшйрулуа рцнччц-оцсулуенвщцэ\n" +
            "цдвлшчцрщу усу р щбуйувчёю вулфшяуаю вдш онбнмшнлва р цонбшлурчцн\n" +
            "оцмеучнчун цдтнмучнччцгф влбшлнжуенвщцгф щцгшчмцршчуз рццбфынччёю\n" +
            "вус (рв) вьш усу щцгшчмфзкнгф цдтнмучнччцжц щцгшчмцршчуа чш лрм.\n" +
            "цвчцрчён чшобшрснчуа бшйрулуа вав рв вьш: гцмнбчуйшяуа у обцмснчун ��\n" +
            "вбцщш ищвосфшлшяуу лд р-52ч у р-2ш; обучалун чш рццбфынчун чцрёю\n" +
            "луоцр рёвцщцлцечёю щбрд, шрушдцгд у лд чцрцжц оцщцснчуа щ 2040 ж.";

    public static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static String char_freq = "оианевстркядмылбпхгучзйьжшюцщъэфё";

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
