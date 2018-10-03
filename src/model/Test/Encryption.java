package model.Test;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

    private static final String AES = "AES";
    private static final String key = "07FF92DF0E195D39AF981E70AFFB2CF1";
    private Cipher cipher;
    private SecretKeySpec sks;

    public Encryption(){
        try {
            byte[] byteKey = hexStringToByteArray(key);
            sks = new SecretKeySpec(byteKey, AES);
            cipher = Cipher.getInstance(Encryption.AES);
        }
        catch(NoSuchAlgorithmException | NoSuchPaddingException ex){
            ex.printStackTrace();
        }
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    private static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }

    public String getEncryptedString(String input){
        String encryptedStr = "";
        try {
            cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
            byte[] encrypted = cipher.doFinal(input.getBytes());

            encryptedStr = byteArrayToHexString(encrypted);
        }
        catch(InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex)
        {
            ex.printStackTrace();
        }

        return encryptedStr;
    }

    public String getDecryptedString(String input){
        String decryptedStr = "";
        try {
            cipher.init(Cipher.DECRYPT_MODE, sks);
            byte[] decrypted = cipher.doFinal(hexStringToByteArray(input));
            decryptedStr = new String(decrypted);
        }
        catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex)
        {
            ex.printStackTrace();
        }
        return decryptedStr;
    }
/*
    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
        //String key = "DB99A2A8EB6904F492E9DF0595ED683C";
        //String password = "Admin";
        Encryption zz = new Encryption();
        String enc = zz.getEncryptedString("hahahha");
        System.out.println("****************  Encrypted Password  ****************");
        System.out.println(enc);

        System.out.println("****************  Original Password  ****************");
        System.out.println(zz.getDecryptedString(enc));

    }
*/
}
