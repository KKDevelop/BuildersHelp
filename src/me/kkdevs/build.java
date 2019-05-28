package me.kkdevs;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerItemHeldEvent;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.item.Item;
import cn.nukkit.math.Vector3;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

import com.google.common.primitives.Ints;

import java.util.HashMap;
import java.util.Optional;

public class build extends PluginBase implements Listener {

    HashMap<Player, Integer> r = new HashMap<>();
    HashMap<String, Integer> id = new HashMap<>();
    HashMap<String, Integer> h = new HashMap<>();
    HashMap<String, Integer> idz = new HashMap<>();
    HashMap<Player, String> w = new HashMap<>();
    HashMap<String, Vector3> pos = new HashMap<>();

    Item stick = Item.get(369);

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String cmd = command.getName();

        if (cmd.toLowerCase().equals("w")) {

            if (sender instanceof Player) {

                if (args.length == 0) {
                    sender.sendMessage("Use: /w < c | cy | sq | l | rp >");
                    return true;
                }

                int one;
                int two;
                int three;

                switch (args[0]) {

                    case "sq":
                    case "square":

                        if (args.length <= 2 || args.length > 3) {
                            sender.sendMessage(TextFormat.RED + "Use: /w sq <r> <id>");
                            return true;
                        } else {

                            one = Optional.ofNullable(args[1]).map(Ints::tryParse).orElse(0);
                            two = Optional.ofNullable(args[2]).map(Ints::tryParse).orElse(0);

                            w.put((Player) sender, "square");
                            r.put((Player) sender, one - 1);
                            id.put(sender.getName(), two);
                            ((Player) sender).sendTitle("Ready to use");

                            if (!((Player) sender).getInventory().contains(stick)) {
                                ((Player) sender).getInventory().setItem(0, stick.setCustomName(""));
                            }

                            if((((Player) sender).isSurvival() || ((Player) sender).getGamemode() == 2 || ((Player) sender).getGamemode() == 3)) {
                                ((Player) sender).setGamemode(1);
                            }

                        }
                        break;
                    case "c":
                    case "circle":

                        if (args.length <= 2 || args.length > 3) {
                            sender.sendMessage(TextFormat.RED + "Use: /w c <r> <id>");
                            return true;
                        } else {

                            one = Optional.ofNullable(args[1]).map(Ints::tryParse).orElse(0);
                            two = Optional.ofNullable(args[2]).map(Ints::tryParse).orElse(0);

                            w.put((Player) sender, "circle");
                            r.put((Player) sender, one - 1);
                            id.put(sender.getName(), two);
                            ((Player) sender).sendTitle("Ready to use");

                            if (!((Player) sender).getInventory().contains(stick)) {
                                ((Player) sender).getInventory().setItem(0, stick.setCustomName(""));
                            }

                            //Tool
                            if((((Player) sender).isSurvival() || ((Player) sender).getGamemode() == 2 || ((Player) sender).getGamemode() == 3)) {
                                ((Player) sender).setGamemode(1);
                            }

                        }
                        break;
                    case "cy":
                    case "cylinder":

                        if (args.length <= 3 || args.length > 4) {
                            sender.sendMessage(TextFormat.RED + "Use: /w cy <r> <h> <id>");
                            return true;
                        } else {

                            one = Optional.ofNullable(args[1]).map(Ints::tryParse).orElse(0);
                            two = Optional.ofNullable(args[2]).map(Ints::tryParse).orElse(0);
                            three = Optional.ofNullable(args[3]).map(Ints::tryParse).orElse(0);

                            w.put((Player) sender, "cylinder");
                            r.put((Player) sender, one - 1);
                            h.put(sender.getName(), two - 1);
                            id.put(sender.getName(), three);
                            ((Player) sender).sendTitle("Ready to use");

                            if (!((Player) sender).getInventory().contains(stick)) {
                                ((Player) sender).getInventory().setItem(0, stick.setCustomName(""));
                            }

                            if((((Player) sender).isSurvival() || ((Player) sender).getGamemode() == 2 || ((Player) sender).getGamemode() == 3)) {
                                ((Player) sender).setGamemode(1);
                            }

                        }
                        break;
                    case "l":
                    case "layer":

                        if (args.length <= 2 || args.length > 3) {
                            sender.sendMessage(TextFormat.RED + "Use: /w l <r> <id>");
                            return true;
                        } else {

                            one = Optional.ofNullable(args[1]).map(Ints::tryParse).orElse(0);
                            two = Optional.ofNullable(args[2]).map(Ints::tryParse).orElse(0);

                            w.put((Player) sender, "layer");
                            r.put((Player) sender, one - 1);
                            id.put(sender.getName(), two);
                            ((Player) sender).sendTitle("Ready to use");

                            if (!((Player) sender).getInventory().contains(stick)) {
                                ((Player) sender).getInventory().setItem(0, stick.setCustomName(""));
                            }

                            if((((Player) sender).isSurvival() || ((Player) sender).getGamemode() == 2 || ((Player) sender).getGamemode() == 3)) {
                                ((Player) sender).setGamemode(1);
                            }

                        }
                        break;
                    case "rp":
                    case "replace":

                        if (args.length <= 3 || args.length > 4) {
                            sender.sendMessage(TextFormat.RED + "Use: /w rp <r> <id> <idz>");
                            return true;
                        } else {

                            one = Optional.ofNullable(args[1]).map(Ints::tryParse).orElse(0);
                            two = Optional.ofNullable(args[2]).map(Ints::tryParse).orElse(0);
                            int three2 = Optional.ofNullable(args[3]).map(Ints::tryParse).orElse(0);

                            w.put((Player) sender, "replace");
                            r.put((Player) sender, one - 1);
                            id.put(sender.getName(), two);
                            idz.put(sender.getName(), three2);
                            ((Player) sender).sendTitle("Ready to use");

                            if (!((Player) sender).getInventory().contains(stick)) {
                                ((Player) sender).getInventory().setItem(0, stick.setCustomName(""));
                            }

                            if((((Player) sender).isSurvival() || ((Player) sender).getGamemode() == 2 || ((Player) sender).getGamemode() == 3)) {
                                ((Player) sender).setGamemode(1);
                            }

                        }
                        break;
                }
            } else {
                sender.sendMessage(TextFormat.RED + "Please run this command in-game.");
            }
        }

        return true;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onTap(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        pos.put(p.getName(), new Vector3(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()));
        if (p.getInventory().getItemInHand().getId() == stick.getId() && p.getInventory().getItemInHand().getCustomName().equals("")) {

            try {
                int i = r.get(p);

                int minX = (int) e.getBlock().getX() - i;
                int minY = (int) e.getBlock().getY() - i;
                int minZ = (int) e.getBlock().getZ() - i;
                int maxX = (int) e.getBlock().getX() + i;
                int maxY = (int) e.getBlock().getY() + i;
                int maxZ = (int) e.getBlock().getZ() + i;


                switch (w.get(p)) {
                    case "circle":
                        for (int x = minX; x <= maxX; x++) {
                            for (int y = minY; y <= maxY; y++) {
                                for (int z = minZ; z <= maxZ; z++) {
                                    if (pos.get(p.getName()).distance(new Vector3(x, y, z)) <= i) {
                                        p.getLevel().setBlock(new Vector3(x, y, z), Block.get(id.get(p.getName())));
                                    }
                                }
                            }
                        }
                        break;
                    case "square":
                        for (int x = minX; x <= maxX; x++) {
                            for (int y = minY; y <= maxY; y++) {
                                for (int z = minZ; z <= maxZ; z++) {
                                    p.getLevel().setBlock(new Vector3(x, y, z), Block.get(id.get(p.getName())));
                                }
                            }
                        }
                        break;

                    case "cylinder":

                        int maxH = (int) e.getBlock().getY() + h.get(p.getName());

                        for (int x = minX; x <= maxX; x++) {
                            for (int y = (int) e.getBlock().getY(); y <= maxH; y++) {
                                for (int z = minZ; z <= maxZ; z++) {
                                    pos.put(p.getName(), new Vector3(e.getBlock().getX(), y, e.getBlock().getZ()));
                                    if (pos.get(p.getName()).distance(new Vector3(x, y, z)) <= i) {
                                        p.getLevel().setBlock(new Vector3(x, y, z), Block.get(id.get(p.getName())));
                                    }
                                }
                            }
                        }
                        break;
                    case "layer":
                        for (int x = minX; x <= maxX; x++) {
                            for (int y = maxY; y >= minY; y--) {
                                for (int z = minZ; z <= maxZ; z++) {
                                    pos.put(p.getName(), new Vector3(e.getBlock().getX(), y, e.getBlock().getZ()));
                                    if (pos.get(p.getName()).distance(new Vector3(x, y, z)) >= i) {
                                        if(p.getLevel().getBlock(new Vector3(x, y, z)).getId() != 0 && p.getLevel().getBlock(new Vector3(x, y+1, z)).getId() == 0) {
                                            p.getLevel().setBlock(new Vector3(x, y+1, z) , Block.get(id.get(p.getName())));
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case "replace":
                        for (int x = minX; x <= maxX; x++) {
                            for (int y = minY; y <= maxY; y++) {
                                for (int z = minZ; z <= maxZ; z++) {
                                    p.sendMessage(x + ";" + y + ";" + z);
                                    pos.put(p.getName(), new Vector3(e.getBlock().getX(), y, e.getBlock().getZ()));
                                    if(pos.get(p.getName()).distance(new Vector3(x, y, z)) <= i) {
                                        if (p.getLevel().getBlock(new Vector3(x, y, z)).getId() == id.get(p.getName())) {
                                            p.getLevel().setBlock(new Vector3(x, y, z), Block.get(idz.get(p.getName())));
                                        }
                                    }
                                }
                            }
                        }
                        break;
                }
            } catch (Exception ex) {}
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onItemHeld(PlayerItemHeldEvent e) {
        if(e.getItem() == stick) e.getPlayer().sendPopup("§l" + TextFormat.AQUA + "» " + TextFormat.WHITE + "Ｙｏｕ ｔｏｏｌ" + TextFormat.AQUA + " «");
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onTrancsactions(InventoryTransactionEvent e) {
        for (InventoryAction action : e.getTransaction().getActions()) {
            if (action.getSourceItem().getId() == 369 && action.getSourceItem().getCustomName().equals("")) e.setCancelled(true);
        }
    }
}
