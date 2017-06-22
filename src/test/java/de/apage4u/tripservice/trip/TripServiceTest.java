package de.apage4u.tripservice.trip;

import org.junit.Test;

import de.apage4u.tripservice.exception.UserNotLoggedInException;
import de.apage4u.tripservice.user.User;

public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;

    private User loggedInUser;

    @Test(expected = UserNotLoggedInException.class)
    public void should_throw_an_exception_when_user_is_not_logged_in() {
        TripService tripService = new TestableTripService();
        loggedInUser = GUEST;

        tripService.getTripsByUser(UNUSED_USER);
    }

    private class TestableTripService extends TripService {

        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }
    }
}
