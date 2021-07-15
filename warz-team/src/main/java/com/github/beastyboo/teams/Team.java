package com.github.beastyboo.teams;

import net.kyori.adventure.text.Component;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.*;

public class Team {

    private final String teamName;
    private final Map<UUID, TeamRank> teamMembers;
    private final String description;
    private final Set<UUID> teamInvites;

    Team(String teamName, Map<UUID, TeamRank> teamMembers, String description, Set<UUID> teamInvites) {
        this.teamName = teamName;
        this.teamMembers = teamMembers;
        this.description = description;
        this.teamInvites = teamInvites;
    }

    Team(String teamName, UUID leader) {
        this(teamName, new HashMap<>(), "Default description", new HashSet<>());
        this.teamMembers.put(leader, TeamRank.LEADER);
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Instead of keeping one field mutable, we provide an immutable object by returning a new
     * Team instead, in order to provide thread-safety.
     *
     * @param description representing string
     * @return new Team with updated description
     */
    public Team modifyDescription(String description) {
        return new Team(this.teamName, this.teamMembers, description, this.teamInvites);
    }

    public void invitePlayer(Player player, Player target) {
        UUID inviter = player.getUniqueId();
        UUID invited = target.getUniqueId();

        if(teamMembers.get(inviter) == TeamRank.MEMBER) {
            player.sendMessage(Component.text("You must be Officer or Leader in order to invite"));
            return;
        }

        if(teamInvites.contains(invited)) {
            player.sendMessage(Component.text(target.getName() + " already invited!"));
            return;
        }

        teamInvites.add(invited);
        player.sendMessage(Component.text(target.getName() + " invited!"));
        target.sendMessage(Component.text(player.getName() + " invited you to join " + teamName));
    }

    public void unInvitePlayer(Player player, OfflinePlayer target) {
        UUID inviter = player.getUniqueId();
        UUID invited = target.getUniqueId();

        if(teamMembers.get(inviter) == TeamRank.MEMBER) {
            player.sendMessage(Component.text("You must be Officer or Leader in order to remove invitation"));
            return;
        }

        if(!teamInvites.contains(invited)) {
            player.sendMessage(Component.text(target.getName() + " is not invited!"));
            return;
        }

        teamInvites.remove(invited);
        player.sendMessage(Component.text(target.getName() + " uninvited!"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamName.equals(team.teamName) && teamMembers.equals(team.teamMembers) && description.equals(team.description) && teamInvites.equals(team.teamInvites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, teamMembers, description, teamInvites);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamMembers=" + teamMembers +
                ", description='" + description + '\'' +
                ", teamInvites=" + teamInvites +
                '}';
    }
}
