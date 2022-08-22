package com.test.demo;
public class TicketManager {
       private int tickets;
       private static TicketManager instance;
       private TicketManager() {}
       static synchronized TicketManager getInstance() {      // k1
          if (instance==null) instance = new TicketManager(); // k2
          return instance;
       }
 
       public int getTicketCount() { return tickets; }
       public void addTickets(int value) {tickets += value;}  // k3
       public void sellTickets(int value) {
          synchronized (this) { // k4
             tickets -= value;
          }
       }
    }