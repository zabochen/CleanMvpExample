package ua.ck.zabochen.englishverbs.view.verbfull;

import javax.inject.Inject;

import ua.ck.zabochen.englishverbs.MainApp;
import ua.ck.zabochen.englishverbs.database.RealmHelper;
import ua.ck.zabochen.englishverbs.mvp.presenter.BasePresenter;

public class VerbFullPresenter extends BasePresenter<VerbFullContract.View> implements VerbFullContract.Presenter {

    @Inject RealmHelper realmHelper;

    public VerbFullPresenter() {
        MainApp.getAppComponent().inject(this);
    }

    @Override
    public void viewIsReady() {

    }

    @Override
    public void verbPosition(int position) {
        getView().updateUi(realmHelper.getVerbList().get(position));
    }
}
