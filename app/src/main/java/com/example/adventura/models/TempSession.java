package com.example.adventura.models;

public class TempSession {
    private int sessionId;
    private int customerId;
    private int sQRId;
    private int kartNumber;

    public TempSession(int sessionId, int customerId, int sQRId, int kartNumber) {
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.sQRId = sQRId;
        this.kartNumber = kartNumber;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getsQRId() {
        return sQRId;
    }

    public int getKartNumber() {
        return kartNumber;
    }
}
