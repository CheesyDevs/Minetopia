package nl.cheesydevs.minetopia.events;

import nl.cheesydevs.minetopia.modules.Module;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

public class OnModuleDisableEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Module module;
    private boolean isCancelled;

    public OnModuleDisableEvent(Module module) {
        this.module = module;
        this.isCancelled = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    public Module getModule() {
        return module;
    }

    @Override
    public @Nonnull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
