package dataHelper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import Util.Function;

/** 
 * 通过自定义 TrustManager 来实现无根证书时访问 https 
 *@author linqiuping
 */  
public class HttpHander {  
       
	static String dateurl="https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=";
	static String from_station= "&leftTicketDTO. from_station=";
	static String to_station="&leftTicketDTO.to_station=";
	static String end		= "&purpose_codes=ADULT";

    public static void main(String[] args) throws Exception {  
        HttpHander test=new HttpHander();
    }  
      
    public String getTrain(String date,String start ,String endN)throws Exception {
    	init();
    	URL url = new URL(dateurl+date+from_station+start+to_station+endN+end);  
        url.openConnection();  
        InputStream in = url.openStream();  
        BufferedReader buf = new BufferedReader(new InputStreamReader(in));  
        String line = null;
        String totalLine="";
        while ((line = buf.readLine()) != null){  
            System.out.println(line);  
            totalLine+=line;
        }  
        buf.close();  
        in.close();  
       Function.println(totalLine);
		return totalLine; 
       
	}
    /** 
     * 初始化 
     */  
    public static void init() {  
        try {  
            SSLContext sslCtx = SSLContext.getInstance("TLS");  
            sslCtx.init(null, new TrustManager[]{new MyTrustManager()}, null);  
            SSLSocketFactory sslSocketFactory = sslCtx.getSocketFactory();  
            HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);  
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {  
                @Override  
                public boolean verify(String hostname, SSLSession session) {  
                    return true;  
                }  
            });  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  
/** 
 * 默认信任服务端根证书 
 */  
class MyTrustManager implements X509TrustManager {  
      
    @Override  
    public void checkClientTrusted(X509Certificate[] chain, String authType)  
            throws CertificateException {  
        return;  
    }  
      
    @Override  
    public void checkServerTrusted(X509Certificate[] chain, String authType)  
            throws CertificateException {  
        return;  
    }  
      
    @Override  
    public X509Certificate[] getAcceptedIssuers() {  
        return null;  
    }  
}  