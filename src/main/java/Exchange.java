import java.util.HashMap;
import java.util.Map;

public class Exchange {

    public Map<String, String> getExchange () {

        Map<String, String> exchange = new HashMap<>();
        exchange.put("eurusd", "1.1289");
        exchange.put("usdaur", "0.8782");
        exchange.put("eurpln", "4.2918");
        exchange.put("plneur", "0.2330");
        exchange.put("usdpln", "3.7689");
        exchange.put("plnusd", "0.2653");
        return exchange;
    }
}
