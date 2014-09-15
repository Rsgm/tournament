package tournament.views;

import io.dropwizard.views.View;

public class NotFoundView extends View {
    public NotFoundView() {
        super("404.ftl");
    }
}
