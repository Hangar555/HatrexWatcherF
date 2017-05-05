package eu.hangar.watcher.cmds;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import eu.hangar.watcher.CommandInfo;
import eu.hangar.watcher.GameCommand;


@CommandInfo(aliases = { "warn", "w" }, description = " Warn a player", op = false, usage = "  'report' or 'r' ")
public class warn extends GameCommand{



	HashMap<String, Integer> Warn = new HashMap<String, Integer>();


	@Override
	
	public void onCommand(Player p, String[] args) {
		
	if(p.hasPermission("watcher.warn")){
if(args.length == 1){
		      
		        Player target = Bukkit.getPlayer(args[0]);

		          if (target != null)
		          {
		            if (!this.Warn.containsKey(args[0]))
		            {
		              p.sendMessage(ChatColor.GREEN + target.getName() + " was warned. ");
		              
		              target.sendMessage(ChatColor.RED + "You have been issued an outstanding warning");
		               


		              this.Warn.put(target.getName().toString(), 1);
		            }
		            else
		            {
		              p.sendMessage(ChatColor.RED + "The player "+ChatColor.WHITE+ target.getDisplayName()+ChatColor.RED+""+" was alredy warned before!" );
		             target.kickPlayer(ChatColor.DARK_RED + "Accumulation of two or more outstanding warnings. Kick issued by Watcher. Last warning issued by " + ChatColor.RED + p.getName()+ChatColor.DARK_RED+ ".");
		             
		                  
		            }
		            }else{
		                	  p.sendMessage(ChatColor.RED + " Not enough permissions!");
		                  }
		       
		              }else{
			            	p.sendMessage(ChatColor.RED + " Target player doesn't exists/is offline");
		              }
		            }else{
		            	p.sendMessage(ChatColor.RED + " Not enough arguments!");
		            	 
		            }
		          }
		       
	}
	

	