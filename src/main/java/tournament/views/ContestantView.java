package tournament.views;

import io.dropwizard.views.View;
import tournament.core.Contestant;

public class ContestantView extends View{
    private Contestant contestant;

    public ContestantView(Contestant contestant) {
        super("contestant.ftl");
        this.contestant = contestant;
    }

    public Contestant getContestant() {
        return contestant;
    }
}
