package com.example.android.volleyballscorekeeper;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.android.volleyballscorekeeper.R.id.points_team_beta;

public class MainActivity extends AppCompatActivity {

    int pointsAlfa = 0;
    int pointsBeta = 0;
    int set = 1;
    int alfaSets = 0;
    int betaSets = 0;
    String leadingTeam = "equal";
    boolean twoPointsDiff = false;
    boolean alfaCrossed = false;
    boolean betaCrossed = false;
    boolean finishedMatch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    * Subtract one point of Team Alfa
    * */
    public void subtractPointTeamA(View view) {
        if (pointsAlfa > 0) {
            pointsAlfa--;
            setResults();
        }
    }

    /*
    * Add one point to Team Alfa
    * */
    public void addPointA(View view) {
        pointsAlfa++;
        setResults();
    }

    /*
    * Subtract one point of Team Beta
    * */
    public void subtractPointTeamB(View view) {
        if (pointsBeta > 0) {
            pointsBeta--;
            setResults();
        }
    }

    /*
    * Add one point to Team Beta
    * */
    public void addPointB(View view) {
        pointsBeta++;
        setResults();
    }

    private void setResults() {

        if (!finishedMatch) {

            //calling helper methods
            checkDifference();
            statusOfPoints();
            crossedPoints();


            TextView pointsAlfaView = (TextView) findViewById(R.id.points_team_alfa);
            pointsAlfaView.setText(String.valueOf(pointsAlfa));

            TextView pointsBetaView = (TextView) findViewById(points_team_beta);
            pointsBetaView.setText(String.valueOf(pointsBeta));

            if (alfaCrossed || betaCrossed) {
                if (twoPointsDiff) {

                    pointsAlfaView.setText(String.valueOf(0));
                    pointsBetaView.setText(String.valueOf(0));

                    if (set == 1) {
                        pointsAlfaView = (TextView) findViewById(R.id.alfa_score_one);
                        pointsAlfaView.setText(String.valueOf("Set 1: " + pointsAlfa));

                        pointsAlfaView = (TextView) findViewById(R.id.alfa_set_one);

                        pointsBetaView = (TextView) findViewById(R.id.beta_score_one);
                        pointsBetaView.setText(String.valueOf("Set 1: " + pointsBeta));

                        pointsBetaView = (TextView) findViewById(R.id.beta_set_one);

                        set++;
                    } else if (set == 2) {
                        pointsAlfaView = (TextView) findViewById(R.id.alfa_score_two);
                        pointsAlfaView.setText(String.valueOf("Set 2: " + pointsAlfa));

                        pointsAlfaView = (TextView) findViewById(R.id.alfa_set_two);

                        pointsBetaView = (TextView) findViewById(R.id.beta_score_two);
                        pointsBetaView.setText(String.valueOf("Set 2: " + pointsBeta));

                        pointsBetaView = (TextView) findViewById(R.id.beta_set_two);

                        set++;

                    } else if (set == 3) {
                        pointsAlfaView = (TextView) findViewById(R.id.alfa_score_three);
                        pointsAlfaView.setText(String.valueOf("Set 3: " + pointsAlfa));

                        pointsAlfaView = (TextView) findViewById(R.id.alfa_set_three);

                        pointsBetaView = (TextView) findViewById(R.id.beta_score_three);
                        pointsBetaView.setText(String.valueOf("Set 3: " + pointsBeta));

                        pointsBetaView = (TextView) findViewById(R.id.beta_set_three);

                        set++;

                    } else if (set == 4) {
                        pointsAlfaView = (TextView) findViewById(R.id.alfa_score_four);
                        pointsAlfaView.setText(String.valueOf("Set 4: " + pointsAlfa));

                        pointsAlfaView = (TextView) findViewById(R.id.alfa_set_four);

                        pointsBetaView = (TextView) findViewById(R.id.beta_score_four);
                        pointsBetaView.setText(String.valueOf("Set 4: " + pointsBeta));

                        pointsBetaView = (TextView) findViewById(R.id.beta_set_four);

                        set++;
                    } else {
                        pointsAlfaView = (TextView) findViewById(R.id.alfa_score_five);
                        pointsAlfaView.setText(String.valueOf("Set 5: " + pointsAlfa));

                        pointsAlfaView = (TextView) findViewById(R.id.alfa_set_five);

                        pointsBetaView = (TextView) findViewById(R.id.beta_score_five);
                        pointsBetaView.setText(String.valueOf("Set 5: " + pointsBeta));

                        pointsBetaView = (TextView) findViewById(R.id.beta_set_five);
                    }

                    if (leadingTeam.compareTo("alfa") == 0) {
                        pointsAlfaView.setText(String.valueOf(1));
                        alfaSets++;
                        pointsAlfaView = (TextView) findViewById(R.id.alfa_score);
                        pointsAlfaView.setText(String.valueOf(alfaSets));
                    } else {
                        pointsBetaView.setText(String.valueOf(1));
                        betaSets++;
                        pointsBetaView = (TextView) findViewById(R.id.beta_score);
                        pointsBetaView.setText(String.valueOf(betaSets));
                    }

                    TextView setView = (TextView) findViewById(R.id.current_set);
                    setView.setText(String.valueOf("Set " + set));

                    pointsAlfa = 0;
                    pointsBeta = 0;

                    twoPointsDiff = false;
                    alfaCrossed = false;
                    betaCrossed = false;

                    if (alfaSets == 3 || betaSets == 3) {
                        finishedMatch = true;
                        setView.setText(String.valueOf("Finished match"));

                        TextView alfaScoreColor = (TextView) findViewById(R.id.alfa_score);
                        TextView betaScoreColor = (TextView) findViewById(R.id.beta_score);
                        if (alfaSets == 3) {

                            alfaScoreColor.setTextColor(Color.parseColor("#4CAF50"));
                            betaScoreColor.setTextColor(Color.parseColor("#F44336"));
                        } else {
                            alfaScoreColor.setTextColor(Color.parseColor("#F44336"));
                            betaScoreColor.setTextColor(Color.parseColor("#4CAF50"));
                        }

                    }

                }
            }
        }


    }

    /*
    * Calculates difference between points of both teams
    * */
    private void checkDifference() {
        if (Math.abs(pointsAlfa - pointsBeta) > 1) {
            twoPointsDiff = true;
        } else {
            twoPointsDiff = false;
        }
    }

    /*
    * Checks which team is leading in points in current set
    * */
    private void statusOfPoints() {
        if (pointsAlfa > pointsBeta) {
            leadingTeam = "alfa";
        } else if (pointsAlfa < pointsBeta) {
            leadingTeam = "beta";
        } else {
            leadingTeam = "equal";
        }
    }

    /*
    * Checks if either teams crossed 25 points; 15 points in case of fifth set
    * */
    private void crossedPoints() {
        if (set < 5) {
            if (pointsAlfa > 24) {
                alfaCrossed = true;
            }
            if (pointsBeta > 24) {
                betaCrossed = true;
            }
        } else {
            if (pointsAlfa > 14) {
                alfaCrossed = true;
            }
            if (pointsBeta > 14) {
                betaCrossed = true;
            }
        }
    }

    public void resetMatch(View view) {

        TextView resetView = (TextView) findViewById(R.id.alfa_score_one);
        resetView.setText(String.valueOf("Set 1: " + 0));

        resetView = (TextView) findViewById(R.id.alfa_set_one);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.beta_score_one);
        resetView.setText(String.valueOf("Set 1: " + 0));

        resetView = (TextView) findViewById(R.id.beta_set_one);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.alfa_score_two);
        resetView.setText(String.valueOf("Set 2: " + 0));

        resetView = (TextView) findViewById(R.id.alfa_set_two);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.beta_score_two);
        resetView.setText(String.valueOf("Set 2: " + 0));

        resetView = (TextView) findViewById(R.id.beta_set_two);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.alfa_score_three);
        resetView.setText(String.valueOf("Set 3: " + 0));

        resetView = (TextView) findViewById(R.id.alfa_set_three);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.beta_score_three);
        resetView.setText(String.valueOf("Set 3: " + 0));

        resetView = (TextView) findViewById(R.id.beta_set_three);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.alfa_score_four);
        resetView.setText(String.valueOf("Set 4: " + 0));

        resetView = (TextView) findViewById(R.id.alfa_set_four);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.beta_score_four);
        resetView.setText(String.valueOf("Set 4: " + 0));

        resetView = (TextView) findViewById(R.id.beta_set_four);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.alfa_score_five);
        resetView.setText(String.valueOf("Set 5: " + 0));

        resetView = (TextView) findViewById(R.id.alfa_set_five);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.beta_score_five);
        resetView.setText(String.valueOf("Set 5: " + 0));

        resetView = (TextView) findViewById(R.id.beta_set_five);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.alfa_score);
        resetView.setText(String.valueOf(0));
        resetView.setTextColor(Color.parseColor("#1565C0"));
        resetView = (TextView) findViewById(R.id.beta_score);
        resetView.setText(String.valueOf(0));
        resetView.setTextColor(Color.parseColor("#1565C0"));

        alfaSets = 0;
        betaSets = 0;

        pointsAlfa = 0;
        pointsBeta = 0;

        set = 1;

        twoPointsDiff = false;
        alfaCrossed = false;
        betaCrossed = false;
        finishedMatch = false;


        TextView setView = (TextView) findViewById(R.id.current_set);
        setView.setText(String.valueOf("Set " + 1));

        resetView = (TextView) findViewById(R.id.alfa_score);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.beta_score);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.points_team_alfa);
        resetView.setText(String.valueOf(0));

        resetView = (TextView) findViewById(R.id.points_team_beta);
        resetView.setText(String.valueOf(0));

    }
}
