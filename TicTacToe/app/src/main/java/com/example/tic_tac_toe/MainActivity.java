package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    boolean game_active= true;
    int active_player=0;
    int[] game_state={2,2,2,2,2,2,2,2,2};
    int[][] win_positions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void PlayerTap(View view){
        ImageView img= (ImageView) view;
        int tapped_image= Integer.parseInt(img.getTag().toString());
        if(!game_active){
            game_reset(view);
        }
        if(game_state[tapped_image]==2){
            game_state[tapped_image]= active_player;
            img.setTranslationY(-1000f);
            if(active_player==0){
                img.setImageResource(R.drawable.xx);
                TextView status= findViewById(R.id.status);
                status.setText("O's Turn - Tap To Play");
                active_player=1;
            }
            else{
                img.setImageResource(R.drawable.oo);
                TextView status= findViewById(R.id.status);
                status.setText("X's Turn - Tap To Play");
                active_player=0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for( int[] win_position: win_positions){
            if (game_state[win_position[0]] == game_state[win_position[1]] && game_state[win_position[1]] == game_state[win_position[2]] && game_state[win_position[0]] != 2){
                String winner;
                game_active=false;
                if(game_state[win_position[0]]==0){
                    winner="X has won";
                }
                else{
                    winner="O has won";
                }
                TextView status= findViewById(R.id.status);
                status.setText(winner);
            }
        }
    }
    public void game_reset(View view){
        game_active=true;
        active_player=0;
        for(int i=0; i<game_state.length; i++){
            game_state[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
