package kz.qazlingo.www.qazlingo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sansyzbaynurbolat on 1/16/18.
 */

public class Fragment_converter extends Fragment {
    private static final String TAG = "MainActivity";
    private static final String KAZ = "Қазақша";
    private static final String QAZ = "Qazaqs'a";
    private static final String BUTTON_TEXT_TO_COPY = "Мәтінді көшіру";
    private static final String BUTTON_TEXT_TO_CONVERT = "Сәйкестендіру";
    Converter converter;
    boolean isKazToQaz = true;
    boolean isRealTimeConvert = true;
    ImageButton btChangeConvertType;
    Button btConvert;
    Switch swRealTimeConvert;
    EditText etTop;
    EditText etBottom;
    TextView tvLeft;
    TextView tvRight;
    String text = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_converter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        converter = new Converter();
        tvLeft = getActivity().findViewById(R.id.converter_textView_left);
        tvRight = getActivity().findViewById(R.id.converter_textView_right);
        btChangeConvertType = getActivity().findViewById(R.id.converter_button_change_type);
        btConvert = getActivity().findViewById(R.id.converter_button_convert);
        swRealTimeConvert = getActivity().findViewById(R.id.converter_switch);
        etBottom = getActivity().findViewById(R.id.converter_et_bottom);
        etTop = getActivity().findViewById(R.id.converter_et_top);

        //Switch
        swRealTimeConvert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isRealTimeConvert = b;
                if (b) {
                    btConvert.setText(BUTTON_TEXT_TO_COPY);
                }else{
                    btConvert.setText(BUTTON_TEXT_TO_CONVERT);
                }
            }
        });

        //when convert button click
        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isRealTimeConvert) {
                    text = etTop.getText().toString();
                    if (isKazToQaz) {
                        text = converter.toLatin(text);
                    } else {
                        text = converter.toKiril(text);
                    }
                    etBottom.setText(text);
                }else{
                    copyTextToClipboard();
                }
            }
        });

        etTop.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (isRealTimeConvert) {
                    text = etTop.getText().toString();
                    if (isKazToQaz) {
                        text = converter.toLatin(text);
                    } else {
                        text = converter.toKiril(text);
                    }
                    etBottom.setText(text);
                }
            }
        });

        btChangeConvertType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isKazToQaz = !isKazToQaz;
                if (isKazToQaz) {
                    tvLeft.setText(KAZ);
                    tvRight.setText(QAZ);
                } else {
                    tvLeft.setText(QAZ);
                    tvRight.setText(KAZ);
                }
            }
        });

        etBottom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                copyTextToClipboard();
                return false;
            }
        });
    }


    private void copyTextToClipboard(){
        ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("converterText", text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getContext(), "Мәтін көшірілді", Toast.LENGTH_SHORT).show();
    }
}
