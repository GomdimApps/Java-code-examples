// Aqui está um exemplo de como usar o GridLayoutem Java usando a biblioteca de suporte do Android://

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout grid = findViewById(R.id.grid);

        // Cria os botões
        Button button1 = new Button(this);
        button1.setText("Botao 1");
        grid.addView(button1);

        Button button2 = new Button(this);
        button2.setText("Botao 2");
        grid.addView(button2);

        Button button3 = new Button(this);
        button3.setText("Botao 3");
        grid.addView(button3);

        Button button4 = new Button(this);
        button4.setText("Botao 4");
        grid.addView(button4);

    }
}

// Esse código suume que você já incluiu o GridLayoutem seu layout xml. Ele cria uma instância da classe GridLayoute adiciona botões a ele.//
// Não esqueça de adicionar as dependências no build.gradle // 

    app:columnCount="4"
    app:rowCount="2"
