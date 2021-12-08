package nl.cheesydevs.minetopia.utils.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SubCommand {
    String name();
    String description();
    String usage();
}

