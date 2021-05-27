package Control;

import Entidades.Artista;
import Entidades.Cuadro;
import Entidades.Escultura;
import Entidades.Instalacion;
import Entidades.Material;
import Entidades.Obra;
import Enumeraciones.Clasificacion;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
public class GestionObras {

    public GestionObras() {
    }

    //Genera lista de obras al iniciar el día
    public Map<Long,Obra> crearObras() {
        Map<Long,Obra> obras = new TreeMap<>();//TEMA , TECNICA
        obras.put((long)2000000,new Cuadro("Lisa Gherardini", "Oleo", Clasificacion.OBRA_REPRESENTATIVA, 2000000, "MariaLisa", LocalDate.of(1880, Month.MARCH, 5), 100000, "100x45"));
        obras.put((long)2000001,new Cuadro("Naturaliza", "Oleo", Clasificacion.OBRA_REPRESENTATIVA, 2000001, "La Maria estrellada", LocalDate.of(2015, Month.SEPTEMBER, 15), 2000, "100x45"));
        obras.put((long)2000002,new Cuadro("Escena biblica","Oleo sobreyeso",Clasificacion.OBRA_REPRESENTATIVA, 2000002, "La ultima Maria", LocalDate.of(2015, Month.OCTOBER, 30), 3000, "300x503"));
        obras.put((long)2000003,new Cuadro("Religioso", "Fresco", Clasificacion.OBRA_MAESTRA, 2000003, "La creación de Maria", LocalDate.of(2013, Month.SEPTEMBER, 1), 4000, "777x666"));
        obras.put((long)2000004,new Cuadro("Realismo", "Oleo"  , Clasificacion.OBRA_MAESTRA,2000004, "AutoMaria", LocalDate.of(2012, Month.SEPTEMBER, 12), 5000, "49x531"));
        obras.put((long)2000005,new Cuadro("Mitologico","Temple sobre lienzo"  , Clasificacion.OBRA_REPRESENTATIVA,2000005, "El nacimiento de Maria", LocalDate.of(2015, Month.NOVEMBER, 19), 6000, "79x53"));
        obras.put((long)2000006,new Cuadro("Juicio final", "Fresco"  , Clasificacion.OBRA_MAESTRA,2000006, "La Maria final", LocalDate.of(2010, Month.DECEMBER, 7), 7000, "81x20"));
        obras.put((long)2000007,new Cuadro("Moderno", "Oleo sobre lienzo"  , Clasificacion.OBRA_MAESTRA,2000007, "La Maria guiando al pueblo", LocalDate.of(2009, Month.SEPTEMBER, 5), 8000, "150x50"));
        obras.put((long)2000008,new Cuadro("Melancolia", "Oleo sobre revoco"  , Clasificacion.OBRA_MAESTRA,2000008, "Maria deborando a su hijo", LocalDate.of(2009, Month.JANUARY, 5), 9000, "300x200"));
        obras.put((long)2000009,new Cuadro("Amor", "Oleo sobre lienzo"  , Clasificacion.OBRA_REPRESENTATIVA,2000009, "Cuando te casas, Maria?", LocalDate.of(2020, Month.MARCH, 5), 10000, "100x10"));
        obras.put((long)2000010,new Cuadro("Tortugas ninja", "Acuarela sobre papel papiro chino full hd"  , Clasificacion.OBRA_MAESTRA,2000010, "El renacimiento de las tortugas de Maria", LocalDate.of(2020, Month.SEPTEMBER, 20), 11000, "100x100"));
        
        Material Marmol= new Material(100, "Marmol", "Roca metamórfica compacta formada a partir de rocas calizas");
        Material Bronce =new Material(200, "Bronce","aleación de cobre y estaño, en la que el primero constituye su base y el segundo aparece en una proporción del tres al veinte por ciento");
        Material Metal = new Material(300, "Metal","Roca sedimentaria descompuesta constituida por agregados de silicatos de aluminio");
        Material Yeso = new Material(400, "Yeso","Sulfato de calcio semihidratado");
        Material Sal = new Material(500, "Sal","Sustancia blanca, cristalina, muy soluble en el agua, que abunda en la naturaleza en forma de grandes masas sólidas");
//long codigo, String nombre, String descripcion
        new Escultura(); //String material, double peso, Material tipoMaterial, long codigoObra, String titulo, Calendar fecha, float precioRef, String dimensiones
        obras.put((long)2000011,new Escultura( 7.72, Marmol, 2000011, "El Maria David", LocalDate.of(2000, Month.MARCH, 4), 50000, "100x3400x4454"));
        obras.put((long)2000012,new Escultura( 9, Marmol, 2000012, "Victoria alada de San Mariatracia", LocalDate.of(2003, Month.MAY, 6), 80000, "275x60x65"));
        obras.put((long)2000013,new Escultura( 12.5, Yeso, 2000013, "La edad madura de Maria", LocalDate.of(2000, Month.MARCH, 4), 140000, "13x342x54"));
        obras.put((long)2000014,new Escultura( 1200.7, Metal, 2000014, "La Maria de la libertad", LocalDate.of(1993, Month.APRIL, 5), 990000, "5005x2420x654"));
        obras.put((long)2000015,new Escultura( 23.7, Bronce, 2000015, "El pensador a la Maria", LocalDate.of(1965, Month.FEBRUARY, 7), 10000, "535x20x624"));
        
        obras.put((long)2000016,new Escultura( 20.3, Yeso, 2000016, "Busto Maria Nefertiti", LocalDate.of(1912, Month.NOVEMBER, 3), 120000, "1205x3320x3854"));
        obras.put((long)2000017,new Escultura( 7.7, Bronce, 2000017, "Manneken Malia piss", LocalDate.of(1977, Month.MAY, 7), 82000, "325x120x4424"));
        obras.put((long)2000018,new Escultura( 13.7, Bronce, 2000018, "Maria Buda Tian Tan", LocalDate.of(1990, Month.APRIL, 3), 12000, "1325x10x44"));
        
        ArrayList<Material> m1 = new ArrayList<>();
        m1.add(Yeso);
        m1.add(Bronce);
        m1.add(Metal);
        m1.add(Marmol);
        
  
        Material Marmol2= new Material(600, "Marmol australiano", "Roca metamórfica compacta formada a partir de rocas calizas");
        Material Bronce2 =new Material(700, "Bronce europeo","aleación de cobre y estaño, en la que el primero constituye su base y el segundo aparece en una proporción del tres al veinte por ciento");
        Material Metal2 = new Material(800, "Metal frances","Roca sedimentaria descompuesta constituida por agregados de silicatos de aluminio");
        Material Yeso2 = new Material(900, "Yeso azul","Sulfato de calcio semihidratado");
        Material Sal2 = new Material(1000, "Sal de frutas","Sustancia blanca, cristalina, muy soluble en el agua, que abunda en la naturaleza en forma de grandes masas sólidas");
 
        ArrayList<Material> m2 = new ArrayList<>();
        m2.add(Bronce2);
        m2.add(Metal2);
        m2.add(Sal2);
        
        ArrayList<Material> m3 = new ArrayList<>();
        m3.add(Yeso2);
        m3.add(Marmol2);
        obras.put((long)2000019,new Instalacion( "Museo contemporáneo y submarino, situado bajo la superficie del océano Atlántico", m1, 2000019, "The Rubicon", LocalDate.of(1952, Month.JANUARY, 26), 440000, "1205x3320"));
        obras.put((long)2000020,new Instalacion( "Laberinto en forma de espiral, hecho minuciosamente con sal", m2, 2000020, "Labyrinth", LocalDate.of(1902, Month.MAY, 24), 1140000, "15305x3320"));
        obras.put((long)2000021,new Instalacion( "Secuencia de piedras colosales, cuya creación desafía la gravedad. Se dice que es la perfecta definición de estabilidad y colapso.", m3, 2000021, "Seven Magic Mountains", LocalDate.of(1944,Month.JULY, 19), 150000, "5705x3320"));
        
        return obras;
    }

    //Genera lista de artistas al iniciar el día
    public Map<Long,Artista> crearArtista() {
        Map<Long,Artista> artistas = new TreeMap<>();
        artistas.put((long) 1001,new Artista(1001, 123456789, "Maria L.", "Da Vinci", LocalDate.of(1452, Month.APRIL, 15), 7654321));
        artistas.put((long)1002 ,new Artista(1002, 234567891, "Maria P.", "Picasso", LocalDate.of(1881, Month.OCTOBER, 25), 7654322));
        artistas.put((long)1003 ,new Artista(1003, 345678912, "Maria V.", "Van Gogh", LocalDate.of(1853, Month.MARCH, 30), 7654323));
        artistas.put((long)1004 , new Artista(1004, 456789123, "Maria M.", "Angel", LocalDate.of(1475, Month.MARCH, 6), 7654324));
        artistas.put((long)1005 , new Artista(1005, 567891234, "Maria Salvador", "Dali", LocalDate.of(1904, Month.MAY, 11), 7654325));
        artistas.put((long)1006 , new Artista(1006, 678912345, "Fernando Maria", "Botero", LocalDate.of(1932, Month.APRIL, 19), 7654326));
        artistas.put((long)1007 , new Artista(1007, 789123456, "Rafael Maria", "Sanzio", LocalDate.of(1483, Month.APRIL, 6), 7654327));
        artistas.put((long)1008 , new Artista(1008, 891234567, "Maria Niccolo", "Donatello", LocalDate.of(1836, Month.JANUARY, 1), 7654328));
        artistas.put((long)1009 , new Artista(1009, 912345678, "Maria Omar", "Rayo", LocalDate.of(1928, Month.JANUARY, 20), 7654329));
        artistas.put((long)1010 , new Artista(1010, 113456789, "Maria Sandro", "Botticelli", LocalDate.of(1445, Month.MARCH, 1), 7654320));
        return artistas;
    }

}