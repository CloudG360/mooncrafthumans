package io.cg360.moon.humans;

import com.google.inject.Inject;
import io.cg360.moon.humans.commands.CommandCreateHuman;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

@Plugin(
        id = "humans",
        name = "Humans",
        version = "1.0-SNAPSHOT",
        description = "Allows for the spawning of human entities",
        authors = {
                "CloudGamer360"
        }
)
public class HumansPlugin {

    private static HumansPlugin humansPlugin;


    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {

        humansPlugin = this;

        CommandSpec testCreateHuman = CommandSpec.builder()
                .description(Text.of("Creates a test human entity"))
                .executor(new CommandCreateHuman())
                .build();

        Sponge.getCommandManager().register(this, testCreateHuman, "createhuman");

    }

    public static HumansPlugin getHumansPlugin() { return humansPlugin; }
    public Logger getLogger() { return logger; }
}
