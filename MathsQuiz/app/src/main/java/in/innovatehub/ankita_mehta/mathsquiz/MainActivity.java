package in.innovatehub.ankita_mehta.mathsquiz;

import android.graphics.Color;
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

    /* static text variables*/
    private static final String TAG = "Math Quiz";
    static final String Ran_Num = "RandomNumber";

    /* Stores prime numbers between 1 and 1000*/
    static final int primeNum[] = {2,   3,   5,   7,  11,  13,  17,  19,  23,  29,  31,  37,  41, 43,  47,  53,  59,  61,  67,  71,  73,  79,  83,  89,  97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
    
    /* XML variables */
    private TextView tv;
    private Button b1;
    private Button b2;
    private Button b3;

    /* Other variables*/
    private int randnum;
    private String randn;

    /* This function uses Random function to generate a random number, then uniformly chooses a prime number */
    public void numberToSet(){
        Random r = new Random();
        int i = r.nextInt(1000) + 1;
        if(i<500){
            randnum = i;
        }else{
            randnum = primeNum[(i%primeNum.length)];
        }
        randn = String.valueOf(randnum);
    }

    /* This sets the random number on screen using text view */
    public void setTheView(){
        numberToSet();
        tv = (TextView) findViewById(R.id.numberToSet);
        tv.setText(randn);
    }

    /* This function checks if generated random number is prime or not */
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
        setTheView();
        b1 = (Button) findViewById(R.id.TrueButtonID);
        b2 = (Button) findViewById(R.id.FalseButtonID);
        b3 = (Button) findViewById(R.id.NextButtonID);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isPrime()){
                    Toast toast = Toast.makeText(MainActivity.this, R.string.Correct, Toast.LENGTH_SHORT);
                    TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
                    tv.setTextColor(Color.GREEN);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(MainActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT);
                    TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
                    tv.setTextColor(Color.RED);
                    toast.show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            if(isPrime()){
                    Toast toast = Toast.makeText(MainActivity.this, R.string.Correct, Toast.LENGTH_SHORT);
                    TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
                    tv.setTextColor(Color.GREEN);
                    toast.show();
            }
            else{
                    Toast toast = Toast.makeText(MainActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT);
                    TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
                    tv.setTextColor(Color.RED);
                    toast.show();
            }
        }});
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTheView();
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
