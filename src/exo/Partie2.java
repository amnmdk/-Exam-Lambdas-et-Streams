package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Partie2 {

    Function<Trip, String> parVille = t -> t.city();

    Function<Trip, String> parChauffeur = t -> t.driverId();

    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(parVille, Collectors.counting()));
    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(parChauffeur, Collectors.summingDouble(t -> t.price())));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(parVille, Collectors.averagingDouble(t -> t.durationMin())));
    }
}
