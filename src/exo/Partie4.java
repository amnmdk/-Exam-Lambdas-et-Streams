package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Partie4 {

    Predicate<Trip> premium = t -> t.price() > 30 && t.rating() > 4;

    public double totalRevenueSequential(List<Trip> trips) {
        return trips.stream()
                .mapToDouble(t -> t.price())
                .sum();
    }

    public double totalRevenueParallel(List<Trip> trips) {
        return trips.parallelStream()
                .mapToDouble(t -> t.price())
                .sum();
    }

    public Map<String, Long> countByCityParallel(List<Trip> trips) {
        return trips.parallelStream()
                .collect(Collectors.groupingBy(t -> t.city(), Collectors.counting()));
    }

    public List<Trip> premiumTripsParallel(List<Trip> trips) {
        return List.of();
    }
}
