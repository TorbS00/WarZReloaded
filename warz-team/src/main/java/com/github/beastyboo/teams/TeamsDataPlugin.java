package com.github.beastyboo.teams;

import com.github.beastyboo.teams.api.TeamsAPI;
import com.github.beastyboo.teams.api.TeamsPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TeamsDataPlugin extends JavaPlugin implements TeamsPlugin {

    private Teams core;

    @Override
    public void onEnable() {
        core = new Teams(this);
        core.load();
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }

    @Override
    public TeamsAPI getAPI() {
        return core;
    }
}
