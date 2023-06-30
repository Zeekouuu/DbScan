package com.example.achrifbouarga;

import java.io.IOException;
import java.util.Arrays;


/*Cette classe display est utilisée pour l'affichage des résultats du dbscan */
public class Affichage {
    public static String[] afficher(String link, String distance_func, double epsilon, double minpoints) throws IOException, Exception {

        String tab1 = "";
        String tab2 = "";
        String tab3 = "";
        String tab4 = "";
        String tab5 = "";


        Donnee dt = new Donnee(link);

        tab2 += (dt.affichage_distances(distance_func));

        DBSCAN db = new DBSCAN();

        tab1 += (db.dbscan(dt, epsilon, minpoints, distance_func)) + "\n\n";

        tab1 += ("           Résumer            \n\n");
        tab1 += (">> les class trouvées sont :  " + db.clusters.size() + " class\n\n");


        for (int i = 0; i < db.clusters.size(); i++) {
            for (int j =0;j< db.clusters.get(i).points.size();j++){

            }
            tab1 += (">>> class " + i + " contient " + db.clusters.get(i).points.size() + " points\n");
        }

        tab1 += ("\n\n>>les bruits trouvées sont :  " + db.noise.size() + "  points\n");

        tab3 += ("\n          LES ClASS          \n\n");

        for (int i = 0; i < db.clusters.size(); i++) {
            tab3 += ("Class " + i + " :  (" + db.clusters.get(i).points.size() + " elements)\n\n");
            for (int j = 0; j < db.clusters.get(i).points.size(); j++) {
                tab3 += (Arrays.toString(db.clusters.get(i).points.get(j)) + "\n");
            }
            tab3 += "\n\n";
        }
        tab4 += ("\n           BRUIT      \n\n");
        tab4 += ("( " + db.noise.size() + " elements)\n\n");
        for (int i = 0; i < db.noise.size(); i++) {
            tab4 += (Arrays.toString(db.noise.get(i)) + "\n");

        }
        Silhouette silhouette = new Silhouette(db.clusters,dt);
        String sdl = silhouette.calculSilhouette();
        tab5 += (sdl +"\n");
        String[] tabs = {tab1, tab2, tab3, tab4,tab5};
        return tabs;
    }
}


