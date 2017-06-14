package beans.dao;

import beans.util.QueryBuilder;
import domain.Player;
import interfaces.dao.PlayerDao;

import javax.ejb.Stateless;

@Stateless
public class PlayerDaoBean extends AbstractDaoBean<Player, Long> implements PlayerDao {

	@Override
	public Player findByName(String name) {
		return new QueryBuilder<Player>(em,
				"select p from player p where lower(p.name) = :name")
				.setParamater("name", name)
				.build().getSingleResult();
	}
}
