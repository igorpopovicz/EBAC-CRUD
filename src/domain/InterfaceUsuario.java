package src.domain;

import java.util.Collection;

import javax.swing.*;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import src.dao.IClienteDAO;
import src.dao.ClienteSetDAO;

public class InterfaceUsuario extends JFrame {

  private static IClienteDAO iClienteDAO = new ClienteSetDAO();

  public void menu() {
    
    setTitle("CRUD");
    Container container = getContentPane();
    container.removeAll();
    container.setLayout(null);

    JButton cadastrarBut = new JButton("Cadastro");
    JButton consultarBut = new JButton("Consulta");
    JButton excluirBut = new JButton("Exclusao");
    JButton alterarBut = new JButton("Alteracao");
    JButton buscarTodosBut = new JButton("Consulta Geral");
    JButton sairBut = new JButton("Sair");

    container.add(cadastrarBut);
    container.add(consultarBut);
    container.add(excluirBut);
    container.add(alterarBut);
    container.add(buscarTodosBut);
    container.add(sairBut);

    cadastrarBut.setBounds(10,10,200,40);
    consultarBut.setBounds(220,10,200,40);
    excluirBut.setBounds(10,60,200,40);
    alterarBut.setBounds(220,60,200,40);
    buscarTodosBut.setBounds(10,110,200,40);
    sairBut.setBounds(220,110,200,40);

    setSize(430, 200);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    cadastrarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleCadastar();
      }
    });
    consultarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleConsultar();
      }
    });
    excluirBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleExcluir();
      }
    });
    alterarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleAlterar();
      }
    });
    buscarTodosBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleBuscarTodos();
      }
    });
    sairBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleSair();
      }
    });
  }

  public void handleCadastar(){
    setTitle("CADASTRO");
    Container container = getContentPane();
    container.removeAll();
    Cliente cliente = new Cliente();
    container.setLayout(null);
    setSize(430, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
                                                            
    JTextField cpfField             = new JTextField();
    JTextField nomeField            = new JTextField();
    JTextField telField             = new JTextField();
    JTextField endField             = new JTextField();
    JTextField numeroField          = new JTextField();
    JTextField cidadeEstadoField    = new JTextField();

    JLabel labelCpf            = new JLabel("CPF: ");
    JLabel labelNome           = new JLabel("Nome: ");
    JLabel labelTelefone       = new JLabel("Telefone: ");
    JLabel labelEndereco       = new JLabel("Endereco: ");
    JLabel labelNumero         = new JLabel("Numero: ");
    JLabel labelCidadeEstado   = new JLabel("Cidade/EST: ");

    JButton cadastrarBut = new JButton("Cadastrar");
    JButton voltarBut    = new JButton("Voltar");

    labelCpf.setBounds(10,10,100,20);
    labelNome.setBounds(220,10,100,20);
    labelTelefone.setBounds(10,30,100,20);
    labelEndereco.setBounds(220,30,100,20);
    labelNumero.setBounds(10,50,100,20);
    labelCidadeEstado.setBounds(220,50,100,20);

    cpfField.setBounds(110,10,100,20);
    nomeField.setBounds(320,10,100,20);
    telField.setBounds(110,30,100,20);
    endField.setBounds(320,30,100,20);
    numeroField.setBounds(110,50,100,20);
    cidadeEstadoField.setBounds(320,50,100,20);

    cadastrarBut.setBounds(77,80,120,20);
    voltarBut.setBounds(207,80,120,20);
    
    container.add(labelCpf);
    container.add(labelNome);
    container.add(labelTelefone);
    container.add(labelEndereco);
    container.add(labelNumero);
    container.add(labelCidadeEstado);
    container.add(cpfField);
    container.add(nomeField);
    container.add(telField);
    container.add(endField);
    container.add(numeroField);
    container.add(cidadeEstadoField);
    container.add(cadastrarBut);
    container.add(voltarBut);

    cpfField.addKeyListener(new KeyAdapter() { 
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
          cpfField.setEditable(true);
        } else {
          cpfField.setEditable(false);
        }
      }
    });

    telField.addKeyListener(new KeyAdapter() { 
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
          telField.setEditable(true);
        } else {
          telField.setEditable(false);
        }
      }
    });

    numeroField.addKeyListener(new KeyAdapter() { 
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
          numeroField.setEditable(true);
        } else {
          numeroField.setEditable(false);
        }
      }
    });

    cadastrarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        String CPF = cpfField.getText();
        String nome = nomeField.getText();

        if(isCamposValidos(CPF, nome)) {
          cliente.setCpf(Long.parseLong(CPF));
          cliente.setNome(nome);
          if(isCamposValidos(telField.getText())){
            cliente.setTel(Long.parseLong(telField.getText()));}
          if(isCamposValidos(endField.getText())){
            cliente.setEnd(endField.getText());}
          if(isCamposValidos(numeroField.getText())){
            cliente.setNumero(Integer.parseInt(numeroField.getText()));}
          if(isCamposValidos(cidadeEstadoField.getText())){
            cliente.setCidade(cidadeEstadoField.getText());}
        } else {
          JOptionPane.showMessageDialog(null, "Os campos CPF e nome nao podem estar vazios.", "Atencao",
          JOptionPane.WARNING_MESSAGE);
          return;
        }
          
        Boolean iscadastrado = iClienteDAO.cadastrar(cliente);
        if(iscadastrado) {
          JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
          "Sucesso", JOptionPane.INFORMATION_MESSAGE);
          menu();
        } else {
          JOptionPane.showMessageDialog(null, "Este CPF ja foi cadastrado.", "Atencao",
          JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    voltarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {menu();}
    });
  }
  
  public void handleConsultar() {
    setTitle("Consulta");
    Container container = getContentPane();
    container.removeAll();
    container.setLayout(null);
    
    JTextField cpfField    = new JTextField();
    JLabel labelCpf      = new JLabel("CPF: ");
    JLabel labelCliente = new JLabel();
    labelCliente.setText("Insira o cpf para consultar.");
    JButton consultarBut = new JButton("Consultar");
    JButton voltarBut = new JButton("Voltar");

    labelCpf.setBounds(130,10,35,20);
    cpfField.setBounds(175,10,100,20);
    labelCliente.setBounds(130,3,400,100);
    consultarBut.setBounds(77,80,120,20);
    voltarBut.setBounds(207,80,120,20);
    
    container.add(labelCpf);
    container.add(cpfField);
    container.add(labelCliente);
    container.add(consultarBut);
    container.add(voltarBut);

    setSize(430, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    cpfField.addKeyListener(new KeyAdapter() { 
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
          cpfField.setEditable(true);
        } else {
          cpfField.setEditable(false);
        }
      }
    });

    consultarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(cpfField.getText() != null && cpfField.getText() != ""){
          Cliente cliente = iClienteDAO.consultar(Long.parseLong(cpfField.getText()));
          if(cliente != null){
            labelCliente.setBounds(40,3,400,100);
            labelCliente.setText(cliente.toString());
          }else {
            JOptionPane.showMessageDialog(null, "Nao existe nenhum cliente cadastrado com esse CPF.", "Atencao",
            JOptionPane.WARNING_MESSAGE);
          }
        } 
      }
    });
    voltarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {menu();}
    });
  }

  public void handleExcluir() {
    setTitle("Exclusao");
    Container container = getContentPane();
    container.removeAll();
    container.setLayout(null);
    
    JTextField cpfField    = new JTextField();
    JLabel labelCpf      = new JLabel("CPF: ");
    JLabel labelMensagem = new JLabel("");
    JButton excluirBut = new JButton("Excluir");
    JButton voltarBut = new JButton("Voltar");
    labelMensagem.setText("Insira o cpf para excluir.");

    labelCpf.setBounds(130,10,35,20);
    cpfField.setBounds(175,10,100,20);
    labelMensagem.setBounds(130,3,400,100);
    excluirBut.setBounds(77,80,120,20);
    voltarBut.setBounds(207,80,120,20);
    
    container.add(labelCpf);
    container.add(cpfField);
    container.add(labelMensagem);
    container.add(excluirBut);
    container.add(voltarBut);

    setSize(430, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    cpfField.addKeyListener(new KeyAdapter() { 
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
          cpfField.setEditable(true);
        } else {
          cpfField.setEditable(false);
        }
      }
    });

    excluirBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        iClienteDAO.excluir(Long.parseLong(cpfField.getText()));
        labelMensagem.setText("Clente excluido com sucesso!");
      }
    });
    voltarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {menu();}
    });
  }
  
  public void handleAlterar() {
    setTitle("Alteracao");
    Container container = getContentPane();
    container.removeAll();
    container.setLayout(null);
    
    JTextField cpfField    = new JTextField();
    JLabel labelCpf      = new JLabel("CPF: ");
    JLabel labelMensagem = new JLabel("");
    JButton alterarBut = new JButton("Alterar");
    JButton voltarBut = new JButton("Voltar");
    labelMensagem.setText("Insira o cpf para alterar.");

    labelCpf.setBounds(130,10,35,20);
    cpfField.setBounds(175,10,100,20);
    labelMensagem.setBounds(130,3,400,100);
    alterarBut.setBounds(77,80,120,20);
    voltarBut.setBounds(207,80,120,20);
    
    container.add(labelCpf);
    container.add(cpfField);
    container.add(labelMensagem);
    container.add(alterarBut);
    container.add(voltarBut);

    setSize(430, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    cpfField.addKeyListener(new KeyAdapter() { 
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
          cpfField.setEditable(true);
        } else {
          cpfField.setEditable(false);
        }
      }
    });

    alterarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(iClienteDAO.consultar(Long.parseLong(cpfField.getText())) != null) { 
          iClienteDAO.excluir(Long.parseLong(cpfField.getText()));
          {
            setTitle("Alteracao");
            Container container = getContentPane();
            container.removeAll();
            container.setLayout(null);
            Cliente cliente = new Cliente();
            
            JTextField nomeField   = new JTextField();
            JTextField telField    = new JTextField();
            JTextField endField    = new JTextField();
            JTextField numeroField = new JTextField();
            JTextField cidadeEstadoField = new JTextField();
        
            JLabel labelNome     = new JLabel("Nome: ");
            JLabel labelTelefone = new JLabel("Telefone: ");
            JLabel labelEndereco = new JLabel("Endereco: ");
            JLabel labelNumero   = new JLabel("Numero: ");
            JLabel labelCidadeEstado   = new JLabel("Cidade/EST: ");
        
            labelCpf.setBounds(10,10,100,20);
            labelNome.setBounds(220,10,100,20);
            labelTelefone.setBounds(10,30,100,20);
            labelEndereco.setBounds(220,30,100,20);
            labelNumero.setBounds(10,50,100,20);
            labelCidadeEstado.setBounds(220,50,100,20);
        
            cpfField.setBounds(110,10,100,20);
            nomeField.setBounds(320,10,100,20);
            telField.setBounds(110,30,100,20);
            endField.setBounds(320,30,100,20);
            numeroField.setBounds(110,50,100,20);
            cidadeEstadoField.setBounds(320,50,100,20);
            
            container.add(labelCpf);
            container.add(labelNome);
            container.add(labelTelefone);
            container.add(labelEndereco);
            container.add(labelNumero);
            container.add(labelCidadeEstado);
            container.add(cpfField);
            container.add(nomeField);
            container.add(telField);
            container.add(endField);
            container.add(numeroField);
            container.add(cidadeEstadoField);
        
            JButton cadastrarBut = new JButton("Alterar");
            cadastrarBut.setBounds(77,80,120,20);
            voltarBut.setBounds(207,80,120,20);
            container.add(cadastrarBut);
            container.add(voltarBut);
  
            setSize(431, 151);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);      
  
            cpfField.addKeyListener(new KeyAdapter() { 
              public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
                  cpfField.setEditable(true);
                } else {
                  cpfField.setEditable(false);
                }
              }
            });
        
            telField.addKeyListener(new KeyAdapter() { 
              public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
                  telField.setEditable(true);
                } else {
                  telField.setEditable(false);
                }
              }
            });
        
            numeroField.addKeyListener(new KeyAdapter() { 
              public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || KeyEvent.getKeyText(ke.getKeyCode()).equals("Backspace")){
                  numeroField.setEditable(true);
                } else {
                  numeroField.setEditable(false);
                }
              }
            });

            cadastrarBut.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                String CPF = cpfField.getText();
                String nome = nomeField.getText();

                if(isCamposValidos(CPF, nome)) {
                  cliente.setCpf(Long.parseLong(CPF));
                  cliente.setNome(nome);
                  if(isCamposValidos(telField.getText())){
                    cliente.setTel(Long.parseLong(telField.getText()));}
                  if(isCamposValidos(endField.getText())){
                    cliente.setEnd(endField.getText());}
                  if(isCamposValidos(numeroField.getText())){
                    cliente.setNumero(Integer.parseInt(numeroField.getText()));}
                  if(isCamposValidos(cidadeEstadoField.getText())){
                    cliente.setCidade(cidadeEstadoField.getText());}
                } else {
                  JOptionPane.showMessageDialog(null, "Os campos CPF e nome nao podem estar vazios.", "Atencao",
                  JOptionPane.WARNING_MESSAGE);
                  return;
                }
          
                Boolean iscadastrado = iClienteDAO.cadastrar(cliente);
                if(iscadastrado) {
                  JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                  "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                  menu();
                } else {
                  JOptionPane.showMessageDialog(null, "Este CPF ja foi cadastrado.", "Atencao",
                  JOptionPane.WARNING_MESSAGE);
                }
              }
            });
          }
        }else {
          JOptionPane.showMessageDialog(null, "O cliente nao existe.", "Atencao", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    voltarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {menu();}
    });
  }

  public void handleBuscarTodos() {
    Collection<Cliente> clientes = iClienteDAO.buscarTodos();

    setTitle("Clientes");
    Container container = getContentPane();
    container.removeAll();
    container.setLayout(null);
    
    JButton voltarBut = new JButton("Voltar");
    JFormattedTextField formClientes = new JFormattedTextField();

    formClientes.setBounds(10,1,410,200);
    voltarBut.setBounds(155,230,120,20);

    container.add(formClientes);
    container.add(voltarBut);

    setSize(430, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    if(clientes.isEmpty()){
      formClientes.setText("Nao existem clientes cadastrados");
    }else{
      formClientes.setText(clientes.toString());
    }

    voltarBut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {menu();}
    });
  }

  public void handleSair() {
    dispose();
  }

  private boolean isCamposValidos(String ...campos) {
    for(String campo: campos){
        if(campo == null || campo.equals("")){
            return false;
        }
    } 
    return true;      
  }
}
