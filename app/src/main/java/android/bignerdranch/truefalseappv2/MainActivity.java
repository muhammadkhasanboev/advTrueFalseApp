package android.bignerdranch.truefalseappv2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton, mFalseButton, mNextButton, mPrevButton, mCheatButton;
    private TextView mQuestionText;
    private int mCurrentIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        question text
        mQuestionText = (TextView) findViewById(R.id.question_text);


//        linking buttons and setting listeners
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                action
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              action
                checkAnswer(false);
            }
        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                action

            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                action

            }
        });

        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                action
            }
        });

    }

    Questions[] mQuestionBank = new Questions[]{
            new Questions(R.string.question_1, false),
            new Questions(R.string.question_2, false),
            new Questions(R.string.question_3, false),
            new Questions(R.string.question_4, true),
            new Questions(R.string.question_5, true),
            new Questions(R.string.question_6, false),
            new Questions(R.string.question_7, true),
            new Questions(R.string.question_8, true),
            new Questions(R.string.question_9, false),
            new Questions(R.string.question_10, true)

    };

//    update question method
    private void updateQuestion(){
        if(mCurrentIndex<mQuestionBank.length){
            mQuestionText.setText(mQuestionBank[mCurrentIndex].getQuestionResID());
        }
        else{
            mQuestionText.setText("Quiz finished!\n"+"Your Score: "+score+"/"+mQuestionBank.length);
        }
    }

    private void checkAnswer(boolean userAnswer){
        int messageID = 0;
        boolean realAnswer = mQuestionBank[mCurrentIndex].getQuestionAnswer();
        if(userAnswer==realAnswer){
            score++;
            messageID=R.string.correct_toast;
        }else{
            messageID=R.string.incorrect_toast;
        }
        Toast.makeText(MainActivity.this, messageID, Toast.LENGTH_SHORT).show();
    }
}