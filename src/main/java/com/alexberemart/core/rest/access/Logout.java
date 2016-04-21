package com.alexberemart.core.rest.access;

import Alexberemart.core.rest.AbstractRestService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("logout")
public class Logout extends AbstractRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SecurityContextHolder.clearContext();
        return ok(mapper.writeValueAsString(true));
    }

}