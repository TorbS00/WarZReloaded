package com.github.beastyboo.teams.api.event;

import com.github.beastyboo.teams.Team;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class TeamCreateEvent extends TeamEvent implements Cancellable {

    private final Player player;
    private boolean cancelled = false;

    public TeamCreateEvent(Team team, Player player) {
        super(team);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
