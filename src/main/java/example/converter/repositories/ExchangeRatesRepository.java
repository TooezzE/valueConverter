package example.converter.repositories;

import example.converter.entity.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Integer> {

    ExchangeRates findExchangeRatesByBaseValueIdAndTargetValueId(int baseId, int targetId);
}
