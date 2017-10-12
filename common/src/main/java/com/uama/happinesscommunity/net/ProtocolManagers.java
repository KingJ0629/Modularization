package com.uama.happinesscommunity.net;


import android.content.Context;

import com.uama.happinesscommunity.CommonApplication;
import com.uama.happinesscommunity.common.BuildConfig;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gujiajia on 2016/4/13.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class ProtocolManagers {

    private Retrofit retrofit;
    private static ProtocolManagers mInstance;
    private static ProtocolManagers newInstance;
    private static final int CONNECT_TIMEOUT_MILLIS = 30 * 1000; // 30s
    private OkHttpClient client;

    private ProtocolManagers(Context context) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Retrofit2Interceptor(context));
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
//        httpClient.addInterceptor(loggingInterceptor);
        httpClient.connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.retryOnConnectionFailure(true);
    
        // 配置 https 证书
        X509TrustManager trustManager;
        SSLSocketFactory sslSocketFactory;
        try {
            trustManager = trustManagerForCertificates(trustedCertificatesInputStream());
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { trustManager }, null);
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (GeneralSecurityException |IOException e) {
            throw new RuntimeException(e);
        }
        httpClient.sslSocketFactory(sslSocketFactory, trustManager);
        
        
        client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jnhtest.4001113900.com:8111/uama-community/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


    private ProtocolManagers(Context context, long timeOut) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Retrofit2Interceptor(context));
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
//        httpClient.addInterceptor(loggingInterceptor);
        httpClient.connectTimeout(timeOut, TimeUnit.MILLISECONDS);
        httpClient.writeTimeout(timeOut, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(timeOut, TimeUnit.MILLISECONDS);
        httpClient.retryOnConnectionFailure(false);//网络请求失败，重复请求
    
        // 配置 https 证书
        X509TrustManager trustManager;
        SSLSocketFactory sslSocketFactory;
        try {
            trustManager = trustManagerForCertificates(trustedCertificatesInputStream());
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { trustManager }, null);
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (GeneralSecurityException |IOException e) {
            throw new RuntimeException(e);
        }
        httpClient.sslSocketFactory(sslSocketFactory, trustManager);
        
        
        retrofit = null;
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jnhtest.4001113900.com:8111/uama-community/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public static ProtocolManagers getInstance(Context context) {
        return null == mInstance ? mInstance = new ProtocolManagers(context) : mInstance;
    }

    public static ProtocolManagers getInstance(Context context, long shortOutTime) {
        return null == newInstance ? newInstance = new ProtocolManagers(context, shortOutTime) : newInstance;
    }

    /**
     * 根据指定的Service.Class ，得到一个被代理后Service
     *
     * @param <T>service
     * @return T
     */
    public <T> T getService(Class<T> service) {
        return retrofit.create(service);
    }
    
    
    
    X509TrustManager xtm = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }
        
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }
        
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            X509Certificate[] x509Certificates = new X509Certificate[0];
            return x509Certificates;
        }
    };
    
    
    /**
     * Returns an input stream containing one or more certificate PEM files.
     */
    private InputStream trustedCertificatesInputStream() throws IOException {
        // 访问接口的证书
        InputStream certInputStream = CommonApplication.context.getAssets().open("star_uama_com_cn_jnh.pem");

        // 代理证书，配置以方便开发的时候进行抓包
        /*
        代理证书的说明：
        配置使用 https 之后，如果不将代理（Charles 或 Fiddler）证书加入信任列表，将无法通过代理进行抓包。
        将 charles.pem 或 fiddler.cer 或两者放入 app/src/debug/assets 目录下。
        1. 证书名字和格式说明：
        Charles 的证书为 charles.pem，Fiddler 的证书为 fiddler.cer，名字算是一种约定。
        本质上证书格式不会造成影响，Charles 使用 pem 格式，Fiddler 使用 cer 格式是因为这是他们各自导出证书的默认格式。
        2. 证书存放位置说明：
        证书必须放到 app/src/debug/assets 目录下，是因为只有在开发的时候才需要抓包，放到该目录下不会在正式打包的时
        候包含到包里面造成不必要的包体积增加。另外，每个人电脑上安装的代理软件（Charles 或 Fiddler）对应的证书
        可能不一样，为了隔离，我将 /src/debug/assets/charles.pem 和 /src/debug/assets/fiddler.cer
        放到了 app/.gitignore 中（也就是没有将代理证书加入 Git 仓库），每个有抓包需求的开发者自行将自己需要的证书
        放到指定目录下（没有的话手动创建）。
         */
       if (BuildConfig.DEBUG) {
            InputStream proxyInputStream = null;
            // charles 的证书
            InputStream charlesInputStream = null;
            try {
                charlesInputStream = CommonApplication.context.getAssets().open("charles.pem");
            } catch (IOException e) {
                e.printStackTrace();
            }
//            // fiddler 的证书
//            InputStream fiddlerInputStream = null;
//            try {
//                fiddlerInputStream = SeApp.context.getAssets().open("fiddler.cer");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            if (charlesInputStream != null) {
                // 注意 SequenceInputStream 构造的第一个参数不能为 null
                proxyInputStream = new SequenceInputStream(charlesInputStream, null);
            }
//            else if (fiddlerInputStream != null) {
//                proxyInputStream = fiddlerInputStream;
//            }
            return new SequenceInputStream(certInputStream, proxyInputStream);
        }
        return certInputStream;
    }
    
    /**
     * Returns a trust manager that trusts certificates and none other. HTTPS services whose
     * certificates have not been signed by these certificates will fail with a
     * SSLHandshakeException.
     */
    private X509TrustManager trustManagerForCertificates(InputStream in)
            throws GeneralSecurityException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(in);
        
        // Put the certificates a key store.
        char[] password = "anchangzhushou".toCharArray();
        KeyStore keyStore = newEmptyKeyStore(password);
        int index = 0;
        for (Certificate certificate : certificates) {
            String certificateAlias = Integer.toString(index++);
            keyStore.setCertificateEntry(certificateAlias, certificate);
        }
        
        // Use it to build an X509 trust manager.
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust manager:"
                    + Arrays.toString(trustManagers));
        }
        return (X509TrustManager) trustManagers[0];
    }
    
    private KeyStore newEmptyKeyStore(char[] password) throws GeneralSecurityException{
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, password);
            return keyStore;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
