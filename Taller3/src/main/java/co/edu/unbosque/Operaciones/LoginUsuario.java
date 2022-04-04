package co.edu.unbosque.Operaciones;

import co.edu.unbosque.Datos.DatosUsuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import co.edu.unbosque.Datos.DatosUsuario;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class LoginUsuario {
    public Optional<List<DatosUsuario>> leerUsuario() {
        try {
            List<DatosUsuario> userList = new ArrayList<>();

            Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("users.csv").toURI()));
            CSVReader csvReader = new CSVReader(reader);

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                String username = line[0];
                String password = line[1];
                String role = line[2];
                DatosUsuario usuario = new DatosUsuario(username, password, role);
                userList.add(usuario);
            }
            reader.close();
            csvReader.close();
            return Optional.of(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void crearUsuario(String[] data) throws URISyntaxException {
        File file = new File(String.valueOf(Paths.get(ClassLoader.getSystemResource("users.csv").toURI())));
        try {
            FileWriter outPutFile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outPutFile);
            writer.writeNext(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
