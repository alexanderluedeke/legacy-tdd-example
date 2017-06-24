package de.apage4u.tripservice.trip;

import java.util.List;

import de.apage4u.tripservice.exception.CollaboratorCallException;
import de.apage4u.tripservice.user.User;

class TripDAO {
    TripDAO() {
    }

    static List<Trip> findTripsByUser(User user) {
        throw new CollaboratorCallException(
                "TripDAO should not be invoked on an unit test.");
    }

}