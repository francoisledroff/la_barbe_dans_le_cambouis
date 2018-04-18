/*
 * ******************************************************************************
 *  * ADOBE CONFIDENTIAL
 *  * ___________________
 *  *
 *  * Copyright 2016 Adobe Systems Incorporated
 *  * All Rights Reserved.
 *  *
 *  * NOTICE:  All information contained herein is, and remains
 *  * the property of Adobe Systems Incorporated and its suppliers,
 *  * if any.  The intellectual and technical concepts contained
 *  * herein are proprietary to Adobe Systems Incorporated and its
 *  * suppliers and are protected by trade secret or copyright law.
 *  * Dissemination of this information or reproduction of this material
 *  * is strictly forbidden unless prior written permission is obtained
 *  * from Adobe Systems Incorporated.
 *  *****************************************************************************
 */

package chez.les.barbus.danslecambouis.conf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration
public class SSLConfig2 {

  private static Logger log = LoggerFactory.getLogger(SSLConfig2.class);

  @Autowired
  private Environment env;

  @PostConstruct
  private void configureSSL()
      throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

    SSLContext sslContext = SSLContext.getInstance("SSL");
    KeyStore keystore = createKeyStore(new URL(env.getProperty("JAVA_TRUST_STORE")),
        env.getProperty("JAVA_TRUST_STORE_PASSWORD"));
    logTrustStore(keystore);
    TrustManager[] trustmanagers = createTrustManagers(keystore);

    sslContext.init(null, trustmanagers, new java.security.SecureRandom());

  }

  private static KeyStore createKeyStore(final URL url, final String password) throws KeyStoreException,
      NoSuchAlgorithmException, CertificateException , IOException
  {
    if (url == null)
    {
      throw new IllegalArgumentException("Keystore url may not be null");
    }
    KeyStore keystore = KeyStore.getInstance("jks");
    if (url.toString().endsWith("p12"))
      keystore = KeyStore.getInstance("PKCS12");
    InputStream is = null;
    try
    {
      is = url.openStream();
      keystore.load(is, password != null ? password.toCharArray() : null);
    } finally
    {
      if (is != null)
        is.close();
    }
    return keystore;
  }

  private void logTrustStore(KeyStore keystore) throws KeyStoreException
  {
    Enumeration<String> aliases = keystore.aliases();
    while (aliases.hasMoreElements())
    {
      String alias = (String) aliases.nextElement();
      log.debug("Trusted certificate '" + alias + "':");
      Certificate trustedcert = keystore.getCertificate(alias);
      if (trustedcert != null && trustedcert instanceof X509Certificate)
      {
        X509Certificate cert = (X509Certificate) trustedcert;
        log.debug("  Subject DN: " + cert.getSubjectDN());
        log.debug("  Signature Algorithm: " + cert.getSigAlgName());
        log.debug("  Valid from: " + cert.getNotBefore());
        log.debug("  Valid until: " + cert.getNotAfter());
        log.debug("  Issuer: " + cert.getIssuerDN());
      }
    }
  }

  private static TrustManager[] createTrustManagers(final KeyStore keystore)
      throws KeyStoreException, NoSuchAlgorithmException
  {
    if (keystore == null) {
      throw new IllegalArgumentException("Keystore may not be null");
    }
    log.debug("Initializing trust manager");
    TrustManagerFactory tmfactory = TrustManagerFactory.getInstance(
        TrustManagerFactory.getDefaultAlgorithm());
    tmfactory.init(keystore);
    TrustManager[] trustmanagers = tmfactory.getTrustManagers();
    for (int i = 0; i < trustmanagers.length; i++) {
      if (trustmanagers[i] instanceof X509TrustManager) {
        /*trustmanagers[i] = new SSLClientX509TrustManager(
            (X509TrustManager)trustmanagers[i]);*/
      }
    }
    return trustmanagers;
  }
}