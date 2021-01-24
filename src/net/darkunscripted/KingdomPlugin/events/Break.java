package net.darkunscripted.KingdomPlugin.events;

import net.darkunscripted.KingdomPlugin.Main;
import net.darkunscripted.KingdomPlugin.managers.FarmingSkill;
import net.darkunscripted.KingdomPlugin.managers.MiningSkill;
import net.darkunscripted.KingdomPlugin.utils.Utils;
import org.bukkit.CropState;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Crops;
import org.bukkit.material.Dye;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;

public class Break implements Listener {

    Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        ArrayList<Material> ores = new ArrayList<>();
        ores.add(Material.COAL_ORE);
        ores.add(Material.IRON_ORE);
        ores.add(Material.REDSTONE_ORE);
        ores.add(Material.LAPIS_ORE);
        ores.add(Material.GOLD_ORE);
        ores.add(Material.DIAMOND_ORE);
        ores.add(Material.EMERALD_ORE);
        Block block = e.getBlock();
        Player player = e.getPlayer();
        if(block.getState().getData() instanceof Crops) {
            if(!(player.isSneaking())) {
                if (isFullyGrown(block)) {
                    Integer xp = FarmingSkill.farmingXP.get(player) + 1;
                    if (xp >= (Math.pow(FarmingSkill.farmingLevel.get(player), 2) * 100)) {
                        FarmingSkill.farmingXP.put(player, 0);
                        FarmingSkill.farmingLevel.put(player, FarmingSkill.farmingLevel.get(player) + 1);
                        player.sendMessage(Utils.chat("&b&lSkills &7>> &a&lFarming Skill leveled up!"));
                    } else {
                        FarmingSkill.farmingXP.put(player, xp);
                    }
                } else {
                    player.sendMessage(Utils.chat("&b&lSkills &7>> &c&lThis crop is not fully grown yet!"));
                    e.setCancelled(true);
                }
            }
        }else if(ores.contains(block.getType())){
            e.setDropItems(false);
            ItemStack drop = null;
            Integer xp = null;
            if(block.getType().equals(Material.COAL_ORE)){
                xp = MiningSkill.miningXP.get(player) + plugin.getConfig().getInt("settings.skills.mining.coal");
                ItemStack item = new ItemStack(Material.COAL);
                item.setAmount(1);
                drop = item;
                block.setType(Material.BEDROCK, true);
            }else if(block.getType().equals(Material.REDSTONE_ORE)){
                xp = MiningSkill.miningXP.get(player) + plugin.getConfig().getInt("settings.skills.mining.redstone");
                ItemStack item = new ItemStack(Material.REDSTONE, 1);
                drop = item;
                block.setType(Material.BEDROCK, true);
            }else if(block.getType().equals(Material.LAPIS_ORE)){
                xp = MiningSkill.miningXP.get(player) + plugin.getConfig().getInt("settings.skills.mining.lapis");
                Dye d = new Dye();
                d.setColor(DyeColor.BLUE);
                ItemStack item = d.toItemStack();
                drop = item;
                block.setType(Material.BEDROCK, true);
            }else if(block.getType().equals(Material.IRON_ORE)){
                xp = MiningSkill.miningXP.get(player) + plugin.getConfig().getInt("settings.skills.mining.iron");
                ItemStack item = new ItemStack(Material.IRON_INGOT);
                item.setAmount(1);
                drop = item;
                block.setType(Material.BEDROCK, true);
            }else if(block.getType().equals(Material.GOLD_ORE)){
                xp = MiningSkill.miningXP.get(player) + plugin.getConfig().getInt("settings.skills.mining.gold");
                ItemStack item = new ItemStack(Material.GOLD_INGOT);
                item.setAmount(1);
                drop = item;
                block.setType(Material.BEDROCK, true);
            }else if(block.getType().equals(Material.DIAMOND_ORE)){
                xp = MiningSkill.miningXP.get(player) + plugin.getConfig().getInt("settings.skills.mining.diamond");
                ItemStack item = new ItemStack(Material.DIAMOND);
                item.setAmount(1);
                drop = item;
                block.setType(Material.BEDROCK, true);
            }else if(block.getType().equals(Material.EMERALD_ORE)){
                xp = MiningSkill.miningXP.get(player) + plugin.getConfig().getInt("settings.skills.mining.emerald");
                ItemStack item = new ItemStack(Material.EMERALD);
                item.setAmount(1);
                drop = item;
                block.setType(Material.BEDROCK, true);
            }
            block.getLocation().getWorld().dropItemNaturally(block.getLocation(), drop);
            if (xp >= (Math.pow(MiningSkill.miningLevel.get(player), 2) * 100)) {
                MiningSkill.miningXP.put(player, (int) (xp - (Math.pow(MiningSkill.miningLevel.get(player), 2) * 100)));
                MiningSkill.miningLevel.put(player, MiningSkill.miningLevel.get(player) + 1);
                player.sendMessage(Utils.chat("&b&lSkills &7>> &a&lMining Skill leveled up!"));
            } else {
                MiningSkill.miningXP.put(player, xp);
            }
        }
    }

    public boolean isFullyGrown(Block block) {
        MaterialData md = block.getState().getData();

        if(md instanceof Crops) {
            return (((Crops) md).getState() == CropState.RIPE);
        }
        else return false;
    }
}
