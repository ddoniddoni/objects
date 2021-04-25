package com.company.objects.first.over;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void toSell(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}
