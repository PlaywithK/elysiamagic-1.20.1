package pwk.elysiamagic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pwk.elysiamagic.ElysiaMagic;
import pwk.elysiamagic.item.spells.FireSpellItem;
import pwk.elysiamagic.item.spells.LightningSpellItem;
import pwk.elysiamagic.item.spells.SpeedSpellItem;
import pwk.elysiamagic.item.spells.TeleportSpellItem;

public class ModItems {

    //public static final Item MAGIC_STAFF = registerItem("magic_staff", new Item(new Item.Settings()));
    public static final Item MAGIC_STAFF = registerItem("magic_staff", new MagicStaffItem(new Item.Settings()));
    public static final Item FIRE_SPELL = registerItem("fire_spell", new FireSpellItem(new Item.Settings()));
    public static final Item LIGHTNING_SPELL = registerItem("lightning_spell", new LightningSpellItem(new Item.Settings()));
    public static final Item TELEPORT_SPELL = registerItem("teleport_spell", new TeleportSpellItem(new Item.Settings()));
    public static final Item SPEED_SPELL = registerItem("speed_spell", new SpeedSpellItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ElysiaMagic.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(MAGIC_STAFF);
            entries.add(FIRE_SPELL);
            entries.add(LIGHTNING_SPELL);
            entries.add(TELEPORT_SPELL);
            entries.add(SPEED_SPELL);
        });
    }
}
