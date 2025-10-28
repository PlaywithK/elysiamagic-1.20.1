package pwk.elysiamagic.item.spells;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public abstract class SpellItem extends Item {

    public SpellItem(Settings settings) {
        super(settings);
    }

    public abstract void cast(PlayerEntity player, World world);
}
