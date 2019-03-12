package palex.site.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "id"; //Исп. константу для передачи идентификатора, чтобы конкр. значение не фиксировалось в коде.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag); //получаем ссылку на фрагмент через вызов метода findFragmentById() у диспетчера фрагментов
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);    //получаем идентификатор из интента
        frag.setWorkout(workoutId); //передаем идентификатор
    }
}
