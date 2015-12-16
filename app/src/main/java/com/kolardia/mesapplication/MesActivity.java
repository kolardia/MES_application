package com.kolardia.mesapplication;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

    public class MesActivity extends ActionBarActivity {
        // Remove the below line after defining your own ad unit ID.
        private static final String TOAST_TEXT = "Kliknij ns przycisk OBLICZ ELEMENT KONSTRUKICJI" + "aby rozpoczac obliczenia";

        private static final int START_LEVEL = 1;
        private static final int START_ELEMENT_LOKALNY = 1;
        private static final int START_WSPOLZEDNA_Xi = 0;
        private static final int START_WSPOLZEDNA_Xk = 0;
        private static final int START_WSPOLZEDNA_Yi = 0;
        private static final int START_WSPOLZEDNA_Yk = 0;
        private int mLevel;
        private int mELokalny;
        private double mXiWspx;
        private double mXkWspx;
        private double mYiWspx;
        private double mYkWspx;
        private Button mNextLevelButton;
        private InterstitialAd mInterstitialAd;
        private TextView mLevelTextView;

        private TextView wezelI;
        private TextView wezelK;

        private TextView xiWspx;
        private TextView yiWspy;
        private TextView xkWspx;
        private TextView ykWspy;

        private TextView cosinusX;
        private TextView cosinusY;

        private TextView eLokalny;
        private TextView eGlobalny;

        private TextView pN;
        private TextView pM;

        private String sPE;
        private String sL;
        private String sF;
        private String sP;
        private String sE;
        private String sJ;
        private String sA;

        private int parametrPrzedzialow;
        private double parametrL;
        private double parametrF;
        private double parametrP;
        private double parametrE;
        private double parametrJ;
        private double parametrA;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mes);

            // Create the next level button, which tries to show an interstitial when clicked.
            mNextLevelButton = ((Button) findViewById(R.id.next_level_button));
            mNextLevelButton.setEnabled(false);
            mNextLevelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showInterstitial();
                }
            });

            // Create the text view to show the level number.
            mLevelTextView = (TextView) findViewById(R.id.level);
            wezelI = (TextView) findViewById(R.id.wezel_i);
            wezelK = (TextView) findViewById(R.id.wezel_k);

            xiWspx = (TextView) findViewById(R.id.xi_wspx);
            yiWspy = (TextView) findViewById(R.id.yi_wspy);
            xkWspx = (TextView) findViewById(R.id.xk_wspx);
            ykWspy = (TextView) findViewById(R.id.yk_wspy);

            cosinusX = (TextView) findViewById(R.id.cosx);
            cosinusY = (TextView) findViewById(R.id.cosy);

            eLokalny = (TextView) findViewById(R.id.element_lokalny);
            eGlobalny = (TextView) findViewById(R.id.element_glogalny);

            pN = (TextView) findViewById(R.id.p_n);
            pM = (TextView) findViewById(R.id.p_m);

            mLevel =  START_LEVEL;
            mELokalny = START_ELEMENT_LOKALNY;
            mXiWspx = START_WSPOLZEDNA_Xi;
            mXkWspx = START_WSPOLZEDNA_Xk;
            mYiWspx = START_WSPOLZEDNA_Yi;
            mYkWspx = START_WSPOLZEDNA_Yk;

            Intent i = getIntent();
            sPE = i.getStringExtra("IloscPrzedzialow");
            sL = i.getStringExtra("L");
            sF = i.getStringExtra("F");
            sP = i.getStringExtra("P");
            sE = i.getStringExtra("E");
            sJ = i.getStringExtra("J");
            sA = i.getStringExtra("A");

            parametrPrzedzialow = Integer.valueOf(sPE).intValue();
            parametrL = Double.valueOf(sL).doubleValue();
            parametrF = Double.valueOf(sF).doubleValue();
            parametrP = Double.valueOf(sP).doubleValue();
            parametrE = Double.valueOf(sE).doubleValue();
            parametrJ = Double.valueOf(sJ).doubleValue();
            parametrA = Double.valueOf(sA).doubleValue();

            // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(getString(R.string.info));
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    mNextLevelButton.setEnabled(true);
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    mNextLevelButton.setEnabled(true);
                }


                @Override
                public void onAdClosed() {
                    // Proceed to the next level.
                    goToNextLevel();}

            });
            loadInterstitial();

            // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
            Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();
        }
        public void ButtonOnClick(View v) {
            switch (v.getId()) {
                case R.id.finish:
                    finish();
                    break;
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        private int licznikElementow = 0;
        private void showInterstitial() {
            if(parametrPrzedzialow == licznikElementow ){
                Toast.makeText(this, "Koniec obliczen", Toast.LENGTH_SHORT).show();
            } else {
                goToNextLevel();
                Toast.makeText(this, "Wykaz nastepnego elementu", Toast.LENGTH_SHORT).show();
                licznikElementow = licznikElementow + 1;
            }
        }

        public double test(int nr ) {
            double[] wezelX = new double[1000];
            double x;
            for (int i = 0; i < 1000; i++) {
                wezelX[i] = i ;
            }

            return wezelX[nr];
        }
        public double test1(double nr ) {

            return nr + 0.5;
        }

        private void loadInterstitial() {
            // Disable the next level button and load the ad.
            mNextLevelButton.setEnabled(false);
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
        }

  /*  public double elementLokalny(int nr ){
        double[] X = new double[3];
        if (nr < 100) {
            for (int i = 0; i < 3; i++) {
                X[i] = i;
            }
        }else{
            X[0] = 1;
        }
        return X[nr];
    }*/

        // {
        private void goToNextLevel() {
            // Show the next level and reload the ad to prepare for the level after.
            //mLevelTextView.setText("Level " + (++mLevel));


            eLokalny.setText("Element lokalny: " + (mELokalny++));
            eGlobalny.setText("ilosc elementow w przedziale globalnym: " + parametrPrzedzialow);
            wezelI.setText("Wykaz wezla poczatkowego danego elementu: ");
            xiWspx.setText("Wspolzedna x= " + test1(mXiWspx++));
            yiWspy.setText("Wspolzedna y= " + (mXkWspx++));

            wezelK.setText("Wykaz wezla koncowego danego elementu: ");
            xkWspx.setText("Wspolzedna x= " + (mYiWspx++));
            ykWspy.setText("Wspolzedna y= " + (mYkWspx++));

            cosinusX.setText("cos(X,x1)= " + sPE  );
            cosinusY.setText("cos(Z,x1)= " + sPE );

            pN.setText("wykaz sily podluznej" + parametrE);
            pM.setText("wykaz momentu zginajacego= " + test(++mLevel));

            // loadInterstitial();
        }


    }

