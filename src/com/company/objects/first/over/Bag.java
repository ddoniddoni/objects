package com.company.objects.first.over;

import com.company.objects.first.previous.Invitation;
import com.company.objects.first.previous.Ticket;

public class Bag {
    private Long amount;
    private Ticket ticket;
    private Invitation invitation;

    public Long hold(Ticket ticket){
        if (hasInvitation()){
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private void setTicket(Ticket ticket){
        this.ticket = ticket;
    }
    private boolean hasInvitation(){
        return invitation != null;
    }
    private void minusAmount(Long amount){
        this.amount -= amount;
    }
}
