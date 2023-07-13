package com.yly.factory;

import com.yly.factory.factory.WeaponFactory;

public class Test {
    public static void main(String[] args) {
        // 实际应用中 WeaponFactory 可以是一个组件，交由Spring容器 管理
        WeaponFactory weaponFactory = new WeaponFactory();
        WeaponPrototype swordProto = new WeaponPrototype();
        Weapon sword = weaponFactory.createWeaponFromPrototype(swordProto, "Soul Eater");
    }
}
