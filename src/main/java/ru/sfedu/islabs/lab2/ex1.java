package ru.sfedu.islabs.lab2;

import ru.sfedu.islabs.lab1_standart;

public class ex1 {
    public static void main(String[] args) {
        Caesar_rus qw = new Caesar_rus();
        String text1 = "блюншж явфвн, бйёпнёж яиэбёйёнляёф! оплизкриоь о еэбэфвж,\n" +
                "злабэ кэ яштлбв квжнлккэь овпщ блидкэ яшбэяэпщ кв плищзл зиэоо\n" +
                "(зиэооёсёзэуёь) ё кв мнлопл фёоил (нванвооёь). кэ яштлбв крдкл ялеянэцэпщ x,\n" +
                "y, width, height ё зиэоо люкэнрдвкклал кэ зэнпёкзв лючвзпэ (ёиё зллнбёкэпш\n" +
                "плфвз злкпрнля ъплал лючвзпэ, э-иь овайвкпэуёь)";
        String result1 = qw.decrypt(text1, 30);
        System.out.println("ЗАДАНИЕ 1:");
        System.out.println(result1.concat("\n"));


        System.out.println("ЗАДАНИЕ 2:");
        String text2 = "эзъйфг эюжх. зйьщжвбщлзйф дмйкзы ийюэезавев люёф ийзюдлзы\n" +
                "из дмйкм ai, зжв ы щллщрю. цлз жюзъшбщлюехжфю люёф, ыф ёзаюлю\n" +
                "ыфъйщлх ечъмч кызч";
        String result2 = qw.decrypt(text2, 26);
        System.out.println(result2.concat("\n"));


        System.out.println("ЗАДАНИЕ 3:");
        String text3 = "зрмцфмн ёпдзмрмфтёмы, зиса зтефян. ря х ёдрм еихизтёдпм ут\n" +
                "очфхч фтхд отедпац. утпстъисстн уфтжфдрря рси сднцм си чздптха, пмьа\n" +
                "цтпаот офдцомн упдс очфхд:";
        String result3 = qw.decrypt(text3, 4);
        System.out.println(result3.concat("\n"));


        System.out.println("ЗАДАНИЕ 4:");
        String text4 = "зтефян зиса. ёт ёпткисмм сдьи отррифыихоти уфизпткисми ут\n" +
                "утотумнстрч техпчкмёдсмв. д цдоки хумхто уфизтхцдёпгирящ сдрм чхпчж.\n" +
                "ечзир фдзя здпасиньирч уптзтцётфстрч хтцфчзсмыихцёч!";
        String result4 = qw.decrypt(text4, 4);
        System.out.println(result4.concat("\n"));


        System.out.println("ЗАДАНИЕ 5:");
        String text5 = "сьоюьт баюь. обсйат сьоюи этютшцыбай каьа внчщ ын ятюптю.\n" +
                "каь сщм ныыи п кщтшаюцшб ьэцяныцт ыьътышщнабюи ынсь хнамыбай";
        String result5 = qw.decrypt(text5, 14);
        System.out.println(result5.concat("\n"));


        System.out.println("ЗАДАНИЕ 6:");
        String text6 = "упьлнэюняхюр, пшфюьфх! шрщк уъняю щлюлчзк эрьоррнщл. к\n" +
                "кнчкйэз ъафвфлчзщжш ыьрпэюлнфюрчршцьяыщъх ыьъфунъпэюнрщщъчъофэюфгрэцъх цъшылщфф. улщфшлршэк ыъэюлнцлшфыъ йоя ьъээфф";
        String result6 = qw.decrypt(text6, 12);
        System.out.println(result6.concat("\n"));


        System.out.println("ЗАДАНИЕ 7:");
        String text7 = "тэпяйш туьк. рэ юуярйд samsung ai юяэрэтчб тън ьо 10сэ ыоабуя\n" +
                "щъоаа р ысв";
        String result7 = qw.decrypt(text7, 15);
        System.out.println(result7.concat("\n"));


        System.out.println("ЗАДАНИЕ 8:");
        String text8 = "ощлыёф мпвпы, очуэыуф мцкоучуыщмув! ъщоьхксуэп, хщнок ю\n" +
                "шкь люопэ ьцпоюидпп ткшйэуп?";
        String result8 = qw.decrypt(text8, 11);
        System.out.println(result8.concat("\n"));


        System.out.println("ЗАДАНИЕ 9:");
        String text9 = "ощлыёф опшж. мкг ъщвэщмёф йдух кхэумуыщмкцу";
        String result9 = qw.decrypt(text9, 11);
        System.out.println(result9.concat("\n"));


        System.out.println("ЗАДАНИЕ 10:");
        String text10 = "чвфдоэ чшбп, жхуъушаоэ юяьшбё ! х гдвчвяъшбьш булшцв е хуаь\n" +
                "чьуявцу- бугдухятс булш гдшчявъшбьш гв гвчюяскшбьс ьбёшдбшёу чят хулшэ\n" +
                "вдцубьыуйьь!";
        String result10 = qw.decrypt(text10, 20);
        System.out.println(result10.concat("\n"));
    }
}
