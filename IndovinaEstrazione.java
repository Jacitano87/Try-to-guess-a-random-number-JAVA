import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class IndovinaEstrazione{
	private int numComputer;		//numero da indovinare
    private int numMio;		//numero mio
	private int maxTent=20;	//numero massimo di tentativi
	private int tent=0;		//tentativi fatti
    private int contatore=0;
	JLabel lblTentativi;		//numero di tentativi
	JLabel lblMioNumero;
	JLabel lblNumeroComputer;
    JTextField txtProva;		//numero inserito dall'utente
	JButton butGioca;
    
	
	IndovinaEstrazione(){
		
		lblMioNumero=new JLabel("");
		lblNumeroComputer=new JLabel("");
		txtProva=new JTextField("");
		txtProva.setEditable(true);
		butGioca=new JButton("Inserisci un numero");
        butGioca.setSize(30,30);
        
		JFrame f=new JFrame("Indovina un numero compreso tra 1 e 100");
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setSize(300,150);
		f.setLocation(400,500);
		
		JPanel pn=new JPanel();	
		lblTentativi=new JLabel("   ");	//area a nord
		pn.add(lblTentativi);
		f.add(pn,"North");
		
		JPanel pc=new JPanel();				//pannello al centro
		pc.setLayout(new GridLayout(1,3));
		pc.add(lblMioNumero);
		pc.add(txtProva);
		pc.add(lblNumeroComputer);
		f.add(pc,"Center");
		
		f.add(butGioca,"South");
       
        //area a sud
		
		butGioca.addActionListener(new AscoltatoreGioca());
        
		
		
		f.setVisible(true);
	}
	
	class AscoltatoreGioca implements ActionListener{
		public void actionPerformed(ActionEvent e)
    {
            boolean vinto=false;
            
            if(contatore==0) //il contatore mi serve solo a cambiare la prima volta il testo del bottone
            {
            int p=Integer.parseInt(txtProva.getText());
            numMio=p;
			String numeroInserito = ""+p;
            numComputer=(int)(Math.random()*100)+1;	//estraggo un nnumero casuale
            String numeroCasuale =""+numComputer;
			
			lblMioNumero.setText(numeroInserito);
			lblNumeroComputer.setText(numeroCasuale);
			txtProva.setEditable(false);				//rendo editabile la casella
			txtProva.setText("");
			tent=1;
			lblTentativi.setText("Tentativo  "+tent);
			txtProva.setBackground(Color.white);
                
            if(numMio == numComputer)
            {
                       txtProva.setBackground(Color.green);
						lblTentativi.setText("HAI VINTOOO!!!");
						butGioca.setEnabled(false);
						vinto=true;
            }
                
            contatore++;
                butGioca.setText("Estrai un numero");
            }
            else
            {
            
            numComputer=(int)(Math.random()*100)+1;   
              String numeroCasuale =""+numComputer;
              lblNumeroComputer.setText(numeroCasuale);    
                
                 if(numMio == numComputer)
            {
                       txtProva.setBackground(Color.green);
						lblTentativi.setText("HAI VINTOOO!!!");
						butGioca.setEnabled(false);
						vinto=true;
            }
                
            if (!vinto){
					tent++;				//incremento i tentativi fatti
					lblTentativi.setText("Tentativo  "+tent);	
				}        
                
             if (tent==maxTent){		//tentativi finiti
				lblTentativi.setText("HAI PERSO!!!");
				txtProva.setBackground(Color.red);
                 butGioca.setEnabled(false);
			 }     
                
                
              
                
            
                
                
                
            
                
                
                
            }
			
		}
	}
	
	
	
    
	
	public static void main(String arg[]){
		new IndovinaEstrazione();
	}
	
	
}