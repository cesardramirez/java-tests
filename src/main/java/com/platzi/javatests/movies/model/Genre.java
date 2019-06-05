package com.platzi.javatests.movies.model;

public enum Genre {
    ACTION, COMEDY, DRAMA, HORROR, THRILLER, EMPTY;

    @Override
    public String toString() {
        return this == EMPTY ? "" : this.name();
    }
}
