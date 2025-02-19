package org.abrbz.switchPlay;

public abstract sealed class MotorcycleBrand permits Honda, Kawasaki, Triumph, Ducati{
    public abstract String recap();
}
