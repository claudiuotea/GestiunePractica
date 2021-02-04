package application.services;
import application.Entities.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModificareDocumente
{
    private List <String> file;
    private void completare(String filename, Student S)
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();
            while (line != null)
            {
                file.add(line);
                line = line.replace("num_firma", S.getFirma().getName());
                line = line.replace("tel_firma", S.getFirma().getTel());
                line = line.replace("fax_firma", S.getFirma().getFax());
                line = line.replace("fiscal_firma", S.getFirma().getCod());
                line = line.replace("bancar_firma", S.getFirma().getBanca());
                line = line.replace("iban_firma", S.getFirma().getIban());
                line = line.replace("rep_firma", S.getFirma().getRep());

                line = line.replace("num_stud", S.getName());
                line = line.replace("cetatenie_stud", S.getCetatenie());
                line = line.replace("adresa_stud", S.getDomiciliu());
                line = line.replace("tel_stud", S.getTel());
                line = line.replace("email_stud", S.getEmail());
                line = line.replace("CNP_stud", S.getCNP());
                line = line.replace("CI_stud", S.getCI());
                line = line.replace("data_nastere_stud", S.getDataNastere());
                line = line.replace("oras_natal_stud", S.getOras_n());
                line = line.replace("an_studiu", S.getAnStudiu());
                line = line.replace("grupa_stud", S.getGrupa());
                line = line.replace("specializare_stud", S.getSectie().getName());
                line = line.replace("linie_studiu", S.getLinie());

                line = line.replace("nume_tutore", S.getFirma().getT().getName());
                line = line.replace("functie_tutore", S.getFirma().getT().getFunctie());
                line = line.replace("telefon_tutore", S.getFirma().getT().getTel());
                line = line.replace("fax_tutore", S.getFirma().getT().getFax());
                line = line.replace("email_tutore", S.getFirma().getT().getEmail());

                line = line.replace("nume_supervizor", S.getSectie().getCadruDidactic().getName());
                line = line.replace("functie_supervizor", S.getSectie().getCadruDidactic().getFunctie());
                line = line.replace("telefon_spervizor", S.getSectie().getCadruDidactic().getTel());
                line = line.replace("fax_supervizor", S.getSectie().getCadruDidactic().getFax());
                line = line.replace("email_supervizor", S.getSectie().getCadruDidactic().getEmail());

                line = line.replace("semnatura_rep", S.getFirma().getName());
                line = line.replace("semnatura_decan", S.getSectie().getFacultate().getDecan());
                line = line.replace("semnatura_student", S.getName());
                line = line.replace("semnatura_supervizor", S.getSectie().getCadruDidactic().getName());

                line = bufferedReader.readLine();

                File docCompletat = new File(S.getName());
                FileOutputStream fos = new FileOutputStream(docCompletat);
                OutputStreamWriter osw = new OutputStreamWriter(fos);

                for (String value : file) {
                    osw.write(value);
                }
                osw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
