package Control;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * PROYECTO POO Sistema de Control de una GalerÍa de Arte
 *
 * Autores
 *
 * JANET CHEN HE 
 * MARIA JOSE NIÑO RODRIGUEZ 
 * DAVID SANTIAGO QUINTANA ECHAVARRIA
 * DANIEL STEVEN FLORIDO SAEZ
 *
 */
public class GestionClientes {

    public GestionClientes() {
    }

    //Genera lista de clientes al iniciar el día
    public Map<Long, Cliente> crearClientes() {
        Map<Long, Cliente> clientes = new TreeMap<>();
        clientes.put((long)1000 , new Cliente(1000, 1234567, "Malia", "Minio", "Carrera Dragon N 20-10", 301577261));
        clientes.put((long)2000 ,new Cliente(2000, 2345671, "Malia D.", "Quint Lee Yu", "Carrera Mono N 20-10", 301577262));
        clientes.put((long)3000 ,new Cliente(3000, 3456712, "Malia S.", "Floliro", "Carrera Grulla N 20-10", 301577263));
        clientes.put((long)4000 ,new Cliente(4000, 4567123, "Malia J.", "Chen He", "Carrera Tigresa N 20-10", 301577264));
        clientes.put((long)5000 ,new Cliente(5000, 5671234, "Malia A.", "Po", "Carrera Panda N 20-10", 301577265));
        return clientes;
    }
}