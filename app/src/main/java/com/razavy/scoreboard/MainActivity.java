package com.razavy.scoreboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int pointTeamA, pointTeamB;
    private String statusTeamA, statusTeamB;
    private boolean resetBtnStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            resetBtnStatus = savedInstanceState.getBoolean(getString(R.string.reset_button_key));
            if (resetBtnStatus) {
                statusTeamA = savedInstanceState.getString(getString(R.string.teamA_key));
                statusTeamB = savedInstanceState.getString(getString(R.string.teamB_key));
                updatePointA();
                updatePointB();
            } else {
                pointTeamA = savedInstanceState.getInt(getString(R.string.teamA_key));
                pointTeamB = savedInstanceState.getInt(getString(R.string.teamB_key));
                updatePointA();
                updatePointB();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(getString(R.string.reset_button_key), resetBtnStatus);
        if (resetBtnStatus) {
            outState.putString(getString(R.string.teamA_key), statusTeamA);
            outState.putString(getString(R.string.teamB_key), statusTeamB);
        } else {
            outState.putInt(getString(R.string.teamA_key), pointTeamA);
            outState.putInt(getString(R.string.teamB_key), pointTeamB);
        }
    }

    private void updatePointA() {
        TextView pointATextView = findViewById(R.id.point_team_a);
        if (resetBtnStatus)
            pointATextView.setText(statusTeamA);
        else
            pointATextView.setText("" + (pointTeamA));
    }

    private void updatePointB() {
        TextView pointBTextView = findViewById(R.id.point_team_b);
        if (resetBtnStatus)
            pointBTextView.setText(statusTeamB);
        else
            pointBTextView.setText("" + (pointTeamB));
    }

    public void threePointA(View view) {
        resetBtnStatus = false;
        pointTeamA += 3;
        updatePointA();
    }

    public void twoPointA(View view) {
        resetBtnStatus = false;
        pointTeamA += 2;
        updatePointA();
    }

    public void onePointA(View view) {
        resetBtnStatus = false;
        pointTeamA++;
        updatePointA();
    }

    public void threePointB(View view) {
        resetBtnStatus = false;
        pointTeamB += 3;
        updatePointB();
    }

    public void twoPointB(View view) {
        resetBtnStatus = false;
        pointTeamB += 2;
        updatePointB();
    }

    public void onePointB(View view) {
        resetBtnStatus = false;
        pointTeamB++;
        updatePointB();
    }

    public void resetButton(View view) {
        resetBtnStatus = true;
        if (pointTeamA > pointTeamB) {
            TextView winnerATextView = findViewById(R.id.point_team_a);
            winnerATextView.setText(getString(R.string.winner));
            statusTeamA = getString(R.string.winner);
            TextView winnerBTextView = findViewById(R.id.point_team_b);
            winnerBTextView.setText(getString(R.string.loser));
            statusTeamB = getString(R.string.loser);
        } else if (pointTeamB > pointTeamA) {
            TextView winnerBTextView = findViewById(R.id.point_team_b);
            winnerBTextView.setText(getString(R.string.winner));
            statusTeamB = getString(R.string.winner);
            TextView winnerATextView = findViewById(R.id.point_team_a);
            winnerATextView.setText(getString(R.string.loser));
            statusTeamA = getString(R.string.loser);
        } else {
            TextView winnerBTextView = findViewById(R.id.point_team_b);
            winnerBTextView.setText(getString(R.string.draw));
            TextView winnerATextView = findViewById(R.id.point_team_a);
            winnerATextView.setText(getString(R.string.draw));
            statusTeamB = getString(R.string.draw);
            statusTeamA = getString(R.string.draw);
        }
        pointTeamA = 0;
        pointTeamB = 0;
    }
}
