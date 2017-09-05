package ua.ck.zabochen.englishverbs.view.verb;

import javax.inject.Inject;

import ua.ck.zabochen.englishverbs.MainApp;
import ua.ck.zabochen.englishverbs.database.RealmHelper;
import ua.ck.zabochen.englishverbs.mvp.interactor.Callback;
import ua.ck.zabochen.englishverbs.mvp.presenter.BasePresenter;

public class VerbPresenter extends BasePresenter<VerbContract.View> implements VerbContract.Presenter {

    private static final String TAG = VerbPresenter.class.getSimpleName();

    @Inject VerbFragment mVerbFragment;
    @Inject RealmHelper mRealmHelper;

    public VerbPresenter() {
        MainApp.getAppComponent().inject(this);
    }

    @Override
    public void viewIsReady() {

        mRealmHelper.inflateDatabase(new Callback.DatabaseCallback() {
            @Override
            public void onDatabaseSuccess() {
                mVerbFragment.setAdapter(mRealmHelper.getVerbList());
            }

            @Override
            public void onDatabaseError() {
            }
        });

    }

}
