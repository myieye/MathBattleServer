package interfaces.dao;

import domain.Player;

import javax.ejb.Local;

@Local
public interface PlayerDao extends Dao<Player, Long> {
	
	Player findByName(String name);
}