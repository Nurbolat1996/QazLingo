package kz.qazlingo.www.qazlingo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

/**
 * Created by DoguD on 01/07/2017.
 */

public class TranslatorBackgroundTask extends AsyncTask<String, Void, String> {
    //Declare Context
    Context ctx;
    TextView tv;
    TextView tvyandex;
    CardView cardView;
    CircularProgressButton button;

    //Set Context
    TranslatorBackgroundTask(Context ctx, TextView tv,CardView cardView,CircularProgressButton button,TextView tvyandex) {
        this.tv = tv;
        this.ctx = ctx;
        this.cardView = cardView;
        this.button = button;
        this.tvyandex = tvyandex;
    }

    @Override
    protected String doInBackground(String... params) {
        //String variables
        String textToBeTranslated = params[0];
        String languagePair = params[1];
        textToBeTranslated = textToBeTranslated.replace("\n"," ");
        String jsonString;



        try {
            //Set up the translation call URL
            textToBeTranslated = URLEncoder.encode(textToBeTranslated,"UTF-8");
            String yandexKey = "trnsl.1.1.20180202T115457Z.8686b3c5ad0966e3.8be331a2f10af302cbdf5a671f43a65780bc71a0";
            String yandexUrl = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + yandexKey
                    + "&text=" + textToBeTranslated + "&lang=" + languagePair;
            URL yandexTranslateURL = new URL(yandexUrl);

            //Set Http Conncection, Input Stream, and Buffered Reader
            HttpURLConnection httpJsonConnection = (HttpURLConnection) yandexTranslateURL.openConnection();
            InputStream inputStream = httpJsonConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            //Set string builder and insert retrieved JSON result into it
            StringBuilder jsonStringBuilder = new StringBuilder();
            while ((jsonString = bufferedReader.readLine()) != null) {
                jsonStringBuilder.append(jsonString + "\n");
            }

            //Close and disconnect
            bufferedReader.close();
            inputStream.close();
            httpJsonConnection.disconnect();

            //Making result human readable
            String resultString = jsonStringBuilder.toString().trim();
            //Getting the characters between [ and ]
            resultString = resultString.substring(resultString.indexOf('[') + 1);
            resultString = resultString.substring(0, resultString.indexOf("]"));
            //Getting the characters between " and "
            resultString = resultString.substring(resultString.indexOf("\"") + 1);
            resultString = resultString.substring(0, resultString.indexOf("\""));

            return jsonStringBuilder.toString().trim();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        button.startAnimation();
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            JSONObject object = new JSONObject(result);
            String text = object.getString("text");
            text = text.replace("[\"", "");
            text = text.replace("\"]", "");
            tv.setText(text);
            cardView.setVisibility(View.VISIBLE);

            button.doneLoadingAnimation(ctx.getResources().getColor(R.color.blueTranslator), BitmapFactory.decodeResource(ctx.getResources(), R.drawable.done));
            button.revertAnimation();
            button.setBackground(ctx.getResources().getDrawable(R.drawable.button_shape_default));
            tvyandex.setVisibility(View.VISIBLE);
        } catch (Exception E) {

        }
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

