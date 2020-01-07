package Animacja;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class Interface extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel uklad;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface ramka = new Interface();
					ramka.pack();
					ramka.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interface() { //autor Piotr Krupa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 400);//gdzie otwiera okno na ekranie
		this.setTitle("Efekt Dopplera");
		uklad = new JPanel(); //panel jako podk³ada bod ca³y interfejs
		uklad.setBorder(new EmptyBorder(5, 5, 5, 5));
		uklad.setBackground(new Color(211, 211, 211));
		setContentPane(uklad);
		GridBagLayout gbl_uklad = new GridBagLayout();
		gbl_uklad.columnWidths = new int[]{300, 100, 50, 40};
		gbl_uklad.rowHeights = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 340};
		gbl_uklad.columnWeights = new double[]{1};//rozci¹ganie przy powiêksz
		gbl_uklad.rowWeights = new double[]{1};
		uklad.setLayout(gbl_uklad);
		
		animationPanel ObszarSym1 = new animationPanel(); //du¿y obszar sym
		ObszarSym1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		GridBagConstraints gbc_ObszarSym1  = new GridBagConstraints();
		gbc_ObszarSym1 .gridheight = 8; //iloœc okienek w pionie
		gbc_ObszarSym1 .insets = new Insets(0, 0, 5, 5);//top, left, bot, right
		gbc_ObszarSym1 .fill = GridBagConstraints.BOTH; //rozci¹ganie
		gbc_ObszarSym1 .gridx = 0;//pozycja ierwszego okienka
		gbc_ObszarSym1 .gridy = 0;
		uklad.add(ObszarSym1, gbc_ObszarSym1);
		
		JPanel ObszarSym2 = new JPanel();//ma³y obszar symulacji
		ObszarSym2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_ObszarSym2 = new GridBagConstraints();
		gbc_ObszarSym2.gridheight = 4;
		gbc_ObszarSym2.insets = new Insets(0, 0, 5, 5);
		gbc_ObszarSym2.fill = GridBagConstraints.BOTH;
		gbc_ObszarSym2.gridx = 0;
		gbc_ObszarSym2.gridy = 11;
		XYChartTest wykres =new XYChartTest(ObszarSym2);
		uklad.add(ObszarSym2, gbc_ObszarSym2);
		
		JPanel SymbolZro = new JPanel(); //obszar na wstawienie symbolu Ÿród³a
		SymbolZro.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		GridBagConstraints gbc_SymbolZro= new GridBagConstraints();
		gbc_SymbolZro.gridheight = 3;
		gbc_SymbolZro.insets = new Insets(0, 0, 5, 5);
		gbc_SymbolZro.fill = GridBagConstraints.BOTH;
		gbc_SymbolZro.gridx = 2;
		gbc_SymbolZro.gridy = 5;
		uklad.add(SymbolZro, gbc_SymbolZro);
		
		JPanel SymbolObs = new JPanel();//obszar na wstawienie symbolu obserwatora
		SymbolObs.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		GridBagConstraints gbc_SymbolObs = new GridBagConstraints();
		gbc_SymbolObs.gridheight = 3;
		gbc_SymbolObs.insets = new Insets(0, 0, 5, 5);
		gbc_SymbolObs.fill = GridBagConstraints.BOTH;
		gbc_SymbolObs.gridx = 2;
		gbc_SymbolObs.gridy = 8;
		uklad.add(SymbolObs, gbc_SymbolObs);
		
		JLabel VObs = new JLabel("V obserwatora");
		GridBagConstraints gbc_VObs = new GridBagConstraints();
		gbc_VObs.anchor = GridBagConstraints.EAST;//wyrównanie do prawej gdy tekst mniejszy od obszaru obszar jest mniejszy
		gbc_VObs.insets = new Insets(0, 0, 5, 5);
		gbc_VObs.gridx = 1;
		gbc_VObs.gridy = 1;
		uklad.add(VObs, gbc_VObs);
		
		JLabel VZro = new JLabel("V zrodla");
		GridBagConstraints gbc_VZro= new GridBagConstraints();
		gbc_VZro.anchor = GridBagConstraints.EAST;
		gbc_VZro.insets = new Insets(0, 0, 5, 5);
		gbc_VZro.gridx = 1;
		gbc_VZro.gridy = 2;
		uklad.add(VZro, gbc_VZro);
		
		JLabel VFali = new JLabel("V fali");
		GridBagConstraints gbc_VFali= new GridBagConstraints();
		gbc_VFali.anchor = GridBagConstraints.EAST;
		gbc_VFali.insets = new Insets(0, 0, 5, 5);
		gbc_VFali.gridx = 1;
		gbc_VFali.gridy = 3;
		uklad.add(VFali, gbc_VFali);
		
		JLabel FFali = new JLabel("f fali");
		GridBagConstraints gbc_FFali = new GridBagConstraints();
		gbc_FFali.anchor = GridBagConstraints.EAST;
		gbc_FFali.insets = new Insets(0, 0, 5, 5);
		gbc_FFali.gridx = 1;
		gbc_FFali.gridy = 4;
		uklad.add(FFali, gbc_FFali);
		
		JLabel MsVObs = new JLabel("m/s");//m/s przy v obserwatora
		GridBagConstraints gbc_MsVObs = new GridBagConstraints();
		gbc_MsVObs.anchor = GridBagConstraints.WEST;//wyrównanie do lewej
		gbc_MsVObs.insets = new Insets(0, 0, 5, 0);
		gbc_MsVObs.gridx = 3;
		gbc_MsVObs.gridy = 1;
		uklad.add(MsVObs, gbc_MsVObs);
		
		JLabel MsVZro = new JLabel("m/s");//m/s przy v zród³a
		GridBagConstraints gbc_MsVZro  = new GridBagConstraints();
		gbc_MsVZro .anchor = GridBagConstraints.WEST;
		gbc_MsVZro .insets = new Insets(0, 0, 5, 0);
		gbc_MsVZro .gridx = 3;
		gbc_MsVZro .gridy = 2;
		uklad.add(MsVZro , gbc_MsVZro );
		
		JLabel MsVFali = new JLabel("m/s");//m/s przy v fali
		GridBagConstraints gbc_MsVFali= new GridBagConstraints();
		gbc_MsVFali.anchor = GridBagConstraints.WEST;
		gbc_MsVFali.insets = new Insets(0, 0, 5, 0);
		gbc_MsVFali.gridx = 3;
		gbc_MsVFali.gridy = 3;
		uklad.add(MsVFali, gbc_MsVFali);
		
		JLabel HzFFAli = new JLabel("Hz"); //Hz przy f fali
		GridBagConstraints gbc_HzFFAli = new GridBagConstraints();
		gbc_HzFFAli.anchor = GridBagConstraints.WEST;
		gbc_HzFFAli.insets = new Insets(0, 0, 5, 0);
		gbc_HzFFAli.gridx = 3;
		gbc_HzFFAli.gridy = 4;
		uklad.add(HzFFAli, gbc_HzFFAli);
		
		JTextField VObserwatora = new JTextField(); //miejsce do wpisania v obserwatora
		GridBagConstraints gbc_VObserwatora = new GridBagConstraints();
		gbc_VObserwatora.insets = new Insets(0, 0, 5, 5);
		gbc_VObserwatora.fill = GridBagConstraints.HORIZONTAL;
		gbc_VObserwatora.gridx = 2;
		gbc_VObserwatora.gridy = 1;
		uklad.add(VObserwatora, gbc_VObserwatora);
		
		
		JTextField VZrodla = new JTextField(); //miejsce do wpisania v Ÿród³a
		GridBagConstraints gbc_VZrodla = new GridBagConstraints();
		gbc_VZrodla.insets = new Insets(0, 0, 5, 5);
		gbc_VZrodla.fill = GridBagConstraints.HORIZONTAL;
		gbc_VZrodla.gridx = 2;
		gbc_VZrodla.gridy = 2;
		uklad.add(VZrodla, gbc_VZrodla);
		
		
		JTextField tekstVFali = new JTextField(); //miejsce do wpisania v fali
		GridBagConstraints gbc_tekstVFali = new GridBagConstraints();
		gbc_tekstVFali.insets = new Insets(0, 0, 5, 5);
		gbc_tekstVFali.fill = GridBagConstraints.HORIZONTAL;
		gbc_tekstVFali.gridx = 2;
		gbc_tekstVFali.gridy = 3;
		uklad.add(tekstVFali, gbc_tekstVFali);
		
		
	
		JTextField tekstFFali = new JTextField();// miejsce do wpisania f fali
		GridBagConstraints gbc_tekstFFali = new GridBagConstraints();
		gbc_tekstFFali.insets = new Insets(0, 0, 5, 5);
		gbc_tekstFFali.fill = GridBagConstraints.HORIZONTAL;
		gbc_tekstFFali.gridx = 2;
		gbc_tekstFFali.gridy = 4;
		uklad.add(tekstFFali, gbc_tekstFFali);
		
		
		JLabel Zrodlo = new JLabel("Zrodlo"); 
		GridBagConstraints gbc_Zrodlo = new GridBagConstraints();
		gbc_Zrodlo.anchor = GridBagConstraints.EAST;
		gbc_Zrodlo.insets = new Insets(0, 0, 5, 5);
		gbc_Zrodlo.gridx = 1;
		gbc_Zrodlo.gridy = 6;
		uklad.add(Zrodlo, gbc_Zrodlo);
		
		JLabel Obserwator = new JLabel("Obserwator");
		GridBagConstraints gbc_Obserwator = new GridBagConstraints();
		gbc_Obserwator.anchor = GridBagConstraints.EAST;
		gbc_Obserwator.insets = new Insets(0, 0, 5, 5);
		gbc_Obserwator.gridx = 1;
		gbc_Obserwator.gridy = 9;
		uklad.add(Obserwator, gbc_Obserwator);
		
		JRadioButton UruchomDzwiek = new JRadioButton("Dzwiek"); //w³¹cznik dŸwiêku
		GridBagConstraints gbc_UruchomDzwiek  = new GridBagConstraints();
		gbc_UruchomDzwiek .gridwidth = 2;
		gbc_UruchomDzwiek .insets = new Insets(0, 0, 5, 5);
		gbc_UruchomDzwiek .gridx = 1;
		gbc_UruchomDzwiek .gridy = 11;
		uklad.add(UruchomDzwiek , gbc_UruchomDzwiek );
		
		JButton StartStop= new JButton("Start/Stop"); //przycisk do uruchamiania symulacji
		StartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_StartStop= new GridBagConstraints();
		gbc_StartStop.gridwidth = 2;
		gbc_StartStop.insets = new Insets(0, 0, 5, 5);
		gbc_StartStop.gridx = 1;
		gbc_StartStop.gridy = 12;
		uklad.add(StartStop, gbc_StartStop);
		
		
		
		JButton ZapiszDzwiek = new JButton("Zapisz dzwiek");
		ZapiszDzwiek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_ZapiszDzwiek = new GridBagConstraints();
		gbc_ZapiszDzwiek.insets = new Insets(0, 0, 5, 5);
		gbc_ZapiszDzwiek.gridwidth = 2;
		gbc_ZapiszDzwiek.gridx = 1;
		gbc_ZapiszDzwiek.gridy  = 13;
		uklad.add(ZapiszDzwiek, gbc_ZapiszDzwiek);
	}

}
