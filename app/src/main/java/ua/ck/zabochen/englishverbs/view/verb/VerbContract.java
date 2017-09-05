package ua.ck.zabochen.englishverbs.view.verb;

import java.util.ArrayList;

import ua.ck.zabochen.englishverbs.model.Verb;
import ua.ck.zabochen.englishverbs.mvp.presenter.MvpPresenter;
import ua.ck.zabochen.englishverbs.mvp.view.MvpView;

public class VerbContract {

    public interface View extends MvpView {
        void setAdapter(ArrayList<Verb> verbs);
    }

    public interface Presenter extends MvpPresenter<View> {
        
    }

}
