package nl.cheesydevs.minetopia.modules.core.commands;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.MinetopiaModule;
import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.utils.Chat;
import nl.cheesydevs.minetopia.utils.files.ModulesFile;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Objects;

public class ModuleCMD extends BukkitCommand {
    public ModuleCMD(String name) {
        super(name);
        setDescription("Use the modules");
        setPermission("minetopia.modules");
        ArrayList<String> aliases = new ArrayList<>();aliases.add("modules");
        this.setAliases(aliases);
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String label, @Nonnull String[] args) {
        if(!sender.hasPermission(Objects.requireNonNull(getPermission()))) return false;
        if(args.length > 0) {
            if(args[0].equalsIgnoreCase("reload")) {
                if(args.length < 2) {sender.sendMessage(Chat.color("&c/module reload <module>")); return false;}
                if(args[1].equalsIgnoreCase("core")) {
                    sender.sendMessage(Chat.color("&aReloading all modules!"));
                    for (MinetopiaModule module : Minetopia.getModules()) {
                        Minetopia.reloadModule(module);
                    }
                    sender.sendMessage(Chat.color("&aReloaded all modules!"));
                    return true;
                }
                MinetopiaModule module = null;
                for (MinetopiaModule x : Minetopia.getModules()) {
                    if(x.name().equalsIgnoreCase(args[1])) {
                        module = x;
                        break;
                    }
                }
                if(module != null) {
                    Minetopia.unloadModule(module);
                    Minetopia.loadModule(module);
                    sender.sendMessage(Chat.color("&aReloaded "+module.name()+"!"));
                    return true;
                } else {
                    sender.sendMessage(Chat.color("&cThat module does not exists"));
                    return false;
                }
            }
        }
        if(SubCommandManager.execute(sender, args, this.getClass(), 0)) {
            return true;
        }
        if(label.equalsIgnoreCase("modules")) {
            sender.sendMessage(Minetopia.getModulesString());
            return true;
        }
        sender.sendMessage(Chat.color("&6Modules\n" +
                "&e/module list\n" +
                "&e/module reload"));
        return true;
    }
}
