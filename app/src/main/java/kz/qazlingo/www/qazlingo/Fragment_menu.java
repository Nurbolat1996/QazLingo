package kz.qazlingo.www.qazlingo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sansyzbaynurbolat on 1/16/18.
 */

public class Fragment_menu extends Fragment {
    private static final String TAG = "MainActivity";
    Button buttonAlippe;
    Button buttonConverter;
    Button buttonFact;
    Button buttonTranslator;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonAlippe = getActivity().findViewById(R.id.button_menu_alippe);
        buttonConverter = getActivity().findViewById(R.id.button_menu_converter);
        buttonFact = getActivity().findViewById(R.id.button_menu_fact);
        buttonTranslator = getActivity().findViewById(R.id.button_menu_translator);
        buttonAlippe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr=new Fragment_alippe_menu();
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                fc.replaceFragment(fr);
            }
        });
        buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr=new Fragment_converter();
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                fc.replaceFragment(fr);
            }
        });

        buttonFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr=new Fragment_facts();
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                fc.replaceFragment(fr);
            }
        });

        buttonTranslator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),TranslatorActivity.class);
                startActivity(intent);
            }
        });


    }
}
