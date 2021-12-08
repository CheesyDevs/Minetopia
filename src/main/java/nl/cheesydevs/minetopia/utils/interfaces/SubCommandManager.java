package nl.cheesydevs.minetopia.utils.interfaces;

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

    public static HashMap<String, SubCommandExecutor> getSubCommands() {
        return subCommands;
    }
}
