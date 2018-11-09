/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commondata;

import ProjectInterfaces.ICommonCipher;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Sebas
 */
public class CommonCipher implements ICommonCipher {

    private Cipher cipher;
    private String transformation = "DES";
    private SecretKeySpec secret;
    private SecretKey secretKey;

    public Cipher getCipher() {
        try {
            secretKey = KeyGenerator.getInstance(this.transformation).generateKey(); // Generates a key, based on a given Algorithm

            secret = new SecretKeySpec(secretKey.getEncoded(), transformation); //Initializes the secretKeySpec with a given key's Byte[] value, and the algorithm

            cipher = javax.crypto.Cipher.getInstance(transformation); //Returns an instance of the CommonCipher with a given algorithm
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CommonCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CommonCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cipher;
    }

    public String getTransformation() {
        return this.transformation;
    }

    public SecretKeySpec getKeySpec() {
        return this.secret;
    }

    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    /**
     * Gets the cipher for encryption
     *
     * @return the cipher
     */
    @Override
    public Cipher getEncryptCipher() {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(transformation);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CommonCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CommonCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cipher.init(ENCRYPT_MODE, secret);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(CommonCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cipher;
    }

    /**
     * Gets the cipher for decryption
     *
     * @return the cipher
     */
    @Override
    public Cipher getDecryptCipher() {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(transformation);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CommonCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CommonCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cipher.init(DECRYPT_MODE, secret);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(CommonCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cipher;

    }
}
