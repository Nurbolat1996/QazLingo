package kz.qazlingo.www.qazlingo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sansyzbaynurbolat on 1/16/18.
 */

public class Fragment_facts extends Fragment {
    private static final String TAG = "MainActivity";
    Random random;
    Button btNext;
    TextView tvTitle;
    TextView tvFact;
    ArrayList<String> facts;
    int count=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_facts,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        facts = new ArrayList<>();
        random = new Random();
        btNext = getActivity().findViewById(R.id.fact_button);
        tvTitle = getActivity().findViewById(R.id.fact_title_text_view);
        tvFact = getActivity().findViewById(R.id.fact_fact_text_view);
        setFacts();
        showFacts(count++);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFacts(count++);
            }
        });


    }

    private void setFacts(){
        int index=0;
        String draftFact;
        while (index<5){

            draftFact = Vars.list_fact[random.nextInt(Vars.list_fact.length-1)];
            boolean isNoOverlap = true;
                for(String fact:facts){
                    if(fact.equals(draftFact)){
                        isNoOverlap = false;
                    }
                }
            if(isNoOverlap){
                    facts.add(draftFact);
                    index++;
            }
        }
    }


    private void showFacts(int i){
        int randomTextColor = Vars.lst_colors[random.nextInt(Vars.lst_colors.length-1)];
        tvFact.setTextColor(randomTextColor);

        if(i<5) {
            tvTitle.setTextColor(randomTextColor);
            tvTitle.setText("Факт #" + (i + 1));
            tvFact.setText(facts.get(i));
        }else{
            tvTitle.setTextColor(randomTextColor);
            tvTitle.setText("Факт #" + (i + 1));
            tvFact.setText("Келесі жолы кіріңіз, сіз үшін қызықты фактілерді дайындап қоямыз...");
        }
    }
}
