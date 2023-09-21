package example.converter.services;

import example.converter.entity.ExchangeRates;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeService {
    private final ExchangeRatesService exchangeRatesService;

    public ExchangeService(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    /*
       Method do exchange based on given data
    */
    public BigDecimal makeExchange(String baseValCode, String targetValCode, Double amount) {
        ExchangeRates exchangeRate = exchangeRatesService.getRateOf(baseValCode, targetValCode);
        BigDecimal bigDecimal = new BigDecimal(exchangeRate.getRate() * amount);
        bigDecimal.setScale(6, RoundingMode.HALF_DOWN);
        return bigDecimal;
    }
}
