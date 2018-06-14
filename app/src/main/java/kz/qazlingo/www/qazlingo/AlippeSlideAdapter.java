package kz.qazlingo.www.qazlingo;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by sansyzbaynurbolat on 1/17/18.
 */

public class AlippeSlideAdapter extends PagerAdapter{
    Context context;
    Converter converter = new Converter();
    //list of images
    public int[] list_images ={
        R.drawable.alippe_human,
        R.drawable.alippe_rooster,
        R.drawable.alippe_kids,
        R.drawable.alippe_bike,
        R.drawable.alippe_globe,
        R.drawable.alippe_austro,
        R.drawable.alippe_ball,
        R.drawable.alippe_story,
        R.drawable.alippe_tiger,
        R.drawable.alippe_law,
        R.drawable.alippe_dog,
        R.drawable.alippe_boat,
        R.drawable.alippe_key,
        R.drawable.alippe_little_bear,
        R.drawable.alippe_goat,
        R.drawable.alippe_beads,
        R.drawable.alippe_breads,
        R.drawable.alippe_fridge,
        R.drawable.alippe_think,
        R.drawable.alippe_spider,
        R.drawable.alippe_elephant,
        R.drawable.alippe_radio,
        R.drawable.alippe_carrot,
        R.drawable.alippe_mountain,
        R.drawable.alippe_time,
        R.drawable.alippe_plane,
        R.drawable.alippe_owl,
        R.drawable.alippe_atom,
        R.drawable.alippe_dragon,
        R.drawable.alippe_circus,
        R.drawable.alippe_champion,
        R.drawable.alippe_balls,
        R.drawable.alippe_toothbrush,
        R.drawable.alippe_bear,
        R.drawable.alippe_electromotor,
        R.drawable.alippe_dishes,
        R.drawable.alippe_laptop
    };

    //list of titles
    public String[] lst_title={
            converter.toLatin("Aдам"),
            converter.toLatin("Әтеш"),
            converter.toLatin("Балалар"),
            converter.toLatin("Велосипед"),
            converter.toLatin("Глобус"),
            converter.toLatin("Ғарышкер"),
            converter.toLatin("Доп"),
            converter.toLatin("Ертегі"),
            converter.toLatin("Жолбарыс"),
            converter.toLatin("Заң"),
            converter.toLatin("Ит"),
            converter.toLatin("Қайық"),
            converter.toLatin("Кілт"),
            converter.toLatin("Қонжық"),
            converter.toLatin("Лақ"),
            converter.toLatin("Моншақ"),
            converter.toLatin("Нан"),
            converter.toLatin("Тоңазытқыш"),
            converter.toLatin("Ойлау"),
            converter.toLatin("Өрмекші"),
            converter.toLatin("Піл"),
            converter.toLatin("Радио"),
            converter.toLatin("Сәбіз"),
            converter.toLatin("Тау"),
            converter.toLatin("Уақыт"),
            converter.toLatin("Ұшақ"),
            converter.toLatin("Үкі"),
            converter.toLatin("Физика"),
            converter.toLatin("Айдаһар"),
            converter.toLatin("Цирк"),
            converter.toLatin("Чемпион"),
            converter.toLatin("Шар"),
            converter.toLatin("Щетка"),
            converter.toLatin("Аю"),
            converter.toLatin("Электроқозғалтқыш"),
            converter.toLatin("Ыдыс-аяқ"),
            converter.toLatin("Компьютер")
    };

    //list of description
    public  String[] lst_description={
            "A,a ➜ "+converter.toLatin("А,а"),
            "Ә,ә ➜ "+converter.toLatin("Ә,ә"),
            "Б,б ➜ "+converter.toLatin("Б,б"),
            "В,в ➜ "+converter.toLatin("V,v"),
            "Г,г ➜ "+converter.toLatin("Г,г"),
            "Ғ,ғ ➜ "+converter.toLatin("Ғ,ғ"),
            "Д,д ➜ "+converter.toLatin("Д,д"),
            "Е,е ➜ "+converter.toLatin("Е,е"),
            "Ж,ж ➜ "+converter.toLatin("Ж,ж"),
            "З,з ➜ "+converter.toLatin("З,з"),
            "И,и ➜ "+converter.toLatin("И,и"),
            "Й,й ➜ "+converter.toLatin("Й,й"),
            "К,к ➜ "+converter.toLatin("К,к"),
            "Қ,қ ➜ "+converter.toLatin("Қ,қ"),
            "Л,л ➜ "+converter.toLatin("Л,л"),
            "М,м ➜ "+converter.toLatin("М,м"),
            "Н,н ➜ "+converter.toLatin("Н,н"),
            "Ң,ң ➜ "+converter.toLatin("Ң,ң"),
            "О,о ➜ "+converter.toLatin("О,о"),
            "Ө,ө ➜ "+converter.toLatin("Ө,ө"),
            "П,п ➜ "+converter.toLatin("П,п"),
            "Р,р ➜ "+converter.toLatin("Р,р"),
            "С,с ➜ "+converter.toLatin("С,с"),
            "Т,т ➜ "+converter.toLatin("Т,т"),
            "У,у ➜ "+converter.toLatin("У,у"),
            "Ұ,ұ ➜ "+converter.toLatin("Ұ,ұ"),
            "Ү,ү ➜ "+converter.toLatin("Ү,ү"),
            "Ф,ф ➜ "+converter.toLatin("Ф,ф"),
            "Һ,һ/Х,х ➜ "+converter.toLatin("Һ,һ/Х,х"),
            "Ц,ц ➜ "+converter.toLatin("Ц,ц"),
            "Ч,ч ➜ "+converter.toLatin("Ч,ч"),
            "Ш,ш ➜ "+converter.toLatin("Ш,ш"),
            "Щ,щ ➜ "+converter.toLatin("Щ,щ"),
            "Ю,ю ➜ "+converter.toLatin("Ю,ю"),
            "Э,э ➜ "+converter.toLatin("Э,э"),
            "Ы,ы,Я,я ➜ "+converter.toLatin("Ы,ы,Я,я"),
            "ь,ъ ➜ "+"жоқ",

    };
    //list of background colors
    public int[] lst_bacgroundcolors ={
            Color.rgb(202,90,85), //a
            Color.rgb(83,83,107), //ә
            Color.rgb(214,249,250), //б
            Color.rgb(251,219,104), //в
            Color.rgb(248,231,203),    //г
            Color.rgb(229,245,245),    //ғ
            Color.rgb(189,211,93),    //д
            Color.rgb(47,117,183),    //е
            Color.rgb(196,83,70),    //ж
            Color.rgb(255,255,255),    //з
            Color.rgb(44,1,31),    //и
            Color.rgb(190,226,226),    //й
            Color.rgb(255,255,255),    //к
            Color.rgb(213,242,176),    //қ
            Color.rgb(69,171,233),    //л
            Color.rgb(255,255,255),    //м
            Color.rgb(251,239,216),    //н
            Color.rgb(255,255,255),    //ң
            Color.rgb(255,255,255),    //о
            Color.rgb(255,255,255),    //ө
            Color.rgb(238,240,226),    //п
            Color.rgb(241,243,255),    //р
            Color.rgb(34,31,50),    //с
            Color.rgb(116,174,64),    //т
            Color.rgb(255,255,255),    //у
            Color.rgb(230,248,252),    //ұ
            Color.rgb(231,231,233),    //ү
            Color.rgb(0,0,0),    //ф
            Color.rgb(92,187,231),    //х
            Color.rgb(110,220,237),    //ц
            Color.rgb(241,221,201),    //ч
            Color.rgb(255,255,255),    //ш
            Color.rgb(139,204,196),    //щ
            Color.rgb(169,202,201),    //ю
            Color.rgb(252,243,184),    //э
            Color.rgb(241,232,207),     //я
            Color.rgb(236,230,227)     //я

    };

    //list of text colors
    public  int[] lst_text_colors ={
            Color.rgb(240,240,240), //a
            Color.rgb(240,240,240), //ә
            Color.rgb(171,33,33), //б
            Color.rgb(113,116,111), //в
            Color.rgb(140,198,62),    //г
            Color.rgb(0,0,0),    //ғ
            Color.rgb(255,255,255),    //д
            Color.rgb(240,240,240),    //е
            Color.rgb(255,255,255),    //ж
            Color.rgb(71,160,226),    //з
            Color.rgb(255,255,255),    //и
            Color.rgb(255,255,255),    //й
            Color.rgb(11,154,72),    //к
            Color.rgb(100,100,100),    //қ
            Color.rgb(255,255,255),    //л
            Color.rgb(122,36,99),    //м
            Color.rgb(50,50,50),    //н
            Color.rgb(232,181,28),    //ң
            Color.rgb(166,89,39),    //о
            Color.rgb(98,83,121),    //ө
            Color.rgb(105,105,105),    //п
            Color.rgb(255,178,0),    //р
            Color.rgb(200,96,25),    //с
            Color.rgb(228,57,57),    //т
            Color.rgb(204,55,13),    //у
            Color.rgb(50,50,50),    //ұ
            Color.rgb(238,189,110),    //ү
            Color.rgb(203,241,241),    //ф
            Color.rgb(227,157,126),    //х
            Color.rgb(226,53,39),    //ц
            Color.rgb(255,255,255),    //ч
            Color.rgb(187,234,87),    //ш
            Color.rgb(255,255,255),    //щ
            Color.rgb(250,250,250),    //ю
            Color.rgb(55,55,55),    //э
            Color.rgb(50,50,50),     //я
            Color.rgb(203,102,79)//я

    };

    public AlippeSlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_images.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

       LayoutInflater  inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view = inflater.inflate(R.layout.alippe_card_slide_template,container,false);
        LinearLayout layoutslide = view.findViewById(R.id.slide_linear_layout);
        ImageView img_slide = view.findViewById(R.id.slide_image);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvDescription = view.findViewById(R.id.tv_description);
        tvTitle.setTextColor(lst_text_colors[position]);
        tvDescription.setTextColor(lst_text_colors[position]);
        layoutslide.setBackgroundColor(lst_bacgroundcolors[position]);
        img_slide.setImageResource(list_images[position]);
        tvTitle.setText(lst_title[position]);
        tvDescription.setText(lst_description[position]);
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }
}
