package tournament.views;

import io.dropwizard.views.View;
import lombok.*;

@Data
public class RegisterView extends View {
    private boolean registrationOpen;

    public RegisterView(boolean registrationOpen) {
        super("register.ftl");

        this.registrationOpen = registrationOpen;
    }

}
