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

    public Collection<Value> getAllValues() {
        return valueRepository.findAll();
    }

    public Value getValue(String code) {
        return valueRepository.findValueByCode(code);
    }

    public Value addValue(Value value) {
        return valueRepository.save(value);
    }
}
