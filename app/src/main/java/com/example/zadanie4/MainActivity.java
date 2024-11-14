package com.example.zadanie4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button rzut;
    private Button reset;
    private TextView Blok1;
    private TextView Blok2;
    private TextView Blok3;
    private TextView Blok4;
    private TextView Blok5;
    private TextView tekst1;
    private TextView tekst2;
    private TextView tekst3;

    //ile było gier
    private int gry = 0;
    //wynik ostatniego losowania
    private int wynikLos = 0;
    private int sumaWartosciGier = 0;
    //suma kostek
    private int liczby = 0;
    private int[] tab = new int[5];


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rzut = findViewById(R.id.przycisk1);
        reset = findViewById(R.id.przycisk2);
        Blok1 = findViewById(R.id.blok1);
        Blok2 = findViewById(R.id.blok2);
        Blok3 = findViewById(R.id.blok3);
        Blok4 = findViewById(R.id.blok4);
        Blok5 = findViewById(R.id.blok5);
        tekst1 = findViewById(R.id.tekst1); //wyniki kości
        tekst2 = findViewById(R.id.tekst2); //wyniki wszystkich gier
        tekst3 = findViewById(R.id.tekst3); //ile było gier

       rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();//losowanie
                wynik(liczby); //wynik wszystkich losowan (wynik gry)
                ileLos();//liczba gier
                wyswietl(tab); //wyświetlenie kostek
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetowanie();
            }
        });

    }


    private void roll(){
    Random rand = new Random();
    liczby = 0;

    int x;

    for (int i = 0; i < 5; i++){
        x = rand.nextInt(6) + 1;
        liczby = liczby + x;
        tab[i] = x;
    }
    tekst1.setText("Wynik tego losowania: " + liczby);

    }

    private void resetowanie(){
        Blok1.setText("?");
        Blok2.setText("?");
        Blok3.setText("?");
        Blok4.setText("?");
        Blok5.setText("?");

        wynikLos = 0;
        tekst1.setText("Wynik tego losowania: " + wynikLos);

        sumaWartosciGier = 0;
        tekst2.setText("Wynik gry: " + sumaWartosciGier);

        gry = 0;
        tekst3.setText("Liczba gier: " +  gry);
    }

    private void wynik(int wynik){
    sumaWartosciGier = sumaWartosciGier + wynik;
    tekst2.setText("Wynik gry: " + sumaWartosciGier);
    }

    private void ileLos(){
        gry++;
        tekst3.setText("Liczba gier: " +  gry);
    }

    private void wyswietl (int[] wynikiKosci){
        Blok1.setText(String.valueOf(wynikiKosci[0]));
        Blok2.setText(String.valueOf(wynikiKosci[1]));
        Blok3.setText(String.valueOf(wynikiKosci[2]));
        Blok4.setText(String.valueOf(wynikiKosci[3]));
        Blok5.setText(String.valueOf(wynikiKosci[4]));
    }


}
