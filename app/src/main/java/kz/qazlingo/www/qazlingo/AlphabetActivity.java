package kz.qazlingo.www.qazlingo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class AlphabetActivity extends AppCompatActivity {

    ListView lview3;
    AlphabetListViewCustomAdapter adapter;
    Converter converter = new Converter();



    public  String[] lst_kiril={
            "A,a",
            "Ә,ә",
            "Б,б",
            "В,в",
            "Г,г",
            "Ғ,ғ",
            "Д,д",
            "Е,е",
            "Ж,ж",
            "З,з",
            "И,и",
            "Й,й",
            "К,к",
            "Қ,қ",
            "Л,л",
            "М,м",
            "Н,н",
            "Ң,ң",
            "О,о",
            "Ө,ө",
            "П,п",
            "Р,р",
            "С,с",
            "Т,т",
            "У,у",
            "Ұ,ұ",
            "Ү,ү",
            "Ф,ф",
            "Һ,һ/Х,х",
            "Ц,ц",
            "Ч,ч",
            "Ш,ш",
            "Щ,щ",
            "Ы,ы",
            "I,i",
            "Ю,ю",
            "Э,э",
            "Я,я",
            "ь,ъ",

    };
    public  String[] lst_latin={
            converter.toLatin("А,а"),
            converter.toLatin("Ә,ә"),
            converter.toLatin("Б,б"),
            converter.toLatin("V,v"),
            converter.toLatin("Г,г"),
            converter.toLatin("Ғ,ғ"),
            converter.toLatin("Д,д"),
            converter.toLatin("Е,е"),
            converter.toLatin("Ж,ж"),
            converter.toLatin("З,з"),
            converter.toLatin("И,и"),
            converter.toLatin("Й,й"),
            converter.toLatin("К,к"),
            converter.toLatin("Қ,қ"),
            converter.toLatin("Л,л"),
            converter.toLatin("М,м"),
            converter.toLatin("Н,н"),
            converter.toLatin("Ң,ң"),
            converter.toLatin("О,о"),
            converter.toLatin("Ө,ө"),
            converter.toLatin("П,п"),
            converter.toLatin("Р,р"),
            converter.toLatin("С,с"),
            converter.toLatin("Т,т"),
            converter.toLatin("У,у"),
            converter.toLatin("Ұ,ұ"),
            converter.toLatin("Ү,ү"),
            converter.toLatin("Ф,ф"),
            converter.toLatin("Һ,һ/Х,х"),
            converter.toLatin("Ц,ц"),
            converter.toLatin("Ч,ч"),
            converter.toLatin("Ш,ш"),
            converter.toLatin("Щ,щ"),
            converter.toLatin("Ы,ы"),
            converter.toLatin("I,i"),
            converter.toLatin("Ю,ю"),
            converter.toLatin("Э,э"),
            converter.toLatin("Я,я"),
            "жоқ",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        lview3 = (ListView) findViewById(R.id.listView3);
        adapter = new AlphabetListViewCustomAdapter(this,lst_kiril,lst_latin);
        lview3.setAdapter(adapter);

    }
}
