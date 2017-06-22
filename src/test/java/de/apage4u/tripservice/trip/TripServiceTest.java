package de.apage4u.tripservice.trip;

import static de.apage4u.tripservice.trip.UserBuilder.buildUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.apage4u.tripservice.exception.UserNotLoggedInException;
import de.apage4u.tripservice.user.User;

public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRAZIL = new Trip();

    private User loggedInUser;
    private TripService tripService;

    @Before
    public void initialize() {
        tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;
    }

    @Test(expected = UserNotLoggedInException.class)
    public void should_throw_an_exception_when_user_is_not_logged_in() {
        loggedInUser = GUEST;

        tripService.getTripsByUser((User) UNUSED_USER);
    }

    @Test
    public void should_not_return_any_trips_when_users_are_not_friends() {
        User friend = buildUser().
                withFriends(ANOTHER_USER).
                withTrips(TO_BRAZIL).
                build();

        List<Trip> friendTrips = tripService.getTripsByUser((User) friend);

        assertThat(friendTrips.size(), is(0));
    }

    @Test
    public void should_return_trips_when_users_are_friends() {
        User friend = buildUser().
                withFriends(ANOTHER_USER, loggedInUser).
                withTrips(TO_BRAZIL).
                build();

        List<Trip> friendTrips = tripService.getTripsByUser((User) friend);

        assertThat(friendTrips.size(), is(1));
    }

    private class TestableTripService extends TripService {

        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }

        @Override
        protected List<Trip> tripsByUser(final User user) {
            return user.trips();
        }
    }
}
