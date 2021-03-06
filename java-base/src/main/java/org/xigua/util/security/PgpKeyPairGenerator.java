package org.xigua.util.security;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.RSASecretBCPGKey;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyConverter;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.Date;

/**
 * @author xigua
 * @description 生成秘钥
 */
public class PgpKeyPairGenerator {


    /**
     * 导出秘钥对
     *
     * @param secretOut  私钥导出位置
     * @param publicOut  公钥导出位置
     * @param publicKey  公钥
     * @param privateKey 私钥
     * @param identity   身份信息
     * @param passPhrase
     * @param armor      混淆
     * @throws IOException
     * @throws PGPException
     */
    public void exportKeyPair(OutputStream secretOut,
                              OutputStream publicOut,
                              PublicKey publicKey,
                              PrivateKey privateKey,
                              String identity,
                              char[] passPhrase,
                              boolean armor)
            throws IOException, PGPException {
        if (armor) {
            secretOut = new ArmoredOutputStream(secretOut);
        }


        PGPPublicKey a = (new JcaPGPKeyConverter().getPGPPublicKey(PGPPublicKey.RSA_GENERAL, publicKey, new Date()));
        RSAPrivateCrtKey rsK = (RSAPrivateCrtKey) privateKey;
        RSASecretBCPGKey privPk = new RSASecretBCPGKey(rsK.getPrivateExponent(), rsK.getPrimeP(), rsK.getPrimeQ());
        PGPPrivateKey b = new PGPPrivateKey(a.getKeyID(), a.getPublicKeyPacket(), privPk);

        PGPDigestCalculator sha1Calc = new JcaPGPDigestCalculatorProviderBuilder().build().get(HashAlgorithmTags.SHA1);
        PGPKeyPair keyPair = new PGPKeyPair(a, b);
        PGPSecretKey secretKey = new PGPSecretKey(PGPSignature.DEFAULT_CERTIFICATION,
                keyPair,
                identity,
                sha1Calc,
                null,
                null,
                new JcaPGPContentSignerBuilder(keyPair.getPublicKey().getAlgorithm(), HashAlgorithmTags.SHA1),
                new JcePBESecretKeyEncryptorBuilder(PGPEncryptedData.CAST5, sha1Calc).setProvider("BC").build(passPhrase));

        secretKey.encode(secretOut);

        secretOut.close();

        if (armor) {
            publicOut = new ArmoredOutputStream(publicOut);
        }

        PGPPublicKey key = secretKey.getPublicKey();

        key.encode(publicOut);

        publicOut.close();
    }


}
