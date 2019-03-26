package actualminer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mineShop extends JFrame
{
    JLabel title = new JLabel("Shop");
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
    
    JLabel currentPickaxe = new JLabel();
    JLabel nextArrow = new JLabel();
    JLabel nextPickaxe = new JLabel();
    JLabel nextPickaxeCost = new JLabel("");
    
    JButton coal1 = new JButton("Sell 1");
    JButton coal5 = new JButton("Sell 5");
    
    JButton copper1 = new JButton("Sell 1");
    JButton copper5 = new JButton("Sell 5");
    
    JButton iron1 = new JButton("Sell 1");
    JButton iron5 = new JButton("Sell 5");
    
    JButton silver1 = new JButton("Sell 1");
    JButton silver5 = new JButton("Sell 5");
    
    JButton gold1 = new JButton("Sell 1");
    JButton gold5 = new JButton("Sell 5");
    
    JButton diamond1 = new JButton("Sell 1");
    JButton diamond5 = new JButton("Sell 5");
    
    JButton aub1 = new JButton("Sell 1");
    JButton aub5 = new JButton("Sell 5");
    
    JButton mega1 = new JButton("Sell 1");
    
    JButton buyPickaxe = new JButton("Buy");
    
    JButton close = new JButton("Close");
    
    //Icons for the pickaxes the player can get
    ImageIcon pickaxe = new ImageIcon(getClass().getResource("Pickaxe.PNG")); 
    ImageIcon pickaxeD = new ImageIcon(getClass().getResource("DiamondPickaxe.PNG"));
    ImageIcon pickaxeA = new ImageIcon(getClass().getResource("AubruniumPickaxe.PNG"));
    ImageIcon pickaxeN = new ImageIcon(getClass().getResource("GrayPickaxe.PNG"));
    //Shhhh
    ImageIcon pickaxeM = new ImageIcon(getClass().getResource("MegaAubruniumPickaxe.PNG"));
    ImageIcon arrow = new ImageIcon(getClass().getResource("PickaxeArrow.PNG"));
    
    private int pickaxeCost;
    
    public mineShop()
    {
        super("Shop"); //Title of the window
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
        
        if (mineMan.getMega() > 0)
        {
            display12.setText("Mega Aubrunium Ore");        
            amount12.setText("" + mineMan.getMega());
            amount12.setFont(new Font("Sans Serif", Font.PLAIN, 18));
            amount12.setBounds(250, 750, 100, 100);
            p.add(amount12);  
            
            mega1.setBounds(350, 770, 140, 60);
            p.add(mega1);
            
            if (mineMan.getPickaxe() == 3)
            {
                buyPickaxe.setEnabled(true);
            }
        }
        
        displayCash.setText("Cash: " + mineMan.getCash());
        displayCash.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        displayCash.setBounds(15, 15, 100, 50);
        p.add(displayCash);
        
        coal1.setBounds(350, 70, 140, 60);
        p.add(coal1);
        
        coal5.setBounds(520, 70, 140, 60);
        p.add(coal5);
        
        copper1.setBounds(350, 170, 140, 60);
        p.add(copper1);
        
        copper5.setBounds(520, 170, 140, 60);
        p.add(copper5);
        
        iron1.setBounds(350, 270, 140, 60);
        p.add(iron1);
        
        iron5.setBounds(520, 270, 140, 60);
        p.add(iron5);
        
        silver1.setBounds(350, 370, 140, 60);
        p.add(silver1);
        
        silver5.setBounds(520, 370, 140, 60);
        p.add(silver5);
        
        gold1.setBounds(350, 470, 140, 60);
        p.add(gold1);
        
        gold5.setBounds(520, 470, 140, 60);
        p.add(gold5);
        
        diamond1.setBounds(350, 570, 140, 60);
        p.add(diamond1);
        
        diamond5.setBounds(520, 570, 140, 60);
        p.add(diamond5);
        
        aub1.setBounds(350, 670, 140, 60);
        p.add(aub1);
        
        aub5.setBounds(520, 670, 140, 60);
        p.add(aub5);
        
        nextArrow.setIcon(arrow);
        nextArrow.setBounds(600, 795, 100, 100);
        p.add(nextArrow);
        
        switch(mineMan.getPickaxe()) //This determines the appearance of the current and next pickaxe labels
        {
            case 1:
            {
                pickaxeCost = 2000;
                currentPickaxe.setIcon(pickaxe);
                nextPickaxe.setIcon(pickaxeD);
                
                buyPickaxe.setText("Buy");
                break;
            }
            case 2:
            {
                pickaxeCost = 7000;
                currentPickaxe.setIcon(pickaxeD);
                nextPickaxe.setIcon(pickaxeA);
                
                buyPickaxe.setText("Buy");
                break;
            }
            case 3:
            {
                pickaxeCost = 7777777;
                currentPickaxe.setIcon(pickaxeA);
                nextPickaxe.setIcon(pickaxeN);
                
                buyPickaxe.setText("Bought");
                break;
            }
            case 4:
            {
                currentPickaxe.setIcon(pickaxeM);
                nextPickaxe.setIcon(pickaxeN);
                break;
            }
        }
        
        currentPickaxe.setBounds(500, 795, 100, 100);
        p.add(currentPickaxe);
        
        nextPickaxe.setBounds(700, 795, 100, 100);
        p.add(nextPickaxe);
        
        if (mineMan.getPickaxe() < 3)
        {
            nextPickaxeCost.setText("Cost: " + pickaxeCost);
        }
        nextPickaxeCost.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        nextPickaxeCost.setBounds(705, 645, 100, 100);
        p.add(nextPickaxeCost);
        
        
        buyPickaxe.setBounds(700, 720, 100, 50);
        p.add(buyPickaxe);
        
        close.setBounds(50, 825, 100, 50);
        p.add(close);
        
        shopHandlerClass handoraa2 = new shopHandlerClass();
        coal1.addActionListener(handoraa2);
        coal5.addActionListener(handoraa2);
        copper1.addActionListener(handoraa2);
        copper5.addActionListener(handoraa2);
        iron1.addActionListener(handoraa2);
        iron5.addActionListener(handoraa2);
        silver1.addActionListener(handoraa2);
        silver5.addActionListener(handoraa2);
        gold1.addActionListener(handoraa2);
        gold5.addActionListener(handoraa2);
        diamond1.addActionListener(handoraa2);
        diamond5.addActionListener(handoraa2);
        aub1.addActionListener(handoraa2);
        aub5.addActionListener(handoraa2);
        mega1.addActionListener(handoraa2);
        
        buyPickaxe.addActionListener(handoraa2);
        
        close.addActionListener(handoraa2);
    }
        
    private class shopHandlerClass implements ActionListener
    {
        public void actionPerformed(ActionEvent ebento)
        {
            if (ebento.getSource() == coal1)
            {
                if (mineMan.getCoal() > 0)
                {
                    mineMan.setCoal(mineMan.getCoal() - 1);
                    amount5.setText("" + mineMan.getCoal());
                    
                    mineMan.setCash(mineMan.getCash() + 7);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }           
            else if (ebento.getSource() == coal5)
            {
                if (mineMan.getCoal() > 4)
                {
                    mineMan.setCoal(mineMan.getCoal() - 5);
                    amount5.setText("" + mineMan.getCoal());
                    
                    mineMan.setCash(mineMan.getCash() + 35);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (ebento.getSource() == copper1)
            {
                if (mineMan.getCopper() > 0)
                {
                    mineMan.setCopper(mineMan.getCopper() - 1);
                    amount6.setText("" + mineMan.getCopper());
                    
                    mineMan.setCash(mineMan.getCash() + 10);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (ebento.getSource() == copper5)
            {
                if (mineMan.getCopper() > 4)
                {
                    mineMan.setCopper(mineMan.getCopper() - 5);
                    amount6.setText("" + mineMan.getCopper());
                    
                    mineMan.setCash(mineMan.getCash() + 50);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (ebento.getSource() == iron1)
            {
                if (mineMan.getIron() > 0)
                {
                    mineMan.setIron(mineMan.getIron() - 1);
                    amount7.setText("" + mineMan.getIron());
                    
                    mineMan.setCash(mineMan.getCash() + 15);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (ebento.getSource() == iron5)
            {
                if (mineMan.getIron() > 4)
                {
                    mineMan.setIron(mineMan.getIron() - 5);
                    amount7.setText("" + mineMan.getIron());
                    
                    mineMan.setCash(mineMan.getCash() + 75);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (ebento.getSource() == silver1)
            {
                if (mineMan.getSilver() > 0)
                {
                    mineMan.setSilver(mineMan.getSilver() - 1);
                    amount8.setText("" + mineMan.getSilver());
                    
                    mineMan.setCash(mineMan.getCash() + 25);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (ebento.getSource() == silver5)
            {
                if (mineMan.getSilver() > 4)
                {
                    mineMan.setSilver(mineMan.getSilver() - 5);
                    amount8.setText("" + mineMan.getSilver());
                    
                    mineMan.setCash(mineMan.getCash() + 125);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (ebento.getSource() == gold1)
            {
                if (mineMan.getGold() > 0)
                {
                    mineMan.setGold(mineMan.getGold() - 1);
                    amount9.setText("" + mineMan.getGold());
                    
                    mineMan.setCash(mineMan.getCash() + 45);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (ebento.getSource() == gold5)
            {
                if (mineMan.getGold() > 4)
                {
                    mineMan.setGold(mineMan.getGold() - 5);
                    amount9.setText("" + mineMan.getGold());
                    
                    mineMan.setCash(mineMan.getCash() + 225);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (ebento.getSource() == diamond1)
            {
                if (mineMan.getDiamond() > 0)
                {
                    mineMan.setDiamond(mineMan.getDiamond() - 1);
                    amount10.setText("" + mineMan.getDiamond());
                    
                    mineMan.setCash(mineMan.getCash() + 80);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (ebento.getSource() == diamond5)
            {
                if (mineMan.getDiamond() > 4)
                {
                    mineMan.setDiamond(mineMan.getDiamond() - 5);
                    amount10.setText("" + mineMan.getDiamond());
                    
                    mineMan.setCash(mineMan.getCash() + 400);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (ebento.getSource() == aub1)
            {
                if (mineMan.getAub() > 0)
                {
                    mineMan.setAub(mineMan.getAub() - 1);
                    amount11.setText("" + mineMan.getAub());
                    
                    mineMan.setCash(mineMan.getCash() + 140);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (ebento.getSource() == aub5)
            {
                if (mineMan.getAub() > 4)
                {
                    mineMan.setAub(mineMan.getAub() - 5);
                    amount11.setText("" + mineMan.getAub());
                    
                    mineMan.setCash(mineMan.getCash() + 700);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (ebento.getSource() == mega1)
            {
                if (mineMan.getMega() > 0)
                {
                    mineMan.setMega(mineMan.getMega() - 1);
                    amount12.setText("" + mineMan.getMega());
                    
                    mineMan.setCash(mineMan.getCash() + 1000);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (ebento.getSource() == buyPickaxe)
            {
                if (mineMan.getCash() >= pickaxeCost && mineMan.getPickaxe() < 3)
                {
                    mineMan.setPickaxe(mineMan.getPickaxe() + 1);
                    
                    if (mineMan.getPickaxe() == 2)
                    {
                        mineMan.setCash(mineMan.getCash() - pickaxeCost);
                        pickaxeCost = 7000;
                        nextPickaxeCost.setText("Cost: " + pickaxeCost);
                        currentPickaxe.setIcon(pickaxeD);
                        nextPickaxe.setIcon(pickaxeA);
                    }
                    else if (mineMan.getPickaxe() == 3)
                    {
                        buyPickaxe.setEnabled(false);
                        buyPickaxe.setText("Bought");
                        mineMan.setCash(mineMan.getCash() - pickaxeCost);
                        pickaxeCost = 7777777;
                        nextPickaxeCost.setText("");
                        currentPickaxe.setIcon(pickaxeA);
                        nextPickaxe.setIcon(pickaxeN);
                    }
                }
                else if (mineMan.getPickaxe() == 3) //Shhhh
                {
                    if (mineMan.getMega() > 0)
                    {
                        buyPickaxe.setEnabled(false);
                        mineMan.setPickaxe(4);
                        mineMan.setMega(mineMan.getMega() - 1);
                        currentPickaxe.setIcon(pickaxeM);
                    }
                    else
                    {
                        buyPickaxe.setEnabled(false);
                    }
                }
            }
            
                amount5.setText("" + mineMan.getCoal());
                amount6.setText("" + mineMan.getCopper());
                amount7.setText("" + mineMan.getIron());
                amount8.setText("" + mineMan.getSilver());
                amount9.setText("" + mineMan.getGold());
                amount10.setText("" + mineMan.getDiamond());
                amount11.setText("" + mineMan.getAub());
                amount12.setText("" + mineMan.getMega());
                                                
            if (ebento.getSource() == close)
            {
                mineMan.shopFlag = false;
                mineMan.inventory.setEnabled(true);
                dispose();             
            }
        }       
    }
}
