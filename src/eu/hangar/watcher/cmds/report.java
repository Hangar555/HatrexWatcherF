package eu.hangar.watcher.cmds;


import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import eu.hangar.watcher.CommandInfo;
import eu.hangar.watcher.GameCommand;

@CommandInfo(aliases = { "report", "r" }, description = " Report a player", op = false, usage = "  'report' or 'r' ")
public class report extends GameCommand{



	HashMap<String, Integer> Reports = new HashMap<String, Integer>();


	@Override
	
	public void onCommand(Player p, String[] args) {
		
	
if(args.length == 1){
		      
		        Player target = Bukkit.getPlayer(args[0]);

		          if (target != null)
		          {
		            if (!this.Reports.containsKey(args[0]))
		            {
			          
		              p.sendMessage(ChatColor.BLUE + target.getName() + " was reported. ");


		              this.Reports.put(target.getName().toString(), 1);
		            }
		            else
		            {
		              p.sendMessage(ChatColor.RED + "The player "+ChatColor.WHITE+ target.getDisplayName()+ChatColor.RED+""+" was alredy reported before!" );
		              Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD  +"[Admin]" + ChatColor.RESET +" Watcher" + ChatColor.GRAY + ":" + ChatColor.RED  +"Player " +    "you have been reported twice or more times. ");
		              for(Player staff : Bukkit.getOnlinePlayers()){
		              
		            	  
		                  if(staff.hasPermission("watcher.staff")){
		                	  staff.sendMessage(ChatColor.GREEN + "Player " +  ChatColor.GOLD+target.getName() +ChatColor.GREEN + " has been reported a lot of times!");
		                  }
		       
		              }
		            }
		          }else{
		            	p.sendMessage(ChatColor.RED + " Target player doesn't exists/is offline");
	              }
	            }else{
	            	p.sendMessage(ChatColor.RED + " Not enough arguments!");
	            	 
	            }
	}
	}
	
	

	



