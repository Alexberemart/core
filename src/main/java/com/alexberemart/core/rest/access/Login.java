package com.alexberemart.core.rest.access;

import Alexberemart.core.rest.AbstractRestService;
import com.google.inject.servlet.RequestScoped;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("login")
@RequestScoped
public class Login extends AbstractRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response login() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.isAuthenticated()) {
            return ok(mapper.writeValueAsString(auth));
        }
        else {
            return ok(mapper.writeValueAsString(false));
        }
    }

}


