package com.example.messenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        Button buttonSendMessage = findViewById(R.id.buttonSendMessage);
        EditText editTextMessage = findViewById(R.id.editTextMessage);
        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                launchNextScreen(message);

            }
        });
        }
    // метод, который запускает следующий экран и запускается при клике на кнопку
    private void launchNextScreen(String message) {
        // экземпляр Intent служит для запуска нового окна
        // this - это класс, который хочет запустить новое окно (в нашем случае это - MainActivity)
        // MessageActivity - это класс окна, который мы хотим запустить
        Intent intent = new Intent(this, MessageActivity.class);
        // В Intent есть метод, который может направлять данные на новый экран
        // ключ: "message", значение: message
        intent.putExtra("message", message);
        // запускаем новую активити
        startActivity(intent);
    }
}