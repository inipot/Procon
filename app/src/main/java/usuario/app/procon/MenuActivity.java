package usuario.app.procon;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

    private  String barra;
    private NavigationView navigationView;
    private String cpf,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(barra);
        setSupportActionBar(toolbar);
        Button btconhecaseusdireitos = (Button) findViewById(R.id.btconhecaseusdireitos);
        Button btpostosatendimento = (Button) findViewById(R.id.btpostosatendimento);
        Button btfacareclamacao = (Button) findViewById(R.id.btfacasuareclamacao);
        Button btacompanhareclamacao = (Button) findViewById(R.id.btacompanhereclamacao);
        btconhecaseusdireitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                ConstraintLayout lconteudo = findViewById(R.id.testelayout2);
                getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new ConhecaSeusDireitosFragment()).commit();
                //barra = "Conheça seus direitos";
                lconteudo.setVisibility(View.INVISIBLE);
                //toolbar.setTitle(barra);
                navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(1).setChecked(true);
            }
        });

        btpostosatendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                ConstraintLayout lconteudo = findViewById(R.id.testelayout2);
                getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new PostosAtendimentoFragment()).commit();
                barra = "Postos de atendimento";
                //lconteudo.setVisibility(View.INVISIBLE);
                toolbar.setTitle(barra);
                navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(2).setChecked(true);
            }
        });

        btfacareclamacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                ConstraintLayout lconteudo = findViewById(R.id.testelayout2);
                getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new FacaSuaReclamacaoFragment()).commit();
                barra = "Faça sua reclamação";
               // lconteudo.setVisibility(View.INVISIBLE);
                toolbar.setTitle(barra);
                navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(3).setChecked(true);
            }
        });

        btacompanhareclamacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                ConstraintLayout lconteudo = findViewById(R.id.testelayout2);
                getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new AcompanheSuasReclamacoesFragment()).commit();
                barra = "Acompanhe sua reclamação";
                //lconteudo.setVisibility(View.INVISIBLE);
                toolbar.setTitle(barra);
                navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(4).setChecked(true);
            }
        });
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
        if(extras!= null) {
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
            Intent intent = new Intent(MenuActivity.this, MenuActivity.class);
            intent.putExtra("usuariocpf",cpf);
            intent.putExtra("usuarioemail",email);
            startActivity(intent);
            barra = "Procon";
           // lconteudo.setVisibility(View.INVISIBLE);
        }


          else if (id == R.id.nav_conheca_seus_direitos) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new ConhecaSeusDireitosFragment()).commit();
            barra = "Conheça seus direitos";
           // lconteudo.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_postos_atendimento) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new PostosAtendimentoFragment()).commit();
            barra = "Postos de atendimento";
            //lconteudo.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_faca_reclamacao) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new FacaSuaReclamacaoFragment()).commit();
            barra = "Faça sua reclamação";
           // lconteudo.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_acompanha_reclamacao) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new AcompanheSuasReclamacoesFragment()).commit();
            barra = "Acompanhe suas reclamações";
            //lconteudo.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_configuracoes) {
            getSupportFragmentManager().beginTransaction().replace(R.id.testelayout,new ConfiguracoesFragment()).commit();
            barra = "Configurações";
            //lconteudo.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_sair) {
            getSupportFragmentManager().beginTransaction().remove(new ConhecaSeusDireitosFragment()).commit();
            getSupportFragmentManager().beginTransaction().remove(new PostosAtendimentoFragment()).commit();
            getSupportFragmentManager().beginTransaction().remove(new FacaSuaReclamacaoFragment()).commit();
            getSupportFragmentManager().beginTransaction().remove(new AcompanheSuasReclamacoesFragment()).commit();
            startActivity(new Intent(MenuActivity.this,LoginActivity.class));
            finish();

        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(barra);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}