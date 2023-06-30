package com.example.achrifbouarga;

import java.util.ArrayList;


/* la classe Classs utilisait pour identifier les classes par un id
avec une liste des points qui appartient au class  */
public class Classs {

    ArrayList<String[]> points;
    int id;
    /* la fonction Cluster initialise la liste des points*/
    public Classs(){
        points = new ArrayList<String[]>();
    }
    /* la fonction add ajoute à la liste le point passe comme argument */
    public void add(String[] point){
        points.add(point);
    }

    public ArrayList<String[]> getPoints() {
        return points;
    }

    public int getId() {
        return id;
    }
}





