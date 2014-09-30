package tournament.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import org.eclipse.jetty.server.Authentication;

public class LoginAuth implements Authenticator<String, Authentication.User> {
    @Override
    public Optional<Authentication.User> authenticate(String credentials) throws AuthenticationException {
        return null;
    }
}
