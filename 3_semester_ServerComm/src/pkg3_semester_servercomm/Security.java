package pkg3_semester_servercomm;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

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
    private PrivateKey privateKey;

    public Security() {
        try {
            cipher = Cipher.getInstance(pairAlgorithm); //Returns an instance of the Cipher with a given algorithm

            KeyPairGenerator gen = KeyPairGenerator.getInstance(pairAlgorithm);
            gen.initialize(512);
            KeyPair keyPair = gen.genKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
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

    public PublicKey getPublicKey() {
        return publicKey;
    }

    void recieveSecretKey(SealedObject encryptedSecretKey) {
        try {
            cipher.init(DECRYPT_MODE, privateKey);//Initializes the cipher in decryption mode with the secret key
            byte[] decodedKey = Base64.getDecoder().decode((String) encryptedSecretKey.getObject(cipher));
            secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
            cipher = Cipher.getInstance(secretAlgorithm); //Returns an instance of the Cipher with a given algorithm

        } catch (InvalidKeyException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
