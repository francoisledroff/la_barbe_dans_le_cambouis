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

import com.mongodb.MongoClientOptions;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration
public class SSLConfig {

  private static Logger log = LoggerFactory.getLogger(SSLConfig.class);

  @Autowired
  private Environment env;

  private MongoClientOptions mongoClientOptions;

  @PostConstruct
  private void configureSSL()
      throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    //set to TLSv1.1 or TLSv1.2
    System.setProperty("https.protocols", "TLSv1.1");

    //load the 'javax.net.ssl.trustStore' and
    //'javax.net.ssl.trustStorePassword' from application.properties
    System.setProperty("javax.net.ssl.trustStore", env.getProperty("JAVA_TRUST_STORE"));
    System.setProperty("javax.net.ssl.trustStorePassword",env.getProperty("JAVA_TRUST_STORE_PASSWORD"));

    SSLContext sslContext = SSLContext.getInstance("SSL");
    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

    MongoClientOptions mongoClientOptions=MongoClientOptions.builder().
        sslEnabled(true).
        sslInvalidHostNameAllowed(true).
        socketFactory(sslContext.getSocketFactory()).
        build();
  }

  // Create a trust manager that does not validate certificate chains
  TrustManager[] trustAllCerts = new TrustManager[] {
      new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
          return new X509Certificate[0];
        }
        public void checkClientTrusted(
            java.security.cert.X509Certificate[] certs, String authType) {
        }
        public void checkServerTrusted(
            java.security.cert.X509Certificate[] certs, String authType) {
        }
      }
  };

  @Bean
  public  MongoClientOptions mongoClientOptions(){
    return mongoClientOptions;
  }
}