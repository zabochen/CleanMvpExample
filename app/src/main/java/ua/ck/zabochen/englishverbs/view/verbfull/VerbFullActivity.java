package ua.ck.zabochen.englishverbs.view.verbfull;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.io.IOException;

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
    @BindView(R.id.activityVerbFull_image)
    ImageView mImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApp.getAppComponent().inject(this);
        setUi();
    }

    private void setUi() {
        // Layout
        setContentView(R.layout.activity_verb_full);
        ButterKnife.bind(this);

        // Toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.toolbar_title));

        // Presenter
        verbFullPresenter.attachView(this);
        verbFullPresenter.viewIsReady();
        verbFullPresenter.verbPosition(getIntent().getIntExtra("position", 0));
    }

    @Override
    public void updateUi(Verb verb) {
        try {
            if (verb.getVerbImage() != null) {
                mImage.setImageDrawable(Drawable.createFromStream(getAssets().open(verb.getVerbImage()), null));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
