package interfaces;

import domain.Player;

// import sve2.fhbay.domain.Category;

public interface PlayerService {
	Player findPlayerByName(String name);

    Player[] getAll();

    Player[] getAllMock();
}