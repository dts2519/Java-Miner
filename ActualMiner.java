//This file opens the game window. Also holds the version history.

package actualminer;

import javax.swing.JFrame;

public class ActualMiner {

    public static void main(String[] args) {
        
        mineMan miner = new mineMan();
        miner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miner.setSize(1000, 1100); //Size of the window
        miner.setVisible(true);
                      
    }
    
}

/* Version history:
Beta 1.5.1 (August 23, 2018) - A few bug fixes, such as: Pickaxe price and buy pickaxe button reset on reentering shop; crafting the secret pickaxe does not reduce ore; could move one block deeper than normal 
Beta 1.5 (August 23, 2018) - Each type of stone requires a better pickaxe (buyable at the shop). Mega Aubrunium Ore is no longer visible in the inventory or shop if not found
Beta 1.4.2 (August 17, 2018) - Different colors of stone depending on depth (will affect gameplay in the next update)
Beta 1.4.1 (August 16, 2018) - Fixed bug where closing either the Inventory or the Shop with the X button soft locks the game. Also fixed the location of the Cash display in Inventory/Shop.
Beta 1.4 (August 16, 2018) - Shop added! Now stuff can be sold for glorious profit.
Beta 1.3.3 (Aubust 16, 2018) - Some code fixes in preparation for 1.4
Beta 1.3.2 (August 16, 2018) - Fixed bug where the player could open multiple copies of the inventory
Beta 1.3.1 (August 15, 2018) - Graphics for the shop added. The block below the shop cannot be broken. If a mega aubrunium spawns, the player will be notified once they move. In getGuy, changed to switch statement.
Beta 1.3 (August 13, 2018) - Different weather conditions
Beta 1.2.1 (August 13, 2018) - Fixed bug where WSAD/Arrow Keys do nothing. Also fixed title of inventory screen.
Beta 1.2 (August 10, 2018) - Can now view inventory
Beta 1.1 (August 9, 2018) - Stone-based blocks only show once the player is near.
Beta 1.0 (August 9, 2018) - Ores can now be mined and disappear. Can now only move one block at a time. Added notification when ore is mined.
Indev (August 8, 2018) - Graphics and movement
*/

/* Known bugs:
-
*/
