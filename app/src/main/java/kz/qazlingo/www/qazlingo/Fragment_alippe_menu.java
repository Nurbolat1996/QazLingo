package kz.qazlingo.www.qazlingo;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sansyzbaynurbolat on 1/16/18.
 */

public class Fragment_alippe_menu extends Fragment {
    private static final String TAG = "MainActivity";
    Button button;
    Button btAlphabetTable;
    Button btLowLevel;
    Button btMiddleLevel;
    Button btHighLevel;
    Typeface typeface;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alippe_menu,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"vFKBookmanBoldA.TTF");
         button = getActivity().findViewById(R.id.button_alippe_menu_cards);

         btAlphabetTable = getActivity().findViewById(R.id.button_alippe_menu_table);
         btLowLevel = getActivity().findViewById(R.id.button_alippe_menu_low_level);
         btMiddleLevel= getActivity().findViewById(R.id.button_alippe_menu_middle_level);
         btHighLevel= getActivity().findViewById(R.id.button_alippe_menu_high_level);
        button.setTypeface(typeface);
        btAlphabetTable.setTypeface(typeface);
        btLowLevel.setTypeface(typeface);
        btMiddleLevel.setTypeface(typeface);
        btHighLevel.setTypeface(typeface);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CardActivity.class);
                startActivity(intent);
            }
        });

        btAlphabetTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AlphabetActivity.class);
                startActivity(intent);
            }
        });

        btLowLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr=new Fragment_alippe_low_level();
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                fc.replaceFragment(fr);
            }
        });

        btMiddleLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr=new Fragment_alippe_middle_level();
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                fc.replaceFragment(fr);
            }
        });

        btHighLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr=new Fragment_alippe_high_level();
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                fc.replaceFragment(fr);
            }
        });
    }
}
