package com.otero.david.anotadorsubasta;

/**
 * Created by David on 22/02/2016.
 */
public class Puxa {

    //Properties
    private int puxa;
    private CharSequence jugadores;
    private boolean feitas;
    private boolean anotadas;
    private int pos;

    //Constructors
    public Puxa() {}

    public Puxa(CharSequence puxa, CharSequence jugadores, int pos) {
        this.puxa = Integer.parseInt((String) puxa);
        this.jugadores = jugadores;
        this.pos = pos;
    }

    //Methods
    public int getPuxa() {
        return puxa;
    }

    public String getStringPuxa() {
        return String.valueOf(puxa);
    }

    public void setPuxa(int puxa) {
        this.puxa = puxa;
    }

    public CharSequence getJugadores() {
        return jugadores;
    }

    public void setJugadores(CharSequence jugadores) {
        this.jugadores = jugadores;
    }

    public boolean isFeitas() {
        return feitas;
    }

    public void setFeitas(boolean feitas) {
        this.feitas = feitas;
    }

    public boolean isAnotadas() {
        return anotadas;
    }

    public void setAnotadas(boolean anotadas) {
        this.anotadas = anotadas;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
