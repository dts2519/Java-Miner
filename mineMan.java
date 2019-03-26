package actualminer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*; //Used: Random

/* ID for each block:
-1 - Mined
0 - Clear sky
1 - Sky with clouds
2 - Grass
3 - Dirt
4 - Stone
5 - Coal Ore
6 - Copper Ore
7 - Iron Ore
8 - Silver Ore
9 - Gold Ore
10 - Diamond Ore
11 - Aubrunium Ore
12 - Mega Aubrunium Ore
13 - Bedrock
*/

public class mineMan extends JFrame
{
    JLabel version = new JLabel("Java Miner - Beta 1.5.1");
    
    JLabel message = new JLabel("");
    
    public static JButton inventory = new JButton("Inventory");
    
    int[][] map = new int[100][100]; //Stores info for the entire map
    Boolean[][] minedFlag = new Boolean[100][100];
    Boolean[][] revealedFlag = new Boolean[100][100];
    
    JLabel[][] labelMap = new JLabel[9][9]; //Represents what is on the screen at a given time
    int screenX = 0, screenY = 0; //Translates the stored map information for the JLabel
    
    int playerX = 4, playerY = 4; //This is the location of the player - begins at (4, 4) 
    
    Random seeder = new Random(); //Will be used to decide what each block is at startup
    
    int weather = seeder.nextInt(4); //Selects a weather condition - 0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
     
    //The ImageIcon blocks generate all the necessary graphical files for the game
    
    //This block deals with the sky
    ImageIcon sky = new ImageIcon(getClass().getResource("Sky.PNG"));
    ImageIcon cloud = new ImageIcon(getClass().getResource("Cloud.PNG"));
    ImageIcon skyC = new ImageIcon(getClass().getResource("SkyCloudy.PNG"));
    ImageIcon cloudC = new ImageIcon(getClass().getResource("CloudCloudy.PNG"));
    ImageIcon skyR = new ImageIcon(getClass().getResource("SkyRainy.PNG"));
    ImageIcon cloudR = new ImageIcon(getClass().getResource("CloudRainy.PNG"));
    ImageIcon skyS = new ImageIcon(getClass().getResource("SkySnowy.PNG"));
    ImageIcon cloudS = new ImageIcon(getClass().getResource("CloudSnowy.PNG"));
    
    //This block deals with the ground
    ImageIcon grass = new ImageIcon(getClass().getResource("Grass.PNG"));
    ImageIcon grassC = new ImageIcon(getClass().getResource("GrassCloudy.PNG"));
    ImageIcon grassR = new ImageIcon(getClass().getResource("GrassRainy.PNG"));
    ImageIcon grassS = new ImageIcon(getClass().getResource("GrassSnowy.PNG"));
    ImageIcon dirt = new ImageIcon(getClass().getResource("Dirt.PNG"));
    
    //This block deals with the first layer of stone (layers 10 through 59)
    ImageIcon stone1 = new ImageIcon(getClass().getResource("Stone1.PNG"));
    ImageIcon coal1 = new ImageIcon(getClass().getResource("Coal1.PNG"));
    ImageIcon copper1 = new ImageIcon(getClass().getResource("Copper1.PNG"));
    ImageIcon iron1 = new ImageIcon(getClass().getResource("Iron1.PNG"));
    ImageIcon silver1 = new ImageIcon(getClass().getResource("Silver1.PNG"));
    
    //This block deals with the second layer of stone (layers 60 through 89)
    ImageIcon stone2 = new ImageIcon(getClass().getResource("Stone2.PNG"));
    ImageIcon coal2 = new ImageIcon(getClass().getResource("Coal2.PNG"));
    ImageIcon copper2 = new ImageIcon(getClass().getResource("Copper2.PNG"));
    ImageIcon iron2 = new ImageIcon(getClass().getResource("Iron2.PNG"));
    ImageIcon silver2 = new ImageIcon(getClass().getResource("Silver2.PNG"));
    ImageIcon gold2 = new ImageIcon(getClass().getResource("Gold2.PNG"));
    ImageIcon diamond2 = new ImageIcon(getClass().getResource("Diamond2.PNG"));
    
    //This block deals with the third layer of stone (layers 90 through 99)
    ImageIcon stone3 = new ImageIcon(getClass().getResource("Stone3.PNG"));
    ImageIcon coal3 = new ImageIcon(getClass().getResource("Coal3.PNG"));
    ImageIcon copper3 = new ImageIcon(getClass().getResource("Copper3.PNG"));
    ImageIcon iron3 = new ImageIcon(getClass().getResource("Iron3.PNG"));
    ImageIcon silver3 = new ImageIcon(getClass().getResource("Silver3.PNG"));
    ImageIcon gold3 = new ImageIcon(getClass().getResource("Gold3.PNG"));
    ImageIcon diamond3 = new ImageIcon(getClass().getResource("Diamond3.PNG"));
    ImageIcon aubrunium = new ImageIcon(getClass().getResource("Aubrunium.PNG"));
    ImageIcon mega = new ImageIcon(getClass().getResource("Mega Aubrunium.PNG"));
    
    //Miscellaneous
    ImageIcon mined = new ImageIcon(getClass().getResource("Mined.PNG"));
    ImageIcon unknown = new ImageIcon(getClass().getResource("Unknown.PNG"));
    ImageIcon bedrock = new ImageIcon(getClass().getResource("Bedrock.PNG")); 
    
    //This block deals with the miner using the default pickaxe (1/3)
    ImageIcon skyGuy = new ImageIcon(getClass().getResource("SkyGuy.PNG"));
    ImageIcon cloudGuy = new ImageIcon(getClass().getResource("CloudGuy.PNG"));
    ImageIcon skyGuyC = new ImageIcon(getClass().getResource("SkyGuyCloudy.PNG"));
    ImageIcon cloudGuyC = new ImageIcon(getClass().getResource("CloudGuyCloudy.PNG"));
    ImageIcon skyGuyR = new ImageIcon(getClass().getResource("SkyGuyRainy.PNG"));
    ImageIcon cloudGuyR = new ImageIcon(getClass().getResource("CloudGuyRainy.PNG"));
    ImageIcon skyGuyS = new ImageIcon(getClass().getResource("SkyGuySnowy.PNG"));
    ImageIcon cloudGuyS = new ImageIcon(getClass().getResource("CloudGuySnowy.PNG"));
    ImageIcon minedGuy = new ImageIcon(getClass().getResource("MinedGuy.PNG"));
    
    //This block deals with the miner using the diamond pickaxe (2/3)
    ImageIcon skyGuyD = new ImageIcon(getClass().getResource("SkyGuyDiamond.PNG"));
    ImageIcon cloudGuyD = new ImageIcon(getClass().getResource("CloudGuyDiamond.PNG"));
    ImageIcon skyGuyCD = new ImageIcon(getClass().getResource("SkyGuyCloudyDiamond.PNG"));
    ImageIcon cloudGuyCD = new ImageIcon(getClass().getResource("CloudGuyCloudyDiamond.PNG"));
    ImageIcon skyGuyRD = new ImageIcon(getClass().getResource("SkyGuyRainyDiamond.PNG"));
    ImageIcon cloudGuyRD = new ImageIcon(getClass().getResource("CloudGuyRainyDiamond.PNG"));
    ImageIcon skyGuySD = new ImageIcon(getClass().getResource("SkyGuySnowyDiamond.PNG"));
    ImageIcon cloudGuySD = new ImageIcon(getClass().getResource("CloudGuySnowyDiamond.PNG"));
    ImageIcon minedGuyD = new ImageIcon(getClass().getResource("MinedGuyDiamond.PNG"));
    
    //This block deals with the miner using the aubrunium pickaxe (3/3)
    ImageIcon skyGuyA = new ImageIcon(getClass().getResource("SkyGuyAub.PNG"));
    ImageIcon cloudGuyA = new ImageIcon(getClass().getResource("CloudGuyAub.PNG"));
    ImageIcon skyGuyCA = new ImageIcon(getClass().getResource("SkyGuyCloudyAub.PNG"));
    ImageIcon cloudGuyCA = new ImageIcon(getClass().getResource("CloudGuyCloudyAub.PNG"));
    ImageIcon skyGuyRA = new ImageIcon(getClass().getResource("SkyGuyRainyAub.PNG"));
    ImageIcon cloudGuyRA = new ImageIcon(getClass().getResource("CloudGuyRainyAub.PNG"));
    ImageIcon skyGuySA = new ImageIcon(getClass().getResource("SkyGuySnowyAub.PNG"));
    ImageIcon cloudGuySA = new ImageIcon(getClass().getResource("CloudGuySnowyAub.PNG"));
    ImageIcon minedGuyA = new ImageIcon(getClass().getResource("MinedGuyAub.PNG"));
    
    //Shhhh
    ImageIcon skyGuyM = new ImageIcon(getClass().getResource("SkyGuyMega.PNG"));
    ImageIcon cloudGuyM = new ImageIcon(getClass().getResource("CloudGuyMega.PNG"));
    ImageIcon skyGuyCM = new ImageIcon(getClass().getResource("SkyGuyCloudyMega.PNG"));
    ImageIcon cloudGuyCM = new ImageIcon(getClass().getResource("CloudGuyCloudyMega.PNG"));
    ImageIcon skyGuyRM = new ImageIcon(getClass().getResource("SkyGuyRainyMega.PNG"));
    ImageIcon cloudGuyRM = new ImageIcon(getClass().getResource("CloudGuyRainyMega.PNG"));
    ImageIcon skyGuySM = new ImageIcon(getClass().getResource("SkyGuySnowyMega.PNG"));
    ImageIcon cloudGuySM = new ImageIcon(getClass().getResource("CloudGuySnowyMega.PNG"));
    ImageIcon minedGuyM = new ImageIcon(getClass().getResource("MinedGuyMega.PNG"));
    
    //This block deals with the shop and related blocks
    ImageIcon shop = new ImageIcon(getClass().getResource("Shop.PNG"));
    ImageIcon shopC = new ImageIcon(getClass().getResource("ShopCloudy.PNG"));
    ImageIcon shopR = new ImageIcon(getClass().getResource("ShopRainy.PNG"));
    ImageIcon shopS = new ImageIcon(getClass().getResource("ShopSnowy.PNG"));
    ImageIcon uparrow = new ImageIcon(getClass().getResource("GrassArrow.PNG"));
    ImageIcon uparrowC = new ImageIcon(getClass().getResource("GrassCloudyArrow.PNG"));
    ImageIcon uparrowR = new ImageIcon(getClass().getResource("GrassRainyArrow.PNG"));
    ImageIcon uparrowS = new ImageIcon(getClass().getResource("GrassSnowyArrow.PNG"));
    
    //This block combines the shop and the miner
    ImageIcon shopGuy = new ImageIcon(getClass().getResource("ShopGuy.PNG"));
    ImageIcon shopGuyC = new ImageIcon(getClass().getResource("ShopGuyCloudy.PNG"));
    ImageIcon shopGuyR = new ImageIcon(getClass().getResource("ShopGuyRainy.PNG"));
    ImageIcon shopGuyS = new ImageIcon(getClass().getResource("ShopGuySnowy.PNG"));
    ImageIcon shopGuyD = new ImageIcon(getClass().getResource("ShopGuyDiamond.PNG"));
    ImageIcon shopGuyCD = new ImageIcon(getClass().getResource("ShopGuyCloudyDiamond.PNG"));
    ImageIcon shopGuyRD = new ImageIcon(getClass().getResource("ShopGuyRainyDiamond.PNG"));
    ImageIcon shopGuySD = new ImageIcon(getClass().getResource("ShopGuySnowyDiamond.PNG"));
    ImageIcon shopGuyA = new ImageIcon(getClass().getResource("ShopGuyAub.PNG"));
    ImageIcon shopGuyCA = new ImageIcon(getClass().getResource("ShopGuyCloudyAub.PNG"));
    ImageIcon shopGuyRA = new ImageIcon(getClass().getResource("ShopGuyRainyAub.PNG"));
    ImageIcon shopGuySA = new ImageIcon(getClass().getResource("ShopGuySnowyAub.PNG"));
    //Shhhh
    ImageIcon shopGuyM = new ImageIcon(getClass().getResource("ShopGuyMega.PNG"));
    ImageIcon shopGuyCM = new ImageIcon(getClass().getResource("ShopGuyCloudyMega.PNG"));
    ImageIcon shopGuyRM = new ImageIcon(getClass().getResource("ShopGuyRainyMega.PNG"));
    ImageIcon shopGuySM = new ImageIcon(getClass().getResource("ShopGuySnowyMega.PNG"));
    
    private static int coalGot = 0, copperGot = 0, ironGot = 0, silverGot = 0, goldGot = 0, diamondGot = 0, aubGot = 0, megaGot = 0;
    
    private static int cash = 0;
    
    private static int pickaxe = 1;
    
    Boolean isMega = false;
    Boolean movedFlag = false;
    public static Boolean shopFlag = false;
    
    public mineMan()
    {   
        super("Java Miner"); //Title of the window
        JPanel p = new JPanel();
        
        p.setLayout(null);
        getContentPane().add(p); //Adds the panel to the window (all things are installed on the panel)
        
        version.setBounds(10, 10, 200, 40);
        p.add(version);
        
        message.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        message.setBounds(350, 25, 300, 25);
        p.add(message);
        
        inventory.setBounds(60, 875, 100, 50);
        inventory.setFocusable(false); //Otherwise Key Listener will not work
        p.add(inventory);
        
        for (int column = 0; column < 100; column++) //Start at top, go down - so row 0 is the top of the sky
        {
            if (column < 5)
            {
                for (int row = 0; row < 100; row++) //Then each block is done one by one
                {
                    pickSky(column, row); //Sky layers (0-4)
                    minedFlag[column][row] = false;
                    revealedFlag[column][row] = true;
                } 
            }
            else if (column == 5) //Grass
            {
                for (int row = 0; row < 100; row++)
                {
                    map[column][row] = 2;
                    minedFlag[column][row] = false;
                    revealedFlag[column][row] = true;
                }
            }
            else if (column < 9) //The dirt layers
            {
                for (int row = 0; row < 100; row++)
                {
                    map[column][row] = 3;
                    minedFlag[column][row] = false;
                    revealedFlag[column][row] = true;
                }
            }
            else if (column < 40) //Layers 10 through 39 contain stone with lesser ores only
            {
                for (int row = 0; row < 100; row++)
                {
                    pickStone1(column, row);
                    minedFlag[column][row] = false;
                    revealedFlag[column][row] = false;
                }
            }
            else if (column < 60) //Layers 40 through 59 contain stone plus the lesser ores and silver
            {
                for (int row = 0; row < 100; row++)
                {
                    pickStone2(column, row);
                    minedFlag[column][row] = false;
                    revealedFlag[column][row] = false;
                }
            }
            else if (column < 75) //Layers 60 through 74 add gold - this layer is not accessible from the start of the game 
            {
                for (int row = 0; row < 100; row++)
                {
                    pickStone3(column, row);
                    minedFlag[column][row] = false;
                    revealedFlag[column][row] = false;
                }
            }
            else if (column < 90) //Layers 75 through 89 add diamond
            {
                for (int row = 0; row < 100; row++)
                {
                    pickStone4(column, row);
                    minedFlag[column][row] = false;
                    revealedFlag[column][row] = false;
                }
            }
            else //column >= 90 - The bottom 10 layers could hold the incredibly valuable Aubrunium, and possibly another secret?! The most powerful pickaxe is required to get here
            {
                for (int row = 0; row < 100; row++)
                {
                    pickStone5(column, row);
                    minedFlag[column][row] = false;
                    revealedFlag[column][row] = false;
                }
            }
            map[4][50] = 14; //The shop
            map[5][50] = 15; //The up arrow under the shop      
        }
        
        for (int b = 0; b < 9; b++) //The top left will be the starting position of the player (0-8, 0-8) as shown on screen
        {
            screenY = b;
            for (int a = 0; a < 9; a++)
            {
                screenX = a;
                labelMap[a][b] = new JLabel();
                labelMap[a][b].setBounds((a * 100) + 50, (b * 100) + 50, 100, 100);
                p.add(labelMap[a][b]);
                assign(screenX, screenY, screenX, screenY);
            }
        }
        
        getGuy(4,4);
        
        HandlerClass handoraa = new HandlerClass(); //Allows for key presses to move
        addKeyListener(handoraa);
        
        ButtonHandlerClass handoraa2 = new ButtonHandlerClass();
        inventory.addActionListener(handoraa2);
        
    }
    
    private class HandlerClass implements KeyListener //Both WSAD and arrow keys are allowed
    {
        public void keyTyped(KeyEvent ebento) 
        {
            //Nothing
        }

        public void keyPressed(KeyEvent ebento) 
        {
            //Nothing
        }

        public void keyReleased(KeyEvent ebento) 
        {
            if (ebento.getKeyCode() == KeyEvent.VK_LEFT || (ebento.getKeyCode() == KeyEvent.VK_A)) //Move left
            {
                moveLeft(playerX, playerY);
            }
            else if (ebento.getKeyCode() == KeyEvent.VK_RIGHT || (ebento.getKeyCode() == KeyEvent.VK_D)) //Move right
            {
                moveRight(playerX, playerY);
            }
            else if (ebento.getKeyCode() == KeyEvent.VK_UP || (ebento.getKeyCode() == KeyEvent.VK_W)) //Move up
            {
                moveUp(playerX, playerY);
            }
            else if (ebento.getKeyCode() == KeyEvent.VK_DOWN || (ebento.getKeyCode() == KeyEvent.VK_S)) //Move down
            {
                moveDown(playerX, playerY);
            }
        }     
    }
    
    private class ButtonHandlerClass implements ActionListener
    {
        public void actionPerformed(ActionEvent ebento) 
        {
            if (ebento.getSource() == inventory)
            {
                inventory.setEnabled(false);
                
                mineInventory lolwa = new mineInventory();
                lolwa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                lolwa.setSize(450, 950);
                lolwa.setVisible(true);
                
                lolwa.addWindowListener(new java.awt.event.WindowAdapter() //This allows the user to click either Close or the X to close the window
                {
                    public void windowClosing(java.awt.event.WindowEvent ebento)
                    {
                        shopFlag = false;
                        inventory.setEnabled(true);
                    }                       
                });
            }
        }
    }
    
    public void pickSky(int column, int row) //Decides if that block will have clouds or not
    {
        map[column][row] = seeder.nextInt(3); //0 = Plain sky, 1 = Sky with clouds - This will generate roughly 1/3 clouds
        
        if (map[column][row] == 2)
        {
            map[column][row] = 0; //So, rolling 0 or 2 equals plain sky
        }
        
    }
    
    public void pickStone1(int column, int row) //Layers 10 through 39
    {
        int decision = seeder.nextInt(100);
        
        if (decision < 60)
        {
            map[column][row] = 4; //Stone
        }
        else if (decision < 80)
        {
            map[column][row] = 5; //Coal
        }
        else if (decision < 92)
        {
            map[column][row] = 6; //Copper
        }
        else //decision >= 92
        {
            map[column][row] = 7; //Iron
        }
    }
    
    public void pickStone2(int column, int row) //Layers 40 through 59
    {
        int decision = seeder.nextInt(200);
        
        if (decision < 115) //Stone is a tad less common
        {
            map[column][row] = 4; 
        }
        else if (decision < 155)
        {
            map[column][row] = 5; //Coal is as common
        }
        else if (decision < 167)
        {
            map[column][row] = 6; //Copper is a bit less common
        }
        else if (decision < 187)
        {
            map[column][row] = 7; //Iron is slightly more common
        }
        else //decision >= 187
        {
            map[column][row] = 8; //Silver
        }
    }
    
    public void pickStone3(int column, int row) //Layers 60 through 74
    {
        int decision = seeder.nextInt(400);
        
        if (decision < 225) //Stone is again slightly less common
        {
            map[column][row] = 4; 
        }
        else if (decision < 290)
        {
            map[column][row] = 5; //Coal is somewhat less common
        }
        else if (decision < 314)
        {
            map[column][row] = 6; //Copper is as common
        }
        else if (decision < 354)
        {
            map[column][row] = 7; //Iron is as common
        }
        else if (decision < 380)
        {
            map[column][row] = 8; //Silver is as common
        }
        else //decision >= 380
        {
            map[column][row] = 9; //Gold
        }
    }
    
    public void pickStone4(int column, int row) //Layers 75 through 89
    {
        int decision = seeder.nextInt(800);
        
        if (decision < 440) //Stone is again slightly less common 440
        {
            map[column][row] = 4; 
        }
        else if (decision < 560)
        {
            map[column][row] = 5; //Coal is somewhat less common 120
        }
        else if (decision < 604)
        {
            map[column][row] = 6; //Copper is a bit less common 44
        }
        else if (decision < 680)
        {
            map[column][row] = 7; //Iron is a bit less common 76
        }
        else if (decision < 732)
        {
            map[column][row] = 8; //Silver is as common 52
        }
        else if (decision < 776)
        {
            map[column][row] = 9; //Gold is a bit more common 44
        }
        else //decision >= 776
        {
            map[column][row] = 10; //Diamond
        }
    }
    public void pickStone5(int column, int row) //Layers 90 through 99
    {
        int decision = seeder.nextInt(3200);
        
        if (decision < 1720) //Stone is again slightly less common 1720
        {
            map[column][row] = 4; 
        }
        else if (decision < 2120)
        {
            map[column][row] = 5; //Coal is less common 400
        }
        else if (decision < 2280)
        {
            map[column][row] = 6; //Copper is a bit less common 160
        }
        else if (decision < 2560)
        {
            map[column][row] = 7; //Iron is a bit less common 280
        }
        else if (decision < 2760)
        {
            map[column][row] = 8; //Silver is a bit less common 200
        }
        else if (decision < 2960)
        {
            map[column][row] = 9; //Gold is a bit more common 100
        }
        else if (decision < 3120)
        {
            map[column][row] = 10; //Diamond is more common 160
        }
        else if (decision < 3199)
        {
            map[column][row] = 11; //Aubrunium, the rarest of all? 79
        }
        else //decision = 3199
        {
            map[column][row] = 12; //No, there is one more - Mega Aubrunium! 1
            isMega = true;
        }
    }
    
    public void assign(int x, int y, int jx, int jy) //Takes the stored tile value in the map array and puts it onto the new tiles entering the player's vision corresponding to which label is being passed in
    {
        if (y > 99) //Layers under the actual map
        {
            labelMap[jx][jy].setIcon(bedrock);
        }
        else
        {
            if (revealedFlag[y][x] == false) //I.e. the player has not gone close enough to know what it is
            {
                labelMap[jx][jy].setIcon(unknown);
            }
            else
            {
                switch (map[y][x]) //The tile has been revealed
                {
                    case 0:
                    {
                        switch(weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                        {
                            case 0:
                            {
                               labelMap[jx][jy].setIcon(sky); 
                               break;
                            }
                            case 1:
                            {
                               labelMap[jx][jy].setIcon(skyC);
                               break;
                            }
                            case 2:
                            {
                               labelMap[jx][jy].setIcon(skyR);
                               break;
                            }
                            case 3:
                            {
                               labelMap[jx][jy].setIcon(skyS);
                               break;
                            }
                        } 
                        break;
                    }
                    case 1:
                    {
                        switch(weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                        {
                            case 0:
                            {
                               labelMap[jx][jy].setIcon(cloud); 
                               break;
                            }
                            case 1:
                            {
                               labelMap[jx][jy].setIcon(cloudC);
                               break;
                            }
                            case 2:
                            {
                               labelMap[jx][jy].setIcon(cloudR);
                               break;
                            }
                            case 3:
                            {
                               labelMap[jx][jy].setIcon(cloudS);
                               break;
                            }
                        } 
                        break;
                    }
                    case 2:
                    {
                        switch(weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                        {
                            case 0:
                            {
                               labelMap[jx][jy].setIcon(grass); 
                               break;                                                            
                            }
                            case 1:
                            {
                               labelMap[jx][jy].setIcon(grassC);
                               break;
                            }
                            case 2:
                            {
                               labelMap[jx][jy].setIcon(grassR);
                               break;
                            }
                            case 3:
                            {
                               labelMap[jx][jy].setIcon(grassS);
                               break;
                            }
                        } 
                        break;
                    }
                    case 3:
                    {
                        labelMap[jx][jy].setIcon(dirt);
                        break;
                    }
                    case 4:
                    {
                        if (y < 60)
                        {
                            labelMap[jx][jy].setIcon(stone1); //A lighter and more permeable stone, breakable with any pickaxe
                        }
                        else if (y >= 60 && y < 90)
                        {
                            labelMap[jx][jy].setIcon(stone2); //A slightly darker and harder stone, breakable only with an advanced pickaxe
                        }
                        else //y >= 90 and < 100
                        {
                            labelMap[jx][jy].setIcon(stone3); //Bedrock-like stone bursting with lava seams, breakable only with the best pickaxes
                        }
                        break;
                    }
                    case 5:
                    {
                        if (y < 60)
                        {
                            labelMap[jx][jy].setIcon(coal1); //With the stone1 background
                        }
                        else if (y >= 60 && y < 90)
                        {
                            labelMap[jx][jy].setIcon(coal2); //With the stone2 background
                        }
                        else //y >= 90 and < 100
                        {
                            labelMap[jx][jy].setIcon(coal3); //With the stone3 background
                        }
                        break;
                    }
                    case 6:
                    {
                        if (y < 60)
                        {
                            labelMap[jx][jy].setIcon(copper1); //With the stone1 background
                        }
                        else if (y >= 60 && y < 90)
                        {
                            labelMap[jx][jy].setIcon(copper2); //With the stone2 background
                        }
                        else //y >= 90 and < 100
                        {
                            labelMap[jx][jy].setIcon(copper3); //With the stone3 background
                        }
                        break;
                    }
                    case 7:
                    {
                        if (y < 60)
                        {
                            labelMap[jx][jy].setIcon(iron1); //With the stone1 background
                        }
                        else if (y >= 60 && y < 90)
                        {
                            labelMap[jx][jy].setIcon(iron2); //With the stone2 background
                        }
                        else //y >= 90 and < 100
                        {
                            labelMap[jx][jy].setIcon(iron3); //With the stone3 background
                        }
                        break;
                    }
                    case 8:
                    {
                        if (y < 60) //Of course bear in mind that it doesn't go to the surface
                        {
                            labelMap[jx][jy].setIcon(silver1); //With the stone1 background
                        }
                        else if (y >= 60 && y < 90)
                        {
                            labelMap[jx][jy].setIcon(silver2); //With the stone2 background
                        }
                        else //y >= 90 and < 100
                        {
                            labelMap[jx][jy].setIcon(silver3); //With the stone3 background
                        }
                        break;
                    }
                    case 9:
                    {
                        if (y < 90)
                        {
                            labelMap[jx][jy].setIcon(gold2); //With the stone2 background
                        }
                        else //y >= 90 and < 100
                        {
                            labelMap[jx][jy].setIcon(gold3); //With the stone3 background
                        }
                        break;
                    }
                    case 10:
                    {
                        if (y < 90)
                        {
                            labelMap[jx][jy].setIcon(diamond2); //With the stone2 background
                        }
                        else //y >= 90 and < 100
                        {
                            labelMap[jx][jy].setIcon(diamond3); //With the stone3 background
                        }
                        break;
                    }
                    case 11:
                    {
                        labelMap[jx][jy].setIcon(aubrunium); //Only appears with the stone3 background
                        break;
                    }
                    case 12:
                    {
                        labelMap[jx][jy].setIcon(mega); //Only appears with the stone3 background
                        break;
                    }           
                    case 13:
                    {
                        labelMap[jx][jy].setIcon(bedrock); //Unbreakable
                        break;
                    }
                    case 14: //The shop
                    {
                        switch(weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                        {
                            case 0:
                            {
                               labelMap[jx][jy].setIcon(shop); 
                               break;                                                            
                            }
                            case 1:
                            {
                               labelMap[jx][jy].setIcon(shopC);
                               break;
                            }
                            case 2:
                            {
                               labelMap[jx][jy].setIcon(shopR);
                               break;
                            }
                            case 3:
                            {
                               labelMap[jx][jy].setIcon(shopS);
                               break;
                            }
                        } 
                        break;
                    }
                    case 15: //The tile right below the shop (with the up arrow)
                    {
                        switch(weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                        {
                            case 0:
                            {
                               labelMap[jx][jy].setIcon(uparrow); 
                               break;                                                            
                            }
                            case 1:
                            {
                               labelMap[jx][jy].setIcon(uparrowC);
                               break;
                            }
                            case 2:
                            {
                               labelMap[jx][jy].setIcon(uparrowR);
                               break;
                            }
                            case 3:
                            {
                               labelMap[jx][jy].setIcon(uparrowS);
                               break;
                            }
                        } 
                        break;
                    }
                    default: //A 'mined' tile (the player has been over it and it is not a sky tile) contains the map value -1
                    {
                        labelMap[jx][jy].setIcon(mined);
                        break;
                    }
                }
            }
        }
    }
    
    //That's right folks, we've got three layers of switch statements.
    public void getGuy(int y, int x)
    {
        switch(map[y][x])
        {
            case 0:
            {
                switch (weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                {
                    case 0:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(skyGuy); 
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(skyGuyD); 
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(skyGuyA); 
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(skyGuyM); 
                                break;
                            }
                        }
                        break;
                    }
                    case 1:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(skyGuyC);
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(skyGuyCD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(skyGuyCA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(skyGuyCM);
                                break;
                            }
                        }
                        break;
                    }
                    case 2:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(skyGuyR);
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(skyGuyRD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(skyGuyRA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(skyGuyRM);
                                break;
                            }
                        }
                        break;
                    }
                    case 3:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(skyGuyS);
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(skyGuySD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(skyGuySA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(skyGuySM);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            } 
            case 1:
            {
                switch (weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                {
                    case 0:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(cloudGuy); 
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(cloudGuyD); 
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(cloudGuyA); 
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(cloudGuyM); 
                                break;
                            }
                        }                       
                        break;
                    }
                    case 1:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(cloudGuyC);
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(cloudGuyCD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(cloudGuyCA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(cloudGuyCM);
                                break;
                            }
                        }
                        break;
                    }
                    case 2:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(cloudGuyR);
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(cloudGuyRD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(cloudGuyRA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(cloudGuyRM);
                                break;
                            }                                  
                        }
                        break;
                    }
                    case 3:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(cloudGuyS);
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(cloudGuySD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(cloudGuySA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(cloudGuySM);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case 14: //The shop
            {
                switch (weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                {
                    case 0:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(shopGuy);
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(shopGuyD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(shopGuyA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(shopGuyM);
                                break;
                            }
                        }
                        break;
                    }
                    case 1:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(shopGuyC);
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(shopGuyCD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(shopGuyCA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(shopGuyCM);
                                break;
                            }
                        }
                        break;
                    }
                    case 2:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(shopGuyR); 
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(shopGuyRD); 
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(shopGuyRA); 
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(shopGuyRM); 
                                break;
                            }
                            
                        }
                        break;
                    }
                    case 3:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[4][4].setIcon(shopGuyS); 
                                break;
                            }
                            case 2:
                            {
                                labelMap[4][4].setIcon(shopGuySD); 
                                break;
                            }
                            case 3:
                            {
                                labelMap[4][4].setIcon(shopGuySA); 
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[4][4].setIcon(shopGuySM); 
                                break;
                            }
                            
                        }
                        break;
                    }
                }
                break;
            }       
            default: //Any other value
            {
                switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                {
                    case 1:
                    {
                        labelMap[4][4].setIcon(minedGuy);
                        break;
                    }
                    case 2:
                    {
                        labelMap[4][4].setIcon(minedGuyD);
                        break;
                    }
                    case 3:
                    {
                        labelMap[4][4].setIcon(minedGuyA);
                        break;
                    }
                    //Shhhh
                    case 4:
                    {
                        labelMap[4][4].setIcon(minedGuyM);
                        break;
                    }                                      
                }
                break;
            }
        }
    }
    
    //That's right folks, we've got three layers of switch statements.
    public void getGuyEdgeLeft(int y, int x)
    {   
        switch (map[y][x])
        {
            case 0:
            {
                switch (weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                {
                    case 0:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x][4].setIcon(skyGuy); 
                               break;
                           }
                           case 2:
                           {
                               labelMap[x][4].setIcon(skyGuyD); 
                               break;
                           }
                           case 3:
                           {
                               labelMap[x][4].setIcon(skyGuyA); 
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x][4].setIcon(skyGuyM); 
                               break;
                           }
                       }
                       break;
                    }
                    case 1:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x][4].setIcon(skyGuyC);
                               break;
                           }
                           case 2:
                           {
                               labelMap[x][4].setIcon(skyGuyCD);
                               break;
                           }
                           case 3:
                           {
                               labelMap[x][4].setIcon(skyGuyCA);
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x][4].setIcon(skyGuyCM);
                               break;
                           }
                       }
                       break;
                    }
                    case 2:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x][4].setIcon(skyGuyR);
                               break;
                           }
                           case 2:
                           {
                               labelMap[x][4].setIcon(skyGuyRD);
                               break;
                           }
                           case 3:
                           {
                               labelMap[x][4].setIcon(skyGuyRA);
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x][4].setIcon(skyGuyRM);
                               break;
                           }
                       }
                       break;
                    }
                    case 3:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[x][4].setIcon(skyGuyS);
                                break;
                            }
                            case 2:
                            {
                                labelMap[x][4].setIcon(skyGuySD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[x][4].setIcon(skyGuySA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[x][4].setIcon(skyGuySM);
                                break;
                            }
                        }
                       break;
                    }
                } 
                break;
            }            
            case 1:
            {
                switch (weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                {
                    case 0:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x][4].setIcon(cloudGuy);
                               break;
                           }
                           case 2:
                           {
                               labelMap[x][4].setIcon(cloudGuyD);
                               break;
                           }
                           case 3:
                           {
                               labelMap[x][4].setIcon(cloudGuyA);
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x][4].setIcon(cloudGuyM);
                               break;
                           }
                       }
                       break;
                    }
                    case 1:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[x][4].setIcon(cloudGuyC);
                                break;
                            }
                            case 2:
                            {
                                labelMap[x][4].setIcon(cloudGuyCD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[x][4].setIcon(cloudGuyCA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[x][4].setIcon(cloudGuyCM);
                                break;
                            }
                        }
                       break;
                    }
                    case 2:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[x][4].setIcon(cloudGuyR);
                                break;
                            }
                            case 2:
                            {
                                labelMap[x][4].setIcon(cloudGuyRD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[x][4].setIcon(cloudGuyRA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[x][4].setIcon(cloudGuyRM);
                                break;
                            }
                        }
                       break;
                    }
                    case 3:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[x][4].setIcon(cloudGuyS);
                                break;
                            }
                            case 2:
                            {
                                labelMap[x][4].setIcon(cloudGuySD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[x][4].setIcon(cloudGuySA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[x][4].setIcon(cloudGuySM);
                                break;
                            }
                        }
                       break;
                    }
                }
                break;
            }
            default: //Everything else
            {   
                switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                {
                    case 1:
                    {
                        labelMap[x][4].setIcon(minedGuy);
                        break;
                    }
                    case 2:
                    {
                        labelMap[x][4].setIcon(minedGuyD);
                        break;
                    }
                    case 3:
                    {
                        labelMap[x][4].setIcon(minedGuyA);
                        break;
                    }
                    //Shhhh
                    case 4:
                    {
                        labelMap[x][4].setIcon(minedGuyM);
                        break;
                    }
                }
                break;
            }
        }
    }
    
    
    //That's right folks, we've got three layers of switch statements.
    public void getGuyEdgeRight(int y, int x)
    {   
        switch (map[y][x])
        {
            case 0:
            {
                switch (weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                {
                    case 0:
                    {
                        switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                        {
                            case 1:
                            {
                                labelMap[x - 91][4].setIcon(skyGuy);
                                break;
                            }
                            case 2:
                            {
                                labelMap[x - 91][4].setIcon(skyGuyD);
                                break;
                            }
                            case 3:
                            {
                                labelMap[x - 91][4].setIcon(skyGuyA);
                                break;
                            }
                            //Shhhh
                            case 4:
                            {
                                labelMap[x - 91][4].setIcon(skyGuyM);
                                break;
                            }
                        }
                        break;
                    }
                    case 1:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x - 91][4].setIcon(skyGuyC);
                               break;
                           }
                           case 2:
                           {
                               labelMap[x - 91][4].setIcon(skyGuyCD);
                               break;
                           } 
                           case 3:
                           {
                               labelMap[x - 91][4].setIcon(skyGuyCA);
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x - 91][4].setIcon(skyGuyCM);
                               break;
                           }
                       }
                       break;                       
                    }
                    case 2:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x - 91][4].setIcon(skyGuyR);
                               break; 
                           }
                           case 2:
                           {
                               labelMap[x - 91][4].setIcon(skyGuyRD);
                               break; 
                           }
                           case 3:
                           {
                               labelMap[x - 91][4].setIcon(skyGuyRA);
                               break; 
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x - 91][4].setIcon(skyGuyRM);
                               break; 
                           }
                       }
                       break; 
                    }
                    case 3:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1: 
                           {
                               labelMap[x - 91][4].setIcon(skyGuyS);
                               break;
                           }
                           case 2: 
                           {
                               labelMap[x - 91][4].setIcon(skyGuySD);
                               break;
                           }
                           case 3: 
                           {
                               labelMap[x - 91][4].setIcon(skyGuySA);
                               break;
                           }
                           //Shhhh
                           case 4: 
                           {
                               labelMap[x - 91][4].setIcon(skyGuySM);
                               break;
                           }
                       }
                       break; 
                    }
                }  
                
                break;
            }            
            case 1:
            {
                switch (weather) //0 = Clear, 1 = Cloudy, 2 = Rainy, 3 = Snowy
                {
                    case 0:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuy);
                               break;
                           }
                           case 2:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyD);
                               break;
                           }
                           case 3:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyA);
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyM);
                               break;
                           }
                       }
                       break;
                    }
                    case 1:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyC);
                               break;
                           } 
                           case 2:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyCD);
                               break;
                           }
                           case 3:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyCA);
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyCM);
                               break;
                           }
                       }
                       break; 
                    }
                    case 2:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyR);
                               break;
                           }
                           case 2:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyRD);
                               break;
                           }
                           case 3:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyRA);
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyRM);
                               break;
                           }
                       }
                       break; 
                    }
                    case 3:
                    {
                       switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                       {
                           case 1:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuyS);
                               break;
                           }
                           case 2:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuySD);
                               break;
                           }
                           case 3:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuySA);
                               break;
                           }
                           //Shhhh
                           case 4:
                           {
                               labelMap[x - 91][4].setIcon(cloudGuySM);
                               break;
                           }
                       }
                       break; 
                    }
                }
                break;
            }
            default: //Everything else
            {     
                switch (pickaxe) //1 = Default, 2 = Diamond (D), 3 = Aubrunium (A), (*whispers*) 4 = Mega Aubrunium (M)
                {
                    case 1:
                    {
                       labelMap[x - 91][4].setIcon(minedGuy);
                       break; 
                    }
                    case 2:
                    {
                       labelMap[x - 91][4].setIcon(minedGuyD);
                       break; 
                    }
                    case 3:
                    {
                       labelMap[x - 91][4].setIcon(minedGuyA);
                       break; 
                    }
                    //Shhhh
                    case 4:
                    {
                       labelMap[x - 91][4].setIcon(minedGuyM);
                       break; 
                    }
                }
                break;
            }
        }
    }
    
    public void moveLeft(int x, int y)
    {
        if (x == 51 && y == 5) //The block directly to the right of the shop's up arrow
        {
            //Nothing
        }
        else if (shopFlag == false)
        {
            if (playerX != 0) //That is, the player is not on the left edge
            {           
                playerX--;
                x--; 
            }
        
            checkRevealed(y, x);
        
            if (x < 4)
            {
                updateLabels(4, y);
                getGuyEdgeLeft(y, x);
                assign(x+1, y, x+1, 4);
            }
            else if (x > 95)
            {
                updateLabels(95, y);
                getGuyEdgeRight(y, x);
                assign(x+1, y, x-90, 4);
            }
            else
            {   
                updateLabels(x, y);       
                getGuy(y, x);
                assign(x+1, y, 5, 4);
            }
        
            if (y > 4 && y < 100 && minedFlag[y][x] == false) //The player moves to a block that has not been touched yet, and so the block is mined and checked if it has anything
            {
                minedFlag[y][x] = true;
                checkOre(y, x);
                map[y][x] = -1;
            }
            
            if (movedFlag == false)
            {
                movedFlag = true;
                if (isMega == true)
                {
                    JOptionPane.showMessageDialog(null, String.format("This region seems to be affected by a powerful magic..."));
                }
            }
        }
    }
    
    public void moveRight(int x, int y)
    {
        if (x == 49 && y == 5) //The block directly to the left of the shop's up arrow
        {
            //Nothing
        }
        else if (shopFlag == false)
        {
            if (playerX != 99) //That is, the player is not on the right edge
            {
                playerX++;
                x++; 
            }
        
            checkRevealed(y, x);
        
            if (x < 4)
            {
                updateLabels(4, y);
                getGuyEdgeLeft(y, x);
                assign(x-1, y, x-1, 4);
            }
            else if (x > 95)
            {
                updateLabels(95, y);
                getGuyEdgeRight(y, x);
                assign(x-1, y, x-92, 4);
            }
            else
            {
                updateLabels(x, y);
                getGuy(y, x);
                assign(x-1, y, 3, 4);
            }
        
            if (y > 4 && y < 100 && minedFlag[y][x] == false) //The player moves to a block that has not been touched yet, and so the block is mined and checked if it has anything
            {
                minedFlag[y][x] = true;
                checkOre(y, x);
                map[y][x] = -1;
            }
            
            if (movedFlag == false)
            {
                movedFlag = true;
                if (isMega == true)
                {
                    JOptionPane.showMessageDialog(null, String.format("This region seems to be affected by a powerful magic..."));
                }
            }
        }
    }
    
    public void moveUp(int x, int y)
    {
        if (x == 50 && y == 6) //The block directly below the shop's up arrow
        {
            //Nothing
        }
        else if (shopFlag == false)
        {
            if (y == 4)
            {
                if (x == 50)
                {
                    shopFlag = true;
                    mineMan.inventory.setEnabled(false);
                    
                    mineShop lelda = new mineShop();
                    lelda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    lelda.setSize(875, 950);
                    lelda.setVisible(true);
                    
                    lelda.addWindowListener(new java.awt.event.WindowAdapter() //This allows the user to click either Close or the X to close the window
                    {
                        public void windowClosing(java.awt.event.WindowEvent ebento)
                        {
                            shopFlag = false;
                            inventory.setEnabled(true);
                        }                       
                    });
                }
                else
                {
                    //Nothing
                }
            }
            else
            {
                playerY--;
                y--;
            
                checkRevealed(y, x);
            
                if (x < 4)
                {
                    updateLabels(4, y);
                    getGuyEdgeLeft(y, x);
                    assign(x, y+1, x, 5);
                }
                else if (x > 95)
                {
                    updateLabels(95, y);
                    getGuyEdgeRight(y, x);
                    assign(x, y+1, x-91, 5);
                }
                else
                {
                    updateLabels(x, y);
                    getGuy(y, x);
                    assign(x, y+1, 4, 5);
                }
            }
        
            if (y > 4 && y < 100 && minedFlag[y][x] == false) //The player moves to a block that has not been touched yet, and so the block is mined and checked if it has anything
            {
                minedFlag[y][x] = true;
                checkOre(y, x);
                map[y][x] = -1;
            }
        }
    }
    
    public void moveDown(int x, int y)
    {
        if (x == 50 && y == 4) //The shop, which is directly above the up arrow
        {
            //Nothing
        }
        //This clause does three things: 1. Prevents the player from moving in the shop; 2. Checks depth; 3. Checks pickaxe
        else if (shopFlag == false && (y < 59 || (y < 89 && pickaxe > 1) || pickaxe > 2))
        {
            if (y == 99)
            {
                //Nothing
            }
            else
            {   
                playerY++;
                y++;
            
                checkRevealed(y, x);
            
                if (x < 4)
                {
                    updateLabels(4, y);
                    getGuyEdgeLeft(y, x);
                    assign(x, y-1, x, 3);
                }
                else if (x > 95)
                {
                    updateLabels(95, y);
                    getGuyEdgeRight(y, x);
                    assign(x, y-1, x-91, 3);
                }
                else
                {
                    updateLabels(x, y);
                    getGuy(y, x);
                    assign(x, y-1, 4, 3);
                }
            }
            if (y > 4 && y < 100 && minedFlag[y][x] == false) //The player moves to a block that has not been touched yet, and so the block is mined and checked if it has anything
            {
                minedFlag[y][x] = true;
                checkOre(y, x);
                map[y][x] = -1;
            }
            
            if (movedFlag == false) //On the first move, if a Mega Aubrunium has been generated, the player receives this cryptic message
            {
                movedFlag = true;
                if (isMega == true)
                {
                    JOptionPane.showMessageDialog(null, String.format("This region seems to be affected by a powerful magic..."));
                }
            }
        }    
    }
    
    public void updateLabels(int x, int y) //Called whenever the player moves
    {
        int labY = 0;
            
        for (int b = y - 4; b < y + 5; b++)
        {          
            int labX = 0;
            screenY = b;
            for (int a = x - 4; a < x + 5; a++)
            {
                screenX = a;
                assign(screenX, screenY, labX, labY);
                labX++;
            }
            labY++;
        }
    }
    
    public void checkOre(int y, int x) //Called whenever the player moves - if the value of the tile the player moves to is 5-12, they get that ore and a message is displayed
    {
        switch (map[y][x])
        {
            case 5:
            {
                coalGot++;
                message.setText("You got some coal (" + coalGot + ")");
                break;
            }
            case 6:
            {
                copperGot++;
                message.setText("You got some copper ore (" + copperGot + ")");
                break;
            }
            case 7:
            {
                ironGot++;
                message.setText("You got some iron ore (" + ironGot + ")");
                break;
            }
            case 8:
            {
                silverGot++;
                message.setText("You got some silver ore (" + silverGot + ")");
                break;
            }
            case 9:
            {
                goldGot++;
                message.setText("You got some gold ore! (" + goldGot + ")");
                break;
            }
            case 10:
            {
                diamondGot++;
                message.setText("You got some diamond! (" + diamondGot + ")");
                break;
            }
            case 11:
            {
                aubGot++;
                message.setText("You got some aubrunium ore! (" + aubGot + ")");
                break;
            }
            case 12:
            {
                megaGot++;
                message.setText("You got some mega aubrunium!! (" + megaGot + ")");
                break;
            }           
            default:
            {
                //Nothing
                break;
            }
        }
    }
    
    public void checkRevealed(int y, int x)
    {
        for (int c = y - 1; c < y + 2; c++)
        {
            if (c >= 0 && c < 100)
            {
                for (int d = x - 1; d < x + 2; d++)
                {
                    if (d >= 0 && d < 100)
                    {
                        if (revealedFlag[c][d] == false)
                        {
                            revealedFlag[c][d] = true;
                        }
                    }
                }
            }
        }
    }
    
    public static int getCoal()
    {
        return coalGot;
    }
    
    public static int getCopper()
    {
        return copperGot;
    }
    
    public static int getIron()
    {
        return ironGot;
    }
    
    public static int getSilver()
    {
        return silverGot;
    }
    
    public static int getGold()
    {
        return goldGot;
    }
    
    public static int getDiamond()
    {
        return diamondGot;
    }
    
    public static int getAub()
    {
        return aubGot;
    }
    
    public static int getMega()
    {
        return megaGot;
    }
    
    public static int getCash()
    {
        return cash;
    }
    
    public static int getPickaxe()
    {
        return pickaxe;
    }
    
    public static void setCoal(int c)
    {
        coalGot = c;
    }
    
    public static void setCopper(int cu)
    {
        copperGot = cu;
    }
    
    public static void setIron(int fe)
    {
        ironGot = fe;
    }
    
    public static void setSilver(int ag)
    {
        silverGot = ag;
    }
    
    public static void setGold(int au)
    {
        goldGot = au;
    }
    
    public static void setDiamond(int d)
    {
        diamondGot = d;
    }
    
    public static void setAub(int ab)
    {
        aubGot = ab;
    }
    
    public static void setMega(int ma)
    {
        megaGot = ma;
    }
    
    public static void setCash(int money)
    {
        cash = money;
    }
    
    public static void setPickaxe(int pa)
    {
        pickaxe = pa;
    }
}

