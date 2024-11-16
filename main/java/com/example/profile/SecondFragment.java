package com.example.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private int counter = 0;
    private TextView counterTextView;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.secondfragment, container, false);


    counterTextView = view.findViewById(R.id.counterTextView);
    View incrementButton = view.findViewById(R.id.incrementButton);
    View decrementButton = view.findViewById(R.id.decrementButton);

    // Установка начального значения счётчика
        counterTextView.setText(String.valueOf(counter));

    // Обработчики кнопок
        incrementButton.setOnClickListener(v -> {
        counter++;
        updateCounter();
    });

        decrementButton.setOnClickListener(v -> {
        if (counter > 0) { // Счётчик не может быть отрицательным
            counter--;
            updateCounter();
        }
    });

        return view;
}

// Метод для обновления текста счётчика
private void updateCounter() {
    counterTextView.setText(String.valueOf(counter));
}
}
