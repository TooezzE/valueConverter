package example.converter.controllers;

import example.converter.entity.ExchangeRates;
import example.converter.entity.Value;
import example.converter.services.ExchangeRatesService;
import example.converter.services.ExchangeService;
import example.converter.services.ValueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    private final ExchangeService exchangeService;
    private final ValueService valueService;
    private final ExchangeRatesService exchangeRatesService;

    public ExchangeController(ExchangeService exchangeService,
                              ValueService valueService,
                              ExchangeRatesService exchangeRatesService) {
        this.exchangeService = exchangeService;
        this.valueService = valueService;
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping
    public ResponseEntity<String> makeExchange(@RequestParam String baseValCode,
                                               @RequestParam String targetValCode,
                                               @RequestParam Double amount) {
        Value baseValue = valueService.getValue(baseValCode);
        Value targetValue = valueService.getValue(targetValCode);
        ExchangeRates exchangeRates = exchangeRatesService.getRateOf(baseValCode, targetValCode);
        Double rate = exchangeRates.getRate();

        String result = "baseValue:\n" + baseValue + "\ntargetValue:\n" + targetValue
                + "\nrate: " + rate + "\namount: " + amount + "\nconvertedResult: " +
                exchangeService.makeExchange(baseValCode, targetValCode, amount);
        return ResponseEntity.ok().body(result);
    }
}
