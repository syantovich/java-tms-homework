package org.example;

import org.example.annotation.Benchmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Game {
    @Autowired
    @Qualifier("ridePairs")
    private List<RidePair> ridePairs;

    public List<RidePair> getRidePairs() {
        return ridePairs;
    }

    @Benchmark
    public Optional<RidePair> play() {
        return ridePairs.stream().reduce((ident, acc) -> Math.random() * ident.getPower() > acc.getPower() * Math.random() ? ident : acc);
    }
}
