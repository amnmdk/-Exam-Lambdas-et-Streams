package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Partie1 {

    Predicate<Trip> longEtCher = t -> t.distanceKm() > 10 && t.price() > 20;

    Predicate<Trip> mauvaise = t -> t.rating() < 3;

    Predicate<Trip> recent = t -> t.startTime().toLocalDate().isAfter(LocalDate.now().minusDays(1));

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .filter(longEtCher)
                .collect(Collectors.toList());
    }

    public List<Trip> badTrips(List<Trip> trips) {
        return trips.stream()
                .filter(mauvaise)
                .collect(Collectors.toList());
    }

    public List<Trip> recentTrips(List<Trip> trips) {
        return trips.stream()
                .filter(recent)
                .collect(Collectors.toList());
    }
}
