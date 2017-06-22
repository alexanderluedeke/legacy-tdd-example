package de.apage4u.tripservice.trip;

import org.junit.Test;

import de.apage4u.tripservice.exception.UserNotLoggedInException;

public class TripServiceTest {

	@Test(expected = UserNotLoggedInException.class)
    public void should_throw_an_exception_when_user_is_not_logged_in() {
        TripService tripService = new TripService();

        tripService.getTripsByUser(null);
    }
}
