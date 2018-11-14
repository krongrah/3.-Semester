package pkg3_semester_clientcomm;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

/**
 *
 * @author Sebas
 */
public class Security {

    private Cipher cipher;
    private String pairAlgorithm = "RSA";
    private String secretAlgorithm = "AES";
    private SecretKey secretKey;
    private PublicKey publicKey;
    private String encodedKey;

    public Security() {
        try {

            KeyGenerator gen = KeyGenerator.getInstance(secretAlgorithm);
            gen.init(128);
            secretKey = gen.generateKey(); // Generates a key, based on a given Algorithm
             encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Encrypts an object according to the transformation string algorithm.
     *
     * @param ser : any serializable object (must be in commondata)
     * @return new SealedObject - an encrypted serializable object.
     * @throws IOException an error during de-serialization
     */
    public SealedObject encryptObject(Serializable ser) throws IOException {
        try {
            cipher.init(ENCRYPT_MODE, secretKey);//Initializes the cipher in encryption mode with the secret key
            return new SealedObject(ser, cipher);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Decrypts an object of the Serializable type according to the
     * transformation string algorithm.
     *
     * @param seal Any sealedobject (A commondata object of the type
     * serializable, which has been encrypted)
     * @return a new Serializable object which is the decrypted SealedObject.
     * @throws IOException - an exception during serialization
     */
    public Serializable decryptObject(SealedObject seal) throws IOException {
        try {
            cipher.init(DECRYPT_MODE, secretKey);//Initializes the cipher in decryption mode with the secret key
            return (Serializable) seal.getObject(cipher);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void setPublicKey(Object publicKey) {
        this.publicKey = (PublicKey) publicKey;
    }

    public SealedObject sendSecretKey() {
        try {
            cipher = Cipher.getInstance(pairAlgorithm); //Returns an instance of the Cipher with a given algorithm
            cipher.init(ENCRYPT_MODE, publicKey);//Initializes the cipher in encryption mode with the secret key
            SealedObject seal = new SealedObject(encodedKey, cipher);
            cipher = Cipher.getInstance(secretAlgorithm); //Returns an instance of the Cipher with a given algorithm
            return seal;
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
