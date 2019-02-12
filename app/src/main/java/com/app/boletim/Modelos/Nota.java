package com.app.boletim.Modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by Marcos Mac on 16/12/18.
 */

@Entity
public class Nota {
    @Id private long id;
    private double notaBimestral;
    ToOne<Disciplina> disciplina;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNotaBimestral(double notaBimestral) {
        this.notaBimestral = notaBimestral;
    }

    public double getNotaBimestral() {
        return notaBimestral;
    }

    public void setDisciplina(ToOne<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    public ToOne<Disciplina> getDisciplina() {
        return disciplina;
    }
}
