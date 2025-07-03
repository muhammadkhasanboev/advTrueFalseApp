package android.bignerdranch.truefalseappv2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
    private static final String KEY_CHEATED = "cheated";

    private boolean mAnswer;
    private boolean mDidCheat = false;
    private TextView mAnswerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cheat);

        // Restore cheat state
        if (savedInstanceState != null) {
            mDidCheat = savedInstanceState.getBoolean(KEY_CHEATED, false);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mAnswerTextView = findViewById(R.id.answer_text_view);
        mCheatButton = findViewById(R.id.cheat);
        mRefuseCheatButton = findViewById(R.id.refuse_cheat);

        mAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        // Restore cheat state UI if needed
        if (mDidCheat) {
            showAnswer();
            disableButtons();
        }

        mCheatButton.setOnClickListener(v -> {
            if (!mDidCheat) {
                mDidCheat = true;
                showAnswer();
                disableButtons();

                // Send result back
                Intent data = new Intent();
                data.putExtra("did_cheat", true);
                setResult(RESULT_OK, data);

                //  Delay finish
                new Handler(Looper.getMainLooper()).postDelayed(() -> finish(), 2000);
            }
        });

        mRefuseCheatButton.setOnClickListener(v -> {
            Intent data = new Intent();
            data.putExtra("did_cheat", false);
            setResult(RESULT_OK, data);
            finish();
        });
    }

    private void showAnswer() {
        String answerText = "Answer is: " + (mAnswer ? "True" : "False");
        mAnswerTextView.setText(answerText);
    }

    private void disableButtons() {
        mCheatButton.setEnabled(false);
        mRefuseCheatButton.setEnabled(false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_CHEATED, mDidCheat);
    }

    public static Intent newIntent(Context context, boolean answer) {
        Intent intent = new Intent(context, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answer);
        return intent;
    }
}
