package de.apage4u.tripservice.trip;

import java.util.ArrayList;
import java.util.List;

import de.apage4u.tripservice.exception.UserNotLoggedInException;
import de.apage4u.tripservice.user.User;
import de.apage4u.tripservice.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user, final User loggedInUser) throws UserNotLoggedInException {
        validate(loggedInUser);

        return user.isFriendWith(loggedInUser)
                ? tripsByUser(user)
                : noTrips();
    }

    protected List<Trip> tripsByUser(final User user) {
        return TripDAO.findTripsByUser(user);
    }

    private void validate(final User loggedInUser) {
        if (loggedInUser == null) {
            throw new UserNotLoggedInException();
        }
    }

    private ArrayList<Trip> noTrips() {
        return new ArrayList<Trip>();
    }
}