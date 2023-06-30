package com.example.achrifbouarga;


import java.io.IOException;
import java.util.ArrayList;


public class DBSCAN {
    /* l'attribut data pour sauvegarder la liste des instances*/
    Donnee data;
    /* la liste clusters pour sauvegarder la liste des clusters*/
    ArrayList<Classs> clusters = new ArrayList<Classs>();
    /* la liste instances pour sauvegarder la liste des instances*/
    ArrayList<String[]> instances;
    /* la liste instances pour sauvegarder la liste des points déjà visiter */
    ArrayList<String[]> visited = new ArrayList<String[]>();
    /* la liste noise pour sauvegarder la liste des points bruit*/
    ArrayList<String[]> noise = new ArrayList<String[]>();


    /* la fonction  voisins prend en argument un point et
    retourne la liste de ses voisins par rapport à l'epsilon choisi */

    public ArrayList<String[]> voisins(Donnee d, double e, String[] point, String distance_function) throws IOException{

        String[] instance = point; // le centre de cercle
        ArrayList<String[]> voisins = new ArrayList<String[]>();

        for(int i=0;i<d.instances.size();i++){ //d.instance.size() c'est la tail de corpus

            String[] x = d.instances.get(i);

            if(d.distance(instance, x, distance_function)< e){ // e c'est epsilon
                voisins.add(x);}
        }
        return voisins;
    }



    /*utiliser pour classifier les points core et les points noise en aplliquant la methode DevClass pour combiner entre les class*/
    public String dbscan(Donnee d, double e, double MinPts, String distance_function) throws IOException{

        this.instances = d.instances;
        this.data = d;
        String result="";
        result+=("\n\n");
        result+=("-- classifier :    "+instances.size()+"    instance (DBSCAN) --\n\n");
        result+=("-- Parametres: \n\n\t+epsilon:"+ e +" \t+minPt: "+ MinPts +" \tdistance : "+distance_function+" --\n\n");
        result+=("---------------------------------------");
        for(int i=0;i<instances.size();i++){
            String[] point = instances.get(i);
            if(visited.contains(point)){ continue;}// si le point est deja visiter en sort de la boucle
            visited.add(point);
            ArrayList<String[]> voisins = voisins(d, e,point, distance_function);
            //si point noise ou points border ajouter le a la liste noise
            if(voisins.size()< MinPts){
            //    System.out.println("cette poit sera ajouter a la liste noise");
                noise.add(point);}
            //else si point core cree cluster et developer le
            else{
                Classs c = new Classs();
                clusters.add(c);
                DevClass(i, voisins, c, e, MinPts, distance_function);
            }
        }
        return result; }

    /* la fonction DevClass utiliser pour ajouter d'autres points au class argument */
    public void DevClass(int indice, ArrayList<String[]> voisins, Classs c, double e, double MinPts, String distance_function ) throws IOException{

        String[] point = instances.get(indice); // indice determine indice de point courant

        c.add(point); // ajouter le point etudier a la class c
        for(int i = 0; i< voisins.size(); i++){
// voisins exprime la liste des voisins du point etudier
            point = voisins.get(i); // on va parcouri chaque voisin dans la liste des voisins
//si le point n'est pas visité retourné ses voisins
            if(!visited.contains(point)){
                visited.add(point);// stocker le point dans la list visited pour ne pas avoir une redendance
                //recuperer la liste des voisin pour chaque voisin du point etudier
                ArrayList<String[]> voisins2 = voisins(data, e, point, distance_function);
               // System.out.println("nombre de voisin est "+voisins2.size());
//si le nombre de voisins > MinPts c-a-d un point core ajouter les voisins du point voisin aux voisins du point initiale
                if(voisins2.size()> MinPts){
                    voisins.addAll(voisins2);}
            }
//ensuite si le points n'appartient a aucune class ajouter le au cluster c
            boolean appartient = false;
            for(Classs cl:clusters){
                if(cl.points.contains(point)){   appartient =true ;}

            }
            if(appartient ==false){
                c.add(point);
            }
        }
    }
}
