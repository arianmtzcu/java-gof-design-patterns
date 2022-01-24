package pattern.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {

    private Internet internet = new AccessToInternet();     //real class
    private static List<String> bannedUrl;                  //lista de urls bloqueadas

    static {
        bannedUrl = new ArrayList<>();
        bannedUrl.add("twitter.com");
        bannedUrl.add("facebook.com");
        bannedUrl.add("google.com");
    }

    @Override
    public void connectTo(String url) throws Exception {
        if(bannedUrl.contains(url)) {
            throw new Exception(String.format("URL bloqueada - Acceso Denegado - Consulta con tu administrador [%s]", url));
        }
        internet.connectTo(url);
    }
}
