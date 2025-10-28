package pwk.elysiamagic.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import pwk.elysiamagic.item.spells.SpellItem;

public class MagicStaffItem extends Item {

    public MagicStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack staffStack = player.getStackInHand(hand);
        ItemStack offHandStack = player.getOffHandStack();

        if(offHandStack.getItem() instanceof SpellItem spellItem) {
            spellItem.cast(player, world);
            player.getItemCooldownManager().set(this, 20);
            return TypedActionResult.success(staffStack);
        }

        return TypedActionResult.pass(staffStack);
    }
}
