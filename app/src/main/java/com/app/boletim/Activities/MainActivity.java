package com.app.boletim.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.app.boletim.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.navegacao_slide);

        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);

        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (mToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_disciplinas)
    public void abrirDisciplinas(View view) {
        startActivity(new Intent(this, DiscplinasActivity.class));
    }

    @OnClick(R.id.btn_agendamentos)
    public void abrirAgendamentos(View view) {
        startActivity(new Intent(this, AgendamentosActivity.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.meus_dados_usuario){
            startActivity(new Intent(this, SeusDadosActivity.class));
            Toast.makeText(this, "Meus Dados", Toast.LENGTH_LONG).show();
        }

        if(id == R.id.sair_usuario){
            getSharedPreferences("boletim.file", MODE_PRIVATE).edit().clear().commit();

            startActivity(new Intent(this, LoginActivity.class));
            finish();
            Toast.makeText(this, "Saiu", Toast.LENGTH_LONG).show();
        }

        return false;
    }
}
