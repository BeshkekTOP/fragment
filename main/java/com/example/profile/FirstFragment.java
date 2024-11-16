package com.example.profile;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private TextView textView; // Элемент для изменения текста

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Инфляция макета фрагмента
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        // Инициализация TextView
        textView = view.findViewById(R.id.textView);

        // Регистрируем TextView для контекстного меню
        registerForContextMenu(textView);

        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Проверяем, что контекстное меню создается для TextView
        if (v.getId() == R.id.textView) {
            menu.setHeaderTitle("Выберите действие");
            menu.add(0, 1, 0, "Сменить текст на 'Хочу пыццу'");
            menu.add(0, 2, 1, "Сменить текст на 'Привет коллеге Java-разработчику'");
            menu.add(0, 3, 2, "Сменить текст на 'Ну ладно пока'");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        // Обработка выбранного пункта меню
        switch (item.getItemId()) {
            case 1:
                textView.setText("Хочу пыццу");
                return true;
            case 2:
                textView.setText("Привет коллеге Java-разработчику");
                return true;
            case 3:
                textView.setText("Ну ладно пока");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
