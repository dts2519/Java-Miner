package actualminer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class mineInventory extends JFrame
{   
    JLabel title = new JLabel("Inventory");
    JLabel display5 = new JLabel("Coal");
    JLabel display6 = new JLabel("Copper Ore");
    JLabel display7 = new JLabel("Iron Ore");
    JLabel display8 = new JLabel("Silver Ore");
    JLabel display9 = new JLabel("Gold Ore");
    JLabel display10 = new JLabel("Diamond");
    JLabel display11 = new JLabel("Aubrunium Ore");
    JLabel display12 = new JLabel("");
    
    JLabel amount5 = new JLabel("");
    JLabel amount6 = new JLabel("");
    JLabel amount7 = new JLabel("");
    JLabel amount8 = new JLabel("");
    JLabel amount9 = new JLabel("");
    JLabel amount10 = new JLabel("");
    JLabel amount11 = new JLabel("");
    JLabel amount12 = new JLabel("");
    
    JLabel displayCash = new JLabel("");
    JLabel displayPickaxe = new JLabel();
    JLabel pickaxeLabel = new JLabel("Pickaxe");
    
    JButton close = new JButton("Close");
    JButton update = new JButton("Update");
    
    //Icons for the pickaxes the player can get
    ImageIcon pickaxe = new ImageIcon(getClass().getResource("Pickaxe.PNG")); 
    ImageIcon pickaxeD = new ImageIcon(getClass().getResource("DiamondPickaxe.PNG"));
    ImageIcon pickaxeA = new ImageIcon(getClass().getResource("AubruniumPickaxe.PNG"));
    //Shhhh
    ImageIcon pickaxeM = new ImageIcon(getClass().getResource("MegaAubruniumPickaxe.PNG"));
    
    public mineInventory()
    {
        super("Inventory"); //Title of the window
        JPanel p = new JPanel();
        
        p.setLayout(null);
        getContentPane().add(p); //Adds the panel to the window (all things are installed on the panel)
        
        title.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        title.setBounds(200, 25, 300, 25);
        p.add(title);
        
        display5.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        display5.setBounds(50, 50, 200, 100);
        p.add(display5);
        
        display6.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        display6.setBounds(50, 150, 200, 100);
        p.add(display6);
        
        display7.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        display7.setBounds(50, 250, 200, 100);
        p.add(display7);
        
        display8.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        display8.setBounds(50, 350, 200, 100);
        p.add(display8);
        
        display9.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        display9.setBounds(50, 450, 200, 100);
        p.add(display9);
        
        display10.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        display10.setBounds(50, 550, 200, 100);
        p.add(display10);
        
        display11.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        display11.setBounds(50, 650, 200, 100);
        p.add(display11);
        
        display12.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        display12.setBounds(50, 750, 200, 100);
        p.add(display12);
        
        amount5.setText("" + mineMan.getCoal());
        amount5.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        amount5.setBounds(250, 50, 100, 100);
        p.add(amount5);
        
        amount6.setText("" + mineMan.getCopper());
        amount6.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        amount6.setBounds(250, 150, 100, 100);
        p.add(amount6);
        
        amount7.setText("" + mineMan.getIron());
        amount7.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        amount7.setBounds(250, 250, 100, 100);
        p.add(amount7);
        
        amount8.setText("" + mineMan.getSilver());
        amount8.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        amount8.setBounds(250, 350, 100, 100);
        p.add(amount8);
        
        amount9.setText("" + mineMan.getGold());
        amount9.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        amount9.setBounds(250, 450, 100, 100);
        p.add(amount9);
        
        amount10.setText("" + mineMan.getDiamond());
        amount10.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        amount10.setBounds(250, 550, 100, 100);
        p.add(amount10);
        
        amount11.setText("" + mineMan.getAub());
        amount11.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        amount11.setBounds(250, 650, 100, 100);
        p.add(amount11);
        
        amount12.setText("");
        amount12.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        amount12.setBounds(250, 750, 100, 100);
        p.add(amount12);
        
        displayCash.setText("Cash: " + mineMan.getCash());
        displayCash.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        displayCash.setBounds(15, 15, 100, 100);
        p.add(displayCash);
        
        pickaxeLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        pickaxeLabel.setBounds(320, 630, 100, 100);
        p.add(pickaxeLabel);
        
        displayPickaxe.setBounds(300, 700, 100, 100);
        p.add(displayPickaxe);
        
        //This determines which pickaxe to display
        switch(mineMan.getPickaxe())
        {
            case 1:
            {
                displayPickaxe.setIcon(pickaxe);
                break;
            }
            case 2:
            {
                displayPickaxe.setIcon(pickaxeD);
                break;
            }
            case 3:
            {
                displayPickaxe.setIcon(pickaxeA);
                break;
            }
            //Shhhh
            case 4:
            {
                displayPickaxe.setIcon(pickaxeM);
                break;
            }
        }
        
        update.setBounds(80, 825, 100, 50);
        p.add(update);
        
        close.setBounds(220, 825, 100, 50);
        p.add(close);
        
        invHandlerClass handoraa2 = new invHandlerClass();
        update.addActionListener(handoraa2);
        close.addActionListener(handoraa2);
    }
    
    private class invHandlerClass implements ActionListener
    {
        public void actionPerformed(ActionEvent ebento)
        {
            if (ebento.getSource() == update)
            {
                amount5.setText("" + mineMan.getCoal());
                amount6.setText("" + mineMan.getCopper());
                amount7.setText("" + mineMan.getIron());
                amount8.setText("" + mineMan.getSilver());
                amount9.setText("" + mineMan.getGold());
                amount10.setText("" + mineMan.getDiamond());
                amount11.setText("" + mineMan.getAub());
                
                if (mineMan.getMega() > 0)
                {
                    display12.setText("Mega Aubrunium Ore");
                    amount12.setText("" + mineMan.getMega());
                }
                
                displayCash.setText("Cash: " + mineMan.getCash());
                
                switch(mineMan.getPickaxe())
                {
                    case 1:
                    {
                        displayPickaxe.setIcon(pickaxe);
                        break;
                    }
                    case 2:
                    {
                       displayPickaxe.setIcon(pickaxeD);
                       break;
                    }
                    case 3:
                    {
                        displayPickaxe.setIcon(pickaxeA);
                        break;
                    }
                    //Shhhh
                    case 4:
                    {
                        displayPickaxe.setIcon(pickaxeM);
                        break;
                    }
                }
            }
            if (ebento.getSource() == close)
            {
                mineMan.inventory.setEnabled(true);
                dispose();            
            }
        }       
    }
}
