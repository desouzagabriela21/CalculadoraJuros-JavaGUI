import javax.swing.*;
import java.awt.*;

public class Calculadora {

    static double valorMensal, jurosMensais, anos, total;
    static String texto;

    public static void Resultado(){
        total = valorMensal * (Math.pow(1 + jurosMensais, anos * 12) - 1) / jurosMensais;
    }

    public static void main(String[] args) {
        mostrarTelaInicial();
    }

    public static void mostrarTelaInicial() {
        JFrame inicioFrame = new JFrame("Poupex");
        inicioFrame.setSize(450, 250);
        inicioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicioFrame.setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        painel.setBackground(new Color(100, 5, 49));
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel label = new JLabel("Juros ao mes %:");
        label.setForeground(Color.WHITE);
        JLabel label1 = new JLabel("Num. de anos:");
        label1.setForeground(Color.WHITE);
        JLabel label2 = new JLabel("Deposito mensal:");
        label2.setForeground(Color.WHITE);
        JLabel label3 = new JLabel("Total poupado:");
        label3.setForeground(Color.WHITE);

        JTextField campo = new JTextField(15);
        JTextField campo1 = new JTextField(15);
        JTextField campo2 = new JTextField(15);
        JTextField campo3 = new JTextField(15);
        campo3.setEditable(false);

        JButton button = new JButton("OK");
        button.setPreferredSize(new Dimension(170,22));
        button.setBackground(new Color(131, 54, 90));
        button.setForeground(Color.WHITE);

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.LINE_END;
        painel.add(label, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.LINE_START;
        painel.add(campo, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.LINE_END;
        painel.add(label1, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.LINE_START;
        painel.add(campo2, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.LINE_END;
        painel.add(label2, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.LINE_START;
        painel.add(campo1, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.LINE_END;
        painel.add(label3, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.LINE_START;
        painel.add(campo3, gbc);

        gbc.gridx = 1; 
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        painel.add(button, gbc);

        button.addActionListener(e -> {
            try {
                String texto = campo1.getText().trim(); 
                if (texto.isEmpty()) throw new NumberFormatException();
                valorMensal = Double.parseDouble(texto);

                texto = campo.getText().trim(); 
                if (texto.isEmpty()) throw new NumberFormatException();
                jurosMensais = Double.parseDouble(texto) / 100.0;

                texto = campo2.getText().trim();
                if (texto.isEmpty()) throw new NumberFormatException();
                anos = Double.parseDouble(texto);

                Resultado();
                campo3.setText(String.format("%.2f", total));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(inicioFrame, "Preencha todos os campos com numeros validos.");
            }
        });

        inicioFrame.add(painel);
        inicioFrame.setVisible(true);
    }
}
