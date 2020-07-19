package app.config.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author pickjob@126.com
 * @date 2020-06-26
 */
@ConfigurationProperties( prefix = "jwt")
@Configuration
public class JwtProperties {
    private static final Logger logger = LogManager.getLogger(JwtProperties.class);
    private String publicKey;
    private String privateKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public PrivateKey getRsaPrivateKey() {
        try {
            KeyFactory rsaKeyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(getPrivateKey()));
            PrivateKey privateKey = rsaKeyFactory.generatePrivate(privateKeySpec);
            return privateKey;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public PublicKey getRsaPublicKey() {
        try {
            KeyFactory rsaKeyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(getPublicKey()));
            PublicKey publicKey = rsaKeyFactory.generatePublic(publicKeySpec);
            return publicKey;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
