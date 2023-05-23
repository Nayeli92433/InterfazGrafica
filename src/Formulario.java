import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

    public class Formulario extends JFrame {

        private JFrame frame;
        private JPanel paneliz, paneliz2, panelde, panelde2, panelButton, panelForm, panelContainer;
        private JLabel nombre, apellidos, telefono, ine, genero, carrera, semestre, matricula;
        private JTextField text1, text2, text3, text4, text5, text6, text7, text8;
        private JButton boton1, boton2;




        private static ArrayList<Alumno> lista;

        public Formulario() {
            initializeComponents();
            setupFrame();
            setupPanelContainer();
            addActionListeners();
            add(panelContainer);
            //boton1.addActionListener(eventClick);
            query();
        }

        //Inicializa todos los componentes del formulario, como las etiquetas, campos de texto y botones.
        private void initializeComponents() {
            EventClick eventClick = new EventClick();

            frame = new JFrame();
            paneliz = new JPanel();
            paneliz2 = new JPanel();
            panelde = new JPanel();
            panelde2 = new JPanel();
            panelButton = new JPanel();
            panelForm = new JPanel();
            panelContainer = new JPanel();
            nombre = new JLabel();
            apellidos = new JLabel();
            telefono = new JLabel();
            ine = new JLabel();
            genero = new JLabel();
            carrera = new JLabel();
            semestre = new JLabel();
            matricula = new JLabel();
            text1 = new JTextField();
            text2 = new JTextField();
            text3 = new JTextField();
            text4 = new JTextField();
            text5 = new JTextField();
            text6 = new JTextField();
            text7 = new JTextField();
            text8 = new JTextField();
            boton1 = new JButton();
            boton2 = new JButton();

            nombre.setText("Nombre");
            apellidos.setText("Apellidos");
            telefono.setText("Telefono");
            ine.setText("INE");

            boton1.setText("Aceptar");
            boton2.setText("Consultar");

            genero.setText("Genero");
            carrera.setText("Carrera");
            semestre.setText("Semestre");
            matricula.setText("Matricula");
        }
        //Configura la ventana principal del formulario.
        private void setupFrame() {
            setTitle("Formulario Estudiantes");
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setSize(600, 220);
        }
        // Configura los paneles y los agrega al panel contenedor principal.
        private void setupPanelContainer() {
            paneliz.setLayout(new GridLayout(4, 0));
            paneliz.add(nombre);
            paneliz.add(apellidos);
            paneliz.add(telefono);
            paneliz.add(ine);

            panelde.setLayout(new GridLayout(4, 0));
            panelde.add(text1);
            panelde.add(text2);
            panelde.add(text3);
            panelde.add(text4);

            paneliz2.setLayout(new GridLayout(4, 2));
            paneliz2.add(genero);
            paneliz2.add(carrera);
            paneliz2.add(semestre);
            paneliz2.add(matricula);

            panelde2.setLayout(new GridLayout(4, 2));
            panelde2.add(text5);
            panelde2.add(text6);
            panelde2.add(text7);
            panelde2.add(text8);

            panelForm.setLayout(new GridLayout(1, 1));
            panelForm.setPreferredSize(new Dimension(500, 100));
            panelForm.add(paneliz);
            panelForm.add(panelde);
            panelForm.add(paneliz2);
            panelForm.add(panelde2);

            panelButton.setLayout(new FlowLayout());
            panelButton.setPreferredSize(new Dimension(250, 50));
            panelButton.add(boton1);
            panelButton.add(boton2);

            panelContainer.setLayout(new GridLayout(2, 0));
            panelContainer.add(panelForm);
            panelContainer.add(panelButton);

            frame.add(panelContainer);
        }
        //Asigna los ActionListener a los botones.
        private void addActionListeners() {
            boton1.addActionListener(new EventClick());
            boton2.addActionListener(e -> {
                clearTextFields();
            });
        }
        // Borra el contenido de todos los campos de texto.
        private void clearTextFields() {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
            text6.setText("");
            text7.setText("");
            text8.setText("");
        }

        private void query(){
            boton2.addActionListener(e -> {
                Consultar consultar= new Consultar();
                consultar.setVisible(true);
                this.setVisible(false);
            });
        }
        public static ArrayList<Alumno> getElemento (){
            return lista;
        }
        public class EventClick implements ActionListener {
            public EventClick(){
                lista = new ArrayList<>();
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = text1.getText();
                String apellidos = text2.getText();
                String telefono = text3.getText();
                String ine = text4.getText();
                String genero = text5.getText();
                String carrera = text6.getText();
                String semestre = text7.getText();
                String matricula = text8.getText();

                lista.add(new Alumno(nombre,apellidos,telefono,ine,genero,carrera,semestre,matricula));
                mostrar(lista);
            }
        }

        public void mostrar(ArrayList<Alumno> lista){
            for (Alumno alumno:lista) {
                System.out.println("Nombre: "+alumno.getNombre() +" " + alumno.getApellido());
                System.out.println("Telefono: "+alumno.getTelefono());
                System.out.println("INE:" +alumno.getIne());
                System.out.println("Genero: "+alumno.getGenero());
                System.out.println("Carrera: "+alumno.getCarrera());
                System.out.println("Semestre: "+alumno.getSemestre());
                System.out.println("Matricula: "+alumno.getMatricula());
            }
        }
    }











