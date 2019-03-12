package palex.site.workout;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener{    //Реализуем интерфейс слушателя


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //public void onShowDetails(View view){                         //Код для кнопки, кот. больше не нужна
    //    Intent intent = new Intent(this, DetailActivity.class);
    //    startActivity(intent);
    //}

    @Override
    public void itemClicked(long id) {  //Определенный интерфейсом метод, кот нужно реализовать
        View fragmentContainer = findViewById(R.id.fragment_container);
        if(fragmentContainer != null){  //Если FrameLayout не существует, то приложение выполняется на ус-ве с мал. экраном.
            WorkoutDetailFragment details = new WorkoutDetailFragment();   //Создание фрагмента
            FragmentTransaction ft = getSupportFragmentManager()  //Получение ссылки на транзакцию
                    .beginTransaction(); //Начало транзакции фрагмента
            details.setWorkout(id);
            ft.replace(R.id.fragment_container, details);   //замена фрагмента
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); // добавляем анимацию проявления и расстворения
            ft.addToBackStack(null);
            ft.commit();

            /*
                transaction.add(R.id.fragment_container, fragment); //Добавление фрагмента в ViewGroup.
                transaction.replace(R.id.fragment_container, fragment); //замена фрагмента.
                transaction.remove(fragment); //удаление.
                transaction.setTransition(transition); //назначить переходную анимацию, кот. будет сопровождать эту транзакцию.
                    доп. значения:
                    TRANSIT_FRAGMENT_CLOSE - фрагмент удаляется из стека.
                    TRANSIT_FRAGMENT_OPEN - фрагмент добавляется.
                    TRANSIT_FRAGMENT_FADE - фрагмент растворяется или проявляется.
                    TRANSIT_FRAGMENT_NONE - анимация отсутствует.
                transaction.addToBackStack(null) - помещает транзакцию в стек возврата, получает строку с именем, исп. для идентификации транзакции.
                transaction.commit();   //закрепление транзакции, изменения вступают в силу.
            */

        } else {
            Intent intent = new Intent(this, DetailActivity.class); //Запускаем активность DetailActivity.class
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id); //Добавляем ID выбранного пункта меню.
            startActivity(intent);
        }
    }

}
