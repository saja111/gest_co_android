package fr.doranco.flash.database;

import android.content.Context;
import android.util.Log;

import fr.doranco.flash.dao.SpecialiteDao;
import fr.doranco.flash.entity.Specialite;

public class SpecialiteDatabaseTest extends Thread {

    private DaoFactory daoFactory;
    private SpecialiteDao specialiteDao;

    public SpecialiteDatabaseTest(Context context) {
        daoFactory = DaoFactory.getInstance(context);
        specialiteDao = daoFactory.getSpecialiteDao();
    }

    @Override
    public void run() {
        super.run();

        // Creation des objets
        Specialite specialite1 = new Specialite("Securite informatique");
        Specialite specialite2 = new Specialite("Systeme reseau");
        Specialite specialite3 = new Specialite("Developpement JAVA");
        Specialite specialite4 = new Specialite("Cybersecurite");

        // Enregistrement en BD
        specialiteDao.create(specialite1);
        specialiteDao.create(specialite2);
        specialiteDao.create(specialite3);
        specialiteDao.create(specialite4);
        Log.i("log-bd", "<---- Creation des specialites avec success ---- >");

        // Lister les specialites
        Log.i("log-bd", specialiteDao.findAll().toString());

        // Update specialite id = 4
        specialite4 = specialiteDao.findById(4);
        specialite4.setNom("Cybersecurite");
        specialiteDao.update(specialite4);

        // Delete specialite id = 2
        specialite2 = specialiteDao.findById(2);
        specialiteDao.delete(specialite2);

        // Lister
        Log.i("log-bd", specialiteDao.findAll().toString());

    }
}
