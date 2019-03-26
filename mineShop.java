//This window contains the shop, where the player sells the ores and purchases new pickaxes

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
    
    //The player can sell ore one at a time or in packs of 5 (why there is no Sell All button I have no clue)
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
    ImageIcon pickaxeN = new ImageIcon(getClass().getResource("GrayPickaxe.PNG")); //I.e. no new pickaxe available
    ImageIcon pickaxeM = new ImageIcon(getClass().getResource("MegaAubruniumPickaxe.PNG"));
    
    ImageIcon arrow = new ImageIcon(getClass().getResource("PickaxeArrow.PNG"));
    
    private int pickaxeCost;
    
    public mineShop()
    {
        super("Shop"); //Title of the window
        JPanel p = new JPanel();
        
        p.setLayout(null); //Allows for manual placement of each element
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
        
        if (mineMan.getMega() > 0) //Only visible if the player possesses at least one unit of mega aubrunium
        {
            display12.setText("Mega Aubrunium Ore");        
            amount12.setText("" + mineMan.getMega());
            amount12.setFont(new Font("Sans Serif", Font.PLAIN, 18));
            amount12.setBounds(250, 750, 100, 100);
            p.add(amount12);  
            
            mega1.setBounds(350, 770, 140, 60); //Mega aubrunium can only be sold one at a time
            p.add(mega1);
            
            if (mineMan.getPickaxe() == 3) //The player possesses the aubrunium pickaxe...
            {
                buyPickaxe.setEnabled(true); //...which allows for the player to upgrade to the 'secret' mega aubrunium pickaxe
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
                pickaxeCost = 7777777; //I.e. It is nigh impossible for the player to purchase it
                currentPickaxe.setIcon(pickaxeA);
                nextPickaxe.setIcon(pickaxeN);
                
                buyPickaxe.setText("Bought");
                break;
            }
            case 4:
            {
                currentPickaxe.setIcon(pickaxeM); //No more pickaxes after mega aubrunium
                nextPickaxe.setIcon(pickaxeN);
                break;
            }
        }
        
        currentPickaxe.setBounds(500, 795, 100, 100);
        p.add(currentPickaxe);
        
        nextPickaxe.setBounds(700, 795, 100, 100);
        p.add(nextPickaxe);
        
        if (mineMan.getPickaxe() < 3) //A better pickaxe is available and so has a cost
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
        
        shopHandlerClass handler2 = new shopHandlerClass();
        coal1.addActionListener(handler2);
        coal5.addActionListener(handler2);
        copper1.addActionListener(handler2);
        copper5.addActionListener(handler2);
        iron1.addActionListener(handler2);
        iron5.addActionListener(handler2);
        silver1.addActionListener(handler2);
        silver5.addActionListener(handler2);
        gold1.addActionListener(handler2);
        gold5.addActionListener(handler2);
        diamond1.addActionListener(handler2);
        diamond5.addActionListener(handler2);
        aub1.addActionListener(handler2);
        aub5.addActionListener(handler2);
        mega1.addActionListener(handler2);
        
        buyPickaxe.addActionListener(handler2);
        
        close.addActionListener(handler2);
    }
        
    private class shopHandlerClass implements ActionListener //A button is pressed
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == coal1) //Sells 1 coal, provided the player has at least one
            {
                if (mineMan.getCoal() > 0)
                {
                    mineMan.setCoal(mineMan.getCoal() - 1);
                    amount5.setText("" + mineMan.getCoal());
                    
                    mineMan.setCash(mineMan.getCash() + 7); //Each coal is worth 7 cash
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }           
            else if (e.getSource() == coal5) //Sells 5 coal, provided the player has enough
            {
                if (mineMan.getCoal() > 4)
                {
                    mineMan.setCoal(mineMan.getCoal() - 5);
                    amount5.setText("" + mineMan.getCoal());
                    
                    mineMan.setCash(mineMan.getCash() + 35);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (e.getSource() == copper1) //Sells 1 copper...
            {
                if (mineMan.getCopper() > 0)
                {
                    mineMan.setCopper(mineMan.getCopper() - 1);
                    amount6.setText("" + mineMan.getCopper());
                    
                    mineMan.setCash(mineMan.getCash() + 10); //Each copper is worth 10 cash
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (e.getSource() == copper5) //Sells 5 copper...
            {
                if (mineMan.getCopper() > 4)
                {
                    mineMan.setCopper(mineMan.getCopper() - 5);
                    amount6.setText("" + mineMan.getCopper());
                    
                    mineMan.setCash(mineMan.getCash() + 50);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (e.getSource() == iron1) //Etc.
            {
                if (mineMan.getIron() > 0)
                {
                    mineMan.setIron(mineMan.getIron() - 1);
                    amount7.setText("" + mineMan.getIron());
                    
                    mineMan.setCash(mineMan.getCash() + 15); //Iron is 15
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (e.getSource() == iron5) //Etc.
            {
                if (mineMan.getIron() > 4)
                {
                    mineMan.setIron(mineMan.getIron() - 5);
                    amount7.setText("" + mineMan.getIron());
                    
                    mineMan.setCash(mineMan.getCash() + 75);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (e.getSource() == silver1)
            {
                if (mineMan.getSilver() > 0)
                {
                    mineMan.setSilver(mineMan.getSilver() - 1);
                    amount8.setText("" + mineMan.getSilver());
                    
                    mineMan.setCash(mineMan.getCash() + 25); //Silver is 25
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (e.getSource() == silver5)
            {
                if (mineMan.getSilver() > 4)
                {
                    mineMan.setSilver(mineMan.getSilver() - 5);
                    amount8.setText("" + mineMan.getSilver());
                    
                    mineMan.setCash(mineMan.getCash() + 125);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (e.getSource() == gold1)
            {
                if (mineMan.getGold() > 0)
                {
                    mineMan.setGold(mineMan.getGold() - 1);
                    amount9.setText("" + mineMan.getGold());
                    
                    mineMan.setCash(mineMan.getCash() + 45); //Gold is 45
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (e.getSource() == gold5)
            {
                if (mineMan.getGold() > 4)
                {
                    mineMan.setGold(mineMan.getGold() - 5);
                    amount9.setText("" + mineMan.getGold());
                    
                    mineMan.setCash(mineMan.getCash() + 225);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (e.getSource() == diamond1)
            {
                if (mineMan.getDiamond() > 0)
                {
                    mineMan.setDiamond(mineMan.getDiamond() - 1);
                    amount10.setText("" + mineMan.getDiamond());
                    
                    mineMan.setCash(mineMan.getCash() + 80); //Diamond is 80
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (e.getSource() == diamond5)
            {
                if (mineMan.getDiamond() > 4)
                {
                    mineMan.setDiamond(mineMan.getDiamond() - 5);
                    amount10.setText("" + mineMan.getDiamond());
                    
                    mineMan.setCash(mineMan.getCash() + 400);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (e.getSource() == aub1)
            {
                if (mineMan.getAub() > 0)
                {
                    mineMan.setAub(mineMan.getAub() - 1);
                    amount11.setText("" + mineMan.getAub());
                    
                    mineMan.setCash(mineMan.getCash() + 140); //Aubrunium is 140
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            else if (e.getSource() == aub5)
            {
                if (mineMan.getAub() > 4)
                {
                    mineMan.setAub(mineMan.getAub() - 5);
                    amount11.setText("" + mineMan.getAub());
                    
                    mineMan.setCash(mineMan.getCash() + 700);
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (e.getSource() == mega1)
            {
                if (mineMan.getMega() > 0)
                {
                    mineMan.setMega(mineMan.getMega() - 1);
                    amount12.setText("" + mineMan.getMega());
                    
                    mineMan.setCash(mineMan.getCash() + 1000); //Mega Aubrunium is 1000, but the player most likely loses out on getting the secret pickaxe
                    displayCash.setText("Cash: " + mineMan.getCash());
                }
            }
            
            else if (e.getSource() == buyPickaxe) //This button purchases the next pickaxe, if available
            {
                if (mineMan.getCash() >= pickaxeCost && mineMan.getPickaxe() < 3) //The player has enough cash and does not have the best pickaxe
                {
                    mineMan.setPickaxe(mineMan.getPickaxe() + 1); //Then gets the next pickaxe...
                    
                    if (mineMan.getPickaxe() == 2) //...and the pickaxe upgrade window updates to reflect that
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
                else if (mineMan.getPickaxe() == 3) //If the player has the aubrunium pickaxe...
                {
                    if (mineMan.getMega() > 0) //...and has at least one mega aubrunium...
                    {
                        buyPickaxe.setEnabled(false);
                        mineMan.setPickaxe(4); //The player 'forges' the mega aubrunium pickaxe
                        mineMan.setMega(mineMan.getMega() - 1);
                        currentPickaxe.setIcon(pickaxeM);
                    }
                    else //I don't think this ever happens, but it is here as a failsafe
                    {
                        buyPickaxe.setEnabled(false);
                    }
                }
            }
            
                //After the transaction, updates the labels with the new amount of ore
                amount5.setText("" + mineMan.getCoal());
                amount6.setText("" + mineMan.getCopper());
                amount7.setText("" + mineMan.getIron());
                amount8.setText("" + mineMan.getSilver());
                amount9.setText("" + mineMan.getGold());
                amount10.setText("" + mineMan.getDiamond());
                amount11.setText("" + mineMan.getAub());
                amount12.setText("" + mineMan.getMega());
                                                
            if (e.getSource() == close) //Closes the shop and re-enables the buttons in the main window
            {
                mineMan.shopFlag = false;
                mineMan.inventory.setEnabled(true);
                dispose();             
            }
        }       
    }
}
