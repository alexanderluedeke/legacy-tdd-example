package de.apage4u.tripservice.user;

import static de.apage4u.tripservice.trip.UserBuilder.buildUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UserTest {

    private static final User BOB = new User();
    private static final User PAUL = new User();

    @Test
    public void should_inform_when_user_are_not_friends() {
        User user = buildUser().withFriends(BOB).build();

        assertThat(user.isFriendWith(PAUL), is(false));
    }

    @Test
    public void should_inform_when_user_are_friends() {
        User user = buildUser().withFriends(BOB, PAUL).build();

        assertThat(user.isFriendWith(PAUL), is(true));
    }
}
