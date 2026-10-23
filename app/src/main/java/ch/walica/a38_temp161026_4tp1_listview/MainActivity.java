package ch.walica.a38_temp161026_4tp1_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import ch.walica.a38_temp161026_4tp1_listview.model.Person;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText etName;
    private Button btnAdd;
    private List<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);
        people.add(new Person("Jan"));
        people.add(new Person("Karol"));
        people.add(new Person("Gustaw"));
        people.add(new Person("Andrzej"));
        people.add(new Person("Adam"));
        people.add(new Person("Tadeusz"));

        //ArrayAdapter<Person> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_item, people);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Person person = people.get(i);
                //Toast.makeText(MainActivity.this, person.getName() + " " + person.getAge(), Toast.LENGTH_SHORT).show();
                people.remove(person);
                adapter.notifyDataSetChanged();
            }
        });

        btnAdd.setOnClickListener(view -> {
            String name = etName.getText().toString().trim();
            if(name.isEmpty()) {
                Toast.makeText(this, "Prosze wpisać imię", Toast.LENGTH_SHORT).show();
                return;
            }
            people.add(new Person(name));
            adapter.notifyDataSetChanged();
            etName.getText().clear();
        });


    }
}