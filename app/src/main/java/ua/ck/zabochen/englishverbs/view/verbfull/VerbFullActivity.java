package ua.ck.zabochen.englishverbs.view.verbfull;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.ck.zabochen.englishverbs.MainApp;
import ua.ck.zabochen.englishverbs.R;
import ua.ck.zabochen.englishverbs.model.realm.Verb;
import ua.ck.zabochen.englishverbs.view.base.BaseActivity;

public class VerbFullActivity extends BaseActivity implements VerbFullContract.View {

    private static final String TAG = VerbFullActivity.class.getSimpleName();

    @Inject
    VerbFullPresenter verbFullPresenter;

    @BindView(R.id.activityVerbFull_toolbar)
    Toolbar mToolbar;

    // Image
    @BindView(R.id.activityVerbFull_imageView_verbImage)
    ImageView mImage;

    // Verb
    @BindView(R.id.activityVerbFull_textView_verb)
    TextView mVerb;
    @BindView(R.id.activityVerbFull_textView_verbTranscription)
    TextView mVerbTranscription;
    @BindView(R.id.activityVerbFull_imageView_verbPlay)
    ImageView mVerbPlay;

    // VerbPastSimple
    @BindView(R.id.activityVerbFull_texView_verbPastSimple)
    TextView mVerbPastSimple;
    @BindView(R.id.activityVerbFull_textView_verbPastSimpleTranscription)
    TextView mVerbPastSimpleTranscription;
    @BindView(R.id.activityVerbFull_imageView_verbPastSimplePlay)
    ImageView mVerbPastSimplePlay;

    private TextToSpeech mTextToSpeech;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApp.getAppComponent().inject(this);
        setTextToSpeech();
        setUi();
    }

    private void setTextToSpeech() {
        mTextToSpeech = new TextToSpeech(this, status -> {
            if (status != TextToSpeech.ERROR) {
                mTextToSpeech.setLanguage(Locale.CANADA);
            }
        });
    }

    private void setUi() {
        // Layout
        setContentView(R.layout.activity_verb_full);
        ButterKnife.bind(this);

        // Toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.toolbar_title));

        // Presenter
        verbFullPresenter.attachView(this);
        verbFullPresenter.viewIsReady();
        // Pass selected item
        verbFullPresenter.verbPosition(getIntent().getIntExtra("position", 0));
    }

    @Override
    public void updateUi(Verb verb) {

        // Image
        try {
            if (verb.getVerbImage() != null) {
                mImage.setImageDrawable(Drawable.createFromStream(getAssets().open(verb.getVerbImage()), null));
            } else {
                mImage.setImageResource(R.drawable.no_image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verb
        mVerb.setText(verb.getVerb());
        mVerbTranscription.setText(verb.getVerbTranscription());
        mVerbPlay.setOnClickListener(view -> {
            mTextToSpeech.speak(verb.getVerb(), TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(this, "Verb - Play", Toast.LENGTH_LONG).show();
        });

        // VerbPastSimple
        mVerbPastSimple.setText(verb.getVerbPastSimple());
        mVerbPastSimpleTranscription.setText(verb.getVerbPastSimpleTranscription());
        mVerbPastSimplePlay.setOnClickListener(view -> {
            mTextToSpeech.speak(verb.getVerbPastSimple(), TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(this, "Verb Past Simple - Play", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    protected void onPause() {
        if (mTextToSpeech != null) {
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
        }

        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        verbFullPresenter.detachView();
    }

}
