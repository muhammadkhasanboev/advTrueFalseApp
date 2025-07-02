package android.bignerdranch.truefalseappv2;

public class Question {
    private int mQuestionResId;
    private boolean mQuestionAnswer;

    public Question(int mQuestionResId, boolean mQuestionAnswer){
        this.mQuestionResId = mQuestionResId;
        this.mQuestionAnswer = mQuestionAnswer;
    }

    public int getQuestionResID(){
        return mQuestionResId;
    }

    public void setQuestionResId(int newQuestionResID){
        mQuestionResId = newQuestionResID;
    }

    public boolean getQuestionAnswer(){
        return mQuestionAnswer;
    }

    public void setQuestionAnswer(boolean newQuestionAnswer){
        mQuestionAnswer = newQuestionAnswer;
    }
}
