package com.app.boletim.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.app.boletim.R;
import com.app.boletim.AppBancoDados.App;
import com.app.boletim.Modelos.Aluno;
import com.app.boletim.Modelos.Aluno_;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class LoginActivity extends Login {
    @BindView(R.id.edit_login_email) protected EditText editLoginEmail;
    @BindView(R.id.edit_login_senha) protected EditText editLoginSenha;

    private Box<Aluno> alunoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        alunoBox = ((App)getApplication()).getBoxStore().boxFor(Aluno.class);
    }

    @OnClick(R.id.btn_logar)
    public void entrar(View view) {
        String email = editLoginEmail.getText().toString();
        String senha = editLoginSenha.getText().toString();

        List<Aluno> alunos =  alunoBox.query()
                .equal(Aluno_.email, email)
                .equal(Aluno_.senha, senha)
                .build().find();

        if(alunos.size() > 0) {
            logar(alunos.get(0));
            finish();
        }

        else {
            editLoginEmail.getText().clear();
            editLoginSenha.getText().clear();

            Snackbar.make(view, "Usuário e/ou senha incorretos.", Snackbar.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.txt_cadastre_se)
    public void cadastrar(View view) {
        startActivity(new Intent(this, CadastroAlunoActivity.class));
    }
}
