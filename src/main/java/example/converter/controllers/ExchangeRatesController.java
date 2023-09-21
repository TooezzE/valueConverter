package example.converter.controllers;

import example.converter.entity.ExchangeRates;
import example.converter.services.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rates")
public class ExchangeRatesController {

    private final ExchangeRatesService service;

    public ExchangeRatesController(ExchangeRatesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<ExchangeRates>> getAllRates() {
        return ResponseEntity.ok().body(service.getAllRates());
    }

    @GetMapping("/rate/")
    public ResponseEntity<ExchangeRates> getRateOf(@RequestParam String baseValCode,
                                                   @RequestParam String targetValCode) {
        return ResponseEntity.ok().body(service.getRateOf(baseValCode, targetValCode));
    }

    @PostMapping
    public ResponseEntity<ExchangeRates> addRate(@RequestBody ExchangeRates exchangeRates) {
        return ResponseEntity.ok().body(service.addRate(exchangeRates));
    }

    @PutMapping("/rate/")
    public ResponseEntity<ExchangeRates> changeRateOf(@RequestParam String baseValCode,
                                                      @RequestParam String targetValCode,
                                                      @RequestParam Double rate) {
        return ResponseEntity.ok().body(service.changeRateOf(baseValCode, targetValCode, rate));
    }

}
