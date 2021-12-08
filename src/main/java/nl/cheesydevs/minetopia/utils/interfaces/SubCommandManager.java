package nl.cheesydevs.minetopia.utils.interfaces;

import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class SubCommandManager {
    private static final HashMap<String, SubCommandExecutor> subCommands = new HashMap<>();

    public static void addSubCommand(String className, SubCommandExecutor executor) {
        Class<? extends SubCommandExecutor> cls = executor.getClass();
        if(cls.isAnnotationPresent(SubCommand.class)) {
            subCommands.put(className, executor);
        } else {
            throw new IllegalArgumentException("Given executor has no SubCommand annotation.");
        }
    }

    public static boolean execute(CommandSender sender, String[] args, Class<?> cls, int place) {
        if (args.length > place) {
            for (SubCommandExecutor subCommandExecutor : SubCommandManager.getSubCommands().values()) {
                if (subCommandExecutor.getCommand().equals(cls.toString())) {
                    if (subCommandExecutor.getClass().getAnnotation(SubCommand.class).name().equals(args[place])) {
                        return subCommandExecutor.execute(sender, args);
                    }
                }
            }
        }
        return false;
    }

    public static boolean execute(CommandSender sender, String[] args, Class<?> cls, int... place) {
        if (args.length > place[0]) {
            for (SubCommandExecutor subCommandExecutor : SubCommandManager.getSubCommands().values()) {
                if (subCommandExecutor.getCommand().equals(cls.toString())) {
                    for(int i : place) {
                        if (subCommandExecutor.getClass().getAnnotation(SubCommand.class).name().equals(args[i])) {
                            return subCommandExecutor.execute(sender, args);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static HashMap<String, SubCommandExecutor> getSubCommands() {
        return subCommands;
    }
}
