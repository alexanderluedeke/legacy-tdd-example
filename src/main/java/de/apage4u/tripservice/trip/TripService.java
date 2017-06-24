package de.apage4u.tripservice.trip;

import java.util.ArrayList;
import java.util.List;

import de.apage4u.tripservice.exception.UserNotLoggedInException;
import de.apage4u.tripservice.user.User;
import de.apage4u.tripservice.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<Trip>();
        User loggedUser = getLoggedUser();

        if (loggedUser != null) {
            if (user.isFriendWith(loggedUser)) {
                tripList = tripsByUser(user);
            }
            return tripList;
        } else {
            throw new UserNotLoggedInException();
        }
    }

    protected List<Trip> tripsByUser(final User user) {
        return TripDAO.findTripsByUser(user);
    }

    protected User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }
}
