package palex.site.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private long workoutId; //Идентификатор комплекса упражнений


    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){    //Восстанавливаем состояние объекта
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        }
    }

    /**
     * Вызывается тогда, когда системе потребуется макет фрагмента
     * @param inflater исп. для заполнения макета фрагмента. При заполнения макета представленя в формате XML преобразуются в объекты Java.
     * @param container Это объект ViewGroup из макета активности, содержащий фрагмент.
     * @param savedInstanceState Используется для восстановления состояния.
     * @return Заполняет элемент view макет фрагмента, преобразуя разметку XML в объекты Java.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();    //Версию суперкласса нужно вызывать всегда при реализации любых методов жизненного цикла фрагмента.
        View view = getView();  //получаем корневой объект View фрагмента.
        if (view != null) { // далее view используем для получения ссылок на надписи.
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {        //Сохраняем состояние фрагмента
        savedInstanceState.putLong("workoutId", workoutId);
    }


    public void setWorkout(long id) {       //Метод для присваивания идентификатора.
        this.workoutId = id;
    }

}
