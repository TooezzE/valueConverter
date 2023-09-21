package example.converter.controllers;

import example.converter.entity.Value;
import example.converter.services.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/values")
public class ValueController {
    private final ValueService service;

    public ValueController(ValueService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<Value>> getAllValues() {
        return ResponseEntity.ok().body(service.getAllValues());
    }

    @GetMapping("/value/{code}")
    public ResponseEntity<Value> getValue(@PathVariable String code) {
        return ResponseEntity.ok().body(service.getValue(code));
    }

    @PostMapping
    public ResponseEntity<Value> addValue(@RequestBody Value value) {
        return ResponseEntity.ok().body(service.addValue(value));
    }
}
