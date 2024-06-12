package org.example.services;


import org.glassfish.jersey.process.internal.RequestScoped;

@RequestScoped
public class RequestService {

    private int count;

    public int getCount() {
        return ++count;
    }
}