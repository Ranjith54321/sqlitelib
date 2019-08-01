package dot.ranjith.sqlitelib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;
    //private SearchView s1;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView BookName = (TextView) convertView.findViewById(R.id.BookName);
            TextView AuthorName = (TextView) convertView.findViewById(R.id.AuthorName);
            TextView Avail = (TextView) convertView.findViewById(R.id.Avail);
          //  SearchView s1 = (SearchView) convertView.findViewById(R.id.s1);

            if (BookName != null) {
                BookName.setText(user.getBookName());
            }
            if (AuthorName != null) {
                AuthorName.setText((user.getAuthorName()));
            }
            if (Avail != null) {
                Avail.setText((user.getAvailable()));
            }

        }
        //SearchView s1 = (SearchView) convertView.findViewById(R.id.s1);
/*
        if (s1 != null) {
            s1.setText("");
        } */

        return convertView;
    }
}
