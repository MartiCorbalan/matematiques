package com.example.matematiques;

public class jugador {

    String nom;
    Boolean jugadorActiu = false;
    int puntuacio=0;

    public Boolean getJugadorActiu() {
        return jugadorActiu;
    }

    public void setJugadorActiu(Boolean jugadorActiu) {
        this.jugadorActiu = jugadorActiu;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public jugador(String nom, int puntuacio) {
        this.nom = nom;
        this.puntuacio = puntuacio;
    }





}
