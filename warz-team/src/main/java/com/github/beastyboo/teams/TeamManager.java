package com.github.beastyboo.teams;

import com.github.beastyboo.teams.api.event.TeamCreateEvent;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.util.UUID;

public class TeamManager {

    //In order to keep it protected
    TeamManager() {
    }

    private final Cache<String, Team> teamsByName = Caffeine.newBuilder().expireAfterAccess(Duration.ofMinutes(10)).build();
    private final Cache<UUID, Team> teamsByPlayer = Caffeine.newBuilder().expireAfterAccess(Duration.ofMinutes(10)).build();

    public Team getCachedTeam(String name) {
        return teamsByName.getIfPresent(name.toLowerCase());
    }

    public Team getCachedTeam(UUID uuid) {
        return teamsByPlayer.getIfPresent(uuid);
    }

    public Team createTeam(Player player, String teamName) {
        UUID uuid = player.getUniqueId();

        if(getCachedTeam(uuid) != null) {
            player.sendMessage(Component.text("You are already in a team!"));
            return null;
        }

        if(getCachedTeam(teamName) != null) {
            player.sendMessage(Component.text("Team with this name already exist!"));
            return null;
        }

        //TODO: Check database team

        Team team = new Team(teamName, uuid);

        TeamCreateEvent event = new TeamCreateEvent(team, player);
        Bukkit.getPluginManager().callEvent(event);

        if(event.isCancelled()) {
            return null;
        }

        teamsByPlayer.put(uuid, team);
        teamsByName.put(teamName.toLowerCase(), team);
        return team;
    }

}
