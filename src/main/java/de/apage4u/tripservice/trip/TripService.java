package de.apage4u.tripservice.trip;

import de.apage4u.tripservice.exception.UserNotLoggedInException;
import java.util.ArrayList;
import java.util.List;

import de.apage4u.tripservice.user.User;
import de.apage4u.tripservice.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	
}
