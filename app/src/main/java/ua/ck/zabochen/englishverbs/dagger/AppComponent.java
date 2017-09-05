package ua.ck.zabochen.englishverbs.dagger;

import javax.inject.Singleton;

import dagger.Component;
import ua.ck.zabochen.englishverbs.view.main.MainActivity;
import ua.ck.zabochen.englishverbs.view.verb.VerbFragment;
import ua.ck.zabochen.englishverbs.view.verb.VerbPresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    // Main Activity
    void inject(MainActivity mainActivity);

    // Verb Fragment
    void inject(VerbFragment verbFragment);

    // Verb Presenter
    void inject(VerbPresenter verbPresenter);

}
