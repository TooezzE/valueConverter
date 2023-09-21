package example.converter.services;

import example.converter.entity.Value;
import example.converter.repositories.ValueRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ValueService {

    private final ValueRepository valueRepository;

    public ValueService(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }

    // Shows all available values
    public Collection<Value> getAllValues() {
        return valueRepository.findAll();
    }

    // Shows value info by its code
    public Value getValue(String code) {
        return valueRepository.findValueByCode(code);
    }

    // Adds new value
    public Value addValue(Value value) {
        return valueRepository.save(value);
    }
}
