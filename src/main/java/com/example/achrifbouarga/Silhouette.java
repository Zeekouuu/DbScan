package com.example.achrifbouarga;

import java.util.ArrayList;
import java.util.Arrays;

public class Silhouette {
    private ArrayList<Classs> clusters;
    private Donnee dt ;

    public Silhouette(ArrayList<Classs> clusters, Donnee dt) {
        this.clusters = clusters;
        this.dt = dt;
    }

    public String calculSilhouette() {
        double globalSilhouette = 0; // la selouette global
 String sa = ""; // la chaine retourner
        for (Classs cluster : clusters) { // parcour les class
            for (String[] instance : cluster.getPoints()) { //parcoure chaque instance dans chaque class
                double a = intraclass(instance, cluster.getPoints()); // Calcul de la distance moyenne intra-class
                double b = interclass(instance, cluster); // calcule la distance moyenne inter-class

                double silhouette = (b - a) / Math.max(a, b); // relation pour le calcule d selhouette
                globalSilhouette += silhouette;

                sa+=("Silhouette pour les instance " + Arrays.toString( instance )+ ": " + silhouette+"\n");
            }
        }

        double global = globalSilhouette / dt.instances.size();
        sa+=("Global Silhouette: " + global+"\n");

        return sa;
    }

    private double intraclass(String[] instance, ArrayList<String[]> instances) {
        double distanceSum = 0;
        int count = 0;

        for (String[] other : instances) {
            double distance = Distance(instance, other);
            distanceSum += distance;
            count++;
        }

        if (count > 0) {
            return distanceSum / count;
        }

        return 0;
    }

    private double interclass(String[] instance, Classs currentCluster) {

double intercla=0;
        for (Classs otherCluster : clusters) {
            if (otherCluster.equals(currentCluster)) {
                continue;
            }

            double distanceSum = 0;
            int count = 0;

            for (String[] otherInstance : otherCluster.getPoints()) {
                double distance = Distance(instance, otherInstance);
                distanceSum += distance; //calculer la distance entre notre instance et les instances d'une class
                count++;
            }

            if (count > 0) {
                double in = distanceSum / count;
                intercla=in;

            }
        }

        return intercla;
    }

    private double Distance(String[] inst1, String[] inst2) {
        double result=0;
        double dis;
        for(int i=0;i<inst1.length;i++){
            try{
                if (inst1[i].equals(inst2[i]))dis=0;
                else dis=1;

                //  dis = dis*dis;
                result+=dis;
            }catch(Exception e){}
        }
        result = Math.sqrt(result);
        return result;
    }


    }


