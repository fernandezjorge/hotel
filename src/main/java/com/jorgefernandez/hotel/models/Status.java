package com.jorgefernandez.hotel.models;

public enum Status {
    RESERVED("reserved"),
    FREE("free"),
    PRE_RESERVED("pre_reserved");

    Status(String pendingReservation) {

    }
}
