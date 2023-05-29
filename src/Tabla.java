import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Tabla extends JFrame{
    private JTable jTable;
    private DefaultTableModel modelo;
    private JPanel panelList, panelButton, panelContainer;
    private JButton regresar;

    public Tabla (){
        initializeComponents();
        initControl();
        configTable();
        configFrame();
        setupPanelContainer();
        add(panelContainer);

        regresar();
    }

    private void initializeComponents() {
        panelList = new JPanel();
        panelButton = new JPanel();
        panelContainer= new JPanel();

        regresar = new JButton();
        regresar.setText("Regresar");

    }

    private void initControl(){
        /*
             DefaultTableModel()
             DefaultTableModel(int numRows, int numColumns)
             DefaultTableModel(Object[][] data, Object[] columnNames)
             DefaultTableModel(Object[] columnNames, int numRows)
             DefaultTableModel(Vector columnNames, int numRows)
             DefaultTableModel(Vector data, Vector columNames)
         */
        modelo = new DefaultTableModel();
        // DefaultTableModel modelo1 = new DefaultTableModel(UtilTable.usuarios,UtilTable.titulos);
        //modelo.setDataVector(UtilTable.usuarios,UtilTable.titulos);
        modelo.setColumnIdentifiers(UtilTable.titulos);
        String [] fila = new String[modelo.getColumnCount()];
        // Vector<String> data = new Vector<>(modelo.getColumnCount());
        ArrayList<Alumno> lista = Formulario.getElemento();
        for (Alumno userTable : lista) {
            fila[0] = userTable.getNombre();
            fila[1] = userTable.getApellido();
            fila[2] = userTable.getTelefono();
            fila[3] = userTable.getIne();
            fila[4] = userTable.getGenero();
            fila[5] = userTable.getSemestre();
            fila[6] = userTable.getCarrera();
            fila[7] = userTable.getMatricula();


            modelo.addRow(fila);


        }
        jTable = new JTable(modelo);
    }

    private void configFrame(){
        setTitle("Tabla de usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
        setResizable(false);
        setSize(900, 300);
    }

    private void configTable(){
        jTable.setGridColor(new Color(92, 88, 214));
        jTable.setPreferredScrollableViewportSize(new Dimension(850, 120));
        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(jTable);
        //Agregamos el JScrollPane al contenedor
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void setupPanelContainer() {


        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(380, 50));
        panelButton.add(regresar);


        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelButton);

    }
    private void regresar(){
        regresar.addActionListener(e -> {
            this.setVisible(false);
            new Formulario().setVisible(true);
        });
    }
}
