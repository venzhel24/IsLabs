package ru.sfedu.islabs.lab4;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Arg {
    // -- cipher parameters
    // раундов шифрования (16)
    public static final int ROUNDS = 16;
    // -- feistel parameters
    // разрядность блока данных для криптографии, менять нельзя т.к. определяет
    // тип int функции фейстеля
    public static final int DATA_BLOCK_WIDE = 32;
    // разрядность S-блока (4)
    public static final int S_BLOCK_WIDE = 4;
    public static final int MAGIC_ROTATE = 11;
    // разрядность ключа шифрования (128)
    public static final int KEY_SIZE = ROUNDS * DATA_BLOCK_WIDE / S_BLOCK_WIDE;
    // количество S-блоков в раунде (16)
    public static final int S_BLOCKS = 2 * DATA_BLOCK_WIDE / S_BLOCK_WIDE;
    // -- блоки сети фейстеля
    static int s[][][] = new int[ROUNDS][S_BLOCKS][(int) Math.pow(2, S_BLOCK_WIDE)]; // 16,16,16
    static void generate(int studentNum) {
        Random rand = new Random(studentNum);
        for (int r = 0; r < s.length; r++) {
            System.out.printf("ROUND: %d\n", r);
            for (int i = 0; i < s[r].length; i++) {
                System.out.print(" {");
                for (int j = 0; j < s[r][i].length; j++) {
                    s[r][i][j] = rand.nextInt(s[r][i].length);
                    System.out.print(s[r][i][j] + ",");
                }
                System.out.println("},");
            }
        }
    }

    static int str2int(String s) {
        int rez = 0;
        for (int i = 0; i < 4; i++) {
            rez |= (s.charAt(i) & 255) << (i * 8);
        }
        return rez;
    }
    static String int2str(int l) {
        String rez = "";
        for (int i = 0; i < 4; i++) {
            rez += (char) (l & 255);
            l >>= 8;
        }
        return rez;
    }

    static long str2long(String s) {
        long rez = 0;
        for (int i = 0; i < 4; i++) {
            rez |= (long) (s.charAt(i) & 255) << (i * 8);
        }
        return rez;
    }

    static String long2str(long l) {
        String rez = "";
        for (int i = 0; i < 4; i++) {
            rez += (char) (l & 255);
            l >>= 8;
        }
        return rez;
    }

    public static void main(String[] args) {
        generate(Integer.parseInt(args[0]));
        String message=args[1];
        String pass_key=args[2];
        System.out.printf("==========\nисходные данные(2x32бит): \"%s\"\n",message);
        System.out.printf("ключ шифрования(128 бит): \"%s\"\n",pass_key);
        String rez=crypt(message,pass_key);
        System.out.println("зашифрованные данные: "+rez);
        rez=decrypt(rez,pass_key);
        System.out.println("расшифрованные данные: "+rez);
    }

    public static String crypt(String message,String pass_key) {
        int l = str2int(message.substring(0, 4));
        int r = str2int(message.substring(4, 8));
        return get_code(l, r, pass_key, false);
    }

    public static String decrypt(String message,String pass_key) {
        int r = str2int(message.substring(0, 4));
        int l = str2int(message.substring(4, 8));
        return get_code(l, r, pass_key, true);
    }

    public static String get_code(int l, int r, String pass_key, boolean decrypt) {

        byte[] arr_bytes = pass_key.getBytes(StandardCharsets.UTF_8);
        String[] code_keys = new String[arr_bytes.length];

        for(int i = 0; i < code_keys.length; i++){
            code_keys[i] = Integer.toBinaryString(arr_bytes[i]);
        }

        if(decrypt) {
            for (int i = ROUNDS - 1; i >= 0; i--) {
                String sBlock = s_block(l, i, String.valueOf(code_keys[i]));
                int temp = r ^ Integer.rotateLeft(Integer.parseUnsignedInt(sBlock, 2), MAGIC_ROTATE);
                r = l;
                l = temp;
            }

            return int2str(r) + int2str(l);
        }
        else {
            for (int i = 0; i < ROUNDS; i++) {
                String sBlock = s_block(l, i, String.valueOf(code_keys[i]));
                int temp = r ^ Integer.rotateLeft(Integer.parseUnsignedInt(sBlock, 2), MAGIC_ROTATE);
                r = l;
                l = temp;
            }

            return int2str(l) + int2str(r);
        }
    }

    static String s_block(int l, int r, String key) {
        StringBuilder keyBuilder = new StringBuilder(key);

        while(keyBuilder.length() != 8) {
            keyBuilder.insert(0, '0');
        }

        String new_key = keyBuilder.toString();

        String l_b = Integer.toBinaryString(l);
        StringBuilder l_bBuilder = new StringBuilder(l_b);

        while(l_bBuilder.length() != 32) {
            l_bBuilder.insert(0, '0');
        }

        l_b = l_bBuilder.toString();

        String tmp;
        int tmp4int;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < new_key.length(); i++){
            tmp = l_b.substring(i*4, i*4+4);
            tmp4int = s[r][i*2 + Integer.parseInt(String.valueOf(new_key.charAt(i)))][Integer.parseInt(tmp, 2)];
            result.append(String.format("%4s", Integer.toBinaryString(tmp4int)).replace(' ', '0'));
        }
        return result.toString();
    }

    static long getUnsigned(int signed) {
        return signed >= 0 ? signed : 2 * (long) Integer.MAX_VALUE + 2 + signed;
    }
}
