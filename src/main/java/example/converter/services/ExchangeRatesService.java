package example.converter.services;

import example.converter.entity.ExchangeRates;
import example.converter.repositories.ExchangeRatesRepository;
import example.converter.repositories.ValueRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExchangeRatesService {

    private final ExchangeRatesRepository exchangeRepository;
    private final ValueRepository valueRepository;

    public ExchangeRatesService(ExchangeRatesRepository exchangeRepository, ValueRepository valueRepository) {
        this.exchangeRepository = exchangeRepository;
        this.valueRepository = valueRepository;
    }

    public Collection<ExchangeRates> getAllRates() {
        return exchangeRepository.findAll();
    }

    public ExchangeRates getRateOf(String baseValCode, String targetValCode) {
        int baseId = valueRepository.findValueByCode(baseValCode).getId();
        int targetId = valueRepository.findValueByCode(targetValCode).getId();
        return exchangeRepository.findExchangeRatesByBaseValueIdAndTargetValueId(baseId, targetId);
    }

    public ExchangeRates addRate(ExchangeRates exchangeRates) {
        return exchangeRepository.save(exchangeRates);
    }

    public ExchangeRates changeRateOf(String baseValCode, String targetValCode, Double rate) {
        ExchangeRates exchangeRate = getRateOf(baseValCode, targetValCode);
        exchangeRate.setRate(rate);
        return exchangeRate;
    }
}
