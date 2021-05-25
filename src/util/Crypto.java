package util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Crypto {


    // when click on the "Decrypt Form" button, it is check text and key fields are empty or not
    // if it is not empty then pop up the encrypted text in cipher text field.
    //In Encryption process, text take to reverse, next add the ascii valuve of "z" for each of letter's ascii and numerical key value,
    //That summation of ascii convert to the new character.
    //Get a new String by new characters build as cipher text.

    public static String encrypt(String text, String key) {
        String textEncoded = "";
        String finalString = "";
        int i = 0;

        if (text.trim().isEmpty() && key.trim().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Check whether your text field or key field is empty", ButtonType.CANCEL).show();

        } else {
            try {
                int keyInt = Integer.parseInt(key);
                for (char s1 : text.toCharArray()
                ) {
                    textEncoded = (char) ((int) s1 + (int) ('z')) + textEncoded;
                }

                String keyEncoded = "";
                int j = 0;

                for (char keys : key.toCharArray()
                ) {
                    j = (int) keys + (int) ('z');
                    //System.out.println((char)j);
                    keyEncoded = (char) j + keyEncoded;
                }

                finalString = keyEncoded + textEncoded;
                //txtCipherText.setText(finalString);

            } catch (Exception e) {
                new Alert(Alert.AlertType.WARNING, "Please enter numerical input for the key ", ButtonType.CANCEL).show();
            }


        }
        return finalString;
        //return finalString;
    }


    //when click on "Decryption" button,it is get both text of cipher and key text fields,
    //and check those are empty or not.if it is empty it give a msg about it.if it is not,it going to decode the cipher as text and key
    //finally check the key is correct with decrypted key.it is correct then decr000ypted text is deploy on text field.
    public static String decrypt(String inputString, String inputKey) {
        String keyFinder = "";
        String decodeText = "";

        try {
            //System.out.println(inputString.toCharArray().length);

            int keyInput = Integer.parseInt(inputKey);

            String decrypted = "";
            for (int i = 0; i < inputString.toCharArray().length; i++) {
                decrypted = decrypted + (char) ((int) inputString.toCharArray()[i] - (int) ('z'));
            }

            String decryptedFinal = "";

            for (char s1 : decrypted.toCharArray()
            ) {
                decryptedFinal = s1 + decryptedFinal;

            }

            int l = 0;

            char c[] = decryptedFinal.toCharArray();
            for (int i = c.length - 1; i > -1; i--) {

                if (l < inputKey.length()) {
                    keyFinder = c[i] + keyFinder;
                    l++;
                } else {
                    decodeText = c[i] + decodeText;
                }


            }
            if (keyFinder.equals(inputKey)) {
                //txtDecrypted.setText(decodeText); //
                return decodeText;
            } else {
                new Alert(Alert.AlertType.ERROR, "Access Denied", ButtonType.CANCEL).show();
                return "Access Denied";

            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Please check the key ", ButtonType.CANCEL).show();
            return "Please check the key";

        }


        //return decodeText;
    }

}
