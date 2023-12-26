
package DependencyInjection;

/*AmusementPark 类依赖于 TicketMarkingService 来为票添加标记。这种依赖关系是通过构造函数注入的*/
public class AmusementPark {
    private TicketMarkingService ticketMarkingService;

    public AmusementPark(TicketMarkingService ticketMarkingService) {
        this.ticketMarkingService = ticketMarkingService;
    }

    public void visitAttraction(Ticket ticket, Attraction attraction) {

        ticketMarkingService.markTicket(ticket, attraction);
    }
}
