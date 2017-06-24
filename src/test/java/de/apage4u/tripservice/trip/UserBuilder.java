package de.apage4u.tripservice.trip;

import de.apage4u.tripservice.user.User;

public class UserBuilder {

    private User[] friends = new User[] {};
    private Trip[] trips = new Trip[] {};

    public static UserBuilder buildUser() {
        return new UserBuilder();
    }

    UserBuilder withTrips(Trip... trips) {
        this.trips = trips;
        return this;
    }

    public UserBuilder withFriends(User... friends) {
        this.friends = friends;
        return this;
    }

    public User build() {
        User user = new User();
        addTripsTo(user);
        addFriendsTo(user);

        return user;
    }

    private void addFriendsTo(final User user) {
        for (User friend : friends) {
            user.addFriend(friend);
        }
    }

    private void addTripsTo(final User user) {
        for (Trip trip : trips) {
            user.addTrip(trip);
        }
    }
}