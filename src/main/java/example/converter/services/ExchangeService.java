package example.converter.services;

import example.converter.entity.ExchangeRates;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeService {
    private final ValueService valueService;
    private final ExchangeRatesService exchangeRatesService;

    public ExchangeService(ValueService valueService, ExchangeRatesService exchangeRatesService) {
        this.valueService = valueService;
        this.exchangeRatesService = exchangeRatesService;
    }

    public BigDecimal makeExchange(String baseValCode, String targetValCode, Double amount) {
        ExchangeRates exchangeRate = exchangeRatesService.getRateOf(baseValCode, targetValCode);
        BigDecimal bigDecimal = new BigDecimal(exchangeRate.getRate() * amount);
        bigDecimal.setScale(6, RoundingMode.HALF_DOWN);
        return bigDecimal;
    }
}
