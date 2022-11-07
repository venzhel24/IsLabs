package ru.sfedu.islabs.lab3;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CryptoTest {
    private static int[] PI_SUBST = {41, 46, 67, 201, 162, 216, 124, 1, 61, 54, 84, 161, 236, 240, 6,
            19, 98, 167, 5, 243, 192, 199, 115, 140, 152, 147, 43, 217, 188,
            76, 130, 202, 30, 155, 87, 60, 253, 212, 224, 22, 103, 66, 111, 24,
            138, 23, 229, 18, 190, 78, 196, 214, 218, 158, 222, 73, 160, 251,
            245, 142, 187, 47, 238, 122, 169, 104, 121, 145, 21, 178, 7, 63,
            148, 194, 16, 137, 11, 34, 95, 33, 128, 127, 93, 154, 90, 144, 50,
            39, 53, 62, 204, 231, 191, 247, 151, 3, 255, 25, 48, 179, 72, 165,
            181, 209, 215, 94, 146, 42, 172, 86, 170, 198, 79, 184, 56, 210,
            150, 164, 125, 182, 118, 252, 107, 226, 156, 116, 4, 241, 69, 157,
            112, 89, 100, 113, 135, 32, 134, 91, 207, 101, 230, 45, 168, 2, 27,
            96, 37, 173, 174, 176, 185, 246, 28, 70, 97, 105, 52, 64, 126, 15,
            85, 71, 163, 35, 221, 81, 175, 58, 195, 92, 249, 206, 186, 197,
            234, 38, 44, 83, 13, 110, 133, 40, 132, 9, 211, 223, 205, 244, 65,
            129, 77, 82, 106, 220, 55, 200, 108, 193, 171, 250, 36, 225, 123,
            8, 12, 189, 177, 74, 120, 136, 149, 139, 227, 99, 232, 109, 233,
            203, 213, 254, 59, 0, 29, 57, 242, 239, 183, 14, 102, 88, 208, 228,
            166, 119, 114, 248, 235, 117, 75, 10, 49, 68, 80, 180, 143, 237,
            31, 26, 219, 153, 141, 51, 159, 17, 131, 20};

    public static void main(String[] args) {
        String msg = "hello, world!";
        //System.out.println(hashTest(args[0].toCharArray()));
        System.out.println(hashTest(msg.toCharArray()));
    }

    public static String hashTest(char[] msg){
        byte[] arr_bytes = new String(msg).getBytes(StandardCharsets.UTF_8);
        int[] arr_ints = new int[arr_bytes.length];
        for(int i = 0; i < arr_ints.length; i++){
            arr_ints[i] = arr_bytes[i];
        }

        System.out.println("start array\n" + Arrays.toString(arr_ints));

        // Step 1
        int leng = 16 - arr_ints.length % 16;
        int[] padded_array = new int[arr_ints.length+leng];
        System.arraycopy(arr_ints, 0, padded_array, 0, arr_ints.length);
        for(int i = 0; i < leng; i++){
            padded_array[arr_ints.length+i] = leng;
        }
        System.out.println("step 1 result\n"+Arrays.toString(padded_array));

        // Step 2
        int[] check_sum = new int[16];
        int l = 0;
        int c;
        for(int i = 0; i < padded_array.length/16; i++) {
            for(int j = 0; j < 16; j++){
                c = padded_array[i*16+j];
                check_sum[j] = (check_sum[j]^PI_SUBST[(c^l)]);
                l = check_sum[j];
            }
        }
        //System.out.println(Arrays.toString(arr_C));
        int[] new_padded_array= new int[padded_array.length+check_sum.length];
        System.arraycopy(padded_array, 0, new_padded_array, 0, padded_array.length);
        System.arraycopy(check_sum, 0, new_padded_array, padded_array.length, check_sum.length);
        System.out.println("step 2 result\n" + Arrays.toString(new_padded_array));

        // Step 3
        int[] arr_X = new int[48];
        int t;
        for(int i = 0; i < new_padded_array.length/16; i++) {
            for(int j = 0; j < 16; j++){
                arr_X[16+j] = new_padded_array[i*16+j];
                arr_X[32+j] = arr_X[16+j]^arr_X[j];
            }

            t = 0;

            for(int j = 0; j < 18; j++) {
                for(int k = 0; k < 48; k++) {
                    t = arr_X[k]^PI_SUBST[t];
                    arr_X[k] = arr_X[k]^PI_SUBST[t];
                }

                t = (t + j) / 256;
                //System.out.println(Arrays.toString(arr_X));
            }
        }
        System.out.println("step 3 result\n" + Arrays.toString(arr_X));

        // step 4
        byte[] result_arr = new byte[16];
        for(int i = 0; i < result_arr.length; i++) {
            if(arr_X[i] < 0) arr_X[i]+=127;
            else if (arr_X[i] > 128) {
                arr_X[i] -= 127;
            }
            result_arr[i] = (byte)(arr_X[i]);
        }

        System.out.println("step 4 result\n" + Arrays.toString(result_arr));
        StringBuilder sb = new StringBuilder(result_arr.length * 2);
        for(byte b: result_arr)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
