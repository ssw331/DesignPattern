package miscellaneous.DependencyInjection;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private List<String> attractions;

    public Ticket() {
        this.attractions = new ArrayList<>();
    }

    public void markAttraction(String attractionName) {
        attractions.add(attractionName);
    }

    public List<String> getAttractions() {
        return attractions;
    }
}
