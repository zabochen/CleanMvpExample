package ua.ck.zabochen.englishverbs.view.verb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ua.ck.zabochen.englishverbs.R;
import ua.ck.zabochen.englishverbs.model.Verb;

public class VerbAdapter extends RecyclerView.Adapter<VerbAdapter.VerbViewHolder> {

    private ArrayList<Verb> verbs = new ArrayList<>();

    public VerbAdapter(ArrayList<Verb> verbs) {
        this.verbs = verbs;
    }

    @Override
    public VerbViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VerbViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_verb, parent, false));
    }

    @Override
    public void onBindViewHolder(VerbViewHolder holder, int position) {
        holder.bind(verbs.get(position));
    }

    @Override
    public int getItemCount() {
        return verbs.size() > 0
                ? verbs.size()
                : 0;
    }

    static class VerbViewHolder extends RecyclerView.ViewHolder {

        private TextView verb;

        public VerbViewHolder(View itemView) {
            super(itemView);
            this.verb = itemView.findViewById(R.id.adapterVerb_verb);
        }

        void bind(Verb verb) {
            this.verb.setText(verb.getVerb());
        }
    }

}
