package io.thorntail.example;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 10/5/18
 */
@Path("/")
@Produces("application/json")
@Consumes("application/json")
@ApplicationScoped
public class AResource {

    @Inject
    private io.thorntail.example.AProvider provider;

    @GET
    public String get() {
        return provider.get();
    }

}
