import Facade.AdminFacade;
import entities.Admin;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    @EJB
    AdminFacade adminFacade;
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public List<Admin> getClichedMessage() {
        // Return some cliched textual content
        return this.adminFacade.findAll();
    }
}