package com.yly.factory;

import com.yly.factory.enums.WeaponType;
import lombok.Data;

@Data
public class WeaponPrototype {
    private WeaponType weaponType; // enum
    private int damage;
    private int damageType; // 0 - physical, 1 - fire, 2 - ice
}
