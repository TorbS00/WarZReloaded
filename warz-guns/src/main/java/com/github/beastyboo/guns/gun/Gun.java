package com.github.beastyboo.guns.gun;

import com.github.beastyboo.guns.gun.ammo.Ammo;
import com.github.beastyboo.guns.gun.firemode.FireModeType;
import com.github.beastyboo.guns.gun.firemode.IFireMode;
import org.bukkit.Material;

public record Gun(String gunName, Material material, Ammo ammo, WeaponClass weaponClass, FireModeType fireModeType,
                  IFireMode fireMode, boolean canAim, long reloadTime, long delay, int maxClipSize, double damagePerBullet,
                  double headShotIncrease, double legShotDecrease, double bulletSpeed, double accuracy, double accuracy_aimed,
                  double accuracy_crouched, double targetKnockBack, double recoil) {
}
