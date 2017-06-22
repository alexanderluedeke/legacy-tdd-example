package de.apage4u.tripservice.trip;

import de.apage4u.tripservice.user.User;

class UserBuilder {

    private User[] friends = new User[] {};
    private Trip[] trips = new Trip[] {};

    static UserBuilder buildUser() {
        return new UserBuilder();
    }

    UserBuilder withTrips(Trip... trips) {
        this.trips = trips;
        return this;
    }

    UserBuilder withFriends(User... friends) {
        this.friends = friends;
        return this;
    }

    User build() {
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