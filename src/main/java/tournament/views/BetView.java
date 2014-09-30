package tournament.views;

import io.dropwizard.views.View;
import lombok.Data;

/*
* legal notice: This shall not be used for betting with any form of currency nor any objects of value.
 */

@Data
public class BetView extends View {
    private boolean bettingOpen;

    public BetView(boolean bettingOpen) {
        super("bet.ftl");
        this.bettingOpen = bettingOpen;
    }
}
