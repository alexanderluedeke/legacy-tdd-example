package de.apage4u.tripservice.user;

import java.util.ArrayList;
import java.util.List;

import de.apage4u.tripservice.trip.Trip;

public class User {
    private List<Trip> trips = new ArrayList<Trip>();
    private List<User> friends = new ArrayList<User>();

    public List<User> getFriends() {
        return friends;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public List<Trip> trips() {
        return trips;
    }

    public boolean isFriendWith(User anotherUser) {
        return friends.contains(anotherUser);
    }
}
