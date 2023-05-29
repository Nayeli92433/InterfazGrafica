import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

    public class Formulario extends JFrame implements ChangeListener, ItemListener {

        private JFrame frame;
        private JPanel paneliz, paneliz2, panelde, panelde2, panelButton, panelForm, panelContainer, panelRadio;
        private JLabel nombre, apellidos, telefono, ine, genero, listCarrera, listSemestre, matricula;
        private JTextField text1, text2, text3, text4, text5, text6, text7, text8;
        private JButton boton1, boton2, boton3, boton4;
        private JRadioButton radio1,radio2;
        private ButtonGroup buttonGroup;
        private JComboBox<String> carreras;
        private JComboBox<String> semestres;



        private static ArrayList<Alumno> lista;
        private static final ArrayList<String> listaCarreras = UtilCombo.listaCarreras();
        private static final ArrayList<String> listaSemestres = UtilCombo.listaSemestres();

        public Formulario() {
            initializeComponents();
            setupFrame();
            setupPanelContainer();
            addActionListeners();
            llenarCombo();
            add(panelContainer);
            //boton1.addActionListener(eventClick);
            //query();

            radio1.addChangeListener(this);
            radio2.addChangeListener(this);
            carreras.addItemListener(this);
            semestres.addItemListener(this);

        }

        //Inicializa todos los componentes del formulario, como las etiquetas, campos de texto y botones.
        private void initializeComponents() {
            EventClick eventClick = new EventClick();

            frame = new JFrame();
            panelRadio= new JPanel();
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
            boton3 = new JButton();
            boton4= new JButton();
            radio1 = new JRadioButton();
            radio2 = new JRadioButton();
            buttonGroup = new ButtonGroup();
            carreras = new JComboBox<>();
            semestres= new JComboBox<>();
            listSemestre= new JLabel();
            listCarrera= new JLabel();

            nombre.setText("Nombre");
            apellidos.setText("Apellidos");
            telefono.setText("Telefono");
            ine.setText("INE");
            listCarrera.setText("Carrera");

            boton1.setText("Aceptar");
            boton2.setText("Consultar");
            boton3.setText("Tabla");
            boton4.setText("Borrar");

            radio1.setText("Estudiante");
            radio2.setText("Aspirante");

            genero.setText("Genero");
            listSemestre.setText("Semestre");
            matricula.setText("Matricula");
        }
        //Configura la ventana principal del formulario.
        private void setupFrame() {
            setTitle("Formulario Estudiantes");
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setSize(600, 300);
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
            paneliz2.add(listCarrera);
            paneliz2.add(listSemestre);
            paneliz2.add(matricula);

            panelde2.setLayout(new GridLayout(4, 2));
            panelde2.add(text5);
            panelde2.add(carreras);
            panelde2.add(semestres);
            panelde2.add(text8);

            panelForm.setLayout(new GridLayout(1, 1));
            panelForm.setPreferredSize(new Dimension(450, 90));
            panelForm.add(paneliz);
            panelForm.add(panelde);
            panelForm.add(paneliz2);
            panelForm.add(panelde2);

            panelButton.setLayout(new FlowLayout());
            panelButton.setPreferredSize(new Dimension(250, 50));
            panelButton.add(boton1);
            panelButton.add(boton4);
            panelButton.add(boton2);
            panelButton.add(boton3);


            panelRadio.setLayout(new FlowLayout());
            panelRadio.setPreferredSize(new Dimension(200, 20));
            buttonGroup.add(radio1);
            buttonGroup.add(radio2);
            panelRadio.add(radio1);
            panelRadio.add(radio2);


            panelContainer.setLayout(new GridLayout(3, 0));
            panelContainer.add(panelRadio);
            panelContainer.add(panelForm);
            panelContainer.add(panelButton);

            frame.add(panelContainer);
        }
        //Asigna los ActionListener a los botones.
        private void addActionListeners() {
            boton1.addActionListener(new EventClick());
            boton2.addActionListener(e -> {
                Consultar consultar= new Consultar();
                consultar.setVisible(true);
                this.setVisible(false);
            });
            boton3.addActionListener(e ->{
                Tabla tabla= new Tabla();
                tabla.setVisible(true);
                this.setVisible(false);
            });
            boton4.addActionListener(e -> {
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

        private void llenarCombo(){
            for (String s: listaCarreras) {
                carreras.addItem(s);
            }
            for (String s: listaSemestres) {
                semestres.addItem(s);
            }
        }

        public static ArrayList<Alumno> getElemento (){
            return lista;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == carreras){
                String item2 = (String) carreras.getSelectedItem();
                text6.setText(item2);

            }
            if (e.getSource() == semestres){
                String item2 = (String) semestres.getSelectedItem();
                text7.setText(item2);

            }

        }

        @Override
        public void stateChanged(ChangeEvent e) {
            if (radio1.isSelected()) {
                text1.setEditable(true);
                text2.setEditable(true);
                text3.setEnabled(true);
                text4.setEnabled(true);
                text5.setEnabled(true);
                carreras.setEnabled(true);
                semestres.setEnabled(true);
                text8.setEnabled(true);
            }
            if (radio2.isSelected()) {
                text1.setEditable(true);
                text2.setEditable(true);
                text3.setEnabled(true);
                text4.setEnabled(true);
                text5.setEnabled(true);
                carreras.setEnabled(false);
                semestres.setEnabled(false);
                text8.setEnabled(false);
            }

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











