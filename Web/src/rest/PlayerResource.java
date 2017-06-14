package rest;

import domain.Player;
import interfaces.PlayerServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/") // Base url
public class PlayerResource {

	@EJB
	private PlayerServiceLocal playerService;

	@GET
	@Path("/player")
	@Produces(MediaType.APPLICATION_JSON)
	public Player[] getAllPlayers() {
		return playerService.getAll();
	}

	@GET
	@Path("/player-mock")
	@Produces(MediaType.APPLICATION_JSON)
	public Player[] getAllMockPlayers() {
		return playerService.getAllMock();
	}
}