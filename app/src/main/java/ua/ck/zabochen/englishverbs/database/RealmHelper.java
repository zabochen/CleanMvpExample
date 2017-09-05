package ua.ck.zabochen.englishverbs.database;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import ua.ck.zabochen.englishverbs.model.Verb;
import ua.ck.zabochen.englishverbs.mvp.interactor.Callback;

public class RealmHelper {

    private static final String TAG = RealmHelper.class.getSimpleName();

    private Context mContext;

    public RealmHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void inflateDatabase(Callback.DatabaseCallback callback) {
        Realm.getDefaultInstance().executeTransactionAsync(realm -> {
            try {
                realm.createOrUpdateAllFromJson(Verb.class, mContext.getAssets().open("englishVerbs.json"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, () -> {
            // Inflate success
            callback.onDatabaseSuccess();
        }, error -> {
            // Inflate error
            callback.onDatabaseError();
        });
    }

    public ArrayList<Verb> getVerbList() {

        RealmResults<Verb> realmResults = Realm.getDefaultInstance()
                .where(Verb.class)
                .findAll();

        ArrayList<Verb> verbList = new ArrayList<>();
        verbList.addAll(realmResults);

        return verbList;
    }

}
