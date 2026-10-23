package ch.walica.a38_temp161026_4tp1_listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ch.walica.a38_temp161026_4tp1_listview.model.Person;

public class PersonAdapter extends ArrayAdapter<Person> {

    private Context context;
    private List<Person> people;

    public PersonAdapter(Context context, List<Person> people) {
        super(context, R.layout.person_item, people);
        this.context = context;
        this.people = people;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
