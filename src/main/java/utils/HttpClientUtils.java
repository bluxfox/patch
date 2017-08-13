package utils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * Created by mad-man on 2017/8/12.
 */
public class HttpClientUtils {
    static final String URL = "https://www.stubhub.com/shape/search/inventory/v2/listings/?eventId=9708708&sectionStats=true&zoneStats=false&start=0&allSectionZoneStats=true&eventLevelStats=true&quantitySummary=true&rows=20&sort=value+desc,price+asc&edgeControlEnabled=true&urgencyMessaging=true&priceType=nonBundledPrice&valuePercentage=true&shstore=1";
    static final String URL_TEMPLATE = "https://www.stubhub.com/shape/search/inventory/v2/listings/?eventId=${eventId}&sectionStats=true&zoneStats=false&start=${start}&allSectionZoneStats=true&eventLevelStats=true&quantitySummary=true&rows=20&sort=value+desc,price+asc&edgeControlEnabled=true&urgencyMessaging=true&priceType=nonBundledPrice&valuePercentage=true&shstore=1&sectionIdList=${sectionIdList}";
//    static final String URL_TEMPLATE = "https://www.stubhub.com/shape/search/inventory/v2/listings/?eventId=${eventId}&sectionStats=true&zoneStats=true&start=${start}&allSectionZoneStats=true&eventLevelStats=true&quantitySummary=true&rows=20&sort=price+asc,value+desc&edgeControlEnabled=true&urgencyMessaging=true&priceType=nonBundledPrice&valuePercentage=true&shstore=1";
    public static HttpClient getHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("SSL");

        // set up a TrustManager that trusts everything
        sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs,
                                           String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs,
                                           String authType) {
            }
        }}, new SecureRandom());

        SSLSocketFactory sf = new SSLSocketFactory(sslContext);
        Scheme httpsScheme = new Scheme("https", 443, sf);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(httpsScheme);

        // apache HttpClient version >4.2 should use BasicClientConnectionManager
        ClientConnectionManager cm = new SingleClientConnManager(schemeRegistry);
        HttpClient httpClient = new DefaultHttpClient(cm);
        return httpClient;
    }

    public static HttpGet getHttpGet(String eventId, String sectionIdList, Integer start){
        String getUrl = URL_TEMPLATE.replace("${eventId}", eventId).replace("${start}", start + "").replace("${sectionIdList}", sectionIdList == null || sectionIdList.equals("") ? "" : sectionIdList);
        System.out.println("URL=" + getUrl);
        HttpGet httpget = new HttpGet(getUrl);

//            httpget.setHeader(":authority", "www.stubhub.com");
//            httpget.setHeader(":method", "GET");
//            httpget.setHeader(":path", "/shape/search/inventory/v2/listings/?eventId=9873537&sectionStats=true&zoneStats=true&start=0&allSectionZoneStats=true&eventLevelStats=true&quantitySummary=true&sectionIdList=226672,226639&rows=20&sort=price+asc,value+desc&edgeControlEnabled=true&urgencyMessaging=true&priceType=nonBundledPrice&valuePercentage=true&shstore=1");
//            httpget.setHeader(":scheme", "https");
        httpget.setHeader("accept", "application/json");
        httpget.setHeader("accept-encoding", "deflate, br");
        httpget.setHeader("accept-language", "en-us");
        httpget.setHeader("com-stubhub-dye-path", "afbafa98669145e3b132d1b4b0c099b2,fea9d4aa4ead43e48dbbe120447555e7");
        httpget.setHeader("content-type", "application/json");
        httpget.setHeader("com-stubhub-dye-path", "afbafa98669145e3b132d1b4b0c099b2,fea9d4aa4ead43e48dbbe120447555e7");
        httpget.setHeader("referer", "https://www.stubhub.com/new-york-giants-tickets-new-york-giants-east-rutherford-metlife-stadium-8-11-2017/event/9873537/?sort=price+asc&sid=226672,226639");
        httpget.setHeader("x-distil-ajax", "yyqvbuqewxtcufrxveb");
        httpget.setHeader("x-requested-with", "XMLHttpRequest");
        httpget.setHeader("cookie", "D_SID=103.37.140.14:fQgKoIGBhkHGGHaopsnl2+XMAzTRXyysNzKLOn405+0; __gads=ID=f0965a3de207a78e:T=1502421263:S=ALNI_MYyBA6jPlerHGMjtb_Xz8e8gyNaUg; __uvt=; s_fid=0662BA877C3EB1A9-1D9902705A606F5F; s_vi=[CS]v1|2CC6908F8548BC57-60000103A00086BE[CE]; _ga=GA1.2.1076832490.1502421279; _gid=GA1.2.1942626449.1502421279; ak_bmsc=4D131B394CD7A0D714683625F939B644684BA995950F0000B98B8D59A5A1184F~plR05GQHWG57+JFGbFAegEZchY2l/nMs7RPNFiQGR7SLi/zZxj2BdP9wXyqn1jjTkpbMH9aVwra0BaG94T+MBIf5RrE1KpzIsXDbsj8YtdLM9NsHxkYSdoxaKjDwtZBHYhiJw+LadxyndC5EE4qKxJGCqiUL3FVMFkAzIlqkyw8JZQPDEa7OtNYCUqYRMtoPVhSp2R2bmpRIfJL6VMk9uVEjvYJc4mXMJlJzTjaErsnhc=; DC=lvs01; TLTSID=35C726E67E84107E0A419CC0D79489D6; AMCVS_1AEC46735278551A0A490D45%40AdobeOrg=1; AMCV_1AEC46735278551A0A490D45%40AdobeOrg=1099438348%7CMCIDTS%7C17390%7CMCMID%7C07112519794668968390641034230808811943%7CMCAAMLH-1503026061%7C11%7CMCAAMB-1503053998%7CNRX38WO0n5BH8Th-nqAG_A%7CMCOPTOUT-1502456398s%7CNONE%7CMCAID%7CNONE%7CMCSYNCSOP%7C411-17397%7CvVersion%7C2.1.0; xdVisitorId=1157ltRrKyifNpOSbHMPA3mnbJYrxGRV3PGXGRo_88LKIUAFB65; SH_AT=1XNOHCPxzhOmYfQsadRFfX%2FOMRCZ0KKzhzQg%2BzAtaxxW5pfv1Rx11KOIF7aMprwAW04a8GyXEiEOQT1T%2BfSZVe8ld7XAvyG5R2DKMOekj%2BM%3D; D_IID=7F2BAC5A-7D56-3B1A-B880-3A3EC42C7CE5; D_UID=2D4D1378-852D-347E-AA54-F2AFDC505904; D_ZID=868BC0F7-24A6-31BE-8832-092B673A61BB; D_ZUID=2B38355D-E74D-303D-B7DE-0BA663EE4BF4; D_HID=F9F4EEFB-915A-3A1D-AABE-FA6D8023555F; mbox=PC#6c7312902a444dcb8cdc79dcb3ff8000.24_4#1565666066|session#61a8728247434165a411b9c116b07456#1502451262; s_sess=%20s_sq%3D%3B%20s_cc%3Dtrue%3B; _uetsid=_uet6c852215; check=true; uvts=6NQMZ1W9BjCwex2Z; QuantumMetricUserID=efa02b2ab06e091908f8ce257c72c83b; QuantumMetricSessionID=c7f79600409c636c5f01aff9b26afaf7; atgRecVisitorId=1157ltRrKyifNpOSbHMPA3mnbJYrxGRV3PGXGRo_88LKIUAFB65; atgRecSessionId=XHPQ83jMvIE4pgPNIW5SRN41p788zTjAgDC04RxexOepVlkFtX-w!1541357695!-1954438623; _4c_=fZJvb9owEMa%2FyuS3I8RnO3aMNFUdIG3S2kqlvEaJc0AEJMh2yKqq370XQBPqpvHC8V1%2B9yfPwxvrt9iwCWRcKGUVzzSYEdvha2CTN%2BaOw3kajs7v2YRtYzyGSZr2fT8OsSu3XTl27SFtsE9eW79LNnXRxJDE2u2Qnp%2FzWISY%2BC5u0a9bXyUHjPt6jUmIRVV3hyRPABLBwaR4wiamNjcykya9C62P346%2Bdvi1CI6N2MuvBYZQt83PGe0ls6kReq7NPFfAzZzfK7DTKZ8Zq3I701QQ4%2BpU%2BGEN4pfzxTMHsVp0mw2GuMoIWDb1usZqtaDv%2BtGVRD0OZegPpAWja%2BnbPqCnYLr17QG%2FaE7Zdnj7UAw7eVyj92eColBHpNuNTJR0bTUkwY7lWCansaDcmlRmpTZGOqFFxaVTViosK6gKnakCrNCWuKeHl%2BfV9%2Fn99Onx1ooi3FpxR%2BCRHGOg6LZvXbEfBi4X7H3Efl%2BczmSWcyUFDKqQrblWfPgR4evqajkzlctMoUl%2F6SDX6CQA0p%2FEOmlQSEPtz%2F2AgyXxMxCaGgyzz%2FWgPs8D%2B%2Fe8i6b%2FKfrXkkcKL%2FgfWmlhTWZBXmlQV%2Fr9%2FQM%3D; TLTHID=B083BE6C7E84107E1A13DF4AD894D6EC; _mibhv=anon-1502421264591-9539116251_5167; bm_sv=FCD287AA202A4BEF803AAB91FFE5B02C~DkdAP/D/5uUNBzU6RgRpOUd0iqXiavrYg/lhpQ6Q3bSTz9yxdOMksU7oB2lOS6bNCBbC+RQj2WwHF52/GFru7Eh8vs5LFgOJGph532+O6f3ZYPVeKxqbuF4xz5jioI6RC2Imd/cRwRTu7BiigTOWvl3xGVwjVknVsf7cWivyhHw=; S_ACCT=stubhub; SH_VI=6322995a24894ccb880f58fa36e5bad3; s_pers=%20s_dfa%3Dstubhub%7C1502451200601%3B%20s_vs%3D1%7C1502451271823%3B%20s_nr%3D1502449471827-Repeat%7C1536577471827%3B");
        return httpget;
    }



}
