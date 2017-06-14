package beans;

import domain.Player;
import interfaces.PlayerServiceLocal;
import interfaces.PlayerServiceRemote;
import interfaces.dao.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@WebService()
@SOAPBinding(style=Style.RPC)
public class PlayerServiceBean implements PlayerServiceLocal, PlayerServiceRemote {

	Logger logger = Logger.getLogger(PlayerServiceBean.class.getName());

	@EJB
	private PlayerDao playerDao;
	
	@Override
	public Player findPlayerByName(String name) {
		Player player = playerDao.findByName(name);
		//if (player == null)
		//	throw new PLayerNotFoundException(Article.class.getSimpleName(), id);
		return player;
	}

	@Override
	public Player[] getAll() {
		logger.log(Level.INFO, "GetAll");
		return playerDao.findAll().toArray(new Player[0]);
	}

	@Override
	public Player[] getAllMock() {
		return new Player[]{new Player(1L, 1L, "John", "Mushroom", "Power", false, 100)};
	}
}