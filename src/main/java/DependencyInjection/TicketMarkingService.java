package DependencyInjection;

/*模拟游乐设施前的票务，用于对票做标记*/
public class TicketMarkingService {
    public void markTicket(Ticket ticket, Attraction attraction) {
        System.out.println("游客游玩项目"+attraction.getName());
        ticket.markAttraction(attraction.getName());
    }
}
