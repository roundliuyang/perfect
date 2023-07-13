package com.yly.factory.factory;


import com.yly.factory.Weapon;
import com.yly.factory.WeaponPrototype;

/**
 * 使用Factory模式来降低调用方复杂度。
 * 通过Factory模式来创建对象，降低一些重复性的入参。
 * 通过传入一个已经存在的Prototype，可以快速的创建新的实体。还有一些其他的如Builder等设计模式就不一一指出了。
 */
public class WeaponFactory {
    public Weapon createWeaponFromPrototype(WeaponPrototype proto, String newName) {
        Weapon weapon = new Weapon(null, newName, proto.getWeaponType(), proto.getDamage(), proto.getDamageType());
        return weapon;
    }
}