package io.cg360.moon.humans.commands;

import com.flowpowered.math.vector.Vector3d;
import io.cg360.moon.humans.HumansPlugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.event.cause.entity.spawn.SpawnTypes;

import java.util.UUID;

public class CommandCreateHuman implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {


        if(src instanceof Player){
            Player p = (Player) src;
            Entity e = p.getWorld().createEntity(EntityTypes.HUMAN, p.getPosition());
            Human h = (Human) e;
            h.offer(Keys.SKIN_UNIQUE_ID, UUID.fromString("f9e34eba-10c0-4cc9-88fe-2c4b79640704"));
            try (CauseStackManager.StackFrame frame = Sponge.getCauseStackManager().pushCauseFrame()) {
                frame.addContext(EventContextKeys.SPAWN_TYPE, SpawnTypes.PLUGIN);
                p.getWorld().spawnEntity(h);
            }
        }

        return CommandResult.success();
    }
}
