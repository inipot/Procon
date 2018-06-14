package usuario.app.procon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private String cpf, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().add(R.id.testelayout3,new ContentMenuFragment()).commit();

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            cpf = extras.getString("usuariocpf");
            email = extras.getString("usuarioemail");
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            View header = navigationView.getHeaderView(0);
            TextView usuario = (TextView) header.findViewById(R.id.textmenu1);
            TextView emailusuario = (TextView) header.findViewById(R.id.textmenu2);
            usuario.setText(cpf);
            emailusuario.setText(email);
        }
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    } */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ConstraintLayout lconteudo = findViewById(R.id.testelayout2);

        if (id == R.id.nav_inicio) {

            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,
                    new ContentMenuFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_conheca_seus_direitos) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,
                    new ConhecaSeusDireitosFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_postos_atendimento) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,
                    new PostosAtendimentoFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_faca_reclamacao) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,
                    new FacaSuaReclamacaoFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_acompanha_reclamacao) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,
                    new AcompanheSuasReclamacoesFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_configuracoes) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,
                    new ConfiguracoesFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_sair) {
            finish();
            getSupportFragmentManager().popBackStack();
            startActivity(new Intent(MenuActivity.this, LoginActivity.class));

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setToolbarTitle(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
    }

    public void setCheckedNavView(int idItem) {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().findItem(idItem).setChecked(true);
    }

}
