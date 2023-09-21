package example.converter.repositories;

import example.converter.entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends JpaRepository<Value, Integer> {
    Value findValueByCode(String code);
}
