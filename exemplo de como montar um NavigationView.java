// Aqui está um exemplo de como montar um NavigationViewem Java utilizando a biblioteca de suporte do Android:

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Configura o NavigationView
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

// Esse código suume que você já incluiu o NavigationView em seu layout xml, e o DrawerLayout. Ele cria uma instância da classe NavigationViewe configura o NavControllerpara lidar com as navegações e ações do usuário. Ele também configura a barra de navegação superior e suporta navegação de volta.//

// Não esqueça de adicionar as dependências no build.gradle //

dependencies {
    implementation 'com.google.android.material:material:1.3.0-alpha03'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.2'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.2'
}
