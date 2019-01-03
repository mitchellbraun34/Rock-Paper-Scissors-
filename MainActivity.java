package tech.mbraun.rockpaperscissors;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button rockBtn = findViewById(R.id.rockBtn);
        final Button paperBtn = findViewById(R.id.paperBtn);
        final Button scissorBtn = findViewById(R.id.scissorBtn);
        Button replayBtn = findViewById(R.id.replayBtn);

        final ImageView rockPNG = findViewById(R.id.playerRockPNG);
        final ImageView paperPNG = findViewById(R.id.playerPaperPNG);
        final ImageView scissorPNG = findViewById(R.id.playerScissorPNG);

        final ImageView enemyRockPNG = findViewById(R.id.enemyRockPNG);
        final ImageView enemyPaperPNG = findViewById(R.id.enemyPaperPNG);
        final ImageView enemyScissorPNG = findViewById(R.id.enemyScissorPNG);

        final TextView gameOverText = findViewById(R.id.gameOverText);

        final Random rand = new Random();

        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rockPNG.setVisibility(View.VISIBLE);
                enemyMove(rand, enemyRockPNG,enemyPaperPNG,enemyScissorPNG);
                gameOver(rockPNG,paperPNG,scissorPNG,enemyRockPNG,enemyPaperPNG,enemyScissorPNG, gameOverText);
                disableBtns(rockBtn,paperBtn,scissorBtn);
            }
        });
        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paperPNG.setVisibility(View.VISIBLE);
                enemyMove(rand, enemyRockPNG,enemyPaperPNG,enemyScissorPNG);
                gameOver(rockPNG,paperPNG,scissorPNG,enemyRockPNG,enemyPaperPNG,enemyScissorPNG, gameOverText);
                disableBtns(rockBtn,paperBtn,scissorBtn);
            }
        });
        scissorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scissorPNG.setVisibility(View.VISIBLE);
                enemyMove(rand, enemyRockPNG,enemyPaperPNG,enemyScissorPNG);
                gameOver(rockPNG,paperPNG,scissorPNG,enemyRockPNG,enemyPaperPNG,enemyScissorPNG, gameOverText);
                disableBtns(rockBtn,paperBtn,scissorBtn);
            }
        });
        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBoard(rockPNG,paperPNG,scissorPNG,enemyRockPNG,enemyPaperPNG,enemyScissorPNG, gameOverText,rockBtn,paperBtn,scissorBtn);
            }
        });

    }

    public void enemyMove(Random rand, ImageView enemyRockPNG, ImageView enemyPaperPNG, ImageView enemyScissorPNG)
    {

        int randomNumber = rand.nextInt(3) + 1;

        if(randomNumber == 1){ enemyRockPNG.setVisibility(View.VISIBLE);}

        else if(randomNumber == 2){enemyPaperPNG.setVisibility(View.VISIBLE);}

        else{ enemyScissorPNG.setVisibility(View.VISIBLE);}
    }

    public void clearBoard(ImageView rockPNG, ImageView paperPNG, ImageView scissorPNG, ImageView enemyRockPNG, ImageView enemyPaperPNG, ImageView enemyScissorPNG, TextView gameOverText,Button rockBtn, Button paperBtn, Button scissorBtn )
    {
        rockPNG.setVisibility(View.INVISIBLE);
        paperPNG.setVisibility(View.INVISIBLE);
        scissorPNG.setVisibility(View.INVISIBLE);
        enemyRockPNG.setVisibility(View.INVISIBLE);
        enemyPaperPNG.setVisibility(View.INVISIBLE);
        enemyScissorPNG.setVisibility(View.INVISIBLE);
        gameOverText.setText("");
        enableBtns(rockBtn,paperBtn,scissorBtn);
    }
    public void gameOver(ImageView rockPNG, ImageView paperPNG, ImageView scissorPNG, ImageView enemyRockPNG, ImageView enemyPaperPNG, ImageView enemyScissorPNG, TextView gameOverText)
    {
        if(rockPNG.getVisibility() == View.VISIBLE && enemyScissorPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("You Win!");
        }
        if(paperPNG.getVisibility() == View.VISIBLE && enemyRockPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("You Win!");
        }
        if(scissorPNG.getVisibility() == View.VISIBLE && enemyPaperPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("You Win!");
        }

        if(rockPNG.getVisibility() == View.VISIBLE && enemyRockPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("Draw!");
        }
        if(paperPNG.getVisibility() == View.VISIBLE && enemyPaperPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("Draw!");
        }
        if(scissorPNG.getVisibility() == View.VISIBLE && enemyScissorPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("Draw!");
        }

        if(rockPNG.getVisibility() == View.VISIBLE && enemyPaperPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("You Lose!");
        }
        if(paperPNG.getVisibility() == View.VISIBLE && enemyScissorPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("You Lose!");
        }
        if(scissorPNG.getVisibility() == View.VISIBLE && enemyRockPNG.getVisibility() == View.VISIBLE)
        {
            gameOverText.setText("You Lose!");
        }

    }

    public void disableBtns(Button rockBtn, Button paperBtn, Button scissorBtn)
    {
        rockBtn.setEnabled(false);
        paperBtn.setEnabled(false);
        scissorBtn.setEnabled(false);
    }
    public void enableBtns(Button rockBtn, Button paperBtn, Button scissorBtn)
    {
        rockBtn.setEnabled(true);
        paperBtn.setEnabled(true);
        scissorBtn.setEnabled(true);
    }
}
