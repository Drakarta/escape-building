package org.example.utils.databaseconverters;

import org.example.classes.items.Inventory;
import org.example.classes.items.Item;
import org.example.classes.items.weapons.WeaponBase;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.consumables.scrolls.ScrollBase;
import org.example.classes.items.consumables.potions.PotionBase;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.List;

@Converter(autoApply = false)
public class InventoryConverter implements AttributeConverter<Inventory, String> {

    @Override
    public String convertToDatabaseColumn(Inventory attribute) {
        if (attribute == null || attribute.getItems().isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Item item : attribute.getItems()) {
            if (item == null) continue;

            if (item instanceof WeaponBase weapon) {
                sb.append("Weapon")
                  .append("|").append(escape(weapon.getName())) 
                  .append("|").append(weapon.getDurability())
                  .append("|").append(weapon.getDamage());
            } else if (item instanceof ArmorBase armor) {
                sb.append("Armor")
                  .append("|").append(escape(armor.getName()))
                  .append("|").append(armor.getDurability())
                  .append("|").append(armor.getShield());
            } else if (item instanceof ScrollBase<?> scroll) {
                sb.append("Scroll")
                  .append("|").append(escape(scroll.getName()))
                  .append("|").append(escape(scroll.getSpellDescription()))
                  .append("|").append(scroll.getAmount());
            } else if (item instanceof PotionBase potion) {
                sb.append("Potion")
                  .append("|").append(escape(potion.getName()))
                  .append("|").append(escape(potion.getEffectDescription()))
                  .append("|").append(potion.getPotency());
            } else {
                // Basis item alleen naam
                sb.append("Item")
                  .append("|").append(escape(item.getName()));
            }
            sb.append(";");
        }
        return sb.toString();
    }

    @Override
    public Inventory convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty()) {
            return new Inventory();
        }

        List<Item> items = new ArrayList<>();
        String[] itemStrings = dbData.split(";");
        for (String itemString : itemStrings) {
            if (itemString.trim().isEmpty()) continue;
            String[] fields = itemString.split("\\|");
            String type = fields[0];
            switch (type) {
                case "Weapon" -> {
                    if (fields.length < 4) continue;
                    String name = unescape(fields[1]);
                    int durability = Integer.parseInt(fields[2]);
                    double damage = Double.parseDouble(fields[3]);
                    items.add(new WeaponBase(name, durability, damage));
                }
                case "Armor" -> {
                    if (fields.length < 4) continue;
                    String name = unescape(fields[1]);
                    int durability = Integer.parseInt(fields[2]);
                    double shield = Double.parseDouble(fields[3]);
                    items.add(new ArmorBase(name, durability, shield));
                }
                case "Scroll" -> {
                    if (fields.length < 4) continue;
                    String name = unescape(fields[1]);
                    String spellDescription = unescape(fields[2]);
                    int amount = Integer.parseInt(fields[3]);
                    // abstract class, anonieme subclass voor converter
                    items.add(new ScrollBase<>(name, spellDescription, amount) {
                        @Override
                        public void cast(Object target) { }
                    });
                }
                case "Potion" -> {
                    if (fields.length < 4) continue;
                    String name = unescape(fields[1]);
                    String effectDescription = unescape(fields[2]);
                    int potency = Integer.parseInt(fields[3]);
                    // abstract class, anonieme subclass
                    items.add(new PotionBase(name, effectDescription, potency) {
                        @Override
                        public void consume(org.example.classes.Player player) { }
                    });
                }
                case "Item" -> {
                    if (fields.length < 2) continue;
                    String name = unescape(fields[1]);
                    items.add(new Item(name));
                }
            }
        }
        return new Inventory(items);
    }

    // Escape methode om | en ; in strings te encoden
    private String escape(String input) {
        if (input == null) return "";
        return input.replace("|", "\\|").replace(";", "\\;");
    }

    // Unescape methode
    private String unescape(String input) {
        if (input == null) return "";
        return input.replace("\\|", "|").replace("\\;", ";");
    }
}
