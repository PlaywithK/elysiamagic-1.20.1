package pwk.elysiamagic.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pwk.elysiamagic.ElysiaMagic;

public class ModItemGroups {

    public static final ItemGroup ELYSIAMAGIC_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ElysiaMagic.MOD_ID, "elysiamagic_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MAGIC_STAFF))
                    .displayName(Text.translatable("itemgroup.elysiamagic.items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MAGIC_STAFF);
                        entries.add(ModItems.FIRE_SPELL);
                        entries.add(ModItems.LIGHTNING_SPELL);
                        entries.add(ModItems.TELEPORT_SPELL);
                        entries.add(ModItems.SPEED_SPELL);
                    }).build());

    public static void registerItemGroups() {

    }
}
