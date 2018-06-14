package kz.qazlingo.www.qazlingo;

/**
 * Created by sansyzbaynurbolat on 1/19/18.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class AlphabetListViewCustomAdapter extends BaseAdapter
{
    public String kiril[];
    public String latin[];
    public Activity context;
    public LayoutInflater inflater;
    private Random random;
    public AlphabetListViewCustomAdapter(Activity context,String[] kiril, String[] latin) {
        super();
        random = new Random();
        this.context = context;
        this.kiril = kiril;
        this.latin = latin;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return kiril.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder
    {
        LinearLayout linearLayout;
        TextView txtViewTitle;
        TextView txtViewSecondTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listitem_row, null);
            holder.linearLayout  = convertView.findViewById(R.id.list_linear_layout);
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.txtViewTitle_int_list);
            holder.txtViewSecondTitle = (TextView) convertView.findViewById(R.id.txtSecondViewTitle_int_list);
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        int number = random.nextInt(Vars.lst_colors.length-1);
        holder.txtViewTitle.setText(kiril[position]);
        holder.txtViewSecondTitle.setText(latin[position]);
        holder.txtViewTitle.setTextColor(Vars.lst_colors[number]);
        holder.txtViewSecondTitle.setTextColor(Vars.lst_colors[number]);
        //holder.linearLayout.setBackgroundColor(colors[number]);

        return convertView;
    }

}
