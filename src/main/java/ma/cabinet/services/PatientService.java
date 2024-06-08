package ma.cabinet.services;

import ma.cabinet.entities.Consultation;
import ma.cabinet.entities.DossierMedicale;
import ma.cabinet.entities.Patient;
import ma.cabinet.repository.IDossierMedRepository;
import ma.cabinet.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IDossierMedRepository dossierMedRepository;

    @Transactional
    public void addPatient(Patient patient) {
        DossierMedicale dossierMedicale = new DossierMedicale();
        dossierMedicale.setDateCreation(LocalDate.now());
        dossierMedicale.setPatient(patient);
        dossierMedicale.setConsultations(new ArrayList<Consultation>());

        dossierMedRepository.save(dossierMedicale);

        patient.setDossierMedicale(dossierMedicale);
        patientRepository.save(patient);
    }
}
