package telas;

import bancoDados.HibernateUtil;
import com.mycompany.prowayswing.entidades.Cliente;
import com.mycompany.prowayswing.repositorios.ClienteDAO;
import com.mycompany.prowayswing.repositorios.ClienteDAOImpl;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ClienteJFrame extends JFrame {
    private JTextField textField1;
    private JFormattedTextField formattedTextFieldCPF;
    private JFormattedTextField formattedTextField2;
    private JPanel Painel;
    private JLabel textFieldNome;
    private JLabel textFieldCPF;
    private JLabel textFieldDataNascimento;
    private JButton salvarButton;
    private JTable table1;
    private EntityManager entityManager;
    private ClienteDAO clienteDAO;

    public ClienteJFrame() {
        entityManager = HibernateUtil.getEntityManager();
        clienteDAO = new ClienteDAOImpl(entityManager);
        listarClientes();
        salvarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                salvarCliente();
            }
        });
    }

    private void salvarCliente() {
        var nome = textFieldNome.getText().trim();
        var cpf = formattedTextFieldCPF.getText().trim();
        var dataNascimento = formattedTextField2.getText().trim();

        var cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setDataNascimento(LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        clienteDAO.salvar(cliente);
        listarClientes();
        textFieldNome.setText("");
        formattedTextFieldCPF.setText("");
        formattedTextField2.setText("");
    }

    private void listarClientes() {
        var clientes = clienteDAO.obterTodos();
        table1.setModel(new ClientesTableModel(clientes));
    }

    public static void main(String[] args) {
        var jFrame = new ClienteJFrame();
        jFrame.setContentPane(jFrame.Painel);
        jFrame.setSize(600, 400);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    private class ClientesTableModel extends AbstractTableModel {
        private final String[] COLUMNS = {"Código", "Nome", "CPF", "Data de Nascimento"};
        private List<Cliente> clientes;

        private ClientesTableModel(List<Cliente> clientes) {
            this.clientes = clientes;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public int getRowCount() {
            return clientes.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var cliente = clientes.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> cliente.getId();
                case 1 -> cliente.getNome();
                case 2 -> cliente.getCpf();
                case 3 -> cliente.getDataNascimento();
                default -> "";
            };
        }
    }
}

