package kz.qazlingo.www.qazlingo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class TranslatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    //constants
    private final int KAZ = 0;
    private final int RU = 1;
    private final int EN = 2;
    private final int DEFAULT_EDIT_TEXT_HEIGHT = 200;

    private Spinner leftLanguageSpinner;
    private Spinner rightLanguageSpinner;
    private CircularProgressButton btnTranslate;
    private ImageView btnClear;
    private ImageView btnSwitchLanguage;
    private EditText etText;
    private TextView tvResult;
    private TextView tvYandex;
    private ImageView btnCopyToClipboard;
    private Integer fromSelectedLanguage;
    private Integer toSelectedLanguage;
    private CardView cardViewResult;
    ConnectivityManager conMgr;
    HashMap<Integer,String> languageToString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        cardViewResult = findViewById(R.id.translator_card_view_bottom);
        //Initialize left spinner
         leftLanguageSpinner = (Spinner) findViewById(R.id.translator_spinner_left);
        ArrayAdapter<CharSequence> adapterForLeftSpinner = ArrayAdapter.createFromResource(this,
                R.array.langlist, android.R.layout.simple_spinner_item);
        adapterForLeftSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leftLanguageSpinner.setAdapter(adapterForLeftSpinner);

        //Initialize right spinner
        rightLanguageSpinner = (Spinner) findViewById(R.id.translator_spinner_right);
        ArrayAdapter<CharSequence> adapterForRightSpinner = ArrayAdapter.createFromResource(this,
                R.array.langlist, android.R.layout.simple_spinner_item);
        adapterForRightSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rightLanguageSpinner.setAdapter(adapterForRightSpinner);

        btnTranslate = findViewById(R.id.translator_button);
        btnClear = findViewById(R.id.translator_image_clear);
        btnSwitchLanguage = findViewById(R.id.translator_arrows_change);
        btnCopyToClipboard = findViewById(R.id.translator_image_copy);

        tvYandex= (TextView) findViewById(R.id.translator_tv_yandex);
        etText = findViewById(R.id.translator_edit_text);
        tvResult = findViewById(R.id.translator_text_view);

        //default ru to kz
        fromSelectedLanguage = 1;
        toSelectedLanguage = 0;

        rightLanguageSpinner.setOnItemSelectedListener(this);
        leftLanguageSpinner.setOnItemSelectedListener(this);
        leftLanguageSpinner.setSelection(RU);
        rightLanguageSpinner.setSelection(KAZ);
        //init hashmap to get string version of language
        languageToString = new HashMap<>();
        languageToString.put(KAZ,"kk");
        languageToString.put(RU,"ru");
        languageToString.put(EN,"en");

        toDefault();

        btnClear.setOnClickListener(this);
        btnCopyToClipboard.setOnClickListener(this);
        btnSwitchLanguage.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);


        etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                btnClear.setVisibility(View.VISIBLE);
            }
        });


    }


     private void toDefault(){
        tvYandex.setVisibility(View.GONE);
        btnClear.setVisibility(View.GONE);
        cardViewResult.setVisibility(View.GONE);
        etText.setText("");
        tvResult.setText("");
        etText.getLayoutParams().height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_EDIT_TEXT_HEIGHT, getResources().getDisplayMetrics());;


     }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
         if(parent.getId() == leftLanguageSpinner.getId()){
             if(toSelectedLanguage!=pos){
                 fromSelectedLanguage = pos;
             }else{
                 toSelectedLanguage = fromSelectedLanguage;
                 fromSelectedLanguage = pos;
                 rightLanguageSpinner.setSelection(toSelectedLanguage);
             }
         }


         if(parent.getId() == rightLanguageSpinner.getId()){
             if(fromSelectedLanguage!=pos){
                 toSelectedLanguage = pos;
             }else{
                 fromSelectedLanguage = toSelectedLanguage;
                 toSelectedLanguage = pos;
                 leftLanguageSpinner.setSelection(fromSelectedLanguage);
             }
         }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.translator_arrows_change:
                    int temporaryNumber =  fromSelectedLanguage;
                    fromSelectedLanguage = toSelectedLanguage;
                    toSelectedLanguage = temporaryNumber;
                    leftLanguageSpinner.setSelection(fromSelectedLanguage);
                    rightLanguageSpinner.setSelection(toSelectedLanguage);

                    break;
            case R.id.translator_image_copy:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Translated Text", tvResult.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "аударма көшірілді", Toast.LENGTH_SHORT).show();
                break;
            case R.id.translator_button:
                conMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                if ( conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED
                        || conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED ) {

                    String languagePair = languageToString.get(fromSelectedLanguage)+"-"+languageToString.get(toSelectedLanguage);
                    String textToBeTranslated = etText.getText().toString();
                    Translate(textToBeTranslated,languagePair);
                }else{
                    Toast.makeText(this, "Интернетке қосылыңыз", Toast.LENGTH_SHORT).show();
                }

                break;
            case  R.id.translator_image_clear:
                toDefault();
        }
    }


    void Translate(String textToBeTranslated, String languagePair) {
        TranslatorBackgroundTask translatorBackgroundTask = new TranslatorBackgroundTask(getApplicationContext(),tvResult,cardViewResult,btnTranslate,tvYandex);
        try {
            translatorBackgroundTask.execute(textToBeTranslated, languagePair); // Returns the translated text as a String
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Интернетке қосылыңыз", Toast.LENGTH_SHORT).show();
        }
    }
}
