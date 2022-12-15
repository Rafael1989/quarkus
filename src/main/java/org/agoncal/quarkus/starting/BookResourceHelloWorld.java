package org.agoncal.quarkus.starting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books/hello")
public class BookResourceHelloWorld {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello RestEasy";
    }

}
