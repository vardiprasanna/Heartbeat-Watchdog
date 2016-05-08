package com.example.prasannakumarvardi.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.google.api.server.spi.response.CollectionResponse;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;

import java.util.logging.Logger;

import javax.inject.Named;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "userApi",
        version = "v1",
        resource = "user",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.prasannakumarvardi.example.com",
                ownerName = "backend.myapplication.prasannakumarvardi.example.com",
                packagePath = ""
        )
)
public class UserEndpoint {

    private static final Logger logger = Logger.getLogger(UserEndpoint.class.getName());

    private static final int DEFAULT_LIST_LIMIT = 20;

    static {
        ObjectifyService.register(User.class);
    }

    /**
     * This method gets the <code>User</code> object associated with the specified <code>id</code>.
     *
     * @param email The id of the object to be returned.
     * @return The <code>User</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getUser",
            path = "user/{email}",
            httpMethod = ApiMethod.HttpMethod.GET)
    public User getUser(@Named("email") String email) {
        // Implemented this function as follows

        User user = ofy().load().type(User.class).id(email).now();
        logger.info("Getting User ID:" + email);

        return user;
    }

    /**
     * This inserts a new <code>User</code> object.
     *
     * @param user The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertUser",
            path = "user",
            httpMethod = ApiMethod.HttpMethod.POST)
    public User insertUser(User user) {
        // TODO: Implement this function
        if(user.getEmail()!=null){
            if(findRecord(user.getEmail())!=null){
                return null;
            }
            ofy().save().entity(user).now();
            logger.info("Created user with email: " + user.getEmail());
        }
        logger.info("Calling insertUser method");
        return ofy().load().entity(user).now();

    }

    /*@ApiMethod(
            name="updateUser",
            path = "user/{email}",
            httpMethod = ApiMethod.HttpMethod.PUT)
    public User updateUser(@Named("email") String emailID, User user){
        if(findRecord(user.getEmail())==null){
            logger.info("User does not exists with this email id: " + user.getEmail());
            return null;
        }
        ofy().save().entity(user).now();
        return  ofy().load().entity(user).now();
    }*/
    private User findRecord(String email){
        return ofy().load().type(User.class).id(email).now();
    }
}
