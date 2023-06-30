package com.example.achrifbouarga;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/* la classe  Donnee utiliser pour enregister les donnes de la Base de Données dans une liste instances */
    public class Donnee {
        ArrayList<String[]> instances;

        public Donnee(String path) throws IOException {
            File2list(path);
        }
        /* la fonction csv_to_instances permet l'enregistrement des donnes d'un fichier CSV
        dans la liste des instances de la classe Data */
        public ArrayList<String[]> File2list(String path) throws FileNotFoundException, IOException{
            instances = new ArrayList<String[]>();
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line;
            while((line=bf.readLine())!=null){
                if (!line.contains("@") && !line.contains("%") && !line.contains(" ") && !line.isEmpty()) {
                    instances.add(line.split(","));
                }
            }return instances;
        }
        /* la fonction quantitative_euclidean permet le calcule de la distance euclidienne
         entre deux vecteurs de donnes quantitatives*/
        public double quantitative(String[] inst1, String[] inst2){
            double result=0;
            double dis;
            for(int i=0;i<inst1.length;i++){
                try{
                    dis = Double.parseDouble(inst1[i])-Double.parseDouble(inst2[i]);
                   // dis = dis*dis;
                    result+=dis;
                }catch(Exception e){}
            }
            result = Math.sqrt(result);
            return result;
        }
        /* la fonction qualitative_euclidean permet le calcule de la distance euclidienne
        entre deux vecteurs de donnes qualitatives*/
        public double qualitative(String[] inst1, String[] inst2){
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




        /* la fonction distance prend en arguments le nom de la fonction à utiliser pour calculer la distance
         et les deux vecteurs de donnes*/
        public double distance(String[] inst1, String[] inst2, String distance_function) throws IOException{
            double result=0;
            if(distance_function.equals("quantitative")){
                result = quantitative(inst1,inst2);
            }


            else if(distance_function.equals("qualitative")){
                result = qualitative(inst1, inst2);
              //  System.out.println("distance entre "+ Arrays.toString(inst1)+ "et "+Arrays.toString(inst2)+ " = "+result);
            }
            return result;
        }

        /* la fonction affichage_distances affiche une matrice des distances entre tous les instances de la base de données*/
        public String affichage_distances(String distance_function) throws IOException{
            String result="",res="";
            res+="\n Distance Matrix  :\n\n";
            double max=0, min=1000, moyenne=0, d;
            for(int i=0;i<instances.size();i++){
                for(int j=0;j<instances.size();j++){


                    d = distance(instances.get(i),instances.get(j), distance_function);
                    res+=(int)(d)+"    ";
                    if(d>max){max=d;}
                    if(d<min){min=d;}
                    moyenne+=d;
                }
                res+="\n";
            }
            moyenne=moyenne/instances.size();
            moyenne=moyenne/instances.size();
            result+="\nNombre d'instances = "+instances.size();
            result+="\ndistance maximal: "+max;
            result+="\ndistance minimal: "+min;
            result+="\nmoyenne des distances: "+moyenne;
            result+="\n\n--------------------------------";
            result+="\n";
            result+=res;
            result+="\n\n";

            return result;
        }


    }

