package in.innovatehub.ankita_mehta.mathsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Math Quiz";
    static final String Ran_Num = "RandomNumber";

    private TextView tv;
    private Button b1;
    private Button b2;
    private Button b3;
    private int randnum;
    private String randn;

    public void numberToSet(){

        Random r = new Random();
        int i = r.nextInt(1000) + 1;
        randnum = i;
        randn = String.valueOf(randnum);

    }
    public void settheView(){
        numberToSet();
        tv = (TextView) findViewById(R.id.numberToSet);
        tv.setText(randn);
    }
    public boolean isPrime(){

        for(int i =2; i<Math.sqrt(randnum);i++){

            if(randnum % i == 0){
                return false;
            }

        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settheView();
        b1 = (Button) findViewById(R.id.TrueButtonID);
        b2 = (Button) findViewById(R.id.FalseButtonID);
        b3 = (Button) findViewById(R.id.NextButtonID);

        b1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                if(isPrime()){
                    Toast.makeText(MainActivity.this, R.string.Correct, Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT).show();

                }
                }
        });

        b2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                if(isPrime()){
                    Toast.makeText(MainActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, R.string.Correct, Toast.LENGTH_SHORT).show();

                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                settheView();
            }
        });




    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(Ran_Num, randnum);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        randnum = savedInstanceState.getInt(Ran_Num);
    }


}
