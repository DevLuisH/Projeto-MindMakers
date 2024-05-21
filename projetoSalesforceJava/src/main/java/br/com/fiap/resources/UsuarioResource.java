package br.com.fiap.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.fiap.beans.UsuarioBeans;
import br.com.fiap.bo.UsuarioBO;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO;

    public UsuarioResource() throws ClassNotFoundException, SQLException {
        this.usuarioBO = new UsuarioBO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioBeans> getAllUsuarios() throws ClassNotFoundException, SQLException {
        return usuarioBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUsuario(UsuarioBeans usuario) throws ClassNotFoundException, SQLException {
        usuarioBO.inserirBO(usuario);
        return Response.status(Status.CREATED).entity(usuario).build();
    }

    @PUT
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsuario(@PathParam("email") String email, UsuarioBeans usuario) throws ClassNotFoundException, SQLException {
        usuario.setEmail_user(email);
        usuarioBO.atualizarBO(usuario);
        return Response.ok(usuario).build();
    }

    @DELETE
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUsuario(@PathParam("email") String email) throws ClassNotFoundException, SQLException {
        usuarioBO.deletarBO(email);
        return Response.noContent().build();
    }
}
