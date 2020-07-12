package org.xigua;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author xigua
 */
//@Configuration
public class ApplicationCfgEncrypted implements CommandLineRunner {

    private ApplicationContext applicationContext;

    private StringEncryptor stringEncryptor;

    @Autowired
    public ApplicationCfgEncrypted(ApplicationContext applicationContext, StringEncryptor stringEncryptor) {
        this.applicationContext = applicationContext;
        this.stringEncryptor = stringEncryptor;
    }

    @Override
    public void run(String... args) throws Exception {

        Environment environment = applicationContext.getBean(Environment.class);

        String mysqlOriginPawd = environment.getProperty("spring.datasource.druid.password");
        String mysqlOriginUrl = environment.getProperty("spring.datasource.druid.url");
        String mysqlOriginUser = environment.getProperty("spring.datasource.druid.username");

        String mysqlEncryptedPawd = encrypt(mysqlOriginPawd);
        String mysqlEncryptedUrl = encrypt(mysqlOriginUrl);
        String mysqlEncryptedUser = encrypt(mysqlOriginUser);

        //=================================mysql
        System.out.println(mysqlOriginPawd);
        System.out.println(mysqlOriginUrl);
        System.out.println(mysqlOriginUser);

        System.out.println("加密后");

        System.out.println("密码" + mysqlEncryptedPawd);
        System.out.println("地址" + mysqlEncryptedUrl);
        System.out.println("用户" + mysqlEncryptedUser);
		/*密码5hr+DY3QUf9PlTcOqr5jkiUb1dLexwGv0V2dpuHz51/VnJOifVNNtPqOpsEyWo1H
		地址zMranCcK1z0qC0eOrQMW6B+ler4Aq+iB47Y4J8kb49z+JyIzVVY/SPyX3i7xqKtw/uupFVXvdAnPNelthqpaobdF9PM4rXSSX+ToACHDyKKI6zidNGnzBW1q5VS0kFLJ5SESk4bZiWw23WYLjS5RkqkiLHLXEQkXnse3ekOpuPuxvhypZ6xFrT3/5wjyZgqitcA/9U9OtNHW96twjIxDSQ==
		用户TzFaR0+ZyLE7UITozxoKaTOjxK2QBMUmYjokRo5JE+LugquN6hIMSexdyU9/yvF6*/

        //====================================redis

    }

    /**
     * 加密
     *
     * @param origin
     * @return
     */
    private String encrypt(String origin) {
        String encryptStr = stringEncryptor.encrypt(origin);
        return encryptStr;
    }

    /**
     * 解密
     *
     * @param encrypted
     * @return
     */
    private String decrypt(String encrypted) {
        String decryptStr = stringEncryptor.decrypt(encrypted);
        return decryptStr;
    }


}
