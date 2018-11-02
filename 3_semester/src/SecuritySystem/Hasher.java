/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecuritySystem;

import ProjectInterfaces.IHasher;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hasher class used for hashing a string value
 *
 * @author Sebas
 */
public class Hasher implements IHasher{

//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        System.out.println(hash("password"));
//    }
    
    /**
     * Hashes the value from a string to a byte array, then calls bytesToHex()
     *
     * @param value : String
     * @return Hashed value
     * @throws NoSuchAlgorithmException
     */
    public String hash(String value) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                value.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
    }

    /**
     * Converts a byte array to a hex string
     *
     * @param hash : byte array
     * @return A conversion of a byte array to a hex string
     */
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
