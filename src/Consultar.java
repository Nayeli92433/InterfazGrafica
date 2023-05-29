import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Consultar extends  JFrame {
    private JList<Alumno> jLista;
    private JButton eliminar, eliminarTodo, mostrar, regresar;
    private DefaultListModel<Alumno> elementosModel;
    private JPanel panelList, panelButton, panelContainer;

    public Consultar() {
        initializeComponents();
        setupFrame();
        setupPanelContainer();
        add(panelContainer);

        mostrar();
        eliminar();
        eliminarTodo();
        regresar();
    }


    private void initializeComponents() {
        jLista= new JList<>();
        panelList = new JPanel();
        panelButton = new JPanel();
        panelContainer = new JPanel();

        mostrar = new JButton();
        eliminar = new JButton();
        eliminarTodo = new JButton();
        regresar = new JButton();

        mostrar.setText("Mostrar");
        eliminar.setText("Eliminar");
        eliminarTodo.setText("Eliminar Todo");
        regresar.setText("Regresar");

    }

    private void setupFrame() {
        setTitle("Lista de Datos");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(420, 420);
    }

    private void setupPanelContainer() {

        panelList.setLayout(new GridLayout(1, 0));
        panelList.add(jLista);
        panelList.setPreferredSize(new Dimension(300,300));


        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(380, 50));
        panelButton.add(mostrar);
        panelButton.add(eliminar);
        panelButton.add(eliminarTodo);
        panelButton.add(regresar);


        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelList);
        panelContainer.add(panelButton);

    }




    private void mostrar(){
        mostrar.addActionListener(e -> {
            elementosModel = new DefaultListModel<>();
            ArrayList<Alumno> lista = Formulario.getElemento();
            for (Alumno elemento: lista) {
                elementosModel.addElement(elemento);
                System.out.println(elemento.getNombre());
                elemento.getApellido();
            }
            jLista.setModel(elementosModel);
        });
    }

    private void eliminar(){
        eliminar.addActionListener(e -> {
            int elemento = jLista.getSelectedIndex();
            elementosModel.remove(elemento);

        });
    }

    private void eliminarTodo(){
        eliminarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementosModel.removeAllElements();
            }
        });
    }

    private void regresar(){
        regresar.addActionListener(e -> {
            this.setVisible(false);
            new Formulario().setVisible(true);
        });
    }

}




