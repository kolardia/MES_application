package com.kolardia.mesapplication;

/**
 * Created by Kolardia on 2015-12-16.
 */
/**
 *Przyjmujmujemy pierszy element dla wspolzednych jako element poczatkowy Xi =0
 *oraz element koncowy pelnej dlugosci osi Xk =8
 * zakladamy ze dany odcinek osi bedzie rkladany na 4 elementy

 * zatem poszukujemy 5 wspolzdnych
 * X1 = Xi, X5 = Xk dla pelnej dlugosci osi X
 * X1 = Xi, X3 = Xk; X3 = Xi, X5 = Xk dla dwoch elementow symetrycznych wykreslonych z pelnej osi x
 * X1 = Xi, X2= Xk; X2 = Xi, Xk = X3; Xi = X3, Xk = X4; Xi = X4, Xk = X5 dla czterech elemenow kolejengo wykrœlenia rekurecyjnego
 **/

public class WezlyElementow {


    /* Iloœæ elementow zostanie poprana z parametru Przedzialow dla niech zostanie obliczona symetryczna
     * Symetryczny okresla podzial elementu globalnego
     * iloœæ elementow musi byæ parzysta poniewaz jest to oœ symetryczna
     **/

    /* Funkcja zostanie wywyo³ana w klasie MesActivity*/
    public double podzialElementowLokalnych(double parametrPrzedzialow, double parametrL) {
    /*Parametr Przedzia³ow dotyczy podzialow ewlementu globalnego
    * Parametr L dotyczy przedzial w ktirym wystepuje podzial*/
       /* int iloscPodzialow = (parametrPrzedzialow /2);
        int[] wsp = new int[iloscPodzialow];
        for (int i = 0; i < iloscPodzialow; i++) {
            parametrL = parametrL / parametrPrzedzialow;
        }
        /*funkcja zwaraca dlugosc elementu loklnego*/
        double parametr;
        return parametr = parametrL / parametrPrzedzialow;
    }
      /* public double symetrycznaElementu(double przedzialElementuGlobalnego) {
        double symetrycznaElementu = dlogoscOsi / 2;
        return symetrycznaElementu;
    }*/

    //public double przesunieciePrzedzialuLokalnego = symetrycznaElementu(iloscElementow, przedzialElementuGlobalnego);

   // double przesunieciePrzedzialuLokalnego = symetrycznaElementowLokalnych(iloscElementow, przedzialElementuGlobalnego);

    public double wykazWspolzednejX(double parametrL,double lokalnyParametrL, int nrWezla ) {

        // int iloscWezlow = iloscElementow + 1;
        // double przedzialElementuGlobalnego = 8.0;

        double[] wspolzedneX = new double[10000];
        double x;
        for (int i = 0; i < 10000; i++) {
            x = i * lokalnyParametrL;
            // przesunieciePrzedzialuLokalnego = i * przesunieciePrzedzialuLokalnego;
            wspolzedneX[i] = x;//przesunieciePrzedzialuLokalnego ;
            //System.out.println(i);
        }

        return wspolzedneX[nrWezla];
    }




/*

    // WYKAZ WEZLOW WSPOLZEDNYCH DLA OSI X
    // Pierwszy wezel lokalny jest pierszym wezlem elementu globalnego w tym przykladzie poczatkiem osi X
    double wezelX1 = ElementGlobalnyXi;
    // Drugi wezel lokalny zosytal obliczony od podstawy do przesuniecia z wuznaczonej podzialki symetrycznej
    // kolejne wezly zostaly wyliczone analogicznie
   public double wezelX2 = ElementGlobalnyXi + ( 1 * przesunieciePrzedzialuLokalnego );
   public double wezelX3 = ElementGlobalnyXi + ( 2 * przesunieciePrzedzialuLokalnego );
   public double wezelX4 = ElementGlobalnyXi + ( 3 * przesunieciePrzedzialuLokalnego );
   public double wezelX5 = ElementGlobalnyXi + ( 4 * przesunieciePrzedzialuLokalnego );*/

    // WYKAZ WEZLOW WSPOLZEDNYCH DLA OSI Y
  /* public double wezelY1 =  wykazWspolzednejY(wezelX1);
   public double wezelY2 =  wykazWspolzednejY(wezelX2);
   public double wezelY3 =  wykazWspolzednejY(wezelX3);
   public double wezelY4 =  wykazWspolzednejY(wezelX4);
   public double wezelY5 =  wykazWspolzednejY(wezelX5);*/



    public double wzkazPrzedialElementu(double wspolzendnaElementuXi, double wspolzendnaElementuXk ){
        double przedialElementu = wspolzendnaElementuXk -wspolzendnaElementuXi;

        return przedialElementu;
    }

    /*Wzor umozliwiajacy generownanie wspolzednych Y wzgledem osi X */
   /* public double wykazWspolzednejY(double X) {
        double wspY;
        int L= 1;
        double f = 0.125;
        double J = 8.64;
        double IE = 4;
        wspY = (- ((IE * f)/J)) * (L - X);
        return wspY;
    }

*/
    // jakoœ takoœ ale nie iestem przekonana

    public double wykazWspolzednejY(double parametrPrzedzialow, double parametrL, double parametrF, double parametrJ, double wspolzednaX) {
        double wspY;
        /*int L= 1;
        double f = 0.125;
        double J = 8.64;
        double IE = 4;*/
        wspY = (- (( parametrPrzedzialow * wspolzednaX * parametrF)/parametrJ)) * (parametrL - wspolzednaX);
        return wspY;
    }

    private double generatorWspolzednych( double przedzialElementu) {

        double element = przedzialElementu + przedzialElementu;
        return element;
    }
}
