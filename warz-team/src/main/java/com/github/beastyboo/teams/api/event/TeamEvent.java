package com.github.beastyboo.teams.api.event;

import com.github.beastyboo.teams.Team;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TeamEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final Team team;

    TeamEvent(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
