package android.bignerdranch.truefalseappv2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheatActivity extends AppCompatActivity {

    private Button mCheatButton, mRefuseCheatButton;
    private static final String EXTRA_ANSWER_IS_TRUE = "android.bignerdanch.truefalseappv2.answer_is_true";
    private boolean mAnswer;
    private TextView mAnswerTextView;
    private boolean mDidCheat = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cheat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mCheatButton = (Button) findViewById(R.id.cheat);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mDidCheat) {
                    mDidCheat = true;
                    mAnswerTextView.setText("Answer is: " + (mAnswer ? "True" : "False"));
                    Intent data = new Intent();
                    data.putExtra("did_cheat", true);
                    setResult(RESULT_OK, data);
                    mRefuseCheatButton.setEnabled(false); // or setVisibility(View.GONE)
                }

            }
        });

        mRefuseCheatButton = (Button) findViewById(R.id.refuse_cheat);
        mRefuseCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("did_cheat", false);
                setResult(RESULT_OK, data);
               finish();
            }
        });


    }

    public static Intent newIntent(Context packageContext, boolean answer){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answer);
        return i;
    }
}