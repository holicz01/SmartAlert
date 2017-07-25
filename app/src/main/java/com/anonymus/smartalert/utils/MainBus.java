package com.anonymus.smartalert.utils;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class MainBus {

    private static MainBus instance;

    public static MainBus getInstance() {
        if (instance == null)
            instance = new MainBus();
        return instance;
    }

    private Bus bus;

    private MainBus() {
        bus = new Bus(ThreadEnforcer.MAIN);
    }

    public Bus getBus() {
        return bus;
    }

}
