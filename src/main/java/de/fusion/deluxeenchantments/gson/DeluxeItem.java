package de.fusion.deluxeenchantments.gson;

import java.util.List;

public class DeluxeItem {

    public DeluxeItemType itemType;
    public String material;
    public String displayName;
    public String lore;
    public boolean countKills;
    public List<String> enchantments;
    public List<DeluxeEffect> effects;

    public void setCountKills(boolean countKills) {
        this.countKills = countKills;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEffects(List<DeluxeEffect> effects) {
        this.effects = effects;
    }

    public void setEnchantments(List<String> enchantments) {
        this.enchantments = enchantments;
    }

    public void setItemType(DeluxeItemType itemType) {
        this.itemType = itemType;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
